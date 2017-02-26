package cc.czc.cn.boringtime.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * Created by czc on 2017/2/25.
 */

public class MusicPlayUtil {
    static MusicPlayUtil musicPlayUtil;
    private final MediaPlayer player;
    private Context context;
    private int
            PLAY_CURRENT = -1;
    private boolean IS_PLAYING=false;
    public MusicPlayUtil(Context context) {
        player = new MediaPlayer();
//        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        this.context = context;
    }


    public static MusicPlayUtil getInstance(Context context) {
        if (musicPlayUtil == null) {
            synchronized (MusicPlayUtil.class) {
                if (musicPlayUtil == null) {
                    musicPlayUtil = new MusicPlayUtil(context);
                    return musicPlayUtil;
                }
            }
        }
        return musicPlayUtil;
    }

    /**
     * 如果之前有播放就取消播放新的，如果同一首就暂停，
     *
     * @param url
     */
    public void palyMusic(String url,int playPosition) {
        try {
            //相同就暂停
            if (playPosition == PLAY_CURRENT) {
                if (IS_PLAYING){
                    player.pause();
                    IS_PLAYING=false;
                }else {
                    player.start();
                    IS_PLAYING=true;
                }
            } else {
//                player.release();
                player.reset();
                player.setDataSource(context, Uri.parse(url));
                player.prepare();
                player.start();
                IS_PLAYING=true;
            }
            PLAY_CURRENT = playPosition;
            ToastUtil.getInstance(context).showMsg(PLAY_CURRENT+"   "+playPosition);
//            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    player.release();
//                }
//            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
