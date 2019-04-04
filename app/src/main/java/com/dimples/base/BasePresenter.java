package com.dimples.base;

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

    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(AbstractTask abstractTask) {
        TaskHelper.submitTask(abstractTask, abstractTask);
    }

}
