package com.fadly.entrepreneurs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailForum extends Fragment {

    private Integer image;
    private String release, content, title, author;

    private ImageView ivThumbnail;
    private TextView tvRelease, tvContent, tvAuthor, tvTitle;

    public DetailForum() {
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

        View view = inflater.inflate(R.layout.fragment_detail_forum, container, false);

        tvAuthor = (TextView) view.findViewById(R.id.tv_author);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        tvRelease = (TextView) view.findViewById(R.id.tv_release);
        ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);

        if (getArguments() != null) {
            author = getArguments().getString("author");
            title = getArguments().getString("title");
            release = getArguments().getString("release");
            content = getArguments().getString("content");
            image = getArguments().getInt("image");

            tvRelease.setText(release);
            tvAuthor.setText(author);
            tvTitle.setText(title);
            tvContent.setText(content);
            ivThumbnail.setImageResource(image);
        }

        return view;

    }
}