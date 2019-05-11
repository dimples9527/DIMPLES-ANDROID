package com.dimples.ui.index.book;

import com.dimples.mvp.ILifeCircle;
import com.dimples.mvp.IMvpView;
import com.dimples.mvp.MvpController;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 11:15
  */
public interface IBookDetailContract {

    /**
     * View层——视图逻辑
     */
    interface IView extends IMvpView {

        /**
         *  showData
         * @param data TreatPatientResultBean
         */
        void showData(TreatPatientResultBean data);
    }

    /**
     * P层——业务逻辑
     */
    interface IPresenter extends ILifeCircle {

        /**
         * 获取数据
         */
        void getPatientData();
    }

    IBookDetailContract.IView EMPTY_VIEW = new IBookDetailContract.IView() {


        @Override
        public void showData(TreatPatientResultBean data) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };

}
