package com.dimples.ui.main.book.presenter;

import android.util.Log;

import com.dimples.base.BasePresenter;
import com.dimples.base.BaseTask;
import com.dimples.http.result.IResult;
import com.dimples.ui.main.book.IBookDetailContract;
import com.dimples.ui.main.book.dto.TreatPatientResultBean;
import com.dimples.ui.main.book.dto.TreatPatientBean;
import com.dimples.ui.main.book.module.BookDetailHttpServer;

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
                return new BookDetailHttpServer<TreatPatientResultBean>().getData("00026", "待诊");
            }

            @Override
            public void onSuccess(IResult<TreatPatientResultBean> t) {
                TreatPatientResultBean data = t.getData();
                Log.i(D_TAG, "onSuccess: " + data);
            }
        });

    }
}










