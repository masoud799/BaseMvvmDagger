package com.shembil.base.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModelProviders;

import com.shembil.base.di.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
public abstract class BaseFragment<T extends BaseViewModel> extends DaggerFragment {

    @Inject
    ViewModelFactory mViewModelFactory;
    public T mViewModel;

    private Unbinder unbinder;
    private BaseActivity mActivity;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void createViewModel(Class<T> clazz) {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(clazz);
        startObserving();
    }

    protected abstract void startObserving();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public void showToast(String message) {
        if (mActivity != null)
            mActivity.showToast(message);
    }

    public void showToast(@StringRes int string) {
        if (mActivity != null)
            mActivity.showToast(string);
    }
}
