package cc.czc.cn.boringtime.util;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;

import com.bumptech.glide.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;

/**
 * Created by czc on 2017/2/25.
 */

public class DiskLruCaCheUtil {
    static DiskLruCaCheUtil instance=null;
    Context context;
    private  DiskLruCache diskLruCache;

    private DiskLruCaCheUtil(){
        int version=getAppVersion();
        File cache = getCacheFile(context, "czcBitmap");
        try {
            diskLruCache = DiskLruCache.open(cache, version, 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public DiskLruCaCheUtil getInstance(Context context){
        if (instance == null) {
            synchronized (DiskLruCaCheUtil.class) {
                if (instance == null) {
                    this.context=context;
                    instance=new DiskLruCaCheUtil();
                }
            }
        }
        return instance;
    }

    public void caCheBitmap(String key,Bitmap cache) throws IOException {
//        DiskLruCache.Editor editor = diskLruCache.edit(key);
    }

    /**
     * 获得app版本号
     * @return
     */
    private int getAppVersion(){
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return  1;
    }

    /**
     * 获得不同状态下的缓存目录
     * @param context
     * @param uniqueName
     * @return
     */
    private File getCacheFile(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                ||!Environment.isExternalStorageRemovable()){
            cachePath=context.getExternalCacheDir().getPath();
        }else{
            cachePath=context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }
}
