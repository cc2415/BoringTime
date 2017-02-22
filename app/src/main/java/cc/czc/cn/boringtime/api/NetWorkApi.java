package cc.czc.cn.boringtime.api;

import android.util.Log;

import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cc on 2016/12/5.
 */
//T 是linster返回的json实体类
//T2 是访问网络的接口
public class NetWorkApi{
    String TAG = "NetWorkApi";

    Retrofit retrofit=null;
    //正确的单利模式
    public static NetWorkApi instance;
    BaiduApi baiduApi;
    UserApi userApi;
    /**
     * 干活集中营
     */
    GankApi gankApi;
    private NetWorkApi(){
//        retrofit=new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        baiduApi = retrofit.create(BaiduApi.class);

//        gankApi = retrofit.create(GankApi.class);
    }
    public static NetWorkApi getInstance(){
        if (instance == null) {
            synchronized (NetWorkApi.class) {
                if (instance == null) {
                    instance=new NetWorkApi();
                }
            }
        }
        return instance;
    }

    /**
     * 百度api获得图片数据
     * @param subscriber
     * @param url
     * @param apikey
     * @param page
     */
    public void getImageData(Subscriber<ResponseBody> subscriber,String url,String apikey,String page){
        baiduApi.getImageData(apikey,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 百度api
     * @param subscriber
     * @param apikey
     * @param page
     */
    public void getTextData(Subscriber<ResponseBody> subscriber,String apikey,String page){
        baiduApi.getJokeTextData(apikey,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void logingUser(Subscriber<ResponseBody> subscriber,String url,String userName,String passWord){
        userApi.login(userName, passWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 获得干货的对象
     * @param url
     * @return
     */
    private GankApi getGanHuoRetrofit(String url){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gankApi=build.create(GankApi.class);
        return gankApi;
    }

    /**
     * 获得干货每日推荐
     * @param url
     * @param subscriber
     * @param year 2017
     * @param month 05
     * @param daty  01
     */
    public void getGankHuoRecommend(String url,Subscriber<ResponseBody> subscriber,int year,int month,int daty){
        gankApi=getGanHuoRetrofit(url);
        gankApi.getRecommend(year, month, daty)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获得干货福利
     * @param url
     * @param subscriber
     * @param page
     */
    public void getGanHuoWelfare(String url,Subscriber<ResponseBody> subscriber,int page){
        gankApi = getGanHuoRetrofit(url);
        gankApi.getMeiZhiData(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    /**
     * 根据参数获取不同的干货数据
     * @param url
     * @param classfy
     * @param page
     * @param subscriber
     */
    public void getGanHuoData(String url, String classfy, int page, Subscriber<ResponseBody> subscriber) {
        gankApi=getGanHuoRetrofit(url);
        gankApi.getGanHuoData(classfy, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
