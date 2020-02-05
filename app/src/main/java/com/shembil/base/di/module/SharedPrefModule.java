package com.shembil.base.di.module;


import android.content.SharedPreferences;

import com.shembil.base.ui.base.BaseApplication;
import com.shembil.base.utils.AppConstants;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

@Module
public class SharedPrefModule {

    @Provides
    static SharedPreferences ProvideSharedPrefs(BaseApplication context) {
        return context.getSharedPreferences(AppConstants.PREF_NAME, MODE_PRIVATE);
    }
}
