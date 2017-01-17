package com.spikes.resume.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Luca Rossi
 * (luca.rossi@alea.pro) on 17/01/2017.
 */

public class App extends Application {

    private static App sInstance;

    private SharedPreferences mSharedPreferences;

    public static App get() {
        return sInstance;
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    public static AssetManager getAssetManager() {
        return sInstance.getAssets();
    }

    public static SharedPreferences getSharedPreferences() {
        return sInstance.mSharedPreferences;
    }

    public static boolean isPermissionGranted(@NonNull String permission) {
        return ActivityCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }
}