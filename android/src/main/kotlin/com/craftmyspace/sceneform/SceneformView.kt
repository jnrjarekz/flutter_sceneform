package com.craftmyspace.sceneform

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import com.google.ar.core.ArCoreApk
import com.google.ar.core.Session
import com.google.ar.sceneform.ArSceneView
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.platform.PlatformView

class SceneformView (context: Context, registrar: PluginRegistry.Registrar, id: Int) : PlatformView, MethodCallHandler {

    private val context: Context = context
    private val registrar: PluginRegistry.Registrar = registrar
    private val methodChannel: MethodChannel = MethodChannel(registrar.messenger(), "plugins.cms/sceneformview$id")
    private val view = ArSceneView(context)

    init {
        methodChannel.setMethodCallHandler(this)
    }

    override fun getView(): View {
        if (ArCoreApk.getInstance().checkAvailability(context).isSupported()) {
            if (registrar.activity().checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

                view.setupSession(Session(context))
                view.session?.resume()
            } else {
                registrar.activity().requestPermissions(arrayOf(Manifest.permission.CAMERA),153)
            }
        }
        return view
    }

    override fun onMethodCall(methodCall: MethodCall, result: MethodChannel.Result) {
        when (methodCall.method) {
            "setText" -> result.notImplemented() // setText(methodCall, result)
            else -> result.notImplemented()
        }

    }

//    private fun setText(methodCall: MethodCall, result: Result) {
//        val text = methodCall.arguments as String
//        textView.text = text
//        result.success(null)
//    }

    override fun dispose() {}


}
