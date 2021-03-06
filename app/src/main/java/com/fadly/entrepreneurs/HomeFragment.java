package com.fadly.entrepreneurs;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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

public class HomeFragment extends Fragment
        implements ArticlesRecyclerAdapter.OnArticleListener,
        BlogsRecyclerAdapter.OnBlogListener,
        CoursesRecyclerAdapter.OnCourseListener,
        ForumsRecyclerAdapter.OnForumListener {

    private static final String TAG = "HomeFragment";
    //Forum
    private RecyclerView mRecyclerViewForum;
    private ForumsRecyclerAdapter mForumRecyclerAdapter;
    private ArrayList<Forum> mForums;

    //Article
    private RecyclerView mRecyclerViewArticle;
    private ArticlesRecyclerAdapter mArticleRecyclerAdapter;
    private ArrayList<Article> mArticles;

    //Blog
    private RecyclerView mRecyclerViewBlog;
    private BlogsRecyclerAdapter mBlogRecyclerAdapter;
    private ArrayList<Blog> mBlogs;

    //Course
    private RecyclerView mRecyclerViewCourse;
    private CoursesRecyclerAdapter mCourseRecyclerAdapter;
    private ArrayList<Course> mCourses;

    //Exposed Dropdown
    private ArrayAdapter<String> mSortRecyclerAdapter;
    private ArrayList<String> mSort;
    private TextInputLayout tilSort;
    private AutoCompleteTextView sortCourse;

    //Variables
    private MaterialButton btnForum, btnBlog;
    private TextView tvBlog, tvDate, tvIsi;
    private ImageView ivLogo, ivStart, ivBlog, ivEmail, ivYoutube, ivInstagram;
    private CardView cardStart, cardBlog;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            //Restore the fragment's state here
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
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
        mRecyclerViewArticle = (RecyclerView) view.findViewById(R.id.article_recycler);
        mArticleRecyclerAdapter = new ArticlesRecyclerAdapter(mArticles, this);
        RecyclerView.LayoutManager articleLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewArticle.setLayoutManager(articleLayoutManager);
        mRecyclerViewArticle.setAdapter(mArticleRecyclerAdapter);

        //Recycler View Blog
        addDataBlog();
        mRecyclerViewBlog = (RecyclerView) view.findViewById(R.id.blog_recycler);
        mBlogRecyclerAdapter = new BlogsRecyclerAdapter(mBlogs, this);
        RecyclerView.LayoutManager blogLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewBlog.setLayoutManager(blogLayoutManager);
        mRecyclerViewBlog.setAdapter(mBlogRecyclerAdapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.line));
        mRecyclerViewBlog.addItemDecoration(itemDecoration);

        //Exposed Dropdown
        addSortList();
        tilSort = (TextInputLayout) view.findViewById(R.id.sort_course);
        sortCourse = (AutoCompleteTextView) view.findViewById(R.id.sort_list);
        sortCourse.setText("Alphabetical", false);
        mSortRecyclerAdapter = new ArrayAdapter<>(getActivity(), R.layout.sort_list, mSort);
        sortCourse.setAdapter(mSortRecyclerAdapter);

        //Recycler View Course
        addDataCourse();
        mRecyclerViewCourse = (RecyclerView) view.findViewById(R.id.course_recycler);
        mCourseRecyclerAdapter = new CoursesRecyclerAdapter(mCourses, this);
        RecyclerView.LayoutManager courseLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewCourse.setLayoutManager(courseLayoutManager);
        mRecyclerViewCourse.setAdapter(mCourseRecyclerAdapter);

        //Recycler View Forum
        addDataForum();
        mRecyclerViewForum = (RecyclerView) view.findViewById(R.id.forum_recycler);
        mForumRecyclerAdapter = new ForumsRecyclerAdapter(mForums, this);
        RecyclerView.LayoutManager forumLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewForum.setLayoutManager(forumLayoutManager);
        mRecyclerViewForum.setAdapter(mForumRecyclerAdapter);
        mRecyclerViewForum.addItemDecoration(itemDecoration);

        btnForum = (MaterialButton) view.findViewById(R.id.btn_forum);
        btnForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new ForumFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
                View inflatedView = getLayoutInflater().inflate(R.layout.activity_main, null);
            }
        });

        cardStart = (CardView) view.findViewById(R.id.card_start);
        cardStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new StartFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
                View inflatedView = getLayoutInflater().inflate(R.layout.activity_main, null);
            }
        });

        cardBlog = (CardView) view.findViewById(R.id.card_blog);
        cardBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new DetailBlog();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
            }
        });

        btnBlog = (MaterialButton) view.findViewById(R.id.btn_blog);
        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new DetailBlog();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
            }
        });

        tvBlog = (TextView) view.findViewById(R.id.tv_blog);
        tvBlog.setText(R.string.artikel_bisnis);
        tvBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = new DetailBlog();
                getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
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

        String address = "info@entrepreneurs.id";
        ivEmail = (ImageView) view.findViewById(R.id.iv_email);
        ivEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactEmail(address);

            }
        });

        ivInstagram = (ImageView) view.findViewById(R.id.iv_instagram);
        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followInstagram();
            }
        });

        ivYoutube = (ImageView) view.findViewById(R.id.iv_youtube);
        ivYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribeYoutube();
            }
        });

        ivStart = (ImageView) view.findViewById(R.id.iv_start);
        ivStart.setImageResource(R.drawable.thumbnail_start);

        tvDate = (TextView) view.findViewById(R.id.tv_date);
        tvDate.setText("January 19, 2021  •  Success");

        tvIsi = (TextView) view.findViewById(R.id.tv_isi);
        tvIsi.setText(R.string.isi_artikel_bisnis);

        ivBlog = (ImageView) view.findViewById(R.id.iv_blog);
        ivBlog.setImageResource(R.drawable.thumbnail_blog);

        return view;

    }

    void addSortList() {
        mSort = new ArrayList<>();
        mSort.add(new String("Alphabetical"));
        mSort.add(new String("Newly Created"));

    }

    void addDataArticle() {
        mArticles = new ArrayList<>();
        mArticles.add(new Article(R.drawable.thumbnail_artikel1,
                "Eatlah : Bisnis Fast Food dengan Modal Kecil Hingga Sukses Punya 17 Outlet"));
        mArticles.add(new Article(R.drawable.thumbnail_artikel2,
                "Anak Muda Indonesia Jangan Mau Kalah, 11 Profil CEO Muda Ini Bikin Kamu Iri"));
        mArticles.add(new Article(R.drawable.thumbnail_artikel3,
                "Strategi Bisnis Model Reseller Ala Randy Oktaviano Founder Footstep Footwear"));
        mArticles.add(new Article(R.drawable.thumbnail_artikel4,
                "Strategi Mempertahankan Bisnis Kopi Di Indonesia Ditengah Pandemi COVID-19"));

    }

    void addDataBlog() {
        mBlogs = new ArrayList<>();
        mBlogs.add(new Blog(R.drawable.thumbnail_blog1,
                "Tips Desain Rumah Menjadi Seperti Kantor",
                "January 14, 2021"));
        mBlogs.add(new Blog(R.drawable.thumbnail_blog2,
                "Bisakah Workaholic Menjadi Pengusaha Sukses?",
                "December 29, 2020"));
        mBlogs.add(new Blog(R.drawable.thumbnail_blog3,
                "Pentingnya Mesin Pencari Untuk Bagi Pengusaha?",
                "December 28, 2020"));
        mBlogs.add(new Blog(R.drawable.thumbnail_blog4,
                "Pentingnya Perawatan Peralatan Bisnis Anda",
                "December 10, 2020"));

    }

    void addDataCourse() {
        mCourses = new ArrayList<>();
        mCourses.add(new Course(R.drawable.poster_course1,
                "BEAUTYPRENEUR: Branding 101: How To Nail The “Beauty Industry”",
                "1 Lesson",
                "Rp45.000"));
        mCourses.add(new Course(R.drawable.poster_course2,
                "CLOTHINGPRENEUR: How to Increase Revenue for Your Clothing Business",
                "2 Lessons",
                "Rp45.000"));
        mCourses.add(new Course(R.drawable.poster_course3,
                "FOODPRENEUR: 3 Rahasia FUDGYBRO Menjual 4000 Box Dessert Dalam Waktu 1 Bulan",
                "1 Lesson",
                "Rp45.000"));
        mCourses.add(new Course(R.drawable.poster_course4,
                "FOODPRENEUR: 3 Rahasia Membuka 200 Cabang Dalam Waktu 5 Bulan Hanya Dengan Modal 5 Juta",
                "1 Lesson",
                "Rp45.000"));

    }

    void addDataForum() {
        mForums = new ArrayList<>();
        mForums.add(new Forum(R.drawable.avatar1,
                "Bagaimana Belajar Mengatakan ‘Tidak’ Dapat Meningkatkan Bisnis Anda",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Kata “tidak” adalah kata unik yang meskipun memiliki konotasi negatif, namun memiliki…"));
        mForums.add(new Forum(R.drawable.avatar1,
                "5 Ide Memulai Bisnis di Perguruan Tinggi",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Mendapatkan bisnis Anda sendiri adalah usaha yang sangat bertanggung jawab namun membebas…"));
        mForums.add(new Forum(R.drawable.avatar1,
                "5 Faktor Yang Memungkinkan Kepercayaan Dalam Kondisi Apa Pun",
                "1 member · 1 reply",
                "Edrus replied 2 months ago",
                "Kepercayaan memiliki pintu depan dan pintu belakang, itulah sebabnya banyak orang menghab…"));
        mForums.add(new Forum(R.drawable.avatar1,
                "10 Skill Negosiasi Yang Harus Dimiliki Setiap Pengusaha",
                "1 member · 1 reply",
                "Edrus replied 2 months, 1 week ago",
                "Kita semua ingin mendapatkan sebanyak yang kita bisa dalam setiap kesepakatan atau transa…"));
        mForums.add(new Forum(R.drawable.avatar1,
                "Sumber Daya Terbaik Di Mana Anda Dapat Menemukan Ide Bisnis",
                "1 member · 1 reply",
                "Edrus replied 2 months, 1 week ago",
                "Peluang dan ide bisnis adalah titik awal untuk setiap bisnis. Mereka penting karena energ…"));
        mForums.add(new Forum(R.drawable.avatar1,
                "Entrepreneur Success: Tricks For New Players",
                "1 member · 1 reply",
                "Edrus replied 2 month, 3 weeks ago",
                "Ask any entrepreneur and they’ll tell you starting a business is never an easy task. It…"));

    }

    @Override
    public void onArticleClick(int position) {
        Log.d(TAG, "onArticleClick() called with: position = [" + position + "]");
        Article article = mArticles.get(position);
        Fragment mFragment = new DetailArticle();
        Bundle args = new Bundle();
        args.putInt("image", article.articleImage);
        args.putString("title", article.articleTitle);
        mFragment.setArguments(args);
        getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBlogClick(int position) {
        Log.d(TAG, "onBlogClick() called with: position = [" + position + "]");
        Blog blog = mBlogs.get(position);
        Fragment mFragment = new DetailBlog();
        Bundle args = new Bundle();
        args.putInt("image", blog.blogImage);
        args.putString("date", blog.blogDate);
        args.putString("title", blog.blogTitle);
        mFragment.setArguments(args);
        getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
    }

    @Override
    public void onCourseClick(int position) {
        Log.d(TAG, "onCourseClick() called with: position = [" + position + "]");
        Course course = mCourses.get(position);
        Fragment mFragment = new DetailCourse();
        Bundle args = new Bundle();
        args.putInt("image", course.courseImage);
        args.putString("lesson", course.courseLesson);
        args.putString("title", course.courseTitle);
        args.putString("price", course.coursePrice);
        mFragment.setArguments(args);
        getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
    }

    @Override
    public void onForumClick(int position) {
        Log.d(TAG, "onForumClick() called with: position = [" + position + "]");
        Forum forum = mForums.get(position);
        Fragment mFragment = new DetailForum();
        Bundle args = new Bundle();
        args.putInt("image", forum.forumImage);
        args.putString("author", forum.forumAuthor);
        args.putString("content", forum.forumContent);
        args.putString("release", forum.forumRelease);
        args.putString("title", forum.forumTitle);
        mFragment.setArguments(args);
        getParentFragmentManager().beginTransaction().replace(R.id.flcontent, mFragment).addToBackStack(null).commit();
    }

    public void contactEmail(String address) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Contact us with.."));
        }
    }

    public void subscribeYoutube() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.url_youtube)));
        startActivity(intent);
    }

    public void followInstagram() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.url_instagram)));
        startActivity(intent);
    }
}