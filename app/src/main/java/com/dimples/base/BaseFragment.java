package com.dimples.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimples.component.ViewInject;
import com.dimples.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

/**
  *
  * @author zhongyj
  * @date 2019/3/29 9:18
  */
@SuppressLint("Registered")
public abstract class BaseFragment extends LifeCircleMvpFragment {


    private static final String D_TAG = "D-BaseFragment";
    public Context mContext;
    public Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (null != annotation) {
            int fragmentLayoutId = annotation.LayoutId();
            if (fragmentLayoutId == -1) {
                throw new RuntimeException("LayoutId = 默认值(未注册)");
            } else {
                view = initFragmentView(inflater, fragmentLayoutId);
                bindView(view);
                afterBindView();
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
        Log.i(D_TAG,"BaseFragment------------------onCreateView");
        return view;
    }

    private View initFragmentView(LayoutInflater inflater, int fragmentLayoutId) {
        return inflater.from(mContext).inflate(fragmentLayoutId, null);
    }


    /**
     * 模板方法  设计模式
     */
    public abstract void afterBindView();

    /**
     * View的依赖注解绑定
     */
    private void bindView(View view) {
        ButterKnife.bind(this, view);
    }
}
