package com.example.android.ardesigner.basic.di;

import android.app.Activity;
import com.example.android.ardesigner.basic.views.CameraActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_ContributeCameraActivity.CameraActivitySubcomponent.class)
public abstract class ActivityModule_ContributeCameraActivity {
  private ActivityModule_ContributeCameraActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(CameraActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      CameraActivitySubcomponent.Builder builder);

  @Subcomponent(modules = FragmentBuildersModule.class)
  public interface CameraActivitySubcomponent extends AndroidInjector<CameraActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CameraActivity> {}
  }
}
