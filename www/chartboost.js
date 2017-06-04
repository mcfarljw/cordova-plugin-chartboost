var exec = require('cordova/exec');

module.exports = {
  load: function () {
    return new Promise(
      function (resolve, reject) {
        exec(resolve, reject, 'ChartboostPlugin', 'load', []);
      }
    );
  }
};
