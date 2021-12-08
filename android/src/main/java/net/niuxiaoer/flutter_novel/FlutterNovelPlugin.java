package net.niuxiaoer.flutter_novel;

import android.app.Activity;

import androidx.annotation.NonNull;


import com.bytedance.novel.pangolin.NovelConfig;
import com.bytedance.novel.pangolin.NovelSDK;
import com.bytedance.novel.pangolin.PangolinDocker;

import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.plugin.platform.PlatformViewRegistry;

/**
 * FlutterNovelPlugin
 */
public class FlutterNovelPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;
    private Activity activity;
    private FlutterPluginBinding flutterPluginBinding;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_novel");
        channel.setMethodCallHandler(this);

        this.flutterPluginBinding = flutterPluginBinding;
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        Map<String, Object> params = (Map) call.arguments;
        if (call.method.equals("init")) {
            // 初始化SDK
            NovelConfig config = new NovelConfig.Builder().appName(params.get("appName").toString()).appVersionName(params.get("appVersionName").toString()).appVersionCode((int) params.get("appVersionCode")).channel(params.get("channel").toString()).initInnerApplog((Boolean) params.get("initInnerApplog")).jsonFileName(params.get("jsonFileName").toString()).build();
            NovelSDK.INSTANCE.attach(new PangolinDocker(config), activity);
            result.success("");
        } else if (call.method.equals("start")) {
            // 打开独立的小说Activity
            NovelSDK.INSTANCE.openNovelPage(activity);
            result.success("");
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        activity = binding.getActivity();

        PlatformViewRegistry platformViewRegistry = flutterPluginBinding
                .getFlutterEngine()
                .getPlatformViewsController()
                .getRegistry();
        platformViewRegistry.registerViewFactory(
                "niuxiaoer.net/novel_banner", new NovelBannerFactory(flutterPluginBinding.getBinaryMessenger(), activity));
        platformViewRegistry.registerViewFactory(
                "niuxiaoer.net/novel_icon", new NovelIconFactory(flutterPluginBinding.getBinaryMessenger()));
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {

    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivity() {

    }
}
