import 'package:flutter/material.dart';
import 'package:sceneform/sceneform.dart';

void main() => runApp(MaterialApp(home: MyApp()));

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('Flutter TextView example')),
        body: Column(children: [
          Expanded(
              flex: 1,
              child: Container(
                  child: Sceneform())),
          Expanded(
              flex: 1,
              child: Container(
                  color: Colors.blue[100],
                  child: Center(child: Text("Hello from Flutter!"))))
        ]));
  }
}