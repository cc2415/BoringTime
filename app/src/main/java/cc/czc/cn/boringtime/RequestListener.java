package cc.czc.cn.boringtime;

/**
 * Created by cc on 2017/1/2.
 */

public interface RequestListener<T> {
    void success(T t);

    void failed(T t);
}
