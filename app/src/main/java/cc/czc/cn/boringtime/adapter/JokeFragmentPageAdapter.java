package cc.czc.cn.boringtime.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by cc on 2016/11/22.
 */

public class JokeFragmentPageAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentArrayList;
    public JokeFragmentPageAdapter(FragmentManager fm,ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.fragmentArrayList=fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList==null?0:fragmentArrayList.size();
    }
}
