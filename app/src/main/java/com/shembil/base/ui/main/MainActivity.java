package com.shembil.base.ui.main;

import android.os.Bundle;

import com.shembil.base.R;
import com.shembil.base.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createViewModel(MainViewModel.class);
    }

    @Override
    protected void startObserving() {

    }
}
