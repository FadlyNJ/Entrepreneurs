package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForumsRecyclerAdapter extends RecyclerView.Adapter<ForumsRecyclerAdapter.ForumViewHolder>{

    private ArrayList<Forum> mForums;
    private OnForumListener mOnForumListener;

    public ForumsRecyclerAdapter(ArrayList<Forum> mForums, OnForumListener onForumListener) {
        this.mForums = mForums;
        this.mOnForumListener = onForumListener;
    }

    public class ForumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CircleImageView ivThumbnail;
        private TextView tvTitle, tvRelease, tvContent, tvAuthor;
        private OnForumListener onForumListener;

        public ForumViewHolder(View itemView, OnForumListener onForumListener) {
            super(itemView);
            ivThumbnail = (CircleImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            tvRelease = (TextView) itemView.findViewById(R.id.tv_release);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            this.onForumListener = onForumListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onForumListener.onForumClick(getAdapterPosition());

        }
    }

    @Override
    public ForumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_forum, parent, false);
        return new ForumViewHolder(view, mOnForumListener);
    }

    @Override
    public void onBindViewHolder(ForumsRecyclerAdapter.ForumViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(mForums.get(position).getImage());
        holder.tvTitle.setText(mForums.get(position).getTitle());
        holder.tvAuthor.setText(mForums.get(position).getAuthor());
        holder.tvRelease.setText(mForums.get(position).getRelease());
        holder.tvContent.setText(mForums.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (mForums != null) ? mForums.size() : 0;
    }

    public interface OnForumListener{
        void onForumClick(int position);
    }
}
