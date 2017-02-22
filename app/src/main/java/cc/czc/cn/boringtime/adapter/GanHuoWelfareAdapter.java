package cc.czc.cn.boringtime.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.bean.GanHuoWelfareBean;

/**
 * Created by czc on 2017/2/20.
 */

public class GanHuoWelfareAdapter extends RecyclerView.Adapter<GanHuoWelfareAdapter.MyViewHolder> {
    List<GanHuoWelfareBean.ResultsBean> data;
    Context context;
    LayoutInflater inflater;

    public GanHuoWelfareAdapter(Context context, List<GanHuoWelfareBean.ResultsBean> data) {
        this.data=data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.from(context).inflate(R.layout.item_frag_joke_img, parent, false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Glide.with(context).load(R.drawable.pictures_no).asBitmap().into(holder.iv);
        Glide.with(context).load(data.get(position).getUrl()).asBitmap().into(holder.iv);
        holder.tv_time.setText(data.get(position).getCreatedAt());
        holder.tv_desc.setText(data.get(position).getDesc());
//        Glide.with(context).load(data.get(position).getUrl()).asBitmap().into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                Palette.generateAsync(resource,24, new Palette.PaletteAsyncListener() {
//                    @Override
//                    public void onGenerated(Palette palette) {
//                        Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
//                        if (darkVibrantSwatch != null) {
//                            holder.tv_desc.setBackgroundColor(darkVibrantSwatch.getRgb());
//
//                        }
//                    }
//                });
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_desc;
        TextView tv_time;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_item_frag_joke_img);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_img);
            tv_time = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_img_time);
        }
    }
}
