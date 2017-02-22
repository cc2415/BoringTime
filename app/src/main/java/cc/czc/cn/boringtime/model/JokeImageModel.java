package cc.czc.cn.boringtime.model;

import com.google.gson.Gson;

import java.io.IOException;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.api.NetWorkApi;
import cc.czc.cn.boringtime.bean.JokeImagBean;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by cc on 2016/11/25.
 */

public class JokeImageModel {
    int imagPage = 1;
    public void initData(final NetListener<JokeImagBean> listener) {
        NetWorkApi.getInstance()
                .getImageData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed("error");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String s=responseBody.string();
                            Gson gson=new Gson();
                            JokeImagBean jokeImagBean = gson.fromJson(s, JokeImagBean.class);
                            listener.loadData(jokeImagBean);
                            imagPage+=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        Toast.makeText(MainActivity.this, ResponseBody.toString(), Toast.LENGTH_LONG).show();
                    }
                },"",ApiManage.API_KEY,imagPage+"");
    }

    public void updateData(final NetListener<JokeImagBean> listener) {
        NetWorkApi.getInstance()
                .getImageData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed("error");}

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String s=responseBody.string();
                            Gson gson=new Gson();
                            JokeImagBean jokeImagBean = gson.fromJson(s, JokeImagBean.class);
                            listener.updataDate(jokeImagBean);
                            imagPage=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        Toast.makeText(MainActivity.this, ResponseBody.toString(), Toast.LENGTH_LONG).show();
                    }
                },"",ApiManage.API_KEY,imagPage+"");
    }

    public void loadMoreData(final NetListener<JokeImagBean> listener) {
        NetWorkApi.getInstance()
                .getImageData(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed("error");}

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String s=responseBody.string();
                            Gson gson=new Gson();
                            JokeImagBean jokeImagBean = gson.fromJson(s, JokeImagBean.class);
                            listener.loadMoreData(jokeImagBean);
                            imagPage+=1;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        Toast.makeText(MainActivity.this, ResponseBody.toString(), Toast.LENGTH_LONG).show();
                    }
                },"",ApiManage.API_KEY,imagPage+"");
    }
}
