package cc.czc.cn.boringtime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.fragment.joke.JokeFragment;
import cc.czc.cn.boringtime.present.impl.LoginPresentImpl;
import cc.czc.cn.boringtime.present.contract.ILoginContract;
import cc.czc.cn.boringtime.view.CircleImageView;

public class MainActivity extends AppCompatActivity implements ILoginContract.IView {

    @BindView(R.id.navigationview_activity)
    NavigationView mNavigationView;
    @BindView(R.id.activity_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fl_activity)
    FrameLayout rootFrameLayout;

    View mHeardView;
    CircleImageView mCircleImageView;
    TextView mLogin;

    ILoginContract.Present mPresent;
    Context context;

    static final String JOKE_FRAMGNET_TAG="jokeFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        new LoginPresentImpl(this);
        context=this;
        initHeadView();
        initFragment();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.joke_frag:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.clean_memory:
                        Glide.get(context).clearMemory();
                        Toast.makeText(context, "Sucess", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mNavigationView.setCheckedItem(R.id.joke_frag);
                        break;
                }
                return true;
            }
        });

    }

    private void initHeadView() {
        mHeardView=mNavigationView.getHeaderView(0);
        mCircleImageView= (CircleImageView) mHeardView.findViewById(R.id.iv_menu_header);
        mLogin = (TextView) mHeardView.findViewById(R.id.tv_menu_header);
        mNavigationView.setCheckedItem(R.id.joke_frag);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "loginligng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFragment() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        JokeFragment fragment=new JokeFragment();
        fragmentManager.beginTransaction().replace(R.id.fl_activity, fragment, JOKE_FRAMGNET_TAG).commit();




    }

    public void switchFragment(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void showProgress() {
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiddenProgress() {
//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresent(ILoginContract.Present present) {
        mPresent=present;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent=null;
    }

    @Override
    public void showLoginDialog() {

    }
}
