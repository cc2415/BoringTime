package cc.czc.cn.boringtime.util;

import com.google.gson.Gson;

/**
 * Created by czc on 2017/2/18.
 */

public class GsonUtil {
   static GsonUtil gsonUtil=null;
    private static Gson gson=null;
    private  GsonUtil(){
        gson=new Gson();

    }
    public static GsonUtil getInstance(){
        if (gsonUtil==null) {
            synchronized (GsonUtil.class) {
                if (gsonUtil==null)
                    gsonUtil=new GsonUtil();
            }
        }
        return gsonUtil;
    }

    public <T> T  JsonToBean(String json,Class<T> classoT){
        T t = gson.fromJson(json, classoT);
        return t;
    }


}
