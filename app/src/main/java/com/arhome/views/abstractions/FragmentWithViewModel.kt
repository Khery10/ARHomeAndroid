package com.arhome.views.abstractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arhome.di.Injectable
import javax.inject.Inject

abstract class FragmentWithViewModel<TViewModel : ViewModel, TBinding : ViewDataBinding>(
        private val modelClass: Class<TViewModel>,
        @LayoutRes private val contentLayoutId: Int)
    : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val viewModel: TViewModel by lazy {
        viewModelFactory.create(modelClass)
    }

    protected lateinit var binding: TBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                contentLayoutId,
                container,
                false
        )

        return binding.root
    }

}