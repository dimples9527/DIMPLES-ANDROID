package com.dimples.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.ui.main.book.BookFragment;
import com.dimples.ui.main.live.LiveFragment;
import com.dimples.ui.main.mine.MineFragment;
import com.dimples.ui.main.tools.MainConstantTool;

/**
  *
  * @author zhongyj
  * @date 2019/4/17 19:55
  */
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {

    private static final String D_TAG = "D-MainActivityPresenter";
    private Fragment[] fragments = new Fragment[3];
    /**
     * 当前Fragment角标
     */
    private int currentFragmentIndex;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
        mContext = (Context) view;
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.EMPTY_VIEW;
    }

    /**
     * 初始化Fragment
     */
    @Override
    public void initMainFragment() {
        //当前Fragment下标
        this.currentFragmentIndex = MainConstantTool.BOOK;
        replaceFragment(currentFragmentIndex);
    }

    /**
     * 切换Fragment
     *
     * @param currentFragmentIndex int
     */
    @Override
    public void replaceFragment(int currentFragmentIndex) {
        Log.i(D_TAG, "MainActivityPresenter-----------------replaceFragment----currentFragmentIndex:" + currentFragmentIndex);
        for (int i = 0; i < fragments.length; i++) {
            if (currentFragmentIndex != i) {
                if (fragments[i] != null) {
                    hideFragment(fragments[i]);
                }
            }
        }
        Fragment fragment = fragments[currentFragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
            saveCurrentFragment(currentFragmentIndex);
        } else {
            newCurrentFragment(currentFragmentIndex);
            saveCurrentFragment(currentFragmentIndex);
        }
    }

    /**
     * 记录当前Fragment的下标
     *
     * @param currentFragmentIndex int
     */
    private void saveCurrentFragment(int currentFragmentIndex) {
        Log.i(D_TAG, "MainActivityPresenter-----------------saveCurrentFragment----currentFragmentIndex:" + currentFragmentIndex);
        this.currentFragmentIndex = currentFragmentIndex;
//        switch (currentFragmentIndex) {
//            case MainConstantTool.BOOK:
//                currentCheckedId = R.id.item_book;
//                break;
//            case MainConstantTool.DISCOVER:
//                currentCheckedId = R.id.item_discover;
//                break;
//            case MainConstantTool.MINE:
//                currentCheckedId = R.id.item_mine;
//                break;
//            default:
//                currentCheckedId = R.id.item_book;
//                break;
//        }
    }

    /**
     * 根据下标创建当前的Fragment
     *
     * @param currentFragmentIndex int
     */
    private void newCurrentFragment(int currentFragmentIndex) {
        Log.i(D_TAG, "MainActivityPresenter-----------------newCurrentFragment----currentFragmentIndex:" + currentFragmentIndex);
        Fragment fragment = null;
        switch (currentFragmentIndex) {
            case MainConstantTool.BOOK:
                fragment = new BookFragment();
                break;
            case MainConstantTool.DISCOVER:
                fragment = new LiveFragment();
                break;
            case MainConstantTool.MINE:
                fragment = new MineFragment();
                break;
            default:
                fragment = new BookFragment();
                break;
        }
        fragments[currentFragmentIndex] = fragment;
        //显示Fragment
        addAndShowFragment(fragment);
    }

    /**
     * 显示Fragment
     *
     * @param fragment Fragment
     */
    private void addAndShowFragment(Fragment fragment) {
        Log.i(D_TAG, "MainActivityPresenter-----------------addAndShowFragment----Fragment:" + fragment);
        if (fragment.isAdded()) {
            getView().showFragment(fragment);
        } else {
            getView().addFragment(fragment);
        }
    }

    /**
     * 隐藏Fragment
     *
     * @param fragment Fragment
     */
    private void hideFragment(Fragment fragment) {
        Log.i(D_TAG, "MainActivityPresenter-----------------hideFragment----Fragment:" + fragment);
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }
}
















