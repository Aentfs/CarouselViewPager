package com.mrwii.carousel.carouselviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
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

        viewPager1 = (ViewPager) findViewById(R.id.vp_slider1);
        viewPager1.setClipToPadding(false);
        viewPager1.setPageMargin(10);
        adapter1 = new SlideAdapter(this.getSupportFragmentManager());
        viewPager1.setAdapter(adapter1);
        viewPager1.setCurrentItem(adapter1.FIRST_PAGE);

        viewPager2 = (ViewPager) findViewById(R.id.vp_slider2);
        viewPager2.setClipToPadding(false);
        viewPager2.setPageMargin(10);
        adapter2 = new SlideAdapter(this.getSupportFragmentManager());
        viewPager2.setAdapter(adapter2);
        viewPager2.setCurrentItem(adapter2.FIRST_PAGE);

        viewPager3 = (ViewPager) findViewById(R.id.vp_slider3);
        viewPager3.setClipToPadding(false);
        viewPager3.setPageMargin(10);
        adapter3 = new SlideAdapter(this.getSupportFragmentManager());
        viewPager3.setAdapter(adapter3);
        viewPager3.setCurrentItem(adapter3.FIRST_PAGE);
    }
}
