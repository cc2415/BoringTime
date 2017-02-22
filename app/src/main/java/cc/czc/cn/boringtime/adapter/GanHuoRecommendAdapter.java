package cc.czc.cn.boringtime.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.bean.GanHuoRecommendBean;
import cc.czc.cn.boringtime.bean.GanHuoRecommendDetailBean;
import cc.czc.cn.boringtime.util.RecycliViewClickListenUtil;

/**
 * Created by czc on 2017/2/16.
 */

public class GanHuoRecommendAdapter extends RecyclerView.Adapter<GanHuoRecommendAdapter.MyViewHolder> {
    List<GanHuoRecommendDetailBean> data;
    LayoutInflater layoutInflater;
    Context context;
    public GanHuoRecommendAdapter(List<GanHuoRecommendDetailBean> data, Context context) {
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View va = layoutInflater.inflate(R.layout.item_ganhuo_recommend, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(va);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //初始化图片
        Glide.with(context).load(R.drawable.pictures_no).asBitmap().into(holder.iv);

        holder.tv_desc.setText(data.get(position).getDesc());
        holder.tv_time.setText(data.get(position).getCreateAt());
        Glide.with(context).load(data.get(position).getImages()).asBitmap().into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClickListen(view,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_time;
        TextView tv_desc;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_item_ganhuo_recommend_desc);
            tv_time = (TextView) itemView.findViewById(R.id.tv_item_ganhuo_recommend_time);
            iv = (ImageView) itemView.findViewById(R.id.iv_item_ganhuo_recommend);
        }
    }

    RecycliViewClickListenUtil listener=null;
    public void setRecycliViewClickListener(RecycliViewClickListenUtil listener){
        this.listener=listener;
    }


}
