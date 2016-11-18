package com.xiaoziqianbao.richtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_rich);
       textView.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动

        textView.setText(getClickableHtml(  "<div style='font-size:14px'><center><b>黄莺儿</b></center><br/>\"\n" +
                "    \"<p>园林晴昼春谁主。<br/>暖律潜催，幽谷暄和，黄鹂翩翩，<font color='red'>乍迁芳树</font>。<br/>观露湿缕金衣，叶映如簧语。<br/>晓来枝上绵蛮，似把芳心、深意低诉。<sup>(1)</sup></p>\"\n" +
                "    \"<p>基本的html元素都支持，例如设置字体 <font face='Zapfino'>font</font>, 加粗\"\n" +
                "    \" <b>bold</b>, 斜体 <i>italics</i> 或者下划线 <u>underlined</u> <span style='color:red'>CSS</span> 等等。</p>\"\n" +
                "    \"<p>列表(注意里面的链接必须有:xxx//):<ul>\"\n" +
                "    \"<li>链接:&nbsp;<a href='https://github.com/molon/MLLabel'>MLLabel</a></li>\"\n" +
                "    \"<li>邮箱:&nbsp;<a href='mailto://dudl@qq.com'>我的邮箱</a></li>\"\n" +
                "    \"<li>电话:&nbsp;<a href='tel://13612341234'>假电话号码</a></li>\"\n" +
                "    \"</ul></p>\"\n" +
                "    \"当然这些还是需要使用者自己尝试下，最好不要随便拿html源码使用，这里只是为了更好的利用html生成可用的NSAttributedString，仅仅作为辅助来用。</div>"));

        textView.setClickable(true);
         textView.setMovementMethod(LinkMovementMethod.getInstance());//点击的时候产生超链接
    }




    private CharSequence getClickableHtml(String html) {
        Spanned spannedHtml = Html.fromHtml(html);
        SpannableStringBuilder clickableHtmlBuilder = new SpannableStringBuilder(spannedHtml);
        URLSpan[] urls = clickableHtmlBuilder.getSpans(0, spannedHtml.length(), URLSpan.class);
        for(final URLSpan span : urls) {
            setLinkClickable(clickableHtmlBuilder, span);
        }
        return clickableHtmlBuilder;
    }

    private void setLinkClickable(final SpannableStringBuilder clickableHtmlBuilder,
                                  final URLSpan urlSpan) {
        int start = clickableHtmlBuilder.getSpanStart(urlSpan);
        int end = clickableHtmlBuilder.getSpanEnd(urlSpan);
        int flags = clickableHtmlBuilder.getSpanFlags(urlSpan);
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View view) {
                //Do something with URL here.
                Log.i(TAG, "onClick url=" + urlSpan.getURL() );
                Toast.makeText(MainActivity.this, urlSpan.getURL(), Toast.LENGTH_SHORT).show();
            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
    }

}
