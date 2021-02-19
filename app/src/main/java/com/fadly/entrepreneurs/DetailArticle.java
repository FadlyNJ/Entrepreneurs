package com.fadly.entrepreneurs;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class DetailArticle extends Fragment {

    private String title;
    private Integer image;

    private TextView tvTitle;
    private ImageView ivThumbnail;

    public DetailArticle() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_article, container, false);

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);

        if (getArguments() != null) {
            title = getArguments().getString("title");
            image = getArguments().getInt("image");

            tvTitle.setText(title);
            ivThumbnail.setImageResource(image);
        }
        return view;
    }
}