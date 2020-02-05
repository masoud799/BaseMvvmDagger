package com.shembil.base.di.component;

import com.shembil.base.di.module.BuildersModule;
import com.shembil.base.di.module.AppModule;
import com.shembil.base.di.module.ViewModelModule;
import com.shembil.base.ui.base.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


/**
 * Created by Masoud Mokhtari on 12/24/19.
 */
@Singleton
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class, BuildersModule.class, ViewModelModule.class})
public interface ApplicationComponent extends AndroidInjector<BaseApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication application);

        ApplicationComponent build();
    }
}