package cc.czc.cn.boringtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.bean.JokeTextEntiy;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeTextAdapter extends RecyclerView.Adapter<JokeTextAdapter.MyViewHolder> {
    List<JokeTextEntiy.ShowapiResBodyBean.ContentlistBean> data;
    Context context;
    LayoutInflater inflater;
    public JokeTextAdapter(Context context, List<JokeTextEntiy.ShowapiResBodyBean.ContentlistBean> data){
        this.context=context;
        this.data=data;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_frag_joke_text, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_content.setText(data.get(position).getText());
        holder.tv_time.setText(data.get(position).getCt());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_content;
        TextView tv_time;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_text_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_text_content);
            tv_time = (TextView) itemView.findViewById(R.id.tv_item_frag_joke_text_time);
        }
    }
}
