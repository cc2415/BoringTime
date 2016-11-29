package cc.czc.cn.boringtime.model;

import cc.czc.cn.boringtime.bean.JokeImagEntiy;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cc on 2016/11/25.
 */

public interface IJokeImageNet {
    @GET("joke_pic")
    Observable<JokeImagEntiy> getData(@Header("apikey") String apikey, @Query("page") String page);
}
