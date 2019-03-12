package com.dimples;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dimples.widget.CustomCountDownTimer;
import com.dimples.widget.FullScreenVideoView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 启动页
 *
 * @author zhongyj
 * @date 2019/3/11 11:24
 */
public class SplashActivity extends AppCompatActivity {

    private static final String D_TAG = "D-SplashActivity";
    @BindView(R.id.vv_play_splash)
    FullScreenVideoView vvPlaySplash;
    @BindView(R.id.tv_hint_splash)
    TextView tvHintSplash;

    private CustomCountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //申请权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        } else {
            initPlay();
        }
    }

    /**
     * 设置视频播放
     */
    public void initPlay() {
        vvPlaySplash.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        //开始播放视频回调方法  start()——播放视频
        vvPlaySplash.setOnPreparedListener(MediaPlayer::start);
        //视频播放完成回调方法
        vvPlaySplash.setOnCompletionListener(MediaPlayer::start);
        //开启倒计时
        countDownTimer = new CustomCountDownTimer(3, new CustomCountDownTimer.ICountDownHandler() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTicker(int time) {
                tvHintSplash.setText("跳过(" + time + ")");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    @OnClick(R.id.tv_hint_splash)
    public void onClick() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}















