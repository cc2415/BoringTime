package cc.czc.cn.boringtime.present.contract;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;
import cc.czc.cn.boringtime.bean.JokeImagBean;

/**
 * Created by cc on 2016/11/21.
 */

public interface IJokeImagContract {
    interface JokeView extends IBaseView<Present>{
        void initData(JokeImagBean data);
        void updateDate(JokeImagBean newData);
        void loadMoreData(JokeImagBean moreData);
    }

    interface Present extends IBasePresent {
        void loadData();
        void updateData();
        void loadMoreData();
    }
}
