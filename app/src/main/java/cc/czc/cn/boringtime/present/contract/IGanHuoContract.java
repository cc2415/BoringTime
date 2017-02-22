package cc.czc.cn.boringtime.present.contract;

import java.util.List;

import cc.czc.cn.boringtime.base.IBasePresent;
import cc.czc.cn.boringtime.base.IBaseView;
import cc.czc.cn.boringtime.bean.GanHuoIOSBean;
import cc.czc.cn.boringtime.bean.GanHuoRecommendBean;
import cc.czc.cn.boringtime.bean.GanHuoAndroidBean;
import cc.czc.cn.boringtime.bean.GanHuoWelfareBean;

/**
 * Created by czc on 2017/2/16.
 */

public interface IGanHuoContract {
    interface IView extends IBaseView<GangHuoPresent>{
        void setRecommendAdapter(GanHuoRecommendBean.ResultsBean results);
        void loadMoreRecommendData(GanHuoRecommendBean.ResultsBean results);

        void setAndroidAdapter(List<GanHuoAndroidBean.ResultsBean> result);
        void loadMoreAndroidData(List<GanHuoAndroidBean.ResultsBean> result);

        void setIOSAdapter(List<GanHuoIOSBean.ResultsBean> result);
        void loadMoreIOSAdapter(List<GanHuoIOSBean.ResultsBean> result);

        void setWelfareAdapter(List<GanHuoWelfareBean.ResultsBean> results);
        void loadMoreWelfareData(List<GanHuoWelfareBean.ResultsBean> results);

        void loadFailed();

    }

    interface GangHuoPresent extends IBasePresent{
        void loadRecommendData();
        void loadMoreRecommendData();

        void loadWelafreData();
        void loadMoreWelafreData();

        void loadAndroidData();
        void loadMoreAndroidData();

        void loadIOSData();
        void loadMoreIOSData();
    }
}
