package com.mrwii.carousel.carouselviewpager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class SlideFragment extends Fragment {
    public static final String ARG_STRING_TEXT = "com.mrwii.carousel.carouselviewpager.slidefragment.stringText";
    public static final String ARG_INTENT = "com.mrwii.carousel.carouselviewpager.slidefragment.intentClickAction";
    public static final String ARG_IMAGE = "com.mrwii.carousel.carouselviewpager.slidefragment.isImage";

    private Intent mIntent;

    public SlideFragment() {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(Intent intent) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_INTENT, intent);

        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIntent = getArguments().getParcelable(ARG_INTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout root = (FrameLayout) inflater.inflate(R.layout.fragment_slide, container, false);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getActivity().getPackageManager();
                if (mIntent.resolveActivity(packageManager) != null) {
                    getContext().startActivity(mIntent);
                }
            }
        });

        TextView tvPos = (TextView) root.findViewById(R.id.text);
        ImageView ivPos = (ImageView) root.findViewById(R.id.image);

        tvPos.setVisibility(View.GONE);
        ivPos.setVisibility(View.GONE);

        if (mIntent.hasExtra(ARG_STRING_TEXT)) {
            tvPos.setText(mIntent.getStringExtra(ARG_STRING_TEXT));
            tvPos.setVisibility(View.VISIBLE);
        }

        if (mIntent.hasExtra(ARG_IMAGE)) {
            ivPos.setImageResource(mIntent.getIntExtra(ARG_IMAGE, R.mipmap.ic_launcher));
            ivPos.setVisibility(View.VISIBLE);
        }

        return root;
    }

}
