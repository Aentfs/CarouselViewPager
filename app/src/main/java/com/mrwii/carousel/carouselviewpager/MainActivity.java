package com.mrwii.carousel.carouselviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SlideAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.vp_slider);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(10);
        adapter = new SlideAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(adapter.FIRST_PAGE);
    }
}
