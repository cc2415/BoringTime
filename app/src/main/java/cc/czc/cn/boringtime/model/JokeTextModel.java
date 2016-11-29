package cc.czc.cn.boringtime.model;

import java.util.List;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeTextModel {
    int textPage =1;

    public void initTextData(final NetListener<JokeTextEntiy> listener) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeTextNet IJokeTextNet = retrofit.create(IJokeTextNet.class);
        IJokeTextNet.getJokeText(ApiManage.API_KEY, textPage +"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeTextEntiy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        System.out.println("error+++++++++++++++++++++++++++++");
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onNext(JokeTextEntiy jokeTextEntiy) {
                        List<JokeTextEntiy.ShowapiResBodyBean.ContentlistBean> contentlist = jokeTextEntiy.getShowapi_res_body().getContentlist();
                        String title = contentlist.get(0).getTitle();
                        System.out.println("size: "+contentlist.size()+"  title:"+title);
                        listener.loadData(jokeTextEntiy);
                        textPage +=1;

                    }
                });
    }

    public void loadMoreTextData(final NetListener<JokeTextEntiy> listener){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeTextNet IJokeTextNet = retrofit.create(IJokeTextNet.class);
        IJokeTextNet.getJokeText(ApiManage.API_KEY, textPage +"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeTextEntiy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onNext(JokeTextEntiy jokeTextEntiy) {
                        listener.loadMoreData(jokeTextEntiy);
                        textPage +=1;
                    }
                });
    }

    public void updateTextData(final NetListener<JokeTextEntiy> listener) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeTextNet IJokeTextNet = retrofit.create(IJokeTextNet.class);
        IJokeTextNet.getJokeText(ApiManage.API_KEY,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeTextEntiy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed(e.getMessage());
                    }

                    @Override
                    public void onNext(JokeTextEntiy jokeTextEntiy) {
                        List<JokeTextEntiy.ShowapiResBodyBean.ContentlistBean> contentlist = jokeTextEntiy.getShowapi_res_body().getContentlist();
                        listener.updataDate(jokeTextEntiy);
                        textPage =1;
                    }
                });
    }

}
