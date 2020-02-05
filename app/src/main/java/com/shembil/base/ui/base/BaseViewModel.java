package com.shembil.base.ui.base;

import androidx.lifecycle.ViewModel;

import com.shembil.base.data.local.prefs.PrefManager;
import com.shembil.base.data.remote.RestManagerImpl;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Masoud Mokhtari on 12/24/19.
 */
public class BaseViewModel extends ViewModel {

    @Inject
    protected PrefManager mPrefManager;

    @Inject
    protected RestManagerImpl mRestManager;

    @Inject
    protected CompositeDisposable mCompositeDisposable;

    protected BaseViewModel() {
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
