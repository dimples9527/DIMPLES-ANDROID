package com.dimples.base;

import com.dimples.mvp.IMvpView;
import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.task.Task;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 11:46
  */
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }

    protected void submitTask(Task task) {

    }

}
