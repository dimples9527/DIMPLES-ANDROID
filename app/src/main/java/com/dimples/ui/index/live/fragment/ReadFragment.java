package com.dimples.ui.index.live.fragment;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.widget.RefreshLayout;

import butterknife.BindView;

/**
 * @author zhongyj
 * @date 2019/4/18 16:59
 */
@ViewInject(LayoutId = R.layout.fragment_read)
public class ReadFragment extends BaseFragment {

    @BindView(R.id.refresh_read)
    RefreshLayout mRefreshRead;

    @Override
    public void afterBindView() {
        mRefreshRead.setRefreshManager();
        mRefreshRead.setRefreshListener(
                () -> mRefreshRead.postDelayed(
                        () -> mRefreshRead.refreshOver(), 2000));
    }

}

















