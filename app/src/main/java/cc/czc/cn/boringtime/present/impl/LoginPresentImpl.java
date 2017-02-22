package cc.czc.cn.boringtime.present.impl;

import cc.czc.cn.boringtime.RequestListener;
import cc.czc.cn.boringtime.model.UserModel;
import cc.czc.cn.boringtime.present.contract.ILoginContract;

/**
 * Created by cc on 2016/11/20.
 */

public class LoginPresentImpl implements ILoginContract.Present {
    ILoginContract.IView mView;
    UserModel model;
    public LoginPresentImpl(ILoginContract.IView view){
        mView=view;
        mView.setPresent(this);
        model=new UserModel();
    }

    @Override
    public void loging(String userName, String passWord) {
        mView.showProgress();
        model.loging(userName, passWord, new RequestListener<String>() {
            @Override
            public void success(String s) {
                System.out.println(s);
                mView.hiddenLoginDialog();
            }

            @Override
            public void failed(String s) {

            }
        });

    }


    @Override
    public void register() {

    }

    @Override
    public void start() {

    }
}
