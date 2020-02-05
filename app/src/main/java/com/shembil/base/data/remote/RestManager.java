package com.shembil.base.data.remote;

import io.reactivex.Single;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
public interface RestManager {

    Single<String> getData();

}
