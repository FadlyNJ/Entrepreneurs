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

public class ForumFragment extends Fragment {

    private RecyclerView recyclerViewForum;
    private ForumAdapter forumAdapter;
    private ArrayList<Forum> forumArrayList;


    public ForumFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forum, container, false);

        addDataForum();
        recyclerViewForum = (RecyclerView) view.findViewById(R.id.forum_recycler);
        forumAdapter = new ForumAdapter(forumArrayList);
        RecyclerView.LayoutManager forumLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewForum.setLayoutManager(forumLayoutManager);
        recyclerViewForum.setAdapter(forumAdapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.line));
        recyclerViewForum.addItemDecoration(itemDecoration);

        return view;
    }

    void addDataForum() {
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

    }

}