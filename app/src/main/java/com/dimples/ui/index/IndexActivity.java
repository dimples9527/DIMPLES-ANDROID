package com.dimples.ui.index;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.dimples.R;
import com.dimples.base.BaseActivity;
import com.dimples.component.ViewInject;
import com.dimples.ui.index.tools.IndexConstantTool;

import butterknife.BindView;

/**
 * 主界面
 *
 * @author zhongyj
 * @date 2019/4/14 20:54
 */
@ViewInject(LayoutId = R.layout.activity_main)
public class IndexActivity extends BaseActivity implements IIndexActivityContract.IView {

    private static final String D_TAG = "D-IndexActivity";

    @BindView(R.id.fab_float_main)
    FloatingActionButton fabFloatMain;
    @BindView(R.id.bnv_bottom_main)
    BottomNavigationView bnvBottomMain;
    private IIndexActivityContract.IPresenter presenter = new IndexActivityPresenter(this);

    @Override
    public void afterBindView() {
        initMainFragment();
        initBottomNavigationViewSelected();
    }

    private void initBottomNavigationViewSelected() {
        bnvBottomMain.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_book:
                    Log.i(D_TAG, "book");
                    presenter.replaceFragment(IndexConstantTool.BOOK);
                    break;
                case R.id.item_discover:
                    Log.i(D_TAG, "discover");
                    presenter.replaceFragment(IndexConstantTool.DISCOVER);
                    break;
                case R.id.item_mine:
                    Log.i(D_TAG, "mine");
                    presenter.replaceFragment(IndexConstantTool.MINE);
                    break;
                default:
                    Log.i(D_TAG, "book");
                    presenter.replaceFragment(IndexConstantTool.BOOK);
                    break;
            }
            return true;
        });
    }

    /**
     * 初始化Fragment
     */
    private void initMainFragment() {
        presenter.initMainFragment();
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content_main, fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

}
