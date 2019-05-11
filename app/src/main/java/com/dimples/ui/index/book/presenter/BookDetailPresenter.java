package com.dimples.ui.index.book.presenter;

import android.util.Log;

import com.dimples.base.BasePresenter;
import com.dimples.base.BaseTask;
import com.dimples.http.result.IResult;
import com.dimples.ui.index.book.IBookDetailContract;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;
import com.dimples.ui.index.book.module.BookDetailHttpServer;

/**
 * @author zhongyj
 * @date 2019/3/28 11:13
 */
public class BookDetailPresenter extends BasePresenter<IBookDetailContract.IView> implements IBookDetailContract.IPresenter {

    private static final String D_TAG = "D-BookDetailPresenter";

    public BookDetailPresenter(IBookDetailContract.IView view) {
        super(view);
    }

    @Override
    protected IBookDetailContract.IView getEmptyView() {
        return IBookDetailContract.EMPTY_VIEW;
    }

    @Override
    public void getPatientData() {

        submitTask(new BaseTask<TreatPatientResultBean>() {
            @Override
            public IResult<TreatPatientResultBean> onBackground() {
                return new BookDetailHttpServer<TreatPatientResultBean>().getData("154924925952626", "治疗完成");
            }

            @Override
            public void onSuccess(IResult<TreatPatientResultBean> t) {
                TreatPatientResultBean data = t.getData();
                getView().showData(data);
                Log.i(D_TAG, "onSuccess: " + data);
            }
        });

    }
}










