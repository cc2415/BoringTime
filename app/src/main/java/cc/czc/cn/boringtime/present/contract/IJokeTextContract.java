package cc.czc.cn.boringtime.present.contract;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;
import cc.czc.cn.boringtime.bean.JokeTextBean;

/**
 * Created by cc on 2016/11/21.
 */

public interface IJokeTextContract {
    interface JokeView extends IBaseView<Present>{
        void initData(JokeTextBean data);
        void updateDate(JokeTextBean newData);
        void loadMoreData(JokeTextBean moreData);

    }

    interface Present extends IBasePresent {
        void loadData();
        void updateData();
        void loadMoreData();
    }
}
