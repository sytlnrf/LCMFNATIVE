package com.sytlnrf.shengyitao.mofangnative;

import android.app.Activity;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private static final String TAG = "MAIN_ACTIVITY";
    private static final int ainiDuration = 150;
    private static final int PAGE_NUM = 5;
    private static final int TEXT_COLOR_BLUE = Color.parseColor("#3A5FCD");
    private static final int TEXT_COLOR_BLACK = Color.parseColor("#000000");
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
//    private ImageView cursor;// 动画图片
    private TextView t1, t2 , t3, t4, t5;//底部文字
    private ImageView image1, image2, image3, image4, image5;//底部图片
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitTextView();
        InitImageView();
//        InitImageView();2
        InitViewPager();

    }

    private void InitTextView() {
        t1 = (TextView) findViewById(R.id.profit_tab_text);
        t2 = (TextView) findViewById(R.id.rank_tab_text);
        t3 = (TextView) findViewById(R.id.vote_tab_text);
        t4 = (TextView) findViewById(R.id.collect_tab_text);
        t5 = (TextView) findViewById(R.id.me_tab_text);
        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
        t4.setOnClickListener(new MyOnClickListener(3));
        t5.setOnClickListener(new MyOnClickListener(4));
    }
    private void InitImageView(){
        image1 = (ImageView) findViewById(R.id.profit_tab_image);
        image2 = (ImageView) findViewById(R.id.rank_tab_image);
        image3 = (ImageView) findViewById(R.id.vote_tab_image);
        image4 = (ImageView) findViewById(R.id.collect_tab_image);
        image5 = (ImageView) findViewById(R.id.me_tab_image);

        image1.setOnClickListener(new MyOnClickListener(0));
        image2.setOnClickListener(new MyOnClickListener(1));
        image3.setOnClickListener(new MyOnClickListener(2));
        image4.setOnClickListener(new MyOnClickListener(3));
        image5.setOnClickListener(new MyOnClickListener(4));
    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;
        public MyOnClickListener(int i) {
            index = i;
        }
        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);


        }
    }
    public void ChangeTabProfileUnselected(int clickIndex){
        switch (clickIndex){
            case 0:
                t1.setTextColor(TEXT_COLOR_BLACK);
                image1.setImageResource(R.mipmap.profit);
                break;
            case 1:
                t2.setTextColor(TEXT_COLOR_BLACK);
                image2.setImageResource(R.mipmap.rank);
                break;
            case 2:
                t3.setTextColor(TEXT_COLOR_BLACK);
                image3.setImageResource(R.mipmap.vote_up);
                break;
            case 3:
                t4.setTextColor(TEXT_COLOR_BLACK);
                image4.setImageResource(R.mipmap.collect);
                break;
            case 4:
                t5.setTextColor(TEXT_COLOR_BLACK);
                image5.setImageResource(R.mipmap.me);
                break;
            default:
                break;

        }

    }

    public void ChangeTabProfileSelected(int clickIndex){
        switch (clickIndex){
            case 0:
                t1.setTextColor(TEXT_COLOR_BLUE);
                image1.setImageResource(R.mipmap.profit_ac);
                break;
            case 1:
                t2.setTextColor(TEXT_COLOR_BLUE);
                image2.setImageResource(R.mipmap.rank_ac);
                break;
            case 2:
                t3.setTextColor(TEXT_COLOR_BLUE);
                image3.setImageResource(R.mipmap.vote_up_ac);
                break;
            case 3:
                t4.setTextColor(TEXT_COLOR_BLUE);
                image4.setImageResource(R.mipmap.collect_ac);
                break;
            case 4:
                t5.setTextColor(TEXT_COLOR_BLUE);
                image5.setImageResource(R.mipmap.me_ac);
                break;
            default:
                break;

        }

    }

    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.vPager);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        listViews.add(mInflater.inflate(R.layout.tab_page_profit, null));
        listViews.add(mInflater.inflate(R.layout.tab_page_rank, null));
        listViews.add(mInflater.inflate(R.layout.tab_page_worth, null));
        listViews.add(mInflater.inflate(R.layout.tab_page_interest,null));
        listViews.add(mInflater.inflate(R.layout.tab_page_me,null));
        mPager.setAdapter(new MyPagerAdapter(listViews));
        mPager.setCurrentItem(0);
        mPager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    public class MyPagerAdapter extends PagerAdapter {
        public List<View> mListViews;
        public MyPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(mListViews.get(arg1));
        }
        @Override
        public void finishUpdate(View arg0) {
        }
        @Override
        public int getCount() {
            return mListViews.size();
        }
        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
            return mListViews.get(arg1);
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }
        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }
        @Override
        public Parcelable saveState() {
            return null;
        }
        @Override
        public void startUpdate(View arg0) {
        }
    }

//    private void InitImageView() {
//        cursor = (ImageView) findViewById(R.id.cursor);
////        cursor.setBackgroundColor(android.graphics.Color.parseColor("#000000"));
//        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.a)
//        .getWidth();// 获取图片宽度
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenW = dm.widthPixels;// 获取分辨率宽度
//        offset = (screenW / PAGE_NUM - bmpW) / 2;// 计算偏移量
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(offset, 0);
//        cursor.setImageMatrix(matrix);// 设置动画初始位置
//    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 -> 页卡3 偏移量
        int three = one * 3;
        int four = one * 4;
        @Override
        public void onPageSelected(int selectedPage) {
//            Animation animation = null;
            if (selectedPage != currIndex) {
                ChangeTabProfileSelected(selectedPage);
                ChangeTabProfileUnselected(currIndex);
            }
            currIndex = selectedPage;
//            animation.setFillAfter(true);// True:图片停在动画结束位置
//            animation.setDuration(ainiDuration);
//            cursor.startAnimation(animation);
            }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
        @Override
        public void onPageScrollStateChanged(int arg0) {
            }
        }


}
