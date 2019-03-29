package com.dimples.ui.main.book.presenter;

import com.dimples.base.BasePresenter;
import com.dimples.task.Task;
import com.dimples.ui.main.book.IBookDetailContract;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 11:13
  */
public class BookDetailPresenter extends BasePresenter<IBookDetailContract.IView> implements IBookDetailContract.IPresenter {

    public BookDetailPresenter(IBookDetailContract.IView view) {
        super(view);
    }

    @Override
    protected IBookDetailContract.IView getEmptyView() {
        return IBookDetailContract.EMPTY_VIEW;
    }

    @Override
    public void getPatientData() {
        submitTask(new Task() {
            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onException(Throwable throwable) {

            }

            @Override
            public Object onBackground() {
                return null;
            }
        });
    }
}










