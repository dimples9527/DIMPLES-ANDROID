package com.dimples.ui.splash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.dimples.ui.index.IndexActivity;
import com.dimples.R;
import com.dimples.base.BaseActivity;
import com.dimples.component.ViewInject;
import com.dimples.widget.FullScreenVideoView;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 启动页
 *
 * @author zhongyj
 * @date 2019/3/11 11:24
 */
@ViewInject(LayoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    private static final String D_TAG = "D-SplashActivity";

    @BindView(R.id.vv_play_splash)
    FullScreenVideoView vvPlaySplash;
    @BindView(R.id.tv_hint_splash)
    TextView tvHintSplash;

    @Override
    public void afterBindView() {
        //申请权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        } else {
            initTimerPresenter();
            initVideo();
        }
    }


    @Override
    public void setTvTimer(String s) {
        tvHintSplash.setText(s);
    }

    @Override
    public void pageSwitch(Context context, Class<?> cls) {
        startActivity(new Intent(context,cls));
    }

    @OnClick(R.id.tv_hint_splash)
    public void onClick() {
        Intent intent = new Intent(SplashActivity.this, IndexActivity.class);
        startActivity(intent);
        finish();
    }

    private void initTimerPresenter() {
        ISplashActivityContract.IPresenter timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        vvPlaySplash.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        //开始播放视频回调方法  start()——播放视频
        vvPlaySplash.setOnPreparedListener(MediaPlayer::start);
        //视频播放完成回调方法
        vvPlaySplash.setOnCompletionListener(MediaPlayer::start);
    }
}















