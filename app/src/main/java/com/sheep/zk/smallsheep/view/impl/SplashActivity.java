package com.sheep.zk.smallsheep.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sheep.zk.smallsheep.R;
import com.sheep.zk.smallsheep.base.BaseActivity;
import com.sheep.zk.smallsheep.fragments.CustomTutorialSupportFragment;
import com.sheep.zk.smallsheep.util.StateBarTranslucentUtils;


/**
 * Created by sheep on 2018/5/2.
 */

public class SplashActivity extends BaseActivity {


    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
    }

    @Override
    public void initView() {
        replaceTutorialFragment();
    }

    @Override
    public void initPresenter() {

    }
    public void replaceTutorialFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container_splash, new CustomTutorialSupportFragment())
                .commit();
    }
}
