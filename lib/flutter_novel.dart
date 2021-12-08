
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterNovel {
  static const MethodChannel _channel =
      const MethodChannel('flutter_novel');

  // 初始化
  static Future<void> init({ String appName, String appVersionName, int appVersionCode, String channel, bool initInnerApplog = true, String jsonFileName = "config.json" }) async {
    await _channel.invokeMethod('init', {
      "appName": appName,
      "appVersionName": appVersionName,
      "appVersionCode": appVersionCode,
      "channel": channel,
      "initInnerApplog": initInnerApplog,
      "jsonFileName": jsonFileName
    });
  }

  static Future<void> start() async {
    await _channel.invokeMethod('start');
  }
}
