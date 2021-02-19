package com.fadly.entrepreneurs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBlog extends Fragment {

    private Integer image;
    private String date, title;

    private ImageView ivThumbnail;
    private TextView tvTitle, tvDate;

    public DetailBlog() {
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
        View view = inflater.inflate(R.layout.fragment_detail_blog, container, false);

        tvDate = (TextView) view.findViewById(R.id.tv_date);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);

        if (getArguments() != null) {
            date = getArguments().getString("date");
            title = getArguments().getString("title");
            image = getArguments().getInt("image");

            tvDate.setText(date);
            tvTitle.setText(title);
            ivThumbnail.setImageResource(image);
        }
        return  view;
    }
}