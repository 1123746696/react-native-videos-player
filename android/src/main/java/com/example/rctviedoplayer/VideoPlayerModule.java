package com.example.rctviedoplayer;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;


/**
 * Created by user on 2016/11/15.
 */

public class VideoPlayerModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;
    public VideoPlayerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "VideoPlayer";
    }
    @ReactMethod
    public void play(ReadableMap map) {
        String path = map.getString("url");
        if (TextUtils.isEmpty(path)) {
            return ;
        }

        final Context context = getCurrentActivity();
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra("PATH", path);
        context.startActivity(intent);
    }
}