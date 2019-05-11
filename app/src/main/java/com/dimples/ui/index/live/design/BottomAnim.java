package com.dimples.ui.index.live.design;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.dimples.R;

/**
  *
  * @author zhongyj
  * @date 2019/4/18 18:12
  */
public class BottomAnim {

    public static void show(View view) {
        //展示的动画
        view.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(view.getContext(), R.anim.translate_show);
        view.startAnimation(animationShow);
        view.setVisibility(View.VISIBLE);
    }

    public static void hide(View view) {
        //消失的动画
        view.clearAnimation(); //清楚自身动画
        Animation animationGone = AnimationUtils.loadAnimation(view.getContext(), R.anim.translate_hide);
        view.startAnimation(animationGone);
        view.setVisibility(View.INVISIBLE);
    }

}














