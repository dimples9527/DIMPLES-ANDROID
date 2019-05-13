package com.dimples.ui.index.live.fragment;

import com.dimples.base.BasePresenter;
import com.dimples.ui.index.book.bean.TreatPatientBean;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;

import java.util.ArrayList;
import java.util.List;

public class ReadPresenter extends BasePresenter<IReadContract.IView> implements IReadContract.IPresenter {

    public ReadPresenter(IReadContract.IView view) {
        super(view);
    }

    @Override
    protected IReadContract.IView getEmptyView() {
        return IReadContract.EMPTY_VIEW;
    }

    @Override
    public void getData() {
        int len = 20;
        List<TreatPatientBean> list = new ArrayList<>(len);
        TreatPatientResultBean bean = new TreatPatientResultBean();

        for (int i = 0; i < len; i++) {
            TreatPatientBean patientBean = new TreatPatientBean();
            patientBean.setPatientName("数据" + i);
            list.add(patientBean);
        }
        bean.setData(list);
        getView().setAdapterView(bean);
    }
}

















