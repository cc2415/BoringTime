package cc.czc.cn.boringtime.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cc on 2017/1/2.
 */

public interface ZhiHuApi {
    @GET("/api/4/news/latest")
    Observable<ResponseBody> getLastDaily();

    @GET("/api/4/news/before/{date}")
    Observable<ResponseBody> getTheDaily(@Path("date") String date);

    @GET("/api/4/news/{id}")
    Observable<ResponseBody> getZhihuStory(@Path("id") String id);//id从第一个中获取
}
