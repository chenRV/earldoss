package com.earldoss.rv.atcall.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.earldoss.rv.atcall.Base.BaseFragment;

/**
 * Created by RV on 2018/2/27.
 * 设置
 */

public class SettingFragment extends BaseFragment{
    private static final String TAG = SettingFragment.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"其他Fragment页面被初始化了...");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");
        textView.setText("其他页面");
    }
}
