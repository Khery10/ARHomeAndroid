package com.example.android.ardesigner.basic.di;

import androidx.fragment.app.Fragment;
import com.example.android.ardesigner.basic.views.menu.MenuFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuildersModule_ContributeMenuFragment.MenuFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeMenuFragment {
  private FragmentBuildersModule_ContributeMenuFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(MenuFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MenuFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface MenuFragmentSubcomponent extends AndroidInjector<MenuFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MenuFragment> {}
  }
}
