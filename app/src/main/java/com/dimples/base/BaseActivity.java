package com.dimples.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dimples.component.ViewInject;
import com.dimples.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

@SuppressLint("Registered")
public class BaseActivity extends LifeCircleMvpActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (null != annotation) {
            if (annotation.LayoutId() == -1) {
                throw new RuntimeException("LayoutId = 默认值");
            } else {
                setContentView(annotation.LayoutId());
                ButterKnife.bind(this);
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }
}
