package com.bawei.spannablestringdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    /*
    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)
    Spanned.SPAN_INCLUSIVE_EXCLUSIVE(前包括，后不包括)
    Spanned.SPAN_EXCLUSIVE_INCLUSIVE(前不包括，后包括)
    Spanned.SPAN_INCLUSIVE_INCLUSIVE(前后都包括)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(R.id.textView);


        String content = "我是要显示的内容" ;
        SpannableString spannableString = new SpannableString(content);


        //设置背景色
        spannableString.setSpan(new BackgroundColorSpan(Color.GRAY),0,4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //设置前景色
        spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //下划线
        spannableString.setSpan(new UnderlineSpan(),0,4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //显示图片
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,80,80);
        spannableString.setSpan(new ImageSpan(drawable),7,8, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //加粗倾斜
        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),3,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //下标
        spannableString.setSpan(new SubscriptSpan(),3,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //上标
        spannableString.setSpan(new SuperscriptSpan(),1,2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        //超文本连接
        //点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                System.out.println("widget = " + widget);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED);
                ds.setUnderlineText(true);
            }
        } ;

        spannableString.setSpan(new URLSpan("http://www.baidu.com"),3,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        textView.setText(spannableString);


        //超文本连接  让URLSpan可以点击
        textView.setMovementMethod(new LinkMovementMethod());



    }
}
