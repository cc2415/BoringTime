package cc.czc.cn.boringtime.present.contract;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;
import cc.czc.cn.boringtime.bean.JokeImagEntiy;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;

/**
 * Created by cc on 2016/11/21.
 */

public interface IJokeImagContract {
    interface JokeView extends IBaseView<Present>{
        void initData(JokeImagEntiy data);
        void updateDate(JokeImagEntiy newData);
        void loadMoreData(JokeImagEntiy moreData);
    }

    interface Present extends IBasePresent {
        void loadData();
        void updateData();
        void loadMoreData();
    }
}
