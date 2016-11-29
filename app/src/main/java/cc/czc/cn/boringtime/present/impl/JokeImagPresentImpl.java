package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.bean.JokeImagEntiy;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;
import cc.czc.cn.boringtime.model.JokeImageModel;
import cc.czc.cn.boringtime.model.JokeTextModel;
import cc.czc.cn.boringtime.present.contract.IJokeImagContract;

/**
 * Created by cc on 2016/11/21.
 */

public class JokeImagPresentImpl implements IJokeImagContract.Present {
    IJokeImagContract.JokeView mView;
    JokeImageModel model;

    public JokeImagPresentImpl(IJokeImagContract.JokeView view) {
        this.mView = view;
        mView.setPresent(this);
        model = new JokeImageModel();
    }
    @Override
    public void loadData() {
        mView.showProgress();
        model.initData(new NetListener<JokeImagEntiy>() {
            @Override
            public void loadData(JokeImagEntiy data) {
                mView.initData(data);
                mView.hiddenProgress();
            }

            @Override
            public void updataDate(JokeImagEntiy data) {

            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeImagEntiy data) {

            }
        });

    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void updateData() {
        model.updateData(new NetListener<JokeImagEntiy>() {
            @Override
            public void loadData(JokeImagEntiy data) {

            }

            @Override
            public void updataDate(JokeImagEntiy data) {
                mView.updateDate(data);
            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeImagEntiy data) {

            }
        });
    }

    @Override
    public void loadMoreData() {
        mView.showProgress();
        model.loadMoreData(new NetListener<JokeImagEntiy>() {
            @Override
            public void loadData(JokeImagEntiy data) {

            }

            @Override
            public void updataDate(JokeImagEntiy data) {

            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeImagEntiy data) {
                mView.loadMoreData(data);
                mView.hiddenProgress();
            }
        });
    }
}
