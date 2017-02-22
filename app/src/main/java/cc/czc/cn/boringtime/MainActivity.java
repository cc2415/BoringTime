package cc.czc.cn.boringtime;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.czc.cn.boringtime.fragment.ganghuo.GankHuoFragment;
import cc.czc.cn.boringtime.fragment.joke.JokeFragment;
import cc.czc.cn.boringtime.present.impl.LoginPresentImpl;
import cc.czc.cn.boringtime.present.contract.ILoginContract;
import cc.czc.cn.boringtime.view.CircleImageView;

public class MainActivity extends AppCompatActivity implements ILoginContract.IView,View.OnClickListener {

    @BindView(R.id.navigationview_activity)
    NavigationView mNavigationView;
    @BindView(R.id.activity_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fl_activity)
    FrameLayout rootFrameLayout;
    /**
     * 笑话fragment
     */
    JokeFragment fragment;

    GankHuoFragment gankHuoFragment;
    View mHeardView;
    CircleImageView mCircleImageView;
    TextView mLogin;

    ILoginContract.Present mPresent;
    Context context;

    AlertDialog alter;
    AlertDialog.Builder builder;

    static final String JOKE_FRAMGNET_TAG = "jokeFragment";

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
//        mPresent.start();
        context = this;
        initHeadView();
        initFragment();











//        Retrofit retrofit2 = new Retrofit.Builder()
//                .baseUrl("http://192.168.56.1/withAndroid/index.php/Home/Use/")
////                .baseUrl("http://192.168.1.108:8081/oid/index.php/Home/User/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        BaiduApi apiServer = retrofit2.create(BaiduApi.class);
//        apiServer.getPostTest("qqqqqq123","qw212")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ResponseBody>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("222222222   completed");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("222222222   error");
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            System.out.println(responseBody.string());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("22222222222"+"  "+"sucress");
//                    }
//                });

        // TODO: 2016/12/13 json
//        UploadEntiy uploadEntiy = new UploadEntiy();
//        uploadEntiy.setFood("嘻嘻嘻笑笑晓");
//        Gson gson=new Gson();
//        String toJson = gson.toJson(uploadEntiy);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJson);
//        apiServer.PostJson(requestBody)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ResponseBody>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("===========completed");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        System.out.println("========error");
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            String string = responseBody.string();
//                            System.out.println(string);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });




















//侧边栏点击事件
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.joke_frag:
                        if (fragment==null) {
                            fragment=new JokeFragment();
                        }
                        switchFragment(fragment);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mNavigationView.setCheckedItem(R.id.joke_frag);
                        break;
                    case R.id.new_frag:
                        if (gankHuoFragment == null) {
                            gankHuoFragment=new GankHuoFragment();
                        }
                        switchFragment(gankHuoFragment);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mNavigationView.setCheckedItem(R.id.new_frag);
                        break;
                    case R.id.clean_memory:
                        Glide.get(context).clearMemory();
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        mNavigationView.setCheckedItem(R.id.joke_frag);
                        break;
                }
                return true;
            }
        });

    }

    /**
     * 初始化侧边栏头部
     */
    private void initHeadView() {
        mHeardView = mNavigationView.getHeaderView(0);
        mCircleImageView = (CircleImageView) mHeardView.findViewById(R.id.iv_menu_header);
        mLogin = (TextView) mHeardView.findViewById(R.id.tv_menu_header);
        mNavigationView.setCheckedItem(R.id.joke_frag);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
//                mPresent.showdata();
            }
        });
    }

    /**
     * 初始化fragment，进入软件时显示的fragment
     */
    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        gankHuoFragment =new GankHuoFragment();
//        fragment=new JokeFragment();
        fragmentManager.beginTransaction().replace(R.id.fl_activity, gankHuoFragment, JOKE_FRAMGNET_TAG).commit();
//        fragmentManager.beginTransaction().replace(R.id.fl_activity, fragment, JOKE_FRAMGNET_TAG).commit();
        mNavigationView.setCheckedItem(R.id.new_frag);
    }

    /**
     * 切换fragment
     * @param fragment
     */
    public void switchFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.fl_activity,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void showProgress() {
//        progressBar.setVisibility(View.VISIBLE);
//        Toast.makeText(context, "showProgress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hiddenProgress() {
//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresent(ILoginContract.Present present) {
        mPresent = present;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent = null;
    }

    @Override
    public void showLoginDialog() {
        builder = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.dialog_loging, null, false);
        builder.setView(view);
        builder.setCancelable(true);
        alter=builder.create();
        final EditText et_user = (EditText) view.findViewById(R.id.dialog_et_username);
        final EditText et_pass = (EditText) view.findViewById(R.id.dialog_et_password);
        view.findViewById(R.id.dialog_bt_loging).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_user.getText().toString().isEmpty()&&!et_pass.getText().toString().isEmpty()) {
                    mPresent.loging(et_user.getText().toString(),et_pass.getText().toString());
                }
            }
        });
        alter.show();
    }


    @Override
    public void hiddenLoginDialog() {
        alter.dismiss();
    }

    @Override
    public void onClick(View view) {

    }
}
