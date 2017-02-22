package cc.czc.cn.boringtime.present.impl;

import android.util.Log;

import java.util.List;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.RequestListener;
import cc.czc.cn.boringtime.bean.GanHuoIOSBean;
import cc.czc.cn.boringtime.bean.GanHuoRecommendBean;
import cc.czc.cn.boringtime.bean.GanHuoAndroidBean;
import cc.czc.cn.boringtime.bean.GanHuoWelfareBean;
import cc.czc.cn.boringtime.model.GangHuoModel;
import cc.czc.cn.boringtime.present.contract.IGanHuoContract;
import cc.czc.cn.boringtime.util.GsonUtil;

/**
 * Created by czc on 2017/2/16.
 */

public class GanHuoPresentImpl implements IGanHuoContract.GangHuoPresent {
    IGanHuoContract.IView view;
    GangHuoModel model;
    String TAG = "GanHuoPresentImpl";
    public GanHuoPresentImpl(IGanHuoContract.IView view) {
        this.view=view;
        this.view.setPresent(this);
        model=new GangHuoModel();
    }

    @Override
    public void start() {
        loadRecommendData();
    }

    @Override
    public void loadRecommendData() {
        view.showProgress();
        model.loadRecommendData(new NetListener<String>() {
            @Override
            public void loadData(String data) {
                GanHuoRecommendBean ganHuoRecommendBean = GsonUtil.getInstance().JsonToBean(data, GanHuoRecommendBean.class);
                GanHuoRecommendBean.ResultsBean results = ganHuoRecommendBean.getResults();
                Log.e(TAG, "loadData: "+results );
                view.setRecommendAdapter(results);
                view.hiddenProgress();
            }

            @Override
            public void updataDate(String data) {

            }

            @Override
            public void failed(String msg) {
                Log.e(TAG, "failed:  =======   " + msg + "  loadRecommend");
                view.hiddenProgress();
                view.loadFailed();
            }

            @Override
            public void loadMoreData(String data) {

            }

            @Override
            public void completed(String msg) {

            }
        });
    }

    @Override
    public void loadMoreRecommendData() {
        view.showProgress();
        model.loadMoreRecommendData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoRecommendBean ganHuoRecommendBean = GsonUtil.getInstance().JsonToBean(s, GanHuoRecommendBean.class);
                GanHuoRecommendBean.ResultsBean results = ganHuoRecommendBean.getResults();
                view.loadMoreRecommendData(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }

    @Override
    public void loadWelafreData() {
        view.showProgress();
        model.loadWrlfareData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoWelfareBean ganHuoWelfareBean = GsonUtil.getInstance().JsonToBean(s, GanHuoWelfareBean.class);
                List<GanHuoWelfareBean.ResultsBean> results = ganHuoWelfareBean.getResults();
                view.setWelfareAdapter(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                Log.e(TAG, "failed:  =======   " + s+"  loadWelafreData");
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }

    @Override
    public void loadMoreWelafreData() {
        view.showProgress();
        model.loadMoreWelfareData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoWelfareBean ganHuoWelfareBean = GsonUtil.getInstance().JsonToBean(s, GanHuoWelfareBean.class);
                List<GanHuoWelfareBean.ResultsBean> results = ganHuoWelfareBean.getResults();
                view.loadMoreWelfareData(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }

    @Override
    public void loadAndroidData() {
        view.showProgress();
        model.loadAndroidData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoAndroidBean ganHuoAndroidBean = GsonUtil.getInstance().JsonToBean(s, GanHuoAndroidBean.class);
                List<GanHuoAndroidBean.ResultsBean> results = ganHuoAndroidBean.getResults();
                view.setAndroidAdapter(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                Log.e(TAG, "failed:  =======   " + s + "   loadAndroidData");
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }

    @Override
    public void loadMoreAndroidData() {
        view.showProgress();
        model.loadMoreAndroidData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoAndroidBean ganHuoAndroidBean = GsonUtil.getInstance().JsonToBean(s, GanHuoAndroidBean.class);
                List<GanHuoAndroidBean.ResultsBean> results = ganHuoAndroidBean.getResults();
                view.loadMoreAndroidData(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                view.hiddenProgress();
                view.loadFailed();
            }
        });

    }

    @Override
    public void loadIOSData() {
        view.showProgress();
        model.loadIOSData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoIOSBean ganHuoIOSBean = GsonUtil.getInstance().JsonToBean(s, GanHuoIOSBean.class);
                List<GanHuoIOSBean.ResultsBean> results = ganHuoIOSBean.getResults();
                view.setIOSAdapter(results);
                view.hiddenProgress();
            }

            @Override
            public void failed(String s) {
                Log.e(TAG, "failed:  =======   " + s + "  loadIOSData");
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }

    @Override
    public void loadMoreIOSData() {
        view.showProgress();
        model.loadMoreIOSData(new RequestListener<String>() {
            @Override
            public void success(String s) {
                GanHuoIOSBean ganHuoIOSBean = GsonUtil.getInstance().JsonToBean(s, GanHuoIOSBean.class);
                List<GanHuoIOSBean.ResultsBean> results = ganHuoIOSBean.getResults();
                view.loadMoreIOSAdapter(results);
                view.hiddenProgress();
            }
            @Override
            public void failed(String s) {
                view.hiddenProgress();
                view.loadFailed();
            }
        });
    }
}
