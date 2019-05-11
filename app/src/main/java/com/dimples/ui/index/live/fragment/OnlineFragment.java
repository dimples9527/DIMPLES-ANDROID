package com.dimples.ui.index.live.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.ui.index.book.IBookDetailContract;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;
import com.dimples.ui.index.book.presenter.BookDetailPresenter;
import com.dimples.ui.index.live.adapter.OnlineRecycleAdapter;

import butterknife.BindView;

/**
 * @author zhongyj
 * @date 2019/4/18 16:59
 */
@ViewInject(LayoutId = R.layout.fragment_online)
public class OnlineFragment extends BaseFragment implements IBookDetailContract.IView {

    @BindView(R.id.tb_online)
    Toolbar mTbOnline;
    @BindView(R.id.abl_online)
    AppBarLayout mAblOnline;
    @BindView(R.id.rv_online)
    RecyclerView mRvOnline;

    private IBookDetailContract.IPresenter mPresenter = new BookDetailPresenter(this);

    @Override
    public void afterBindView() {
        mRvOnline.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.getPatientData();
    }

    @Override
    public void showData(TreatPatientResultBean data) {
        if (mRvOnline.getAdapter() == null) {
            OnlineRecycleAdapter adapter = new OnlineRecycleAdapter(data);
            mRvOnline.setAdapter(adapter);
        }
    }
}

















