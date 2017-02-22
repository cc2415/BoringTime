package cc.czc.cn.boringtime.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by czc on 2017/2/18.
 */

public class GanHuoRecommendBean {


    /**
     * category : ["休息视频","瞎推荐","iOS","Android","福利"]
     * error : false
     * results : {"Android":[{"_id":"589d2bcd421aa9270bc7332c","createdAt":"2017-02-10T10:56:13.792Z","desc":"Android 信用卡提交效果。","images":["http://img.gank.io/0df0d67f-6d39-4880-9a44-b2531ccb3a75"],"publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"Android","url":"https://github.com/adonixis/android-sumbit-credit-card-flow","used":true,"who":"代码家"},{"_id":"589d2bed421aa92710db9613","createdAt":"2017-02-10T10:56:45.622Z","desc":"简洁优雅的网络状态提示。","images":["http://img.gank.io/93211cbf-d4af-4bc4-ba76-621dfb1dfe40"],"publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"Android","url":"https://github.com/iammert/StatusView","used":true,"who":"代码家"}],"iOS":[{"_id":"589d2af5421aa9270bc7332b","createdAt":"2017-02-10T10:52:37.898Z","desc":"Swift 发送邮件 📧","images":["http://img.gank.io/41577a74-2e4b-4f20-9cee-5f5d3a2a2ce4"],"publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"iOS","url":"https://github.com/onevcat/Hedwig","used":true,"who":"代码家"},{"_id":"589d2b9f421aa92710db9612","createdAt":"2017-02-10T10:55:27.144Z","desc":"弹出一个醒目而优雅的通知框。","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"iOS","url":"https://github.com/candostdagdeviren/CDAlertView","used":true,"who":"代码家"}],"休息视频":[{"_id":"58974706421aa970bed462c2","createdAt":"2017-02-05T23:38:46.879Z","desc":"不要给我讲理，我就是道理...也是说出了万千女生的心声...哈哈哈~真理都在女人嘴里，无法反驳...[笑cry][笑cry]","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"休息视频","url":"http://weibo.com/tv/v/cf39d9a371f7329cb7736bd1b16293de?fid=1034:cf39d9a371f7329cb7736bd1b16293de","used":true,"who":"lxxself"}],"瞎推荐":[{"_id":"589c0e76421aa92dbe257232","createdAt":"2017-02-09T14:38:46.687Z","desc":"阿里巴巴Java开发手册","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"瞎推荐","url":"http://deadlion.cn/2017/02/05/Alibaba-Java-Code-Style.html","used":true,"who":"wuzheng"}],"福利":[{"_id":"589d31a2421aa9270bc7332e","createdAt":"2017-02-10T11:21:06.747Z","desc":"2-10","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg","used":true,"who":"代码家"}]}
     */

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<IOSBean> iOS;
        @SerializedName("休息视频")
        private List<VideoBean> Video;
        @SerializedName("瞎推荐")
        private List<RecommendBean> Recommend;
        @SerializedName("福利")
        private List<WelfareBean> Welfare;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<VideoBean> getVideo() {
            return Video;
        }

        public void setVideo(List<VideoBean> Video) {
            this.Video = Video;
        }

        public List<RecommendBean> getRecommend() {
            return Recommend;
        }

        public void setRecommend(List<RecommendBean> Recommend) {
            this.Recommend = Recommend;
        }

        public List<WelfareBean> getWelfare() {
            return Welfare;
        }

        public void setWelfare(List<WelfareBean> Welfare) {
            this.Welfare = Welfare;
        }

        public static class AndroidBean {
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

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class IOSBean {
            /**
             * _id : 589d2af5421aa9270bc7332b
             * createdAt : 2017-02-10T10:52:37.898Z
             * desc : Swift 发送邮件 📧
             * images : ["http://img.gank.io/41577a74-2e4b-4f20-9cee-5f5d3a2a2ce4"]
             * publishedAt : 2017-02-10T11:38:22.122Z
             * source : chrome
             * type : iOS
             * url : https://github.com/onevcat/Hedwig
             * used : true
             * who : 代码家
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class VideoBean {
            /**
             * _id : 58974706421aa970bed462c2
             * createdAt : 2017-02-05T23:38:46.879Z
             * desc : 不要给我讲理，我就是道理...也是说出了万千女生的心声...哈哈哈~真理都在女人嘴里，无法反驳...[笑cry][笑cry]
             * publishedAt : 2017-02-10T11:38:22.122Z
             * source : chrome
             * type : 休息视频
             * url : http://weibo.com/tv/v/cf39d9a371f7329cb7736bd1b16293de?fid=1034:cf39d9a371f7329cb7736bd1b16293de
             * used : true
             * who : lxxself
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class RecommendBean {
            /**
             * _id : 589c0e76421aa92dbe257232
             * createdAt : 2017-02-09T14:38:46.687Z
             * desc : 阿里巴巴Java开发手册
             * publishedAt : 2017-02-10T11:38:22.122Z
             * source : chrome
             * type : 瞎推荐
             * url : http://deadlion.cn/2017/02/05/Alibaba-Java-Code-Style.html
             * used : true
             * who : wuzheng
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class WelfareBean {
            /**
             * _id : 589d31a2421aa9270bc7332e
             * createdAt : 2017-02-10T11:21:06.747Z
             * desc : 2-10
             * publishedAt : 2017-02-10T11:38:22.122Z
             * source : chrome
             * type : 福利
             * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg
             * used : true
             * who : 代码家
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
