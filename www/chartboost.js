var exec = require('cordova/exec');

module.exports = {
  cacheInterstitial: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'cacheInterstitial', []);
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
  startWithAppId: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'startWithAppId', [appId, appSignature]);
      }
    );
  }
};
