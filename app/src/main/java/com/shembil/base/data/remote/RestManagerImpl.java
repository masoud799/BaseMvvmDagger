package com.shembil.base.data.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
@Singleton
public class RestManagerImpl implements RestManager {

    @Inject
    ApiInterface mApi;

    @Inject
    RestManagerImpl() {

    }

    @Override
    public Single<String> getData() {
        return mApi.getData();
    }
}
