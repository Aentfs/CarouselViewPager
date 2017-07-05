package com.mrwii.carousel.carouselviewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArrayMap;
import android.view.View;

import java.util.ArrayList;
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

    private ArrayList<Intent> mContent;

    public SlideAdapter(FragmentManager fm, ArrayList<Intent> content) {
        super(fm);
        mContent = new ArrayList<>(content);

        PAGES = mContent.size();
        FIRST_PAGE = PAGES * LOOPS / 2;
        FIRST_PAGE = FIRST_PAGE - (FIRST_PAGE % PAGES);
    }

    @Override
    public Fragment getItem(int position) {
        position = position % PAGES;
        return SlideFragment.newInstance(mContent.get(position));
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
