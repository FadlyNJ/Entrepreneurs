package com.fadly.entrepreneurs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder>{

    private ArrayList<Forum> arrayList;

    public ForumAdapter(ArrayList<Forum> arrayList) {
        this.arrayList = arrayList;
    }

    public class ForumViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView ivThumbnail;
        private TextView tvTitle, tvRelease, tvContent, tvAuthor;
        private RelativeLayout itemList;

        public ForumViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (CircleImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            tvRelease = (TextView) itemView.findViewById(R.id.tv_release);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            itemList = (RelativeLayout) itemView.findViewById(R.id.forum_list);
        }
    }

    @Override
    public ForumAdapter.ForumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_forum, parent, false);
        return new ForumAdapter.ForumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForumAdapter.ForumViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(arrayList.get(position).getImage());
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tvAuthor.setText(arrayList.get(position).getAuthor());
        holder.tvRelease.setText(arrayList.get(position).getRelease());
        holder.tvContent.setText(arrayList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null) ? arrayList.size() : 0;
    }
}
