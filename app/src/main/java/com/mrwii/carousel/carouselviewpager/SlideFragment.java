package com.mrwii.carousel.carouselviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


public class SlideFragment extends Fragment {
    private static final String ARG_STRING_TEXT = "stringText";
    private static final String ARG_INTENT_ACTION = "intentClickAction";

    private String mText;
    private Intent mAction;
    private TextView tvPos;

    public SlideFragment() {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(String text, Intent clickAction) {
        Bundle args = new Bundle();
        args.putString(ARG_STRING_TEXT, text);
        args.putParcelable(ARG_INTENT_ACTION, clickAction);

        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(ARG_STRING_TEXT);
            mAction = getArguments().getParcelable(ARG_INTENT_ACTION);
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
                if(mAction != null) {
                    getContext().startActivity(mAction);
                }
            }
        });

        tvPos = (TextView) root.findViewById(R.id.text);
        tvPos.setText(mText);
        return root;
    }

}
