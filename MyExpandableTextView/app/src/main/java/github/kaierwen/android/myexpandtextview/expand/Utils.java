package github.kaierwen.android.myexpandtextview.expand;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import github.kaierwen.android.myexpandtextview.R;

/**
 * https://cloud.tencent.com/developer/article/1734055
 */
public class Utils {
    /**
     * 添加监听
     *
     * @param tv   要实现伸缩效果的 TextView
     * @param desc TextView 要展示的文字
     */
    public static void toggleEllipsize(final TextView tv, final String desc) {
        if (desc == null) {
            return;
        }

        //去除点击图片后的背景色（ SpannableString 在点击时会使背景变色 ，填上这句则可不变色 ）
        tv.setHighlightColor(Color.TRANSPARENT);

        //添加 TextView 的高度监听
        tv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {

                int paddingLeft = tv.getPaddingLeft();
                int paddingRight = tv.getPaddingRight();
                TextPaint paint = tv.getPaint();
                float moreText = tv.getTextSize() * 3;
                float availableTextWidth = (tv.getWidth() - paddingLeft - paddingRight) * 2 - moreText;
                CharSequence ellipsizeStr = TextUtils.ellipsize(desc, paint, availableTextWidth, TextUtils.TruncateAt.END);

                // TextView 实际显示的文本长度 < 应该显示文本的长度(收缩状态)
                if (ellipsizeStr.length() < desc.length()) {
                    openFun(tv, ellipsizeStr, desc);//显示收缩状态的文本和图标
                }
                // TextView 实际显示的文本长度 == 应该显示文本的长度(正常状态)
                else if (ellipsizeStr.length() == desc.length()) {
                    tv.setText(desc);//正常显示Textview
                }
                // TextView 实际显示的文本长度   应该显示文本的长度(展开状态)
                else {
                    closeFun(tv, ellipsizeStr, desc);//显示展开状态的文本和图标
                }

                if (Build.VERSION.SDK_INT == 16) {
                    tv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    tv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    // 显示收缩状态的文本，设置点击图标，并添加点击事件
    private static void openFun(final TextView tv,final CharSequence ellipsizeStr,final String desc){
        CharSequence temp = ellipsizeStr+".";
        SpannableStringBuilder ssb = new SpannableStringBuilder(temp);
        Drawable dd = tv.getResources().getDrawable(R.drawable.ic_expand);
        dd.setBounds(0, 0, dd.getIntrinsicWidth(), dd.getIntrinsicHeight());
        ClickableImageSpan is = new ClickableImageSpan(dd) {
            @Override
            public void onClick(View view) {
                closeFun(tv,ellipsizeStr,desc);
            }

        };
        ssb.setSpan(is, temp.length()-1, temp.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(ssb);
        tv.setMovementMethod(ClickableMovementMethod.getInstance());
    }

    // 显示展开状态的文本，设置点击图标，并添加点击事件
    private static void closeFun(final TextView tv,final CharSequence ellipsizeStr,final String desc) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(desc);
        Drawable dd = tv.getResources().getDrawable(R.drawable.ic_normal);
        dd.setBounds(0, 0, dd.getIntrinsicWidth(), dd.getIntrinsicHeight());
        ClickableImageSpan is = new ClickableImageSpan(dd) {
            @Override
            public void onClick(View view) {
                openFun(tv,ellipsizeStr,desc);
            }
        };
        ssb.setSpan(is, desc.length()-1, desc.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(ssb);
        tv.setMovementMethod(ClickableMovementMethod.getInstance());
    }
}
