package com.arhome.views.loading

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.arhome.R
import com.arhome.utils.network.NetworkConnectivity

private const val PERMISSIONS_REQUEST_CODE = 10

private val PERMISSIONS_REQUIRED = arrayOf(Manifest.permission.CAMERA)

/**
 * This [Fragment] requests permissions and, once granted, it will navigate to the next fragment
 */
class PermissionsFragment : Fragment() {

    private val _networkConnectivity: NetworkConnectivity by lazy {
        NetworkConnectivity(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check hardware permissions
        if (hasPermissions(requireContext())) {

            // Check network connection
            _networkConnectivity.observe(this, { isConnected ->

                if (isConnected) {
                    Navigation.findNavController(requireActivity(), R.id.main_fragment_container).navigate(
                            PermissionsFragmentDirections.actionPermissionsToLoading())
                } else {
                    Toast.makeText(context, "No network connection", Toast.LENGTH_LONG).show()
                }

            })

        } else {
            // Request related permissions
            requestPermissions(PERMISSIONS_REQUIRED, PERMISSIONS_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.all { res -> res == PackageManager.PERMISSION_GRANTED }) {
                // Takes the user to the success fragment when permission is granted
                Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                        PermissionsFragmentDirections.actionPermissionsToLoading())
            } else {
                Toast.makeText(context, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _networkConnectivity.removeObservers(this);
    }

    companion object {

        /** Convenience method used to check if all permissions required by this app are granted */
        fun hasPermissions(context: Context) = PERMISSIONS_REQUIRED.all {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
    }
}
