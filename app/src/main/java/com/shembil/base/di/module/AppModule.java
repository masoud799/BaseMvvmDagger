package com.shembil.base.di.module;

import android.content.Context;

import com.shembil.base.data.local.prefs.PrefManagerImpl;
import com.shembil.base.data.local.prefs.PrefManager;
import com.shembil.base.data.remote.RestManager;
import com.shembil.base.data.remote.RestManagerImpl;
import com.shembil.base.di.ApplicationContext;
import com.shembil.base.ui.base.BaseApplication;
import com.shembil.base.utils.rx.SingleLiveData;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {SharedPrefModule.class, NetworkModule.class})
public abstract class AppModule {

    @Binds
    @Singleton
    abstract PrefManager providePrefManager(PrefManagerImpl prefManager);

    @Binds
    @Singleton
    abstract RestManager provideRestManager(RestManagerImpl restManager);


    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    static SingleLiveData<Integer> provideIntegerSingleLiveData() {
        return new SingleLiveData<>();
    }

    @Provides
    @ApplicationContext
    static Context provideAppContext() {
        return BaseApplication.getInstance();
    }
}