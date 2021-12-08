package net.niuxiaoer.flutter_novel;

import android.app.Activity;
import android.content.Context;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import io.flutter.plugin.common.StandardMessageCodec;

public class NovelBannerFactory extends PlatformViewFactory {
    private final Activity activity;

    public NovelBannerFactory(BinaryMessenger messenger, Activity activity) {
        super(StandardMessageCodec.INSTANCE);
        this.activity = activity;
        
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new NovelBannerView(context, args, activity);
    }
}
