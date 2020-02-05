package com.shembil.base.data.remote;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
public interface ApiInterface {

    @GET("/api/v1/")
    Single<String> getData();

}
