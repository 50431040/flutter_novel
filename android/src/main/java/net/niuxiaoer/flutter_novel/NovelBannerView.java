package net.niuxiaoer.flutter_novel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bytedance.novel.pangolin.NovelSDK;
import com.bytedance.novel.pangolin.novelenterence.NovelEntranceConstants;
import com.bytedance.novel.pangolin.novelenterence.view.BaseEntranceView;

import io.flutter.plugin.platform.PlatformView;

public class NovelBannerView implements PlatformView {
    private final FrameLayout myNativeView;

    NovelBannerView(Context context, Object args, Activity activity) {
        myNativeView = new FrameLayout(context);

        // 1为16:3 | 2为16:5 | 3为16:9
        String size = args.toString().equals("1") ? NovelEntranceConstants.BannerType.SIXTEEN_THREE : args.toString().equals("2") ? NovelEntranceConstants.BannerType.SIXTEEN_FIVE : NovelEntranceConstants.BannerType.SIXTEEN_NINE;
        BaseEntranceView bannerView = NovelSDK.INSTANCE.getBannerView(activity, size);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        myNativeView.setLayoutParams(layoutParams);

        myNativeView.addView(bannerView);
        
        bannerView.show();
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
