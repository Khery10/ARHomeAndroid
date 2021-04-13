package com.example.android.ardesigner.basic.views.loading;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.android.ardesigner.basic.R;

public class PermissionsFragmentDirections {
  private PermissionsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPermissionsToLoading() {
    return new ActionOnlyNavDirections(R.id.action_permissions_to_loading);
  }
}
