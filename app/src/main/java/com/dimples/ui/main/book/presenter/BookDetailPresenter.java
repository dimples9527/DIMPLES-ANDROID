package com.dimples.ui.main.book.presenter;

import com.dimples.base.BasePresenter;
import com.dimples.task.AbstractTask;
import com.dimples.ui.main.book.IBookDetailContract;
import com.dimples.ui.main.book.module.BookDetailHttpServer;

/**
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
        submitTask(new AbstractTask() {
            /**
             * 一定要回调到主线程
             * @param o Object
             */
            @Override
            public void onSuccess(Object o) {
                //获取网络结果

            }

            @Override
            public void onException(Throwable throwable) {

            }

            /**
             * 运行于子线程
             * @return Object
             */
            @Override
            public Object onBackground() {
                return new BookDetailHttpServer().getData("00026", "待诊");
            }
        });
    }
}










