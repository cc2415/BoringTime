package cc.czc.cn.boringtime;

/**
 * Created by cc on 2016/11/24.
 */

public interface NetListener<T> {
    void loadData(T data);

    void updataDate(T data);
    void failed(String msg);

    void loadMoreData(T data);
    void completed(T msg);
}
