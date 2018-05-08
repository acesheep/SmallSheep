package com.sheep.zk.smallsheep.view.impl;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.sheep.zk.smallsheep.R;
import com.sheep.zk.smallsheep.base.BaseActivity;
import com.sheep.zk.smallsheep.ui.CustomToast;
import com.sheep.zk.smallsheep.util.StateBarTranslucentUtils;

import butterknife.BindView;

/**
 * Created by sheep on 2018/5/7.
 */

public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.kbv_image)
    KenBurnsView kbvImage;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_title)
    TextView tvTitle;


    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
    }

    @Override
    public void initView() {
        Glide.with(this).load(R.mipmap.welcome_image).into(kbvImage);
        logoAnim();
        titleAnim();
    }

    private void logoAnim() {
        ivLogo.setAlpha(1.0f);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.translate_top_to_center);
        ivLogo.startAnimation(animation);
    }

    private void titleAnim() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(tvTitle,"alpha",0,0f,1.0f);
        objectAnimator.setStartDelay(2000);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    @Override
    public void initPresenter() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CustomToast.makeText(context,"欢迎进入~", Toast.LENGTH_SHORT).show();
            }
        },4000);
    }
}
