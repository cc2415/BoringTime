package cc.czc.cn.boringtime.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cc on 2016/12/5.
 */

public interface BaiduApi {
  @GET("joke_pic")
  Observable<ResponseBody> getImageData(@Header("apikey") String apikey, @Query("page") String page);

  @GET("joke_text")
  Observable<ResponseBody> getJokeTextData(@Header("apikey") String key, @Query("textPage") String page);



  @GET("regist")
  Observable<ResponseBody> getTest(@Query("name") String name,@Query("password") String password);

  @FormUrlEncoded
  @POST("regist")
  Observable<ResponseBody> getPostTest(@Field("name") String name,@Field("password") String password);


  @Headers({"Content-Type:application/json","Accept:application/json"})
  @POST("regist")
  Observable<ResponseBody> PostJson(@Body RequestBody requestBody);

}
