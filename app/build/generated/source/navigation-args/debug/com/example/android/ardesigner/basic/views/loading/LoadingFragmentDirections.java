package com.example.android.ardesigner.basic.views.loading;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.android.ardesigner.basic.R;

public class LoadingFragmentDirections {
  private LoadingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoadingToMenuFragment() {
    return new ActionOnlyNavDirections(R.id.action_loading_to_menuFragment);
  }
}
