package com.dimples.ui.main.book.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.dimples.R;
import com.dimples.base.BaseActivity;
import com.dimples.component.ViewInject;

import butterknife.BindView;

@ViewInject(LayoutId = R.layout.activity_book_detail)
public class BookDetailActivity extends BaseActivity {

    private static final String D_TAG = "D-BookDetailActivity";
    private static final String mBookDetailActivity = "BookDetailActivity";

    @BindView(R.id.iv_title_book_detail)
    ImageView ivTitleBookDetail;

    @Override
    public void afterBindView() {
        initAnimal();
    }

    @SuppressLint("ObsoleteSdkInt")
    private void initAnimal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewCompat.setTransitionName(ivTitleBookDetail, mBookDetailActivity);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    /**
     * 界面转场动画 ：界面共享元素
     * 适用于Android 5.0 以上系统
     */
    @SuppressLint("ObsoleteSdkInt")
    public static void start_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity, BookDetailActivity.class);
            Pair pair = new Pair(view, mBookDetailActivity);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}















