package com.fadly.entrepreneurs;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class BlogsRecyclerAdapter extends RecyclerView.Adapter<BlogsRecyclerAdapter.BlogViewHolder> {

    private ArrayList<Blog> mBlogs;
    private OnBlogListener mOnBlogListener;

    public BlogsRecyclerAdapter(ArrayList<Blog> mBlogs, OnBlogListener onBlogListener) {
        this.mBlogs = mBlogs;
        this.mOnBlogListener = onBlogListener;
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivThumbnail;
        private TextView tvTitle, tvDate;
        private OnBlogListener onBlogListener;

        public BlogViewHolder(View itemView, OnBlogListener onBlogListener) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.onBlogListener = onBlogListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBlogListener.onBlogClick(getAdapterPosition());

        }
    }

    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_blog, parent, false);
        return new BlogViewHolder(view, mOnBlogListener);
    }

    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(mBlogs.get(position).getBlogImage());
        holder.tvTitle.setText(mBlogs.get(position).getBlogTitle());
        holder.tvDate.setText(mBlogs.get(position).getBlogDate());

    }

    @Override
    public int getItemCount() {
        return (mBlogs != null) ? mBlogs.size() : 0;
    }

    public interface OnBlogListener {
        void onBlogClick(int position);
    }
}
