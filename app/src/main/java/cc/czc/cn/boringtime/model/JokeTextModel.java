package cc.czc.cn.boringtime.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.api.NetWorkApi;
import cc.czc.cn.boringtime.bean.JokeTextBean;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeTextModel {
    String TAG = "JokeTextModel";
    int textPage =1;

    public void initTextData(final NetListener<JokeTextBean> listener) {
        NetWorkApi.getInstance()
                .getTextData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ==========");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e(TAG, "error: ===========");
                        listener.failed("error");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String data=responseBody.string();
                            System.out.print("============================================");
                            System.out.print(data);
                            Gson gson=new Gson();
                            JokeTextBean jokeTextBean = gson.fromJson(data, JokeTextBean.class);
                            listener.loadData(jokeTextBean);
                            textPage +=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },ApiManage.API_KEY,textPage+"");
    }

    public void loadMoreTextData(final NetListener<JokeTextBean> listener){
        NetWorkApi.getInstance()
                .getTextData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String data=responseBody.string();
                            Gson gson=new Gson();
                            JokeTextBean jokeTextBean = gson.fromJson(data, JokeTextBean.class);
                            listener.loadMoreData(jokeTextBean);
                            textPage +=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },ApiManage.API_KEY,textPage+"");
    }

    public void updateTextData(final NetListener<JokeTextBean> listener) {
        NetWorkApi.getInstance()
                .getTextData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String data=responseBody.string();
                            Gson gson=new Gson();
                            JokeTextBean jokeTextBean = gson.fromJson(data, JokeTextBean.class);
                            listener.updataDate(jokeTextBean);
                            textPage =1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },ApiManage.API_KEY,textPage+"");
    }

}
