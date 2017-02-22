package cc.czc.cn.boringtime.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import cc.czc.cn.boringtime.NetListener;
import cc.czc.cn.boringtime.RequestListener;
import cc.czc.cn.boringtime.api.ApiManage;
import cc.czc.cn.boringtime.api.NetWorkApi;
import cc.czc.cn.boringtime.base.IBaseModel;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by czc on 2017/2/16.
 */

public class GangHuoModel extends IBaseModel {
    //    NetListener<String> listener;
    int page = 1;
    int androidPage=1;
    int iosPage=1;
    String TAG = "GangHuoModel";
    int year=0,month=0,day=0;
    private final SimpleDateFormat format;
    private Date curDate;

    public GangHuoModel(){
        format = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
    }

    /**
     * 获得福利
     *
     * @param listener
     */
    public void loadWrlfareData(final RequestListener<String> listener) {
        NetWorkApi.getInstance().getGanHuoWelfare(ApiManage.Gank_URL, new Subscriber<ResponseBody>() {
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
                    String data = responseBody.string();
                    listener.success(data);
                    page+=1;
                } catch (Exception e) {

                }
            }
        }, page);
    }

    /**
     * 加载更多福利
     * @param listener
     */
    public void loadMoreWelfareData(final RequestListener<String> listener){
        NetWorkApi.getInstance().getGanHuoWelfare(ApiManage.Gank_URL, new Subscriber<ResponseBody>() {
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
                    String data=responseBody.string();
                    listener.success(data);
                    page+=1;
                } catch (Exception e) {

                }
            }
        },page);

    }

    /**
     * 获得每日推荐
     *
     * @param listener
     */
    public void loadRecommendData(final NetListener<String> listener) {
        curDate = new Date(System.currentTimeMillis());
        String format1 = format.format(curDate);
        Log.e(TAG, "GangHuoModel: "+format1 );
        String a=format1.substring(0,4);
        String b=format1.substring(5,7);
        String c=format1.substring(8,10);

        year=Integer.parseInt(a);
        month=Integer.parseInt(b);
        day=Integer.parseInt(c);
        Log.e(TAG, "GangHuoModel: "+year+"  "+month+"  "+day );
        NetWorkApi.getInstance().getGankHuoRecommend(ApiManage.Gank_URL, new Subscriber<ResponseBody>() {
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
                    String data = responseBody.string();
                    listener.loadData(data);
                } catch (Exception e) {

                }

            }
        }, year, month, day);
    }

    /**
     * 加载更多每日推荐
     * @param listener
     */
    public void loadMoreRecommendData(final RequestListener<String> listener) {
        day-=1;
        if (day < 1) {
            month-=1;
            if (month < 1) {
                month=1;
            }
            day=28;
        }
        NetWorkApi.getInstance().getGankHuoRecommend(ApiManage.Gank_URL, new Subscriber<ResponseBody>() {
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
                    String data = responseBody.string();
                    listener.success(data);
                } catch (Exception e) {

                }
            }
        },year,month,day);
    }

    /**
     * 获得android干货
     * @param listener
     */
    public void loadAndroidData(final  RequestListener<String> listener){
        NetWorkApi.getInstance().getGanHuoData(ApiManage.Gank_URL, "Android", androidPage, new Subscriber<ResponseBody>() {
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
                    String data = responseBody.string();
                    listener.success(data);
                    androidPage+=1;
                } catch (Exception e) {

                }
            }
        });

    }

    /**
     * 加载更多
     * @param listener
     */
    public void loadMoreAndroidData(final  RequestListener<String> listener){
        NetWorkApi.getInstance().getGanHuoData(ApiManage.Gank_URL, "Android", androidPage, new Subscriber<ResponseBody>() {
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
                    String data = responseBody.string();
                    listener.success(data);
                    androidPage+=1;
                } catch (Exception e) {

                }
            }
        });

    }

    /**
     * 加载ios数据
     * @param listener
     */
    public void loadIOSData(final RequestListener<String> listener) {
        NetWorkApi.getInstance().getGanHuoData(ApiManage.Gank_URL, "iOS", iosPage, new Subscriber<ResponseBody>() {
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
                    String data=responseBody.string();
                    listener.success(data);
                    iosPage+=1;
                } catch (Exception e) {

                }
            }
        });
    }

    /**
     * 加载更多ios
     * @param listener
     */
    public void loadMoreIOSData(final RequestListener<String> listener){
        NetWorkApi.getInstance().getGanHuoData(ApiManage.Gank_URL, "iOS", iosPage, new Subscriber<ResponseBody>() {
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
                    String data=responseBody.string();
                    listener.success(data);
                    iosPage+=1;
                } catch (Exception e) {

                }
            }
        });
    }


}
