package com.dimples.ui.main;

import android.support.v4.app.Fragment;

import com.dimples.mvp.ILifeCircle;
import com.dimples.mvp.IMvpView;
import com.dimples.mvp.MvpController;

public interface IMainActivityContract  {

    /**
     * View层——视图逻辑
     */
    interface IView extends IMvpView {

        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    /**
     * P层——业务逻辑
     */
    interface IPresenter extends ILifeCircle {

        void initMainFragment();

        void replaceFragment(int currentFragmentIndex);
    }

    IView emptyView = new IView() {
        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };

}
