package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder>{

    private ArrayList<Blog> arrayList;

    public BlogAdapter(ArrayList<Blog> arrayList) {
        this.arrayList = arrayList;
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivThumbnail;
        private TextView tvTitle, tvDate;
        private RelativeLayout itemList;

        public BlogViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            itemList = (RelativeLayout) itemView.findViewById(R.id.article_list);
        }
    }

    @Override
    public BlogAdapter.BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_blog, parent, false);
        return new BlogAdapter.BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogAdapter.BlogViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(arrayList.get(position).getImage());
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tvDate.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null) ? arrayList.size() : 0;
    }
}
