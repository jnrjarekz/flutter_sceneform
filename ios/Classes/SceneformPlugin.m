#import "SceneformPlugin.h"
#import <sceneform/sceneform-Swift.h>

@implementation SceneformPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSceneformPlugin registerWithRegistrar:registrar];
}
@end
