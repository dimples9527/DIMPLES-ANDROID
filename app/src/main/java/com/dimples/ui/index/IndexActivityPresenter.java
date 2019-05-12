package com.dimples.ui.index;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.ui.index.book.BookFragment;
import com.dimples.ui.index.live.LiveFragment;
import com.dimples.ui.index.mine.MineFragment;
import com.dimples.ui.index.tools.IndexConstantTool;

/**
 * @author zhongyj
 * @date 2019/4/17 19:55
 */
@SuppressLint("LongLogTag")
public class IndexActivityPresenter extends BaseMvpPresenter<IIndexActivityContract.IView> implements IIndexActivityContract.IPresenter {

    private static final String D_TAG = "D-IndexActivityPresenter";
    private Fragment[] fragments = new Fragment[3];
    /**
     * 当前Fragment角标
     */
    private int currentFragmentIndex;

    public IndexActivityPresenter(IIndexActivityContract.IView view) {
        super(view);
        mContext = (Context) view;
    }

    @Override
    protected IIndexActivityContract.IView getEmptyView() {
        return IIndexActivityContract.EMPTY_VIEW;
    }

    /**
     * 初始化Fragment
     */
    @Override
    public void initMainFragment() {
        //当前Fragment下标
        this.currentFragmentIndex = IndexConstantTool.BOOK;
        replaceFragment(currentFragmentIndex);
    }

    /**
     * 切换Fragment
     *
     * @param currentFragmentIndex int
     */

    @Override
    public void replaceFragment(int currentFragmentIndex) {
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
        Log.i(D_TAG, "IndexActivityPresenter-----------------saveCurrentFragment----currentFragmentIndex:" + currentFragmentIndex);
        this.currentFragmentIndex = currentFragmentIndex;
//        switch (currentFragmentIndex) {
//            case IndexConstantTool.BOOK:
//                currentCheckedId = R.id.item_book;
//                break;
//            case IndexConstantTool.DISCOVER:
//                currentCheckedId = R.id.item_discover;
//                break;
//            case IndexConstantTool.MINE:
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
        Log.i(D_TAG, "IndexActivityPresenter-----------------newCurrentFragment----currentFragmentIndex:" + currentFragmentIndex);
        Fragment fragment = null;
        switch (currentFragmentIndex) {
            case IndexConstantTool.BOOK:
                fragment = new BookFragment();
                break;
            case IndexConstantTool.DISCOVER:
                fragment = new LiveFragment();
                break;
            case IndexConstantTool.MINE:
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
        Log.i(D_TAG, "IndexActivityPresenter-----------------addAndShowFragment----Fragment:" + fragment);
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
        Log.i(D_TAG, "IndexActivityPresenter-----------------hideFragment----Fragment:" + fragment);
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }
}
















