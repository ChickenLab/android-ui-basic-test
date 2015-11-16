package com.zamva.test;

import android.app.Application;
import android.graphics.Bitmap;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.Tracker;
import com.kakao.auth.Session;

import java.net.CookieManager;

import io.fabric.sdk.android.Fabric;

/**
 * Created by foreblue on 2015-08-10.
 */
public class ZamvaApplication extends Application {
    private static int DISK_IMAGECACHE_SIZE = 1024*1024*10;
    private static Bitmap.CompressFormat DISK_IMAGECACHE_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    private static int DISK_IMAGECACHE_QUALITY = 100;  //PNG is lossless so quality is ignored but must be provided

    private CookieManager cookieManager;
    private Tracker tracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }

    private void initKakao() {
        Session.initialize(this);
    }

    synchronized public Tracker getDefaultTracker() {
//        if (tracker == null) {
//            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
//            tracker = analytics.newTracker(R.xml.global_tracker);
//        }

        return tracker;
    }
}
