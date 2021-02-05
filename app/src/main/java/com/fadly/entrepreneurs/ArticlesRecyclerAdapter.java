package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesRecyclerAdapter.ArticleViewHolder> {

    private ArrayList<Article> mArticles;
    private OnArticleListener mOnArticleListener;

    public ArticlesRecyclerAdapter(ArrayList<Article> mArticles, OnArticleListener onArticleListener) {
        this.mArticles = mArticles;
        this.mOnArticleListener = onArticleListener;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivThumbnail;
        private TextView tvTitle;
        private OnArticleListener onArticleListener;

        public ArticleViewHolder(View itemView, OnArticleListener onArticleListener) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.onArticleListener = onArticleListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onArticleListener.onArticleClick(getAdapterPosition());

        }
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_article, parent, false);
        return new ArticleViewHolder(view, mOnArticleListener);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(mArticles.get(position).getImage());
        holder.tvTitle.setText(mArticles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return (mArticles != null) ? mArticles.size() : 0;
    }

    public interface OnArticleListener{
        void onArticleClick(int position);
    }

}
