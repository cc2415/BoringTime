package cc.czc.cn.boringtime.util;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by czc on 2017/2/21.
 */

public class CacheUtil {
    static CacheUtil cacheUtil = null;
    LruCache<String, Bitmap> mCache;
    private CacheUtil() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize=maxMemory/8;
        mCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
            }
        };
    }

    public static CacheUtil getInstance() {
        if (cacheUtil == null) {
            synchronized (CacheUtil.class) {
                if (cacheUtil == null) {
                    cacheUtil = new CacheUtil();
                }
            }
        }
        return cacheUtil;
    }

    /**
     * 添加图片入缓存
     * @param keyUrl
     * @param bitmap
     */
    public void addBitampIntoCache(String keyUrl, Bitmap bitmap) {
        if (getBiamapFromLruCache(keyUrl) == null) {
            if (bitmap != null) {
                mCache.put(keyUrl, bitmap);
            }
        }
    }

    /**
     * 从图片取缓存
     * @param keyUrl
     * @return
     */
    public Bitmap getBiamapFromLruCache(String keyUrl){
        return mCache.get(keyUrl);
    }
}
