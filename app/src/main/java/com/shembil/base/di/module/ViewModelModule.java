package com.shembil.base.di.module;

import androidx.lifecycle.ViewModel;

import com.shembil.base.di.utils.ViewModelKey;
import com.shembil.base.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Masoud Mokhtari on 12/24/19.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}