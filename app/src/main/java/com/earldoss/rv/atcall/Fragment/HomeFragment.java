package com.earldoss.rv.atcall.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.earldoss.rv.atcall.Base.BaseFragment;
import com.earldoss.rv.atcall.R;


/**
 * Created by RV on 2018/2/27.
 * 主页
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private ImageButton btn_110;
    private ImageButton btn_120;
    private ImageButton btn_family;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_guide, container, false);
        initData();
        return view;

    }

    @Override
    protected void initData() {
        super.initData();
        //实例化按钮
        btn_110 = (ImageButton) view.findViewById(R.id.btn_call110);
        btn_120 = (ImageButton) view.findViewById(R.id.btn_call120);
        btn_family = (ImageButton) view.findViewById(R.id.btn_callfamily);
        setListeners();
        //初始化 网页及html
        WebView mapWeb = (WebView) view.findViewById(R.id.webv_map);
        WebView photoWeb = (WebView) view.findViewById(R.id.webv_photo);

        String mapUrl = "file:///android_asset/map.html";
        String photoUrl = "file:///android_asset/fake.html";
//        String mapUrl = "http://www.baidu.com";
//       String photoUrl = "http://www.baidu.com";

        setWebviewContext(mapWeb,mapUrl);
        setWebviewContext(photoWeb,photoUrl);

    }
    private void setListeners(){
        btn_110.setOnClickListener(this);
        btn_120.setOnClickListener(this);
        btn_family.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_call110:
                call("110");
                break;
            case R.id.btn_call120:
                call("120");
                break;
            case R.id.btn_callfamily:
                call("123456");
                break;
            default:
                break;
        }
    }

    //只调用拨号界面，不拨出电话
    private void call(String phoneNo){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNo));
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    //加载页面
    private void setWebviewContext(WebView wv_produce,String htmlUrl){
        //loadUrl("file:///android_asset/test.html");
        wv_produce.loadUrl(htmlUrl);

        //支持App内部JavaScript交互
        wv_produce.getSettings().setJavaScriptEnabled(true);
        //重要！！！设置是否开启DOM存储API权限
        wv_produce.getSettings().setDomStorageEnabled(true);
        //调整网页至webview大小
        wv_produce.setWebViewClient(new WebViewClient());
        wv_produce.getSettings().setUseWideViewPort(true);
        wv_produce.getSettings().setLoadWithOverviewMode(true);
        //设置是否出现缩放工具
        wv_produce.getSettings().setBuiltInZoomControls(true);
        //设置可以支持缩放
        wv_produce.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        wv_produce.getSettings().setUseWideViewPort(true);

        //设置编码为utf-8
        wv_produce.getSettings().setDefaultTextEncodingName("utf-8");
    }
}

