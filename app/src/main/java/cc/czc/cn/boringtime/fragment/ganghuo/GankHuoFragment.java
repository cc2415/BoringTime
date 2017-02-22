package cc.czc.cn.boringtime.fragment.ganghuo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.activity.GanHuoRecommendDetailActivity;
import cc.czc.cn.boringtime.adapter.GanHuoAndroidAdapter;
import cc.czc.cn.boringtime.adapter.GanHuoIOSAdapter;
import cc.czc.cn.boringtime.adapter.GanHuoRecommendAdapter;
import cc.czc.cn.boringtime.adapter.GanHuoWelfareAdapter;
import cc.czc.cn.boringtime.adapter.GanghuoPagerAdapter;
import cc.czc.cn.boringtime.bean.GanHuoIOSBean;
import cc.czc.cn.boringtime.bean.GanHuoRecommendBean;
import cc.czc.cn.boringtime.bean.GanHuoRecommendDetailBean;
import cc.czc.cn.boringtime.bean.GanHuoAndroidBean;
import cc.czc.cn.boringtime.bean.GanHuoWelfareBean;
import cc.czc.cn.boringtime.fragment.BaseFragment;
import cc.czc.cn.boringtime.present.contract.IGanHuoContract;
import cc.czc.cn.boringtime.present.impl.GanHuoPresentImpl;
import cc.czc.cn.boringtime.util.RecycliViewClickListenUtil;
import cc.czc.cn.boringtime.util.ToastUtil;
import cc.czc.cn.boringtime.view.ViewPagerIndicator;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by czc on 2017/2/15.
 */

public class GankHuoFragment extends BaseFragment implements IGanHuoContract.IView ,View.OnClickListener{
    @BindView(R.id.ganhuo_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.ganhuo_main_ViewPagerIndicator)
    ViewPagerIndicator pagerIndicator;
    @BindView(R.id.ganhuo_main_Viewpager)
    ViewPager viewPager;
    @BindView(R.id.progress_ganghuo_main)
    ProgressBar progressBar;
    @BindView(R.id.floatButton_frag_joke_content)
    FloatingActionButton floatingActionButton;
    String TAG = "GankHuoFragment";
    //viewpagerIndicator
    List<String> titleList;
    //viewpager
    List<View> viewList;
    /**
     * 是否第一次进入这个页面
     */
    HashMap<Integer,Boolean> pageFirseInList;

    //viewPager两个子页
    View recommendView;
    View welfareView;
    View androidView;
    View iosView;

//    集合控件
    SwipeRefreshLayout mSwipeRefresh;

    //    recommendview的子控件
    RecyclerView recommendRecycleview;
    SwipeRefreshLayout recommendSwipeRefresh;
    //    androIDView的子控件
    RecyclerView androidRecycleview;
    SwipeRefreshLayout androidSwipeRefresh;
//    iOsvieW 的子控件
    RecyclerView iosRecycleview;
    SwipeRefreshLayout iosSwipeRefresh;
//    WelfareView的子控件
    RecyclerView welfareRecycleview;
    SwipeRefreshLayout welfaredSwipeRefresh;
//recyclieview数据
    private List<GanHuoRecommendDetailBean> recommendDataList;
    private List<GanHuoAndroidBean.ResultsBean> androidDataList;
    private List<GanHuoIOSBean.ResultsBean> iosDataList;
    private List<GanHuoWelfareBean.ResultsBean> welfareDataList;
//适配器
    GanghuoPagerAdapter pagerAdapter;
    private GanHuoRecommendAdapter recommendAdapter;
    private GanHuoAndroidAdapter androidAdapter;
    private GanHuoIOSAdapter iosAdapter;
    private GanHuoWelfareAdapter welfareAdapter;

    IGanHuoContract.GangHuoPresent present;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ganhuo_main, container, false);
        ButterKnife.bind(this, view);
        init(savedInstanceState);
        new GanHuoPresentImpl(this);
        present.start();
        return view;
    }

    private void init(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("新闻精选");

        titleList = new ArrayList<>();
        recommendDataList = new ArrayList<>();
        viewList = new ArrayList<>();
        pageFirseInList = new HashMap<>();

        LayoutInflater layoutInflater = getLayoutInflater(savedInstanceState).from(getContext());
        recommendView = layoutInflater.inflate(R.layout.fra_joke_content, null);
        androidView = layoutInflater.inflate(R.layout.vp_ganhuo_content, null);
        welfareView = layoutInflater.inflate(R.layout.vp_ganhuo_content, null);
        iosView = layoutInflater.inflate(R.layout.vp_ganhuo_content, null);

        viewList.add(recommendView);
        viewList.add(androidView);
        viewList.add(iosView);
        viewList.add(welfareView);

        for (int i = 0; i < viewList.size(); i++) {
            pageFirseInList.put(i, true);
        }
        pageFirseInList.put(0, false);

        titleList.add("每日推荐");
        titleList.add("Android");
        titleList.add("ios");
        titleList.add("福利");
        titleList.add("视屏");
        pagerIndicator.setTabItemTitles(titleList);
        pagerIndicator.setViewPager(viewPager, 0);
        pagerAdapter = new GanghuoPagerAdapter(viewList);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "onPageSelected: "+position );
                switch (position) {
                    case 0:
                        initSwipeFresh(recommendSwipeRefresh,0);
                        break;
//                    android
                    case 1:
                        initSwipeFresh(androidSwipeRefresh,1);
                        if (pageFirseInList.get(position)){
                            present.loadAndroidData();
                            pageFirseInList.put(position, false);
                        }
                        break;
//                    ios
                    case 2:
                        initSwipeFresh(iosSwipeRefresh,2);
                        if (pageFirseInList.get(position)) {
                            present.loadIOSData();
                            pageFirseInList.put(position, false);
                        }
                        break;
//                        welfare
                    case 3:
                        initSwipeFresh(welfaredSwipeRefresh,3);
                        if (pageFirseInList.get(position)){
                            present.loadWelafreData();
                            pageFirseInList.put(position, false);
                        }
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binView();
    }

    /**
     * view 的绑定
     */
    private void binView() {
        recommendRecycleview = (RecyclerView) recommendView.findViewById(R.id.recycle_fra_joke_content);
        recommendSwipeRefresh = (SwipeRefreshLayout) recommendView.findViewById(R.id.swipe_fra_joke_content);


        androidRecycleview = (RecyclerView) androidView.findViewById(R.id.recycle_vp_ganhuo_content);
        androidSwipeRefresh = (SwipeRefreshLayout) androidView.findViewById(R.id.swipe_vp_ganhuo_content);

        iosRecycleview = (RecyclerView) iosView.findViewById(R.id.recycle_vp_ganhuo_content);
        iosSwipeRefresh = (SwipeRefreshLayout) iosView.findViewById(R.id.swipe_vp_ganhuo_content);

        welfareRecycleview = (RecyclerView) welfareView.findViewById(R.id.recycle_vp_ganhuo_content);
        welfaredSwipeRefresh = (SwipeRefreshLayout) welfareView.findViewById(R.id.swipe_vp_ganhuo_content);

//        mSwipeRefresh=recommendSwipeRefresh;
        initSwipeFresh(recommendSwipeRefresh,0);
        floatingActionButton.setOnClickListener(this);

    }


    private void initSwipeFresh(SwipeRefreshLayout mSwipeRefresh,final int position) {
        this.mSwipeRefresh=mSwipeRefresh;
        //swipeRefreshLayout下拉刷新设置
        int[] color = new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
       this. mSwipeRefresh.setColorSchemeColors(color);
       this. mSwipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
       this. mSwipeRefresh.setProgressViewEndTarget(true, 100);
       this. mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                switch (position) {
                    case 0:
                        present.loadRecommendData();
                        break;
                    case 1:
                        present.loadAndroidData();
                        break;
                    case 2:
                        present.loadIOSData();
                        break;
                    case 3:
                        present.loadWelafreData();
                        break;
                }
//                present.loadMoreRecommendData();
//                刷新
//                recommendSwipeRefresh.setRefreshing(false);//设置不可见刷新
            }

        });


//        androidSwipeRefresh.setColorSchemeColors(color);
//        androidSwipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
//        androidSwipeRefresh.setProgressViewEndTarget(true, 100);
    }


    @Override
    public void showProgress() {
        if (mSwipeRefresh.isRefreshing()) {
            progressBar.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hiddenProgress() {
        progressBar.setVisibility(View.GONE);
       this.mSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void setPresent(IGanHuoContract.GangHuoPresent present) {
        this.present = present;
    }


    @Override
    public void setRecommendAdapter(final GanHuoRecommendBean.ResultsBean results) {
        Observable.create(new Observable.OnSubscribe<List<GanHuoRecommendDetailBean>>() {
            @Override
            public void call(final Subscriber<? super List<GanHuoRecommendDetailBean>> subscriber) {
                Log.e(TAG, "call: " + results);
                recommendResultToList(results);
                subscriber.onNext(recommendDataList);
                Log.e(TAG, "call: " + recommendDataList.size());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GanHuoRecommendDetailBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(final List<GanHuoRecommendDetailBean> list) {
                        Log.e(TAG, "setRecommendAdapter: " + list.size());
                        recommendAdapter = new GanHuoRecommendAdapter(list, getContext());
                        recommendRecycleview.setAdapter(recommendAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recommendRecycleview.setLayoutManager(linearLayoutManager);
//                        点击
                        recommendAdapter.setRecycliViewClickListener(new RecycliViewClickListenUtil() {
                            @Override
                            public void onItemClickListen(View view, int position) {
                                Intent intent = new Intent(getContext(), GanHuoRecommendDetailActivity.class);
                                intent.putExtra("url", list.get(position).getUrl());
                                startActivity(intent);
                            }

                            @Override
                            public void onLongClickListen(View view, int position) {

                            }
                        });
//                        recycleview滚动监听
                        recommendRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                            @Override
                            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                super.onScrolled(recyclerView, dx, dy);
                                if (isSlideToBottom(recyclerView)) {
                                    present.loadMoreRecommendData();
                                }
                            }
                        });
                    }
                });
    }

    @Override
    public void loadMoreRecommendData(final GanHuoRecommendBean.ResultsBean results) {
        Observable.create(new Observable.OnSubscribe<List<GanHuoRecommendDetailBean>>() {
            @Override
            public void call(Subscriber<? super List<GanHuoRecommendDetailBean>> subscriber) {
                recommendResultToList(results);
                subscriber.onNext(recommendDataList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<GanHuoRecommendDetailBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GanHuoRecommendDetailBean> list) {
                        recommendAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void setAndroidAdapter(List<GanHuoAndroidBean.ResultsBean> result) {
        androidDataList=result;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        androidAdapter = new GanHuoAndroidAdapter(getContext(), androidDataList);
        androidRecycleview.setAdapter(androidAdapter);
        androidRecycleview.setLayoutManager(linearLayoutManager);

        androidRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    present.loadMoreAndroidData();
                }

            }
        });
    }


    @Override
    public void loadMoreAndroidData(List<GanHuoAndroidBean.ResultsBean> result) {
        androidDataList.addAll(result);
        androidAdapter.notifyDataSetChanged();
    }

    @Override
    public void setIOSAdapter(List<GanHuoIOSBean.ResultsBean> result) {
        iosDataList=result;
        iosAdapter = new GanHuoIOSAdapter(getContext(),iosDataList);
        iosRecycleview.setAdapter(iosAdapter);
        iosRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));

        iosRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    present.loadMoreIOSData();
                }
            }
        });
    }

    @Override
    public void loadMoreIOSAdapter(List<GanHuoIOSBean.ResultsBean> result) {
        iosDataList.addAll(result);
        iosAdapter.notifyDataSetChanged();
    }

    @Override
    public void setWelfareAdapter(List<GanHuoWelfareBean.ResultsBean> results) {
        welfareDataList=results;
        welfareAdapter = new GanHuoWelfareAdapter(getContext(), welfareDataList);
        welfareRecycleview.setAdapter(welfareAdapter);
        welfareRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));

        welfareRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    present.loadMoreWelafreData();
                }
            }
        });
    }

    @Override
    public void loadMoreWelfareData(List<GanHuoWelfareBean.ResultsBean> results) {
        welfareDataList.addAll(results);
        welfareAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadFailed() {
        ToastUtil.getInstance(getContext()).showMsg("加载失败  请检查网络是否连接");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        present=null;
    }

    /**
     * 推荐的数据整合
     *
     * @param results
     */
    private void recommendResultToList(GanHuoRecommendBean.ResultsBean results) {
        List<GanHuoRecommendBean.ResultsBean.AndroidBean> android = results.getAndroid();
        List<GanHuoRecommendBean.ResultsBean.IOSBean> ios = results.getIOS();
//        List<GanHuoRecommendBean.ResultsBean.RecommendBean> recommend = results.getRecommend();
        List<GanHuoRecommendBean.ResultsBean.WelfareBean> welfare = results.getWelfare();
//        都取一条信息放入一个集合中去
        GanHuoRecommendBean.ResultsBean.AndroidBean androidBean = android.get(0);
        GanHuoRecommendBean.ResultsBean.IOSBean iosBean = ios.get(0);
//        GanHuoRecommendBean.ResultsBean.RecommendBean recommendBean = recommend.get(0);
        GanHuoRecommendBean.ResultsBean.WelfareBean welfareBean = welfare.get(0);

//        GanHuoRecommendDetailBean bean1=new GanHuoRecommendDetailBean(androidBean.get_id(), androidBean.getCreatedAt(), androidBean.getDesc(), androidBean.getImages().get(0), androidBean.getUrl());
//        GanHuoRecommendDetailBean bean2=new GanHuoRecommendDetailBean();
//        bean2.set_id(androidBean.get_id());
//        bean2.setCreateAt(androidBean.getCreatedAt());
//        bean2.setDesc(androidBean.getDesc());
//        bean2.setUrl(androidBean.getUrl());
//        bean2.setImages(androidBean.getImages().get(0));
        Log.e(TAG, "recommendResultToList:  =======   "+recommendDataList.size());
//        recommendDataList.add(bean2);
        recommendDataList.add(new GanHuoRecommendDetailBean(iosBean.get_id(), iosBean.getCreatedAt(), iosBean.getDesc(), iosBean.getImages().get(0), iosBean.getUrl()));
//        recommendDataList.add(new GanHuoRecommendDetailBean(recommendBean.get_id(), recommendBean.getCreatedAt(), recommendBean.getDesc(), null, recommendBean.getUrl()));
        recommendDataList.add(new GanHuoRecommendDetailBean(welfareBean.get_id(), welfareBean.getCreatedAt(), welfareBean.getDesc(), welfareBean.getUrl(), welfareBean.getUrl()));

//        return recommendDataList;
    }

    /**
     * 判断recucleview是否到达底部
     * @param recommendRecycleview
     * @return
     */
    private boolean isSlideToBottom(RecyclerView recommendRecycleview) {
        if (recommendRecycleview == null)
            return false;
        if (recommendRecycleview.computeVerticalScrollExtent() + recommendRecycleview.computeVerticalScrollOffset() >=
                recommendRecycleview.computeVerticalScrollRange())
            return true;
        return false;
    }

    /**
     * 显示popuwindow
     */
    private void showPopuWindow(){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.popuwindow_item, null, false);
        PopupWindow window = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.setAnimationStyle(R.style.mypopuwindow_anim_sstyle);
        window.showAtLocation(floatingActionButton,Gravity.BOTTOM ,240,400);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatButton_frag_joke_content:
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.floatbutton);
                animation.setFillAfter(true);
                floatingActionButton.setAnimation(animation);
                floatingActionButton.startAnimation(animation);
                showPopuWindow();
                ToastUtil.getInstance(getContext()).showMsg("lskjdfkljsdlkflksdjf");
            break;
        }
    }
}
