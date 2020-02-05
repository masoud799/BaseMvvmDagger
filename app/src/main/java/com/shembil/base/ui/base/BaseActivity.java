package com.shembil.base.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModelProviders;

import com.shembil.base.di.utils.ViewModelFactory;
import com.shembil.base.utils.CommonUtils;
import com.shembil.base.utils.NetworkUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
public abstract class BaseActivity<T extends BaseViewModel> extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory mViewModelFactory;
    public T mViewModel;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    public void createViewModel(Class<T> clazz) {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(clazz);
        startObserving();
    }

    protected abstract void startObserving();

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void openActivityOnTokenExpire() {

    }

    public void showToast(String message) {
        if (getApplicationContext() != null)
            CommonUtils.showCustomToast(getApplicationContext(), message);
    }

    public void showToast(@StringRes int string) {
        if (getApplicationContext() != null && string != 0)
            CommonUtils.showCustomToast(getApplicationContext(), getString(string));
    }

}