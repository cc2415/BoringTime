package cc.czc.cn.boringtime.api;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by cc on 2017/1/2.
 */

public interface UserApi {
    @FormUrlEncoded
    @POST("regist")
    Observable<ResponseBody> login(@Field("name") String name, @Field("password") String password);
}
