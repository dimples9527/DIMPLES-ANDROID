package com.dimples.ui.main.book;

import com.dimples.mvp.ILifeCircle;
import com.dimples.mvp.IMvpView;
import com.dimples.mvp.MvpController;

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
        public MvpController getMvpController() {
            return null;
        }
    };

}
