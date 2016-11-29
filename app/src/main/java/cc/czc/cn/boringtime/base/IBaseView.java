package cc.czc.cn.boringtime.base;

/**
 * Created by cc on 2016/11/20.
 */

public interface IBaseView<T> {
    void showProgress();
    void hiddenProgress();

    void setPresent(T present);
}
