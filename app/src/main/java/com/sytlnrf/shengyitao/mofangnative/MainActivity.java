package com.sytlnrf.shengyitao.mofangnative;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private static final String TAG = "MAIN_ACTIVITY";
    private static final int ainiDuration = 150;
    private static final int PAGE_NUM = 5;
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
//    private ImageView cursor;// 动画图片
    private TextView t1, t2 , t3, t4, t5;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitTextView();
//        InitImageView();
        InitViewPager();

    }

    private void InitTextView() {
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);
        t4 = (TextView) findViewById(R.id.text4);
        t5 = (TextView) findViewById(R.id.text5);
        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
        t4.setOnClickListener(new MyOnClickListener(3));
        t5.setOnClickListener(new MyOnClickListener(4));
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
        public void onPageSelected(int arg0) {
//            Animation animation = null;
            switch (arg0) {
                case 0:
//                    if (currIndex == 1) {
//                        animation = new TranslateAnimation(one+offset, offset, 0, 0);
//                        } else if (currIndex == 2) {
//                        animation = new TranslateAnimation(two+offset, offset, 0, 0);
//                        }
//                    animation = new TranslateAnimation(one * currIndex + offset, offset, 0, 0);
                    break;
                case 1:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, one, 0, 0);
//                        } else if (currIndex == 2) {
//                        animation = new TranslateAnimation(two, one, 0, 0);
//                        }
//                    animation = new TranslateAnimation(one * currIndex + offset, one + offset, 0, 0 );
                    break;
                case 2:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, two, 0, 0);
//                        } else if (currIndex == 1) {
//                        animation = new TranslateAnimation(one, two, 0, 0);
//                        }
//                    animation = new TranslateAnimation(one * currIndex + offset, two + offset, 0, 0);
                    break;
                case 3:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, two, 0, 0);
//                    } else if (currIndex == 1) {
//                        animation = new TranslateAnimation(one, two, 0, 0);
//                    }
//                    animation = new TranslateAnimation(one * currIndex + offset, three + offset, 0, 0);
                    break;
                case 4:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, two, 0, 0);
//                    } else if (currIndex == 1) {
//                        animation = new TranslateAnimation(one, two, 0, 0);
//                    }
//                    animation = new TranslateAnimation(one * currIndex + offset, four + offset, 0, 0);
                    break;
                }
            currIndex = arg0;
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
