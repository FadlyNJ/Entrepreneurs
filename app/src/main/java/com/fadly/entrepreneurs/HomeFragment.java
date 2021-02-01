package com.fadly.entrepreneurs;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewArticle, recyclerViewBlog, recyclerViewCourse, recyclerViewForum;
    private ForumAdapter forumAdapter;
    private ArrayList<Forum> forumArrayList;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articleArrayList;
    private BlogAdapter blogAdapter;
    private ArrayList<Blog> blogArrayList;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> courseArrayList;
    private ArrayAdapter<String> sortAdapter;
    private ArrayList<String> sortArrayList;
    private TextInputLayout tilSort;
    private AutoCompleteTextView sortCourse;
    private MaterialButton btnGrid, btnList, btnForum, btnBlog;
    private TextView tvBlog;
    private ImageView ivLogo;
    private CardView cardStart, cardBlog;

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

        //Exposed Dropdown
        addSortList();
        tilSort = (TextInputLayout) view.findViewById(R.id.sort_course);
        sortCourse = (AutoCompleteTextView) view.findViewById(R.id.sort_list) ;
        sortCourse.setText("Alphabetical", false);
        sortAdapter = new ArrayAdapter<>(getActivity(),R.layout.sort_list,sortArrayList);
        sortCourse.setAdapter(sortAdapter);

        //Recycler View Course
        addDataCourse();
        recyclerViewCourse = (RecyclerView) view.findViewById(R.id.course_recycler);
        courseAdapter = new CourseAdapter(courseArrayList);
        RecyclerView.LayoutManager courseLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCourse.setLayoutManager(courseLayoutManager);
        recyclerViewCourse.setAdapter(courseAdapter);

        //Recycler View Forum
        addDataForum();
        recyclerViewForum = (RecyclerView) view.findViewById(R.id.forum_recycler);
        forumAdapter = new ForumAdapter(forumArrayList);
        RecyclerView.LayoutManager forumLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewForum.setLayoutManager(forumLayoutManager);
        recyclerViewForum.setAdapter(forumAdapter);
        recyclerViewForum.addItemDecoration(itemDecoration);

        btnGrid = (MaterialButton) view.findViewById(R.id.btn_grid);
        btnGrid.setChecked(true);

        btnForum = (MaterialButton) view.findViewById(R.id.btn_forum);
        btnForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new ForumFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();
            }
        });

        cardStart = (CardView) view.findViewById(R.id.card_start);
        cardStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new StartFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();
            }
        });

        cardBlog = (CardView) view.findViewById(R.id.card_blog);
        cardBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new AcademyFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();
            }
        });

        btnBlog = (MaterialButton) view.findViewById(R.id.btn_blog);
        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new AcademyFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();
            }
        });

        tvBlog = (TextView) view.findViewById(R.id.tv_blog);
        tvBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new AcademyFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();
            }
        });

        ivLogo = (ImageView) view.findViewById(R.id.iv_logo);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new HomeFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).commit();

            }
        });

        return view;

    }

    void addSortList(){
        sortArrayList = new ArrayList<>();
        sortArrayList.add(new String("Alphabetical"));
        sortArrayList.add(new String("Newly Created"));

    }

    void addDataArticle(){
        articleArrayList = new ArrayList<>();
        articleArrayList.add(new Article(R.drawable.thumbnail_artikel1,
                "Eatlah : Bisnis Fast Food dengan Modal Kecil Hingga Sukses Punya 17 Outlet"));
        articleArrayList.add(new Article(R.drawable.thumbnail_artikel2,
                "Anak Muda Indonesia Jangan Mau Kalah, 11 Profil CEO Muda Ini Bikin Kamu Iri"));
        articleArrayList.add(new Article(R.drawable.thumbnail_artikel3,
                "Strategi Bisnis Model Reseller Ala Randy Oktaviano Founder Footstep Footwear"));
        articleArrayList.add(new Article(R.drawable.thumbnail_artikel4,
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

    void addDataCourse(){
        courseArrayList = new ArrayList<>();
        courseArrayList.add(new Course(R.drawable.poster_course1,
                "BEAUTYPRENEUR: Branding 101: How To Nail The “Beauty Industry”",
                "1 Lesson",
                "Rp45.000"));
        courseArrayList.add(new Course(R.drawable.poster_course2,
                "CLOTHINGPRENEUR: How to Increase Revenue for Your Clothing Business",
                "2 Lessons",
                "Rp45.000"));
        courseArrayList.add(new Course(R.drawable.poster_course3,
                "FOODPRENEUR: 3 Rahasia FUDGYBRO Menjual 4000 Box Dessert Dalam Waktu 1 Bulan",
                "1 Lesson",
                "Rp45.000"));
        courseArrayList.add(new Course(R.drawable.poster_course4,
                "FOODPRENEUR: 3 Rahasia Membuka 200 Cabang Dalam Waktu 5 Bulan Hanya Dengan Modal 5 Juta",
                "1 Lesson",
                "Rp45.000"));

    }

    void addDataForum(){
        forumArrayList = new ArrayList<>();
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "Bagaimana Belajar Mengatakan ‘Tidak’ Dapat Meningkatkan Bisnis Anda",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Kata “tidak” adalah kata unik yang meskipun memiliki konotasi negatif, namun memiliki…"));
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "5 Ide Memulai Bisnis di Perguruan Tinggi",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Mendapatkan bisnis Anda sendiri adalah usaha yang sangat bertanggung jawab namun membebas…"));
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "5 Faktor Yang Memungkinkan Kepercayaan Dalam Kondisi Apa Pun",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Kepercayaan memiliki pintu depan dan pintu belakang, itulah sebabnya banyak orang menghab…"));
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "10 Skill Negosiasi Yang Harus Dimiliki Setiap Pengusaha",
                "1 member · 1 reply",
                "Edrus replied 2 months, 1 week ago",
                "Kita semua ingin mendapatkan sebanyak yang kita bisa dalam setiap kesepakatan atau transa…"));
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "Sumber Daya Terbaik Di Mana Anda Dapat Menemukan Ide Bisnis",
                "1 member · 1 reply",
                "Edrus replied 2 months, 1 week ago",
                "Peluang dan ide bisnis adalah titik awal untuk setiap bisnis. Mereka penting karena energ…"));
        forumArrayList.add(new Forum(R.drawable.avatar1,
                "Entrepreneur Success: Tricks For New Players",
                "1 member · 1 reply",
                "Edrus replied 2 month, 3 weeks ago",
                "Ask any entrepreneur and they’ll tell you starting a business is never an easy task. It…"));

    }
}