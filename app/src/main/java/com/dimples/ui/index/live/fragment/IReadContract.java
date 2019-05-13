package com.dimples.ui.index.live.fragment;

import com.dimples.mvp.ILifeCircle;
import com.dimples.mvp.IMvpView;
import com.dimples.mvp.MvpController;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;

public interface IReadContract {

    interface IView extends IMvpView {

        void setAdapterView(TreatPatientResultBean list);
    }

    interface IPresenter extends ILifeCircle {

        void getData();
    }

    IView EMPTY_VIEW = new IView() {
        @Override
        public void setAdapterView(TreatPatientResultBean list) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}



















