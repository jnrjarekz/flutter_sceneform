package com.craftmyspace.sceneform

import io.flutter.plugin.common.PluginRegistry.Registrar

class SceneformPlugin  {

    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            registrar
                    .platformViewRegistry()
                    .registerViewFactory(
                            "plugins.cms/sceneformview", SceneformViewFactory(registrar))
        }
    }
}
