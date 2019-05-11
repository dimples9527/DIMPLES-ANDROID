package com.dimples.ui.index.live;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.ui.index.live.adapter.LiveViewPagerAdapter;

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
        LiveViewPagerAdapter viewPagerAdapter = new LiveViewPagerAdapter(getChildFragmentManager());
        mVpLiveViewPager.setAdapter(viewPagerAdapter);
    }

}



















