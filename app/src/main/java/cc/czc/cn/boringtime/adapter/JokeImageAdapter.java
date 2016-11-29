package cc.czc.cn.boringtime.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.bean.JokeImagEntiy;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeImageAdapter extends RecyclerView.Adapter<JokeImageAdapter.MyViewHole> {
    List<JokeImagEntiy.ShowapiResBodyBean.ContentlistBean> data;
    Context context;
    LayoutInflater inflater;

    public JokeImageAdapter(Context context, List<JokeImagEntiy.ShowapiResBodyBean.ContentlistBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public JokeImageAdapter.MyViewHole onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_frag_joke_img, parent, false);
        MyViewHole viewHole = new MyViewHole(view);

        return viewHole;
    }

    @Override
    public void onBindViewHolder(final JokeImageAdapter.MyViewHole holder, final int position) {
        final Bitmap[] bitmap = new Bitmap[1];
        holder.tv.setText(data.get(position).getTitle());
        holder.tv_time.setText(data.get(position).getCt());
//        Glide.with(context).load(data.get(position).getImg()).into(holder.iv);
//        SimpleTarget simpleTarget = new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                Palette.generateAsync(resource, 24, new Palette.PaletteAsyncListener() {
//                    @Override
//                    public void onGenerated(Palette palette) {
//                        Palette.Swatch swatch = palette.getDarkMutedSwatch();
//                        holder.tv.setBackgroundColor(swatch.getRgb());
//                    }
//                });
//            }
//        };
//
//        Glide.with(context).load(data.get(position).getImg()).asBitmap().into(simpleTarget);

        Glide.with(context).load(data.get(position).getImg()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.iv.setImageBitmap(resource);
                bitmap[0] =resource;
            }
        }); //方法中设置asBitmap可以设置回调类型
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null) {
                    listener.ItemClickListener(view,position,bitmap[0]);
//                    listener.ItemClickListener(view,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHole extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;
        TextView tv_time;

        public MyViewHole(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_item_frag_joke_img);
            tv = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_img);
            tv_time = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_img_time);
        }
    }

    public interface OnItemClickListener{
        void ItemClickListener(View view, int position, Bitmap bitmap);
        void ItemClickListener(View view, int position);
    }
    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
