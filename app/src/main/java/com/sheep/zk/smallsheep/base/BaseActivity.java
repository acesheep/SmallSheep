package com.sheep.zk.smallsheep.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sheep.zk.smallsheep.manager.ActivityManager;

import butterknife.ButterKnife;

/**
 * Created by sheep on 2018/5/3.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Context context;

    /**
     * 初始化布局
     */
    public abstract int setCustomContentViewResourceId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(setCustomContentViewResourceId());
        ActivityManager.addActivity(this);
        // 初始化View注入
        ButterKnife.bind(this);
        initView();
        initPresenter();

    }

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化控制中心
     */
    public abstract void initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}

