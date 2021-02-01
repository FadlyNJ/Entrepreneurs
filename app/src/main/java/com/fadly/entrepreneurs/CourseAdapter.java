package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    private ArrayList<Course> arrayList;

    public CourseAdapter(ArrayList<Course> arrayList) {
        this.arrayList = arrayList;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivThumbnail;
        private TextView tvTitle, tvLesson, tvPrice;
        private MaterialButton btnAdd;
        private RelativeLayout itemList;

        public CourseViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLesson = (TextView) itemView.findViewById(R.id.tvLesson);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            btnAdd = (MaterialButton) itemView.findViewById(R.id.btnAdd);
            itemList = (RelativeLayout) itemView.findViewById(R.id.course_list);
        }
    }

    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_course, parent, false);
        return new CourseAdapter.CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseAdapter.CourseViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(arrayList.get(position).getImage());
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tvPrice.setText(arrayList.get(position).getPrice());
        holder.tvLesson.setText(arrayList.get(position).getLesson());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null) ? arrayList.size() : 0;
    }
}
