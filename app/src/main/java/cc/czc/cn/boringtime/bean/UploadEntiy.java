package cc.czc.cn.boringtime.bean;

/**
 * Created by cc on 2016/12/13.
 */

public class UploadEntiy {

    /**
     * status : true
     * count : 7672
     * fcount : 0
     * food : 芹菜叶,黑木耳,白芝麻,花椒油,香油
     * id : 164
     * images :
     * img : /cook/150802/fc43c4736144faf2c52aed1965aa5a19.jpg
     * keywords : 黑木耳 菜叶 花椒油 白芝麻 水分
     * name : 芹菜叶拌木耳
     * rcount : 0
     */

    private boolean status;
    private int count;
    private int fcount;
    private String food;
    private int id;
    private String images;
    private String img;
    private String keywords;
    private String name;
    private int rcount;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }
}
