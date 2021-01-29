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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewArticle, recyclerViewBlog, recyclerViewCourse;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articleArrayList;
    private BlogAdapter blogAdapter;
    private ArrayList<Blog> blogArrayList;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> courseArrayList;
    private TextInputLayout tilSort;
    private AutoCompleteTextView sortCourse;
    private ArrayAdapter<String> sortAdapter;
    private ArrayList<String> sortArrayList;

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
}