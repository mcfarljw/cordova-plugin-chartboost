package com.jernung.plugins.chartboost;

import android.util.Log;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging.Level;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

public class ChartboostPlugin extends CordovaPlugin {

    private static final String PLUGIN_NAME = "ChartboostPlugin";

    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("cacheInterstitial".equals(action)) {
            cacheInterstitial();
            callbackContext.success();

            return true;
        }

        if ("cacheRewardedVideo".equals(action)) {
            cacheRewardedVideo();
            callbackContext.success();

            return true;
        }

        if ("showInterstitial".equals(action)) {
            showInterstitial();
            callbackContext.success();

            return true;
        }

        if ("showRewardedVideo".equals(action)) {
            showRewardedVideo();
            callbackContext.success();

            return true;
        }

        if ("startWithAppId".equals(action)) {
            startWithAppId(args.getString(0), args.getString(1));
            callbackContext.success();

            return true;
        }

        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Chartboost.onDestroy(cordova.getActivity());
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        Chartboost.onPause(cordova.getActivity());
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        Chartboost.onResume(cordova.getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        Chartboost.onStop(cordova.getActivity());
    }

    private void cacheInterstitial () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "caching interstitial");

                Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
            }
        });
    }

    private void cacheRewardedVideo () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "caching rewarded video");

                Chartboost.cacheRewardedVideo(CBLocation.LOCATION_DEFAULT);
            }
        });
    }

    private void showInterstitial () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "showing interstitial");

                Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
            }
        });
    }

    private void showRewardedVideo () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "showing rewarded video");

                Chartboost.showRewardedVideo(CBLocation.LOCATION_DEFAULT);
            }
        });
    }


    private void startWithAppId (final String appId, final String appSignature) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "starting app with id " + appId);

                Chartboost.startWithAppId(cordova.getActivity(), appId, appSignature);
                Chartboost.setLoggingLevel(Level.NONE);
                Chartboost.onCreate(cordova.getActivity());
                Chartboost.onStart(cordova.getActivity());
            }
        });
    }

}
