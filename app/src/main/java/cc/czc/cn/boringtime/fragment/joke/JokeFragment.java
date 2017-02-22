package cc.czc.cn.boringtime.fragment.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.R;
import cc.czc.cn.boringtime.adapter.JokeFragmentPageAdapter;
import cc.czc.cn.boringtime.fragment.BaseFragment;

/**
 * Created by cc on 2016/11/21.
 */

public class JokeFragment extends BaseFragment {
    @BindView(R.id.vp_frag_joke)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ViewGroup container;
    View view;
    JokeFragmentPageAdapter adapter;
    ArrayList<Fragment> fragmentArrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_joke, container, false);
        ButterKnife.bind(this, view);
        this.container=container;
        initViewPage();
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("JOKE");


        return view;
    }

    public void initViewPage() {
        fragmentArrayList = new ArrayList<Fragment>();
        fragmentArrayList.add(new JokeImageFragment());
        fragmentArrayList.add(new JokeTextFragment());
        adapter = new JokeFragmentPageAdapter(getFragmentManager(), fragmentArrayList);
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
