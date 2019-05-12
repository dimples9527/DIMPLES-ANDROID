package com.dimples.ui.index.live.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationUtils;

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
    RecyclerView mRvOnlineRecycleView;

    private IBookDetailContract.IPresenter mPresenter = new BookDetailPresenter(this);

    @Override
    public void afterBindView() {
        mRvOnlineRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        //为RecycleView设置一个补间动画
        mRvOnlineRecycleView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.online_recycle_view_show));
        mPresenter.getPatientData();
    }

    @Override
    public void showData(TreatPatientResultBean data) {
        if (mRvOnlineRecycleView.getAdapter() == null) {
            OnlineRecycleAdapter adapter = new OnlineRecycleAdapter(data);
            mRvOnlineRecycleView.setAdapter(adapter);
        }
    }
}

















