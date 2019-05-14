package com.dimples.ui.index.live.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;
import com.dimples.ui.index.live.adapter.OnlineRecycleAdapter;
import com.dimples.ui.index.live.fragment.presenter.IReadContract;
import com.dimples.ui.index.live.fragment.presenter.ReadPresenter;
import com.dimples.ui.index.live.refresh.MeiTuanRefreshManager;
import com.dimples.widget.refresh.RefreshLayout;

import butterknife.BindView;

/**
 * @author zhongyj
 * @date 2019/4/18 16:59
 */
@ViewInject(LayoutId = R.layout.fragment_read)
public class ReadFragment extends BaseFragment implements IReadContract.IView {

    @BindView(R.id.rv_recycle_view_read)
    RecyclerView mRvRecycleViewRead;
    @BindView(R.id.refresh_read)
    RefreshLayout mRefreshRead;

    private IReadContract.IPresenter mPresenter = new ReadPresenter(this);

    @Override
    public void afterBindView() {
        initRecycleView();
        //采用用户默认的下拉刷新
//        mRefreshRead.setRefreshManager();
        //采用用户自定义的方式
        mRefreshRead.setRefreshManager(new MeiTuanRefreshManager(mContext));
        mRefreshRead.setRefreshListener(() -> mRefreshRead.postDelayed(() -> mRefreshRead.refreshOver(), 2000));
    }

    private void initRecycleView() {
        mPresenter.getData();

    }

    @Override
    public void setAdapterView(TreatPatientResultBean resultBean) {
        if (mRvRecycleViewRead.getAdapter() == null) {
            mRvRecycleViewRead.setLayoutManager(new LinearLayoutManager(mContext));
            mRvRecycleViewRead.setAdapter(new OnlineRecycleAdapter(resultBean));
        }
    }
}

















