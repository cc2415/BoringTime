package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.present.contract.ILoginContract;

/**
 * Created by cc on 2016/11/20.
 */

public class LoginPresentImpl implements ILoginContract.Present {
    ILoginContract.IView mView;

    public LoginPresentImpl(ILoginContract.IView view){
        mView=view;
        mView.setPresent(this);

    }

    @Override
    public void showdata() {

    }

    @Override
    public void loadData() {
    }

    @Override
    public void updateData() {

    }

    @Override
    public void start() {

    }
}
