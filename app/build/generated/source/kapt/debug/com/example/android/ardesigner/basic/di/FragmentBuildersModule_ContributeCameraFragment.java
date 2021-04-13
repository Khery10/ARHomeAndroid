package com.example.android.ardesigner.basic.di;

import androidx.fragment.app.Fragment;
import com.example.android.ardesigner.basic.views.camera.CameraFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuildersModule_ContributeCameraFragment.CameraFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeCameraFragment {
  private FragmentBuildersModule_ContributeCameraFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(CameraFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      CameraFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CameraFragmentSubcomponent extends AndroidInjector<CameraFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CameraFragment> {}
  }
}
