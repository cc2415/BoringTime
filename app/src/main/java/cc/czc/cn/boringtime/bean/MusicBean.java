package cc.czc.cn.boringtime.bean;

/**
 * Created by czc on 2017/2/23.
 */

public class MusicBean {
    long id;
    String title;

    String artist;
    long dration;
    long size;
    String url;
    int isMusic;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDration(long dration) {
        this.dration = dration;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMusic(int music) {
        isMusic = music;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public long getDration() {
        return dration;
    }

    public long getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }

    public int isMusic() {
        return isMusic;
    }
}
