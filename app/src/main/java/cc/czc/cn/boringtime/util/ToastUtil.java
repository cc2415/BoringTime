package cc.czc.cn.boringtime.util;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by czc on 2017/2/21.
 */

public class ToastUtil {
    static ToastUtil toastUtil=null;
    Toast mToast = null;
    Context context=null;
    Snackbar snackbar;
    private ToastUtil(Context context){
//        mToast=new Toast(context);
        this.context=context;
    }
    public static ToastUtil getInstance(Context context){
        if (toastUtil == null) {
            synchronized (ToastUtil.class) {
                if (toastUtil == null) {
                    toastUtil = new ToastUtil(context);
                }
            }
        }
        return toastUtil;
    }

    public void showMsg(String msg){
        if (mToast==null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
