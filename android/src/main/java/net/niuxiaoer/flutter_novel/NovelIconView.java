package net.niuxiaoer.flutter_novel;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bytedance.novel.pangolin.NovelSDK;
import com.bytedance.novel.pangolin.novelenterence.NovelEntranceConstants;
import com.bytedance.novel.pangolin.novelenterence.view.BaseEntranceView;

import io.flutter.plugin.platform.PlatformView;

public class NovelIconView implements PlatformView {
    private final FrameLayout myNativeView;

    NovelIconView(Context context) {
        myNativeView = new FrameLayout(context);

        BaseEntranceView iconView = NovelSDK.INSTANCE.getIconView(context, NovelEntranceConstants.IconType.CIRCLE);
        LinearLayout.LayoutParams iconViewLayoutParams = new LinearLayout.LayoutParams(150,150);
        myNativeView.setLayoutParams(iconViewLayoutParams);

        myNativeView.addView(iconView);
        iconView.show();
    }

    @Override
    public View getView() {
        return myNativeView;
    }

    @Override
    public void dispose() {
        myNativeView.removeAllViews();
    }
}
