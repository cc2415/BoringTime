package cc.czc.cn.boringtime.bean;

/**
 * Created by czc on 2017/2/18.
 */

public class GanHuoRecommendDetailBean {
    /**
     * _id : 589d2bcd421aa9270bc7332c
     * createdAt : 2017-02-10T10:56:13.792Z
     * desc : Android 信用卡提交效果。
     * images : ["http://img.gank.io/0df0d67f-6d39-4880-9a44-b2531ccb3a75"]
     * publishedAt : 2017-02-10T11:38:22.122Z
     * source : chrome
     * type : Android
     * url : https://github.com/adonixis/android-sumbit-credit-card-flow
     * used : true
     * who : 代码家
     */
    String _id;
    String createAt;
    String desc;
    String images;
    String url;

    public GanHuoRecommendDetailBean(String _id, String createAt, String desc, String images, String url) {
        this._id = _id;
        this.createAt=createAt;
        this.desc=desc;
        this.url=url;
        this.images=images;
    }
    public GanHuoRecommendDetailBean(){}

    public String get_id() {
        return _id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getDesc() {
        return desc;
    }

    public String getImages() {
        return images;
    }

    public String getUrl() {
        return url;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
