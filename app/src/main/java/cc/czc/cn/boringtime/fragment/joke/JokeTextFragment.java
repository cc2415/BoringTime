package cc.czc.cn.boringtime.fragment.joke;

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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.adapter.JokeTextAdapter;
import cc.czc.cn.boringtime.bean.JokeTextBean;
import cc.czc.cn.boringtime.present.contract.IJokeTextContract;
import cc.czc.cn.boringtime.present.impl.JokeTextPresentImpl;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeTextFragment extends Fragment implements IJokeTextContract.JokeView{

    @BindView(R.id.recycle_fra_joke_content)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_fra_joke_content)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progress)
    ProgressBar progress;

    JokeTextAdapter adapter;
    List<JokeTextBean.ShowapiResBodyBean.ContentlistBean> data;
    IJokeTextContract.Present mPresent;
    boolean isLoading =false;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_joke_content, container, false);
        ButterKnife.bind(this, view);

        initConfig();
        new JokeTextPresentImpl(this);
//        mPresent.start();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                mPresent.updateData();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!recyclerView.canScrollVertically(1)) {
                    System.out.println("加载更多");
//                    mPresent.loadMoreData();
                }
            }
        });
        return view;
    }

    void initConfig(){
        int[] color=new int[]{Color.GREEN, Color.BLUE,Color.YELLOW};
        swipeRefreshLayout.setColorSchemeColors(color);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
//        swipeRefreshLayout.setProgressViewEndTarget(true,100);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void initData(JokeTextBean data) {
        if(data==null){
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }else {
            this.data = data.getShowapi_res_body().getContentlist();
            adapter = new JokeTextAdapter(getContext(), this.data);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void updateDate(JokeTextBean newData) {
        this.data.removeAll(this.data);
        this.data.addAll(newData.getShowapi_res_body().getContentlist());
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMoreData(JokeTextBean moreData) {
        this.data.addAll( moreData.getShowapi_res_body().getContentlist());
        adapter.notifyDataSetChanged();
    }


    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiddenProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setPresent(IJokeTextContract.Present present) {
        mPresent=present;
    }
}
