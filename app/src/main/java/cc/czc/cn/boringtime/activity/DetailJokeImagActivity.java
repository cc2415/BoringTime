package cc.czc.cn.boringtime.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.util.ImageUtil;

/**
 * Created by cc on 2016/11/25.
 */

public class DetailJokeImagActivity extends AppCompatActivity {
    @BindView(R.id.iv_activity_detail_joke)
    ImageView iv;
    @BindView(R.id.tv_activity_detail_joke)
    TextView tv;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_joke_img);
        ButterKnife.bind(this);
        context = this;
        Intent intent = getIntent();
        String title = intent.getStringExtra("text");
        String url = intent.getStringExtra("url");

        tv.setText(title);
        Glide.with(this).load(url).into(iv);
        Glide.with(context).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
               iv.setImageBitmap(resource);
               Palette.generateAsync(resource, 24, new Palette.PaletteAsyncListener() {
                   @Override
                   public void onGenerated(Palette palette) {
                       Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
                       if (darkMutedSwatch != null) {
                        tv.setBackgroundColor(darkMutedSwatch.getRgb());
                        tv.setTextColor(darkMutedSwatch.getTitleTextColor());
                    }
                   }
               });
            }
        });


//        byte[] byteArrayExtra = intent.getByteArrayExtra("url");
//        Bitmap bitmap = ImageUtil.byteArrayToBitmap(byteArrayExtra);
//        if (bitmap != null) {
//            iv.setImageBitmap(bitmap);
//            Palette.generateAsync(bitmap, 24, new Palette.PaletteAsyncListener() {
//                @Override
//                public void onGenerated(Palette palette) {
//                    Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
//                    if (darkMutedSwatch != null) {
//                        tv.setBackgroundColor(darkMutedSwatch.getRgb());
//                        tv.setTextColor(darkMutedSwatch.getTitleTextColor());
////                        Glide.with(context).load(bitmap).into(iv);
//                    }
//                }
//            });
//
//        }
    }




    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


