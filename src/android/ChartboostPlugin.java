package com.jernung.plugins.chartboost;

import android.util.Log;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;

public class ChartboostPlugin extends CordovaPlugin {

    private static final String PLUGIN_NAME = "ChartboostPlugin";

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("cacheInterstitial".equals(action)) {
            cacheInterstitial();
            callbackContext.success();

            return true;
        }

        if ("showInterstitial".equals(action)) {
            showInterstitial();
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

    private void cacheInterstitial () {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "caching interstitial");

                Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
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

    private void startWithAppId (final String appId, final String appSignature) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Log.d(PLUGIN_NAME, "starting app with id " + appId);

                Chartboost.startWithAppId(cordova.getActivity(), appId, appSignature);
                Chartboost.onCreate(cordova.getActivity());
            }
        });
    }

}
