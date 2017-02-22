package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.bean.JokeImagBean;
import cc.czc.cn.boringtime.model.JokeImageModel;
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
        model.initData(new NetListener<JokeImagBean>() {
            @Override
            public void loadData(JokeImagBean data) {
                mView.initData(data);
                mView.hiddenProgress();
            }

            @Override
            public void updataDate(JokeImagBean data) {

            }

            @Override
            public void failed(String msg) {
                mView.hiddenProgress();
            }


            @Override
            public void loadMoreData(JokeImagBean data) {

            }

            @Override
            public void completed(JokeImagBean msg) {

            }
        });

    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void updateData() {
        model.updateData(new NetListener<JokeImagBean>() {
            @Override
            public void loadData(JokeImagBean data) {

            }

            @Override
            public void updataDate(JokeImagBean data) {
                mView.updateDate(data);
            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeImagBean data) {

            }

            @Override
            public void completed(JokeImagBean msg) {

            }
        });
    }

    @Override
    public void loadMoreData() {
        mView.showProgress();
        model.loadMoreData(new NetListener<JokeImagBean>() {
            @Override
            public void loadData(JokeImagBean data) {

            }

            @Override
            public void updataDate(JokeImagBean data) {

            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeImagBean data) {
                mView.loadMoreData(data);
                mView.hiddenProgress();
            }

            @Override
            public void completed(JokeImagBean msg) {

            }
        });
    }
}
