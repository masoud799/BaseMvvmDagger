package com.shembil.base.data.local.prefs;

/**
 * Created by Masoud Mokhtari on 12/23/19.
 */
public interface PrefManager {

    String getAccessToken();

    void setAccessToken(String accessToken);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);
}
