package cc.czc.cn.boringtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.bean.MusicBean;
import cc.czc.cn.boringtime.util.RecycliViewClickListenUtil;

/**
 * Created by czc on 2017/2/23.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {
    List<MusicBean> data;
    Context context;
    LayoutInflater layoutInflater;
    public MusicListAdapter(Context context,List<MusicBean> data){
        this.data=data;
        this.context=context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_musiclist, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_name.setText(data.get(position).getArtist());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null) {
                    listener.onItemClickListen(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_item_muslic_title);
            tv_name = (TextView) itemView.findViewById(R.id.tv_item_muslic_name);
        }
    }

    RecycliViewClickListenUtil listener=null;

    public void setOnItemClickListener(RecycliViewClickListenUtil listener) {
        this.listener=listener;
    }
}
