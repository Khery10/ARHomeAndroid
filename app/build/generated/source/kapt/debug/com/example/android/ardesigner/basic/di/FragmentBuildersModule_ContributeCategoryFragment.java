package com.example.android.ardesigner.basic.di;

import androidx.fragment.app.Fragment;
import com.example.android.ardesigner.basic.views.menu.categories.CategoryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuildersModule_ContributeCategoryFragment.CategoryFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeCategoryFragment {
  private FragmentBuildersModule_ContributeCategoryFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(CategoryFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      CategoryFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CategoryFragmentSubcomponent extends AndroidInjector<CategoryFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CategoryFragment> {}
  }
}
