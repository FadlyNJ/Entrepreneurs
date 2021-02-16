package com.fadly.entrepreneurs;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class CartsRecyclerAdapter extends RecyclerView.Adapter<CartsRecyclerAdapter.CartViewHolder> {

    private ArrayList<Cart> mCarts;
    private OnCartListener mOnCartListener;

    public CartsRecyclerAdapter(ArrayList<Cart> mCarts, OnCartListener onCartListener) {
        this.mCarts = mCarts;
        this.mOnCartListener = onCartListener;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivThumbnail;
        private TextView tvTitle, tvPrice, tvQuantity;
        private MaterialButton btnRemove;
        private OnCartListener onCartListener;

        public CartViewHolder(View itemView, OnCartListener onCartListener) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvQuantity = (TextView) itemView.findViewById(R.id.tv_quantity);
            btnRemove = (MaterialButton) itemView.findViewById(R.id.btn_remove);
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: " + getAdapterPosition());
                }
            });

            this.onCartListener = onCartListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCartListener.onCartClick(getAdapterPosition());

        }
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_cart, parent, false);
        return new CartViewHolder(view, mOnCartListener);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.ivThumbnail.setImageResource(mCarts.get(position).getCourseImage());
        holder.tvTitle.setText(mCarts.get(position).getCourseTitle());
        holder.tvPrice.setText(mCarts.get(position).getCoursePrice());
        holder.tvQuantity.setText(mCarts.get(position).getCourseQuantity());
    }

    @Override
    public int getItemCount() {
        return (mCarts != null) ? mCarts.size() : 0;
    }

    public interface OnCartListener {
        void onCartClick(int position);
    }
}