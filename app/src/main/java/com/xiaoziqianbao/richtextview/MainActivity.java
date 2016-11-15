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

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_rich);
       // textView.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动

        textView.setText(getClickableHtml(  "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                "<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
                "<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
                "<meta name=\"format-detection\" content=\"telephone=no\">\n" +
                "<meta name=\"description\" id=\"descript\" content=\"小资钱包活动分享文字简介\">\n" +
                "<title>小资钱包活动标题</title>\n" +
                "<link href=\"../css/app_base.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                "<style>\n" +
                "body{ margin:0; font-family:Helvetica, \"微软雅黑\"; margin:0 auto; font-size:14px; line-height:26px; background:#f7f7f7;}\n" +
                "img{ vertical-align:middle; width:100%;}\n" +
                "a{ text-decoration:none;}\n" +
                ".infor{ margin-bottom:2%;font-size:14px; color:#666; line-height:1.5em;}\n" +
                ".infor1{ padding:2% 4%; background:#fff;}\n" +
                ".infor2{ padding:2% 4%; background:#fff; margin-top:2%; overflow:hidden;}\n" +
                ".infor1 head,.infor2 .head{ padding:3% 0;}\n" +
                ".infor2 h2{ color:#d0bc88; font-size:16px;}\n" +
                ".head img{ padding-right:5px; width:100%; max-width:25px; display:inline-block;}\n" +
                ".infor2 p{ margin-left:30px; padding-left:15px; background:url(images/information/infor5.png) no-repeat 0 7px; background-size:11px; line-height:25px; margin-bottom:2%;}\n" +
                ".infor3{ max-width:720px; display:block; margin:0 auto;}\n" +
                ".head span{ display:inline-block;}\n" +
                "table{ border-collapse:collapse;}\n" +
                "table td{ line-height:1.5em; padding:5px 5px;}\n" +
                "table td:first-child{ width:90px;}\n" +
                ".img img{ margin-bottom:5px;}\n" +
                ".main{ position:relative;}\n" +
                ".share{ position:fixed; display:inline-block; line-height:50px; text-align:center; top:10px; right:10px; width:50px; height:50px; background:#999; color:#fff; border-radius:50%; -webkit-border-radius:50%;}\n" +
                ".canyu{ position:fixed; bottom:10px; width:60%; left:20%; display:inline-block; text-align:center; line-height:30px; background:#999; color:#fff; display:none;}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div class=\"main\">\n" +
                "\t<a href=\"javascript:;\" class=\"share\" id=\"shareBut\">分享</a>\n" +
                "\t<div class=\"infor\" style=\"padding:10px;\">\n" +
                "\t活动分享测试\n" +
                "\t</div>\n" +
                "\t<div class=\"infor\" style=\"padding:10px;\">\n" +
                "\t活动分享测试\n" +
                "\t</div>\n" +
                "\t<div class=\"infor\" style=\"padding:10px;\">\n" +
                "\t活动分享测试\n" +
                "\t</div>\n" +
                "\t<div class=\"infor\" style=\"padding:10px;\">\n" +
                "\t活动分享测试\n" +
                "\t</div>\n" +
                "\t<div class=\"infor\" style=\"padding:10px;\">\n" +
                "\t活动分享测试\n" +
                "\t</div>\n" +
                "\t<a href=\"http://a.app.qq.com/o/simple.jsp?pkgname=com.xiaoziqianbao.xzqb\" class=\"canyu\" id=\"different\">下载APP</a>\n" +
                "</div>\n" +
                "<script src=\"http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js\"></script>\n" +
                "<script>\n" +
                "function url(name) {\n" +
                "\tvar reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\");\n" +
                "\tvar r = window.location.search.substr(1).match(reg);\n" +
                "\tvar local=document.getElementById(\"url\");\n" +
                "\tif (r != null) {\n" +
                "\t\treturn unescape(r[2])\n" +
                "\t}\n" +
                "\treturn null\n" +
                "}\n" +
                "var different=document.getElementById(\"different\");\n" +
                "var shareBut=document.getElementById(\"shareBut\");\n" +
                "var shareDif = url('shareDif'); \n" +
                "var shareImgUrl=url('shareImgUrl');\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "console.log(shareDif);\n" +
                "console.log(shareImgUrl);\n" +
                "if(shareDif){    //若地址中存在该变量，则引导下载按钮显示；分享按钮不显示\n" +
                "\tdifferent.style.display=\"block\";\n" +
                "\tshareBut.style.display=\"none\";\n" +
                "};\n" +
                "shareBut.onclick=function(){\n" +
                "\tturnShare();\t\n" +
                "}\n" +
                "\n" +
                "var shareImgUrl=\"http://www.xiaoziqianbao.com/pcstatic/images/logo.jpg\";  //分享图片地址\n" +
                "\n" +
                "var shareTitle=document.getElementsByTagName(\"title\")[0].innerHTML; //分享标题\n" +
                "var shareDescript=document.getElementById(\"descript\").content;  //分享简介\n" +
                "console.log(shareImgUrl);\n" +
                "console.log(shareUrl);\n" +
                "console.log(shareTitle);\n" +
                "console.log(shareDescript);\n" +
                "//var shareUrl=window.location.href+\"?shareDif=1\";  //分享地址\n" +
                "var shareUrl=window.location.href;  //分享地址\n" +
                "\n" +
                "var arr = shareUrl.split('?');\n" +
                "console.log(arr);\n" +
                "//var ar = arr[arr.length-1];  //获取url的最后一个参数\n" +
                "shareUrl=arr[0]+\"?shareDif=1\";\n" +
                "console.log(shareUrl);\n" +
                "\n" +
                "/*alert(ar);\n" +
                "alert(arr[0]);*/\n" +
                "\n" +
                "(function(a) {\n" +
                "\tvar b = a.navigator,\n" +
                "\tc = b.userAgent,\n" +
                "\td = c.match(/(Android)[\\s\\/]*([\\d\\.]+)/i),\n" +
                "\te = c.match(/(iPad|iPhone|iPod)[\\w\\s]*;(?:[\\w\\s]+;)*[\\w\\s]+(?:iPad|iPhone|iPod)?\\sOS\\s([\\d_\\.]+)/i),\n" +
                "\tf = c.match(/(Windows\\s+Phone)(?:\\sOS)?\\s([\\d\\.]+)/i),\n" +
                "\tg = /WebKit\\/[\\d.]+/i.test(c),\n" +
                "\th = e ? b.standalone ? g: /Safari/i.test(c) && !/CriOS/i.test(c) && !/MQQBrowser/i.test(c) : !1,\n" +
                "\ti = {};\n" +
                "\td && (i.android = !0, i.version = d[2], i.android4 = /^4/.test(i.version), i.android3 = /^3/.test(i.version), i.android2 = /^2/.test(i.version)),\n" +
                "\te && (i.ios = !0, i.version = e[2].replace(/_/g, \".\"), i[\"ios\" + i.version.match(/^(\\w+)/i)[1]] = !0, \"iPad\" === e[1] ? i.ipad = !0 : \"iPhone\" === e[1] ? i.iphone = !0 : \"iPod\" === e[1] && (i.ipod = !0)),\n" +
                "\tf && (i.wp = !0, i.version = f[2], i.wp8 = /^8/.test(i.version), i.wp7 = /^7/.test(i.version)),\n" +
                "\ta.supporter = {\n" +
                "\t\tos: i,\n" +
                "\t\tisSmartDevice: function() {\n" +
                "\t\t\treturn !! (i.ios || i.android || i.wp)\n" +
                "\t\t} (),\n" +
                "\t\tisWebkit: g,\n" +
                "\t\tisSafari: h,\n" +
                "\t\tisBelowIos7: !!(i.ios && i.version.match(/^(\\w+)/i)[1] < 7),\n" +
                "\t\tisUC: /UC/i.test(c),\n" +
                "\t\tisQQ: /QBrowser/i.test(c),\n" +
                "\t\tisWX: /MicroMessenger/i.test(c)\n" +
                "\t}\n" +
                "})(window);\n" +
                "function turnShare(){   //跳转红包页面\n" +
                "\tif(supporter.os.ios){\n" +
                "\t\tvar iosH = \"http://www.xiaoziqianbao.com/xzqb_ios_shareActivity?shareUrl=\"+shareUrl+\"&shareTitle=\"+shareTitle+\"&shareDescript=\"+shareDescript+\"&shareImgUrl=\"+shareImgUrl;\n" +
                "\t\t//var iosH = \"http://www.xiaoziqianbao.com/xzqb_ios_shareActivity?\"+shareUrl+\"&\"+shareTitle+\"&\"+shareDescript+\"&\"+shareImgUrl;\n" +
                "\t\tdocument.location.href=iosH;\n" +
                "\t}else if(supporter.os.android){\n" +
                "\t\t//uti.turnCoupon($(\"#prtp\").val().toString());\n" +
                "\t\tuti.shareActivity(shareUrl,shareTitle,shareDescript,shareImgUrl);\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n"));

     //   textView.setClickable(true);
        // textView.setMovementMethod(LinkMovementMethod.getInstance());//点击的时候产生超链接
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
            }
        };
        clickableHtmlBuilder.setSpan(clickableSpan, start, end, flags);
    }

}
