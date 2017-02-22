package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.bean.JokeTextBean;
import cc.czc.cn.boringtime.model.JokeTextModel;
import cc.czc.cn.boringtime.present.contract.IJokeTextContract;

/**
 * Created by cc on 2016/11/21.
 */

public class JokeTextPresentImpl implements IJokeTextContract.Present {
    IJokeTextContract.JokeView mView;
    JokeTextModel model;

    public JokeTextPresentImpl(IJokeTextContract.JokeView view) {
        this.mView = view;
        mView.setPresent(this);
        model = new JokeTextModel();
    }
    @Override
    public void loadData() {
        mView.showProgress();
        model.initTextData(new NetListener<JokeTextBean>() {
            @Override
            public void loadData(JokeTextBean data) {
                mView.initData(data);
                mView.hiddenProgress();
            }

            @Override
            public void updataDate(JokeTextBean data) {

            }

            @Override
            public void failed(String msg) {
                if (msg.equals("error")) {
                    mView.hiddenProgress();
                }
            }

            @Override
            public void loadMoreData(JokeTextBean data) {

            }

            @Override
            public void completed(JokeTextBean msg) {

            }
        });

    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void updateData() {
        model.updateTextData(new NetListener<JokeTextBean>() {
            @Override
            public void loadData(JokeTextBean data) {

            }

            @Override
            public void updataDate(JokeTextBean data) {
                mView.updateDate(data);
            }

            @Override
            public void failed(String msg) {
                if (msg.equals("error")) {
                    mView.hiddenProgress();
                }
            }

            @Override
            public void loadMoreData(JokeTextBean data) {

            }

            @Override
            public void completed(JokeTextBean msg) {

            }
        });
    }

    @Override
    public void loadMoreData() {
        mView.showProgress();
        model.loadMoreTextData(new NetListener<JokeTextBean>() {
            @Override
            public void loadData(JokeTextBean data) {

            }

            @Override
            public void updataDate(JokeTextBean data) {

            }

            @Override
            public void failed(String msg) {
                if (msg.equals("error")) {
                    mView.hiddenProgress();
                }
            }

            @Override
            public void loadMoreData(JokeTextBean data) {
                mView.loadMoreData(data);
                mView.hiddenProgress();
            }

            @Override
            public void completed(JokeTextBean msg) {

            }
        });
    }
}
