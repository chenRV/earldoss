package com.earldoss.rv.atcall;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.earldoss.rv.atcall.Base.BaseFragment;
import com.earldoss.rv.atcall.Fragment.GuideFragment;
import com.earldoss.rv.atcall.Fragment.HomeFragment;
import com.earldoss.rv.atcall.Fragment.MonitorFragment;
import com.earldoss.rv.atcall.Fragment.SettingFragment;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by RV on 2018/2/27.
 */
public class MainActivity extends FragmentActivity{
    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private int position;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();
        initFragment();
        setListener();

//        Intent startIntent = new Intent(this, ResourceService.class);
//        startService(startIntent); // 启动实时刷新页面服务
    }
    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        mRg_main.check(R.id.rb_home);
        switchFrament(new HomeFragment());
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home://主页
                    position = 0;
                    break;
                case R.id.rb_guide://导航
                    position = 1;
                    break;
                case R.id.rb_monitor://监测
                    position = 2;
                    break;
                case R.id.rb_setting://设置
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragment fragment1 = getFragment();
            //替换
            switchFrament(fragment1);

        }
    }

    private void switchFrament(BaseFragment fragment) {
        //1.得到FragmentManger
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //3.替换
        transaction.replace(R.id.fl_content, fragment);
        //4.提交事务
        transaction.commit();
    }

    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }
    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new HomeFragment());//主页Fragment
        mBaseFragment.add(new GuideFragment());//导航Fragment
        mBaseFragment.add(new MonitorFragment());//监测Fragment
        mBaseFragment.add(new SettingFragment());//设置Fragment
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);
        mRg_main.check(R.id.rb_home);

    }
}
