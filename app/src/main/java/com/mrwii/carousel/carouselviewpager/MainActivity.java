package com.mrwii.carousel.carouselviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_LIST_1 = "com.mrwii.carousel.carouselviewpager.mainactivity.list1";
    public static final String ARG_LIST_2 = "com.mrwii.carousel.carouselviewpager.mainactivity.list2";
    public static final String ARG_LIST_3 = "com.mrwii.carousel.carouselviewpager.mainactivity.list3";
    public static final String ARG_HEADER_TEXT = "com.mrwii.carousel.carouselviewpager.mainactivity.headertext";

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

        if (callIntent != null && callIntent.hasExtra(ARG_LIST_1) && callIntent.hasExtra(ARG_LIST_2) && callIntent.hasExtra(ARG_LIST_3)) {
            content1 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_1);
            content2 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_2);
            content3 = (ArrayList<Intent>) callIntent.getSerializableExtra(ARG_LIST_3);

            TextView tv = (TextView) findViewById(R.id.caption);

            if (callIntent.hasExtra(ARG_HEADER_TEXT)) {
                tv.setText(callIntent.getStringExtra(ARG_HEADER_TEXT));
            } else {
                if (callIntent.hasExtra(SlideFragment.ARG_STRING_TEXT)) {
                    tv.setText(callIntent.getStringExtra(SlideFragment.ARG_STRING_TEXT));
                }
            }

        } else {
            ArrayList<Intent> openingTimesDay = new ArrayList<>();
            openingTimesDay.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Mo\nGeschlossen"));
            openingTimesDay.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Di + Mi\n11:00 - 18:00"));
            openingTimesDay.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Do + Fr\n11:00 - 20:00"));
            openingTimesDay.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Sa + So\n11:00 - 18:00"));

            ArrayList<Intent> openingTimesHolidaysClosed = new ArrayList<>();
            openingTimesHolidaysClosed.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Heiligabend\nGeschlossen"));
            openingTimesHolidaysClosed.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "1. Weihnachtsfeiertag\nGeschlossen"));
            openingTimesHolidaysClosed.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Silvester\nGeschlossen"));
            openingTimesHolidaysClosed.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Neujahr\nGeschlossen"));

            ArrayList<Intent> openingTimesHolidays = new ArrayList<>();
            openingTimesHolidays.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Alle anderen Feiertage\n11:00 - 18:00"));

            ArrayList<Intent> priceOstwall = new ArrayList<>();
            priceOstwall.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Museum Ostwall\nSammlungspräsentation\nNeues Spiel, Neues Glück"));
            priceOstwall.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Erwachsener: 5€"));
            priceOstwall.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ermäßigt: 2,50€"));
            priceOstwall.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Die Eintrittskarte berechtigt zum Besuch der Ausstellung über das ganze Jahr."));

            ArrayList<Intent> priceHartware = new ArrayList<>();
            priceHartware.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Hartware Medienkustverein\nGesellschaft zur Wertschätzung des Brutalismus / The Brutalism Appreciation Society"));
            priceHartware.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ausstellung auf der Ebene 3"));
            priceHartware.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Erwachsener: 5€"));
            priceHartware.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ermäßigt: 2,50€"));
            priceHartware.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Gruppeneintritt ab 10 Personen\n4€ pro Person\n2€ ermäßigt"));

            ArrayList<Intent> price3 = new ArrayList<>();
            price3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ermäßigungsberechtigt"));
            price3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "SchülerInnen, Studierende, Auszubildende und Absolvierende des freiwilligen Wehrdienstes"));
            price3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "InhaberInnen einer Jugendleitercard"));
            price3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "InhaberInnen des \"Dortmund-Passes\""));

            content1.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Informationen"));
            content1.add(new Intent(this, MainActivity.class)
                    .putExtra(SlideFragment.ARG_STRING_TEXT, "Öffnungszeiten")
                    .putExtra(ARG_LIST_1, openingTimesDay)
                    .putExtra(ARG_LIST_2, openingTimesHolidaysClosed)
                    .putExtra(ARG_LIST_3, openingTimesHolidays));
            content1.add(new Intent(this, MainActivity.class)
                    .putExtra(SlideFragment.ARG_STRING_TEXT, "Preise")
                    .putExtra(ARG_LIST_1, priceOstwall)
                    .putExtra(ARG_LIST_2, priceHartware)
                    .putExtra(ARG_LIST_3, price3));

            ArrayList<Intent> neuesSpielNeuesGlueckDaten = new ArrayList<>();
            neuesSpielNeuesGlueckDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Informationen"));
            neuesSpielNeuesGlueckDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Führungen"));
            neuesSpielNeuesGlueckDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Über"));

            ArrayList<Intent> neuesSpielNeuesGlueckExhibits = new ArrayList<>();
            neuesSpielNeuesGlueckExhibits.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ausstellungsobjekte"));
            neuesSpielNeuesGlueckExhibits.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.exhibit22));
            neuesSpielNeuesGlueckExhibits.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.exhibit21));

            ArrayList<Intent> neuesSpielNeuesGlueckPersons = new ArrayList<>();
            neuesSpielNeuesGlueckPersons.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Personen"));
            neuesSpielNeuesGlueckPersons.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.person2));
            neuesSpielNeuesGlueckPersons.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.person1));

            ArrayList<Intent> womitRechnestDuDaten = new ArrayList<>();
            womitRechnestDuDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Informationen"));
            womitRechnestDuDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Führungen"));
            womitRechnestDuDaten.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Über"));

            ArrayList<Intent> womitRechnestDuExhibits = new ArrayList<>();
            womitRechnestDuExhibits.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ausstellungsobjekte"));
            womitRechnestDuExhibits.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.exhibit12));
            womitRechnestDuExhibits.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.exhibit11));

            ArrayList<Intent> womitRechnestDuPersons = new ArrayList<>();
            womitRechnestDuPersons.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Personen"));
            womitRechnestDuPersons.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.person2));
            womitRechnestDuPersons.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.person1));

            content2.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Ausstellungen\nVeranstaltungen"));
            content2.add(new Intent(this, MainActivity.class).putExtra(SlideFragment.ARG_STRING_TEXT, "Neues Spiel, Neues Glück")
                    .putExtra(ARG_LIST_1, neuesSpielNeuesGlueckDaten)
                    .putExtra(ARG_LIST_2, neuesSpielNeuesGlueckExhibits)
                    .putExtra(ARG_LIST_3, neuesSpielNeuesGlueckPersons));
            content2.add(new Intent(this, MainActivity.class)
                    .putExtra(SlideFragment.ARG_STRING_TEXT, "Womit rechnest du")
                    .putExtra(ARG_LIST_1, womitRechnestDuDaten)
                    .putExtra(ARG_LIST_2, womitRechnestDuExhibits)
                    .putExtra(ARG_LIST_3, womitRechnestDuPersons));

            ArrayList<Intent> puzzleTop = new ArrayList<>();
            puzzleTop.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle12));
            puzzleTop.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle13));
            puzzleTop.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle11));

            ArrayList<Intent> puzzleMiddle = new ArrayList<>();
            puzzleMiddle.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle22));
            puzzleMiddle.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle23));
            puzzleMiddle.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle21));

            ArrayList<Intent> puzzleBottom = new ArrayList<>();
            puzzleBottom.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle32));
            puzzleBottom.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle33));
            puzzleBottom.add(new Intent().putExtra(SlideFragment.ARG_IMAGE, R.drawable.puzzle31));

            content3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Spiele"));
            content3.add(new Intent().putExtra(SlideFragment.ARG_STRING_TEXT, "Quiz"));
            content3.add(new Intent(this, MainActivity.class).putExtra(SlideFragment.ARG_STRING_TEXT, "Puzzle")
                    .putExtra(ARG_LIST_1, puzzleTop)
                    .putExtra(ARG_LIST_2, puzzleMiddle)
                    .putExtra(ARG_LIST_3, puzzleBottom));
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
