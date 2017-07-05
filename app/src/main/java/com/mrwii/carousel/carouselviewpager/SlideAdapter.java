package com.mrwii.carousel.carouselviewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArrayMap;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Droid on 2/29/2016.
 */
public class SlideAdapter extends FragmentPagerAdapter {
    private int PAGES = 3;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    private int LOOPS = 1000;
    public int FIRST_PAGE = PAGES * LOOPS / 2;

    private LinkedHashMap<String, Intent> mContent;

    public SlideAdapter(FragmentManager fm, LinkedHashMap<String, Intent> content) {
        super(fm);
        mContent = new LinkedHashMap<>(content);
        PAGES = mContent.size();
    }

    @Override
    public Fragment getItem(int position) {
        position = position % PAGES;
        String key = mContent.keySet().toArray(new String[mContent.size()])[position];
        return SlideFragment.newInstance(key, mContent.get(key));
    }

    @Override
    public int getCount() {
        return PAGES * LOOPS;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.7f;
    }

}
