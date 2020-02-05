package com.shembil.base.di.module;

import com.shembil.base.ui.main.MainActivity;
import com.shembil.base.ui.main.MainFragmentBindingModule;
import com.shembil.base.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Masoud Mokhtari on 12/24/19.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class, MainModule.class})
    abstract MainActivity bindMainActivity();
}
