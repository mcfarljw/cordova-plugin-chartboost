var exec = require('cordova/exec');

module.exports = {
  cacheInterstitial: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'cacheInterstitial', []);
      }
    );
  },
  cacheRewardedVideo: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'cacheRewardedVideo', []);
      }
    );
  },
  showInterstitial: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'showInterstitial', []);
      }
    );
  },
  showRewardedVideo: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'showRewardedVideo', []);
      }
    );
  },
  startWithAppId: function (appId, appSignature) {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'startWithAppId', [appId, appSignature]);
      }
    );
  }
};
