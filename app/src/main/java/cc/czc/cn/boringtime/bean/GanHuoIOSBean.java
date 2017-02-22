package cc.czc.cn.boringtime.bean;

import java.util.List;

/**
 * Created by czc on 2017/2/20.
 */

public class GanHuoIOSBean {

    /**
     * error : false
     * results : [{"_id":"58a798da421aa9662f429747","createdAt":"2017-02-18T08:44:10.820Z","desc":"Osho 相机是我独立开发上架的一个相机 App，它支持1:1，4:3，16:9多种分辨率拍摄，滤镜可在取景框的实时预览，拍摄过程可与滤镜实时合成，支持分段拍摄，支持回删等特性。下面先分享分享开发这个 App 的一些心得体会，文末会给出项目的下载地址，阅读本文可能需要一点点 AVFoundation 开发的基础。","images":["http://img.gank.io/c1b84373-ceff-4ff0-96e9-1e47a2be569b"],"publishedAt":"2017-02-20T11:56:22.616Z","source":"web","type":"iOS","url":"https://hawk0620.github.io/blog/2017/02/17/zpcamera-opensource-share/","used":true,"who":"陈浩"},{"_id":"58a85f58421aa966366d05f6","createdAt":"2017-02-18T22:51:04.323Z","desc":"这或许是最好用的iOS消息通知框架了，支持多种效果","publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"iOS","url":"https://github.com/imlifengfeng/FFToast","used":true,"who":"feng"},{"_id":"58aa6591421aa93d33938853","createdAt":"2017-02-20T11:42:09.222Z","desc":"Swift 渐变式加载进度条。","images":["http://img.gank.io/ca87801c-030d-466c-89fd-8a27ed734c3d"],"publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"iOS","url":"https://github.com/DholStudio/DSGradientProgressView","used":true,"who":"DS"},{"_id":"58a6667b421aa966366d05e8","createdAt":"2017-02-17T10:56:59.960Z","desc":"基于 iOS10 UIViewPropertyAnimator 创建的 iOS 动画框架","images":["http://img.gank.io/79f02ee4-6f00-4ff6-8f50-3c8d983c43e2"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"iOS","url":"https://github.com/saoudrizwan/Dance","used":true,"who":"saodri"},{"_id":"58a666d1421aa9662f42973e","createdAt":"2017-02-17T10:58:25.242Z","desc":"iOS动画进阶 - 手摸手教你写ShineButton动画","images":["http://img.gank.io/704bd70d-f6d9-44d1-a775-3757e8c605c2"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"iOS","url":"http://blog.imwcl.com/2017/02/16/iOS%E5%8A%A8%E7%94%BB%E8%BF%9B%E9%98%B6-%E6%89%8B%E6%91%B8%E6%89%8B%E6%95%99%E4%BD%A0%E5%86%99ShineButton%E5%8A%A8%E7%94%BB/","used":true,"who":"post"},{"_id":"58a6673a421aa9662f429740","createdAt":"2017-02-17T11:00:10.867Z","desc":"又一个 iOS 色彩提取工具库。","images":["http://img.gank.io/6d96a486-bff2-4b6f-b4f8-7114a48b42c9"],"publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"iOS","url":"https://github.com/orchely/ColorThiefSwift","used":true,"who":"orchely"},{"_id":"58a506ba421aa9662f42972b","createdAt":"2017-02-16T09:56:10.387Z","desc":"iOS 异步绘图工具","images":["http://img.gank.io/bc9ef40a-8ebf-40e4-820e-c79a5928c786","http://img.gank.io/2ef3babf-1509-45e8-8850-4f596b1d23ce"],"publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"iOS","url":"https://github.com/DSKcpp/PPAsyncDrawingKit","used":true,"who":"代码家"},{"_id":"58a5072f421aa9662dc74097","createdAt":"2017-02-16T09:58:07.816Z","desc":"Swift 下实现的漂亮的 Slide 组件。","images":["http://img.gank.io/6df157ee-b394-4710-8184-d35fa53644a4"],"publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"iOS","url":"https://github.com/WenchaoD/FSPagerView","used":true,"who":"代码家"},{"_id":"58a3be9f421aa96631f1661c","createdAt":"2017-02-15T10:36:15.687Z","desc":"ESTabBarController是一个高度自定义的TabBarController组件，更容易的实现改变文字样式、添加动画效果。","images":["http://img.gank.io/026b5581-c34b-48e7-bffc-c6675165c24f","http://img.gank.io/42d2abf8-c663-4c61-bce6-9b9f64df6d82"],"publishedAt":"2017-02-15T11:24:04.127Z","source":"chrome","type":"iOS","url":"https://github.com/eggswift/ESTabBarController","used":true,"who":"代码家"},{"_id":"58a3c063421aa9662f429723","createdAt":"2017-02-15T10:43:47.441Z","desc":"如何优雅的干掉 iOS 的 SSL Pinning，然后盗走你的 Facebook 信息。","images":["http://img.gank.io/e7386763-5ebf-48f9-a67b-0129fa3bfb60"],"publishedAt":"2017-02-15T11:24:04.127Z","source":"chrome","type":"iOS","url":"https://github.com/Naituw/HackingFacebook","used":true,"who":"代码家"}]
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
         * _id : 58a798da421aa9662f429747
         * createdAt : 2017-02-18T08:44:10.820Z
         * desc : Osho 相机是我独立开发上架的一个相机 App，它支持1:1，4:3，16:9多种分辨率拍摄，滤镜可在取景框的实时预览，拍摄过程可与滤镜实时合成，支持分段拍摄，支持回删等特性。下面先分享分享开发这个 App 的一些心得体会，文末会给出项目的下载地址，阅读本文可能需要一点点 AVFoundation 开发的基础。
         * images : ["http://img.gank.io/c1b84373-ceff-4ff0-96e9-1e47a2be569b"]
         * publishedAt : 2017-02-20T11:56:22.616Z
         * source : web
         * type : iOS
         * url : https://hawk0620.github.io/blog/2017/02/17/zpcamera-opensource-share/
         * used : true
         * who : 陈浩
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
