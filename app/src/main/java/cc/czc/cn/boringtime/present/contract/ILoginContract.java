package cc.czc.cn.boringtime.present.contract;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;


/**
 * Created by cc on 2016/11/20.
 */
//契约类
public interface ILoginContract {
    //间接把view和present绑在了一起
    interface IView extends IBaseView<Present>{
        void showLoginDialog();
        void hiddenLoginDialog();
    }
    interface Present extends IBasePresent {
        void loging(String userName,String passWord);
        void register();
    }
}
