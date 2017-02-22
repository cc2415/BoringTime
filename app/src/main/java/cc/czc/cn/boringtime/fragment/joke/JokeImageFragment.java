package cc.czc.cn.boringtime.fragment.joke;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.activity.DetailJokeImagActivity;
import cc.czc.cn.boringtime.adapter.JokeImageAdapter;
import cc.czc.cn.boringtime.bean.JokeImagBean;
import cc.czc.cn.boringtime.present.contract.IJokeImagContract;
import cc.czc.cn.boringtime.present.impl.JokeImagPresentImpl;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeImageFragment extends Fragment implements IJokeImagContract.JokeView {
    @BindView(R.id.swipe_fra_joke_content)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycle_fra_joke_content)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    List<JokeImagBean.ShowapiResBodyBean.ContentlistBean> data;
    JokeImageAdapter adapter;
    IJokeImagContract.Present mPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_joke_content, container, false);
        ButterKnife.bind(this, view);

        new JokeImagPresentImpl(this);
//        mPresent.start();
        initConfig();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresent.updateData();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1)){
//                    mPresent.loadMoreData();
                }
            }
        });
        return view;
    }

    void initConfig() {
        //swipeRefreshLayout下拉刷新设置
        int[] color = new int[]{Color.GREEN, Color.BLUE, Color.YELLOW};
        swipeRefreshLayout.setColorSchemeColors(color);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        swipeRefreshLayout.setProgressViewEndTarget(true, 100);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void showProgress() {
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiddenProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setPresent(IJokeImagContract.Present present) {
        mPresent = present;
    }

    @Override
    public void initData(final JokeImagBean data) {
        this.data=data.getShowapi_res_body().getContentlist();
        adapter = new JokeImageAdapter(getContext(), this.data);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new JokeImageAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position, Bitmap bitmap) {
                ImageView viewById = (ImageView) view.findViewById(R.id.iv_item_frag_joke_img);
//                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity(),viewById,viewById.getTransitionName()).toBundle();
                Intent intent = new Intent(getContext(), DetailJokeImagActivity.class);
                // TODO: 2016/11/28 size problem
//                byte[] bytes = ImageUtil.bitmapToByteArray(bitmap);
//                intent.putExtra("url", bytes);
//                Log.e("aa",bytes+"=====");
                intent.putExtra("text", data.getShowapi_res_body().getContentlist().get(position).getTitle());
                intent.putExtra("url", data.getShowapi_res_body().getContentlist().get(position).getImg());
//                startActivity(intent,bundle);
                startActivity(intent);
            }

            @Override
            public void ItemClickListener(View view, int position) {
//                Intent intent = new Intent(getContext(), DetailJokeImagActivity.class);
//                startActivity(intent);
            }
        });
    }

    @Override
    public void updateDate(JokeImagBean newData) {
        this.data.removeAll(this.data);
        this.data.addAll(newData.getShowapi_res_body().getContentlist());
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreData(JokeImagBean moreData) {
        this.data.addAll(moreData.getShowapi_res_body().getContentlist());
        adapter.notifyDataSetChanged();
    }
}
