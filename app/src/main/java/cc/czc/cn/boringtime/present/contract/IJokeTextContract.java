package cc.czc.cn.boringtime.present.contract;

import java.util.ArrayList;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;

/**
 * Created by cc on 2016/11/21.
 */

public interface IJokeTextContract {
    interface JokeView extends IBaseView<Present>{
        void initData(JokeTextEntiy data);
        void updateDate(JokeTextEntiy newData);
        void loadMoreData(JokeTextEntiy moreData);

    }

    interface Present extends IBasePresent {
        void loadData();
        void updateData();
        void loadMoreData();
    }
}
