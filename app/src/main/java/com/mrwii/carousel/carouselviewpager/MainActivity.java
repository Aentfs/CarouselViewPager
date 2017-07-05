package com.mrwii.carousel.carouselviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_LIST_1 = "list1";
    public static final String ARG_LIST_2 = "list1";
    public static final String ARG_LIST_3 = "list1";

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

        LinkedHashMap<String, Intent> content1 = new LinkedHashMap<>();
        LinkedHashMap<String, Intent> content2 = new LinkedHashMap<>();
        LinkedHashMap<String, Intent> content3 = new LinkedHashMap<>();

        if(callIntent != null && callIntent.hasExtra(ARG_LIST_1) && callIntent.hasExtra(ARG_LIST_2) && callIntent.hasExtra(ARG_LIST_3)) {
            content1 = ((MapWrapper<LinkedHashMap<String, Intent>>) callIntent.getSerializableExtra(ARG_LIST_1)).getMap();
            content2 = ((MapWrapper<LinkedHashMap<String, Intent>>) callIntent.getSerializableExtra(ARG_LIST_2)).getMap();
            content3 = ((MapWrapper<LinkedHashMap<String, Intent>>) callIntent.getSerializableExtra(ARG_LIST_3)).getMap();
        }else{
            LinkedHashMap<String, Intent> test = new LinkedHashMap<>();
            test.put("TEst 1", null);
            test.put("TEst 2", null);
            test.put("TEst 3", null);

            MapWrapper<LinkedHashMap<String, Intent>> testWrapper = new MapWrapper<>(test);

            content1.put("Öffnungszeiten", new Intent(this, MainActivity.class)
                    .putExtra(ARG_LIST_1, testWrapper)
                    .putExtra(ARG_LIST_2, testWrapper)
                    .putExtra(ARG_LIST_3, testWrapper));
            content1.put("Anfahrt", null);
            content1.put("Geschichte", null);

            content2.put("Foto Gallerie", null);
            content2.put("Terasse", null);
            content2.put("Moop", null);

            content3.put("Puzzle", null);
            content3.put("Quiz", null);
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
