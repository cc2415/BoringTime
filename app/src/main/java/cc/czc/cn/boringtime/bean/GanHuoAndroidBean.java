package cc.czc.cn.boringtime.bean;

import java.util.List;

/**
 * Created by czc on 2017/2/18.
 */

public class GanHuoAndroidBean {


    /**
     * error : false
     * results : [{"_id":"58aa6681421aa93d376f74e9","createdAt":"2017-02-20T11:46:09.793Z","desc":"Android 富文本（HTML）解析库，渲染的非常漂亮，值得推荐。","images":["http://img.gank.io/6c6660ab-4cd7-4ecb-b0b3-72d49c5a8cf8"],"publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"Android","url":"https://github.com/fourlastor/dante","used":true,"who":"daimajia"},{"_id":"58aa66b4421aa93d3d15aa33","createdAt":"2017-02-20T11:47:00.216Z","desc":"很有新意的一个滑动效果库。","images":["http://img.gank.io/b2efeade-98d3-40e5-8cc2-9d06738a8e3e"],"publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"Android","url":"https://github.com/MAXDeliveryNG/slideview","used":true,"who":"XM"},{"_id":"58aa6745421aa93d33938855","createdAt":"2017-02-20T11:49:25.96Z","desc":"双指控制图片展开，以及放大缩小，做的超棒！","images":["http://img.gank.io/e3a64868-35b2-46e0-86c4-4ca6e42c2f12"],"publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"Android","url":"https://github.com/imablanco/Zoomy","used":true,"who":"代码家"},{"_id":"58a64202421aa9662dc7409e","createdAt":"2017-02-17T08:21:22.893Z","desc":"Android Dropdown 风格的 Alert 窗体。","images":["http://img.gank.io/61492bf0-03ad-42a2-accb-21abf47e840f","http://img.gank.io/008a38fc-139d-484b-909a-354298366d8b"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://github.com/Tapadoo/Alerter","used":true,"who":"代码家"},{"_id":"58a65ad0421aa9662dc740a3","createdAt":"2017-02-17T10:07:12.739Z","desc":"5分钟完全理解android handler","publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://android-notes.github.io/2016/12/03/5%E5%88%86%E9%92%9F%E5%AE%8C%E5%85%A8%E7%90%86%E8%A7%A3android-handler/","used":true,"who":"LHF"},{"_id":"58a66205421aa9662dc740a4","createdAt":"2017-02-17T10:37:57.553Z","desc":"OkHttp Mock 数据调用，在做 Api 测试，写测试用例的时候会很有用哦。","publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://github.com/mirrajabi/okhttp-json-mock","used":true,"who":"代码家"},{"_id":"58a662a8421aa96631f16631","createdAt":"2017-02-17T10:40:40.669Z","desc":"一款漂亮的 Android 视差效果。","images":["http://img.gank.io/d63f2314-8aac-4023-92c8-9319acf47afb"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://github.com/developer-shivam/ChanelView","used":true,"who":"nds"},{"_id":"58a662e2421aa966366d05e5","createdAt":"2017-02-17T10:41:38.997Z","desc":"实现类似锤子和 Google Photo 的滑动选择功能。","images":["http://img.gank.io/9843391b-480d-475d-b3b0-51802eefd957"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://github.com/MFlisar/DragSelectRecyclerView","used":true,"who":"代码家"},{"_id":"58a6659d421aa96631f16632","createdAt":"2017-02-17T10:53:17.138Z","desc":"一个实用的联系人选择工具。","images":["http://img.gank.io/830f325c-9f1d-46f1-94e5-5b521f9b2dcd"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"Android","url":"https://github.com/quiin/UnifiedContactPicker","used":true,"who":"代码家"},{"_id":"58a50780421aa9662dc74098","createdAt":"2017-02-16T09:59:28.885Z","desc":"Android 上个性自定义 Loader。","images":["http://img.gank.io/5deef32c-5273-4ea6-8d75-9cbc44560725"],"publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"Android","url":"https://github.com/nntuyen/mkloader","used":true,"who":"dmj"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58aa6681421aa93d376f74e9
         * createdAt : 2017-02-20T11:46:09.793Z
         * desc : Android 富文本（HTML）解析库，渲染的非常漂亮，值得推荐。
         * images : ["http://img.gank.io/6c6660ab-4cd7-4ecb-b0b3-72d49c5a8cf8"]
         * publishedAt : 2017-02-20T11:56:22.616Z
         * source : chrome
         * type : Android
         * url : https://github.com/fourlastor/dante
         * used : true
         * who : daimajia
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
}
