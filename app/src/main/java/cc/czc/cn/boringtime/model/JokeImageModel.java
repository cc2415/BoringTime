package cc.czc.cn.boringtime.model;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.bean.JokeImagEntiy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cc on 2016/11/25.
 */

public class JokeImageModel {
    int imagPage = 1;

    public void initData(final NetListener<JokeImagEntiy> listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeImageNet iJokeImageNet = retrofit.create(IJokeImageNet.class);
        iJokeImageNet.getData(ApiManage.API_KEY, imagPage + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeImagEntiy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JokeImagEntiy jokeImagEntiy) {
                        listener.loadData(jokeImagEntiy);
                        imagPage += 1;
                    }
                });

    }

    public void updateData(final NetListener<JokeImagEntiy> listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeImageNet iJokeImageNet = retrofit.create(IJokeImageNet.class);
        iJokeImageNet.getData(ApiManage.API_KEY, "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeImagEntiy>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("over========================");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("timeout=======================");
                    }

                    @Override
                    public void onNext(JokeImagEntiy jokeImagEntiy) {
                        listener.updataDate(jokeImagEntiy);
                        imagPage=1;
                        System.out.println("success======================");

                    }
                });
    }

    public void loadMoreData(final NetListener<JokeImagEntiy> listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManage.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IJokeImageNet iJokeImageNet = retrofit.create(IJokeImageNet.class);
        iJokeImageNet.getData(ApiManage.API_KEY, imagPage + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeImagEntiy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JokeImagEntiy jokeImagEntiy) {
                        listener.loadMoreData(jokeImagEntiy);
                        imagPage+=1;
                    }
                });
    }
}
