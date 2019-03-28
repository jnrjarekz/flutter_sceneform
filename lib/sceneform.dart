import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Sceneform extends StatefulWidget {
  static const MethodChannel _channel =
  const MethodChannel('sceneform');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  @override
  State<StatefulWidget> createState() => _SceneformState();
}

class _SceneformState extends State<Sceneform> {
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
          viewType: 'plugins.cms/sceneformview'
      );
    }
    return Text(
        '$defaultTargetPlatform is not yet supported by the sceneform plugin');
  }
}