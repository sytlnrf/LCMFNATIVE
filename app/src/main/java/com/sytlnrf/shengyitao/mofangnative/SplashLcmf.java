package com.sytlnrf.shengyitao.mofangnative;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SplashLcmf extends Activity {

    private static final String TAG = "LCMF_SPLASH";
    private ViewPager viewPager;
    private ArrayList<View> pageview;


    private ImageView imageView;
    private ImageView[] imageViews;
    //包裹点点的LinearLayout
    private ViewGroup group;
    private TextView enterMain;
    private SharedPreferences MysharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_lcmf);

        MysharedPreferences = getSharedPreferences("start_count",MODE_PRIVATE);
        int start_count = MysharedPreferences.getInt("start_count",0);
        SharedPreferences.Editor myEditor = MysharedPreferences.edit();
        myEditor.putInt("start_count", ++start_count);
        myEditor.commit();
        Log.d(TAG, String.valueOf(start_count));
        if (start_count > 1){
            EnterMain();
        }
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        group = (ViewGroup)findViewById(R.id.viewGroup);
        enterMain = (TextView)findViewById(R.id.enterMain);
        enterMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnterMain();
            }
        });
        //查找布局文件用LayoutInflater.inflate
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.splash_1, null);
        View view2 = inflater.inflate(R.layout.splash_2, null);
        View view3 = inflater.inflate(R.layout.splash_3, null);

        pageview =new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);

        //有多少张图就有多少个点点
        imageViews = new ImageView[pageview.size()];
        for(int i =0;i<pageview.size();i++){
            imageView = new ImageView(SplashLcmf.this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));
            imageView.setPadding(20, 0, 20, 0);
            imageViews[i] = imageView;

            //默认第一张图显示为选中状态
            if (i == 0) {
                Log.d(TAG, "main line 58");
                imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
                Log.d(TAG, "main line 60");
            } else {
                imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
                Log.d(TAG,"main line 61");
            }

            Log.d(TAG, "main line 66");

            try{
                this.group.addView(imageViews[i]);
            }catch (Exception e){
                Log.d(TAG,e.toString());
            }

            Log.d(TAG, "main line 68");
        }



        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
        //绑定监听事件
        viewPager.addOnPageChangeListener(new GuidePageChangeListener());

    }


    //进入主页面
    private void EnterMain(){
        Intent mainIntent = new Intent(SplashLcmf.this, MainActivity.class);
        SplashLcmf.this.startActivity(mainIntent);
        SplashLcmf.this.finish();
    }
    //数据适配器
    PagerAdapter mPagerAdapter = new PagerAdapter(){

        @Override
        //获取当前窗体界面数
        public int getCount() {
            // TODO Auto-generated method stub
            return pageview.size();
        }

        @Override
        //断是否由对象生成界面
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }
        //是从ViewGroup中移出当前View
        public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
            arg0.removeView(pageview.get(arg1));
        }

        //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
        public Object instantiateItem(ViewGroup arg0, int arg1){
            arg0.addView(pageview.get(arg1));
            return pageview.get(arg1);
        }


    };

    //pageView监听器
    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        //如果切换了，就把当前的点点设置为选中背景，其他设置未选中背景
        public void onPageSelected(int arg0) {
            // TODO Auto-generated method stub
            for(int i=0;i<imageViews.length;i++){
                imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
                if (arg0 != i) {
                    imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
                }
            }

        }

    }





}
