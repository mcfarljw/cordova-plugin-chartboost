package com.jernung.plugins.chartboost;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;

import java.io.IOException;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

public class ChartboostPlugin extends CordovaPlugin {

    private static final String PLUGIN_NAME = "ChartboostPlugin";

    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if ("load".equals(action)) {
            callbackContext.success();

            return true;
        }

        return false;
    }

}
