package com.dimples.ui.main.live;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.ui.main.mine.MineFragment;

import butterknife.BindView;

/**
 * @author zhongyj
 * @date 2019/4/17 15:35
 */
@ViewInject(LayoutId = R.layout.fragment_live)
public class LiveFragment extends BaseFragment {
    @BindView(R.id.tl_live_tab_layout)
    TabLayout mTlLiveTabLayout;
    @BindView(R.id.vp_live_view_pager)
    ViewPager mVpLiveViewPager;

    @Override
    public void afterBindView() {
        mTlLiveTabLayout.setupWithViewPager(mVpLiveViewPager);
        mVpLiveViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return new MineFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }

            @NonNull
            @Override
            public CharSequence getPageTitle(int position) {
                return "直播";
            }
        });
    }
}



















