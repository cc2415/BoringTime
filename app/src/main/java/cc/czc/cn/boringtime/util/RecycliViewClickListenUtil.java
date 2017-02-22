package cc.czc.cn.boringtime.util;

import android.view.View;

/**
 * Created by czc on 2017/2/20.
 */

public interface RecycliViewClickListenUtil {
    void onItemClickListen(View view , int position);

    void onLongClickListen(View view, int position);
}
