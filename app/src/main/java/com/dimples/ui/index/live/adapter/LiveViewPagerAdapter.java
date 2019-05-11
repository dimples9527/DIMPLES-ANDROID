package com.dimples.ui.index.live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dimples.ui.index.live.fragment.EssayJokeFragment;
import com.dimples.ui.index.live.fragment.OnlineFragment;
import com.dimples.ui.index.live.fragment.ReadFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyj
 * @date 2019/5/11
 */
public class LiveViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> titleList;

    public LiveViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titleList = new ArrayList<>();
        titleList.add("直播");
        titleList.add("皮皮虾");
        titleList.add("阅读");
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new OnlineFragment();
            case 1:
                return new EssayJokeFragment();
            case 2:
                return new ReadFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}












