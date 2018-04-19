package com.earldoss.rv.atcall.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.earldoss.rv.atcall.Base.BaseFragment;
import com.earldoss.rv.atcall.R;

/**
 * Created by RV on 2018/2/27.
 * 监测
 */

public class MonitorFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monitor,container,false);
    }


}
