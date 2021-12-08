package net.niuxiaoer.flutter_novel;

import android.content.Context;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class NovelIconFactory extends PlatformViewFactory {

    public NovelIconFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new NovelIconView(context);
    }
}
