package com.craftmyspace.sceneform

import android.content.Context
import android.view.View
import android.widget.TextView
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.platform.PlatformView

class SceneformView internal constructor(context: Context, messenger: BinaryMessenger, id: Int) : PlatformView, MethodCallHandler {

    private val textView: TextView
    private val methodChannel: MethodChannel

    init {
        textView = TextView(context)
        textView.text = "Hello from android"
        methodChannel = MethodChannel(messenger, "plugins.cms/sceneformview$id")
        methodChannel.setMethodCallHandler(this)
    }

    override fun getView(): View {
        return textView
    }

    override fun onMethodCall(methodCall: MethodCall, result: MethodChannel.Result) {
        when (methodCall.method) {
            "setText" -> setText(methodCall, result)
            else -> result.notImplemented()
        }

    }

    private fun setText(methodCall: MethodCall, result: Result) {
        val text = methodCall.arguments as String
        textView.text = text
        result.success(null)
    }

    override fun dispose() {}
}
