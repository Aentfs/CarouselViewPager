package com.mrwii.carousel.carouselviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_LIST_1 = "com.mrwii.carousel.carouselviewpager.mainactivity.list1";
    public static final String ARG_LIST_2 = "com.mrwii.carousel.carouselviewpager.mainactivity.list2";
    public static final String ARG_LIST_3 = "com.mrwii.carousel.carouselviewpager.mainactivity.list3";

    private SlideAdapter adapter1;
    private SlideAdapter adapter2;
    private SlideAdapter adapter3;
    private ViewPager viewPager1;
    private ViewPager viewPager2;
    private ViewPager viewPager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent callIntent = getIntent();

        ArrayList<Intent> content1 = new ArrayList<>();
        ArrayList<Intent> content2 = new ArrayList<>();
        ArrayList<Intent> content3 = new ArrayList<>();

        if(callIntent != null && callIntent.hasExtra(ARG_LIST_1) && callIntent.hasExtra(ARG_LIST_2) && callIntent.hasExtra(ARG_LIST_3)) {
            content1 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_1);
            content2 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_2);
            content3 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_3);
        }else{
            ArrayList<Intent> test = new ArrayList<>();
            test.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Test 1"));
            test.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Test 2"));
            test.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Test 3"));

            content1.add(new Intent(this, MainActivity.class)
                    .putExtra(SlideFragment.ARG_STRING_TEXT, "Öffnungszeiten")
                    .putExtra(ARG_LIST_1, test)
                    .putExtra(ARG_LIST_2, test)
                    .putExtra(ARG_LIST_3, test));
            content1.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Anfahrt"));
            content1.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Geschichte"));

            content2.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Foto Gallerie"));
            content2.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Terasse"));
            content2.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Moop"));

            content3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Puzzle"));
            content3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT,  "Quiz"));
        }

        viewPager1 = (ViewPager) findViewById(R.id.vp_slider1);
        viewPager1.setClipToPadding(false);
        viewPager1.setPageMargin(10);
        adapter1 = new SlideAdapter(this.getSupportFragmentManager(), content1);
        viewPager1.setAdapter(adapter1);
        viewPager1.setCurrentItem(adapter1.FIRST_PAGE);

        viewPager2 = (ViewPager) findViewById(R.id.vp_slider2);
        viewPager2.setClipToPadding(false);
        viewPager2.setPageMargin(10);
        adapter2 = new SlideAdapter(this.getSupportFragmentManager(), content2);
        viewPager2.setAdapter(adapter2);
        viewPager2.setCurrentItem(adapter2.FIRST_PAGE);

        viewPager3 = (ViewPager) findViewById(R.id.vp_slider3);
        viewPager3.setClipToPadding(false);
        viewPager3.setPageMargin(10);
        adapter3 = new SlideAdapter(this.getSupportFragmentManager(), content3);
        viewPager3.setAdapter(adapter3);
        viewPager3.setCurrentItem(adapter3.FIRST_PAGE);
    }
}
