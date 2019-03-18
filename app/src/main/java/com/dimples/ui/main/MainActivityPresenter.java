package com.dimples.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.dimples.R;
import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.ui.discover.DiscoverFragment;
import com.dimples.ui.book.BookFragment;
import com.dimples.ui.mine.MineFragment;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {

    private static final String D_TAG = "D-MainActivityPresenter";
    private Fragment fragments[] = new Fragment[3];
    /**
     * 当前Fragment角标
     */
    private int currentFragmentIndex;
    private int currentCheckedId;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
        context = (Context) view;
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    /**
     * 初始化Fragment
     */
    @Override
    public void initMainFragment() {
        //当前Fragment下标
        this.currentFragmentIndex = 0;
        replaceFragment(currentFragmentIndex);
    }

    /**
     * 切换Fragment
     *
     * @param currentFragmentIndex int
     */
    private void replaceFragment(int currentFragmentIndex) {
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
        switch (currentFragmentIndex) {
            case 0:
                currentCheckedId = R.id.item_book;
                break;
            case 1:
                currentCheckedId = R.id.item_discover;
                break;
            case 2:
                currentCheckedId = R.id.item_mine;
                break;
            default:
                currentCheckedId = R.id.item_book;
                break;
        }
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
            case 0:
                fragment = new BookFragment();
                break;
            case 1:
                fragment = new DiscoverFragment();
                break;
            case 2:
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
















