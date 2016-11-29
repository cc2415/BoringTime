package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;
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
        model.initTextData(new NetListener<JokeTextEntiy>() {
            @Override
            public void loadData(JokeTextEntiy data) {
                mView.initData(data);
                mView.hiddenProgress();
            }

            @Override
            public void updataDate(JokeTextEntiy data) {

            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeTextEntiy data) {

            }
        });

    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void updateData() {
        model.updateTextData(new NetListener<JokeTextEntiy>() {
            @Override
            public void loadData(JokeTextEntiy data) {

            }

            @Override
            public void updataDate(JokeTextEntiy data) {
                mView.updateDate(data);
            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeTextEntiy data) {

            }
        });
    }

    @Override
    public void loadMoreData() {
        mView.showProgress();
        model.loadMoreTextData(new NetListener<JokeTextEntiy>() {
            @Override
            public void loadData(JokeTextEntiy data) {

            }

            @Override
            public void updataDate(JokeTextEntiy data) {

            }

            @Override
            public void failed(String msg) {

            }

            @Override
            public void loadMoreData(JokeTextEntiy data) {
                mView.loadMoreData(data);
                mView.hiddenProgress();
            }
        });
    }
}
