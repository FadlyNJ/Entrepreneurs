package com.fadly.entrepreneurs;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewArticle, recyclerViewBlog;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articleArrayList;
    private BlogAdapter blogAdapter;
    private ArrayList<Blog> blogArrayList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Recycler View Article
        addDataArticle();
        recyclerViewArticle = (RecyclerView) view.findViewById(R.id.article_recycler);
        articleAdapter = new ArticleAdapter(articleArrayList);
        RecyclerView.LayoutManager articleLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewArticle.setLayoutManager(articleLayoutManager);
        recyclerViewArticle.setAdapter(articleAdapter);

        //Recycler View Blog
        addDataBlog();
        recyclerViewBlog = (RecyclerView) view.findViewById(R.id.blog_recycler);
        blogAdapter = new BlogAdapter(blogArrayList);
        RecyclerView.LayoutManager blogLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewBlog.setLayoutManager(blogLayoutManager);
        recyclerViewBlog.setAdapter(blogAdapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.line));
        recyclerViewBlog.addItemDecoration(itemDecoration);

        return view;
    }

    void addDataArticle(){
        articleArrayList = new ArrayList<>();
        articleArrayList.add(new Article(R.drawable.thumbnail_eatlah,
                "Eatlah : Bisnis Fast Food dengan Modal Kecil Hingga Sukses Punya 17 Outlet"));
        articleArrayList.add(new Article(R.drawable.thumbnail_ceo,
                "Anak Muda Indonesia Jangan Mau Kalah, 11 Profil CEO Muda Ini Bikin Kamu Iri"));
        articleArrayList.add(new Article(R.drawable.thumbnail_footstep,
                "Strategi Bisnis Model Reseller Ala Randy Oktaviano Founder Footstep Footwear"));
        articleArrayList.add(new Article(R.drawable.thumbnail_kopi,
                "Strategi Mempertahankan Bisnis Kopi Di Indonesia Ditengah Pandemi COVID-19"));

    }

    void addDataBlog(){
        blogArrayList = new ArrayList<>();
        blogArrayList.add(new Blog(R.drawable.thumbnail_blog1,
                "Tips Desain Rumah Menjadi Seperti Kantor",
                "January 14, 2021"));
        blogArrayList.add(new Blog(R.drawable.thumbnail_blog2,
                "Bisakah Workaholic Menjadi Pengusaha Sukses?",
                "December 29, 2020"));
        blogArrayList.add(new Blog(R.drawable.thumbnail_blog3,
                "Pentingnya Mesin Pencari Untuk Bagi Pengusaha?",
                "December 28, 2020"));
        blogArrayList.add(new Blog(R.drawable.thumbnail_blog4,
                "Pentingnya Perawatan Peralatan Bisnis Anda",
                "December 10, 2020"));

    }
}