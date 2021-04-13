// Generated by Dagger (https://google.github.io/dagger).
package com.example.android.ardesigner.basic.views;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

  public MainActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider) {
    return new MainActivity_MembersInjector(dispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
  }

  public static void injectDispatchingAndroidInjector(
      MainActivity instance, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
    instance.dispatchingAndroidInjector = dispatchingAndroidInjector;
  }
}