package com.fadly.entrepreneurs;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class DetailArticle extends Fragment {

    private TextView tvNyoba;
    private MaterialButton btnChange;

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

        tvNyoba = (TextView) view.findViewById(R.id.tv_nyoba);
        btnChange = (MaterialButton) view.findViewById(R.id.btn_change);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvNyoba.getVisibility() == View.GONE) {
                    tvNyoba.setVisibility(View.VISIBLE);
                    btnChange.setText("Make Text Invisible");
                } else {
                    tvNyoba.setVisibility(View.GONE);
                    btnChange.setText("Make Text Visible");
                }
            }
        });

        return view;
    }
}