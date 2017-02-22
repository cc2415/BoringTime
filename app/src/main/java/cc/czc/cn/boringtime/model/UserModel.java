package cc.czc.cn.boringtime.model;

import java.io.IOException;

import cc.czc.cn.boringtime.RequestListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.api.NetWorkApi;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by cc on 2017/1/2.
 */

public class UserModel {
    public void register(){

    }
    public void loging(String userName, String passWord, final RequestListener<String> listener){
        NetWorkApi.getInstance().logingUser(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.failed("失败");
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    listener.success(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },"",userName,passWord);
    }
}
