package com.fadly.entrepreneurs;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DetailCourse extends Fragment {

    private String lesson, title, price;
    private Integer image;

    private TextView tvPrice, tvTitle, tvLesson;
    private ImageView ivThumbnail;

    public DetailCourse() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_course, container, false);

        tvLesson = (TextView) view.findViewById(R.id.tvLesson);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);

        if (getArguments() != null) {
            lesson = getArguments().getString("lesson");
            title = getArguments().getString("title");
            price = getArguments().getString("price");
            image = getArguments().getInt("image");

            tvPrice.setText(price);
            tvTitle.setText(title);
            tvLesson.setText(lesson);
            ivThumbnail.setImageResource(image);
        }
        return view;

    }
}