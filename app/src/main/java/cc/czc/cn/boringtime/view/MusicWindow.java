package cc.czc.cn.boringtime.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.List;

import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.adapter.MusicListAdapter;
import cc.czc.cn.boringtime.bean.MusicBean;

/**
 * Created by czc on 2017/2/23.
 */

public class MusicWindow extends PopupWindow {
    View view;
    LayoutInflater lanyoutInflater;
    Context context;
    List<MusicBean> data;
    View showAtView;
    private int widthPixels;
    private int heightPixels;
    private RecyclerView recyclerView;
    private MusicListAdapter adapter;

    public MusicWindow(Context context, List<MusicBean> data,View showatView,MusicListAdapter adapter) {
        this.showAtView=showatView;
        this.adapter=adapter;
        this.context=context;
        this.data=data;

        calWidthAndHeight();
        setWidth(widthPixels);
        setHeight(heightPixels);
//        super(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setAnimationStyle(R.style.music_popuwindow_anim_sstyle);

        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });

        initView();
        initEven();
    }

    private void calWidthAndHeight() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);

        widthPixels = metrics.widthPixels;
        heightPixels = (int) (metrics.heightPixels * 0.5);
//        heightPixels = LinearLayout.LayoutParams.WRAP_CONTENT;
    }


    private void initView() {
        view=LayoutInflater.from(context).inflate(R.layout.popuwindow_musiclist_item, null);
        setContentView(view);
        showAtLocation(showAtView, Gravity.BOTTOM,0,0);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_popuwindow_musicllist_item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    private void initEven() {

    }
}
