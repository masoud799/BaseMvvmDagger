package com.shembil.base.ui.base;

import com.shembil.base.di.component.ApplicationComponent;
import com.shembil.base.di.component.DaggerApplicationComponent;
import com.shembil.base.utils.AppLogger;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by Masoud Mokhtari on 12/24/19.
 */
public class BaseApplication extends DaggerApplication {

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        AppLogger.init();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}