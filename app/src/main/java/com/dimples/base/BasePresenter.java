package com.dimples.base;

import android.content.Context;

import com.dimples.annotation.MvpEmptyViewFactory;
import com.dimples.mvp.IMvpView;
import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.task.AbstractTask;
import com.dimples.task.TaskHelper;

/**
 * 集成MVP及网络请求快捷方式
 *
 * @author zhongyj
 * @date 2019/3/28 11:46
 */
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public Context context;

    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(AbstractTask abstractTask) {
        TaskHelper.submitTask(abstractTask, abstractTask);
    }

//    @Override
//    protected T getEmptyView() {
//        T t;
//        Class superClassGenericsType = GenericsUtils.getSuperClassGenericsType(this.getClass(), 0);
//        t = MvpEmptyViewFactory.create(superClassGenericsType);
//        return null;
//    }
}














