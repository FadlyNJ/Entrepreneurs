package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CoursesRecyclerAdapter extends RecyclerView.Adapter<CoursesRecyclerAdapter.CourseViewHolder> {

    private ArrayList<Course> mCourses;
    private OnCourseListener mOnCourseListener;

    public CoursesRecyclerAdapter(ArrayList<Course> mCourses, OnCourseListener onCourseListener) {
        this.mCourses = mCourses;
        this.mOnCourseListener = onCourseListener;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivThumbnail;
        private TextView tvTitle, tvLesson, tvPrice;
        private MaterialButton btnAdd;
        private OnCourseListener onCourseListener;

        public CourseViewHolder(View itemView, OnCourseListener onCourseListener) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLesson = (TextView) itemView.findViewById(R.id.tvLesson);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            btnAdd = (MaterialButton) itemView.findViewById(R.id.btnAdd);
            this.onCourseListener = onCourseListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCourseListener.onCourseClick(getAdapterPosition());

        }
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_course, parent, false);
        return new CourseViewHolder(view, mOnCourseListener);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(mCourses.get(position).getCourseImage());
        holder.tvTitle.setText(mCourses.get(position).getCourseTitle());
        holder.tvPrice.setText(mCourses.get(position).getCoursePrice());
        holder.tvLesson.setText(mCourses.get(position).getCourseLesson());
    }

    @Override
    public int getItemCount() {
        return (mCourses != null) ? mCourses.size() : 0;
    }

    public interface OnCourseListener {
        void onCourseClick(int position);
    }
}
