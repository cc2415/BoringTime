package cc.czc.cn.boringtime.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cc on 2017/1/2.
 */

public interface GankApi {
    @GET("/api/data/福利/10/{page}")
    Observable<ResponseBody> getMeiZhiData(@Path("page") int page);

//    Android  iOS  福利  前端  扩展资源
    @GET("/api/data/{Android}/10/{page}")
    Observable<ResponseBody> getGanHuoData(@Path("Android") String classfiy,@Path("page") int page);

    @GET("/api/day/{year}/{month}/{day}")
    Observable<ResponseBody> getRecommend(@Path("year") int year, @Path("month") int month,
                                     @Path("day") int day);

    @GET("/api/data/休息视频/10/{page}")
    Observable<ResponseBody> getVedioData(@Path("page") int page);
}
