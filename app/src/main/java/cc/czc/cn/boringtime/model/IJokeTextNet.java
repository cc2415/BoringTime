package cc.czc.cn.boringtime.model;

import cc.czc.cn.boringtime.bean.JokeTextEntiy;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cc on 2016/11/24.
 */

public interface IJokeTextNet {
    @GET("joke_text")
    Observable<JokeTextEntiy> getJokeText(@Header("apikey") String key, @Query("textPage") String page);
}
