package com.fadly.entrepreneurs;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PopUpCart implements CartsRecyclerAdapter.OnCartListener {

    View cart;
    MaterialButton btnCart, btnCheckout;
    LinearLayout checkoutLayout;
    RecyclerView cartRecycler;
    TextView tvEmpty;

    //Article
    private RecyclerView mRecyclerViewCart;
    private CartsRecyclerAdapter mCartRecyclerAdapter;
    private ArrayList<Cart> mCarts;

    public void showPopupWindow(final View view) {

        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_cart, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //Create a window with our parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        mCarts = new ArrayList<>();
        addDataCart();
        mRecyclerViewCart = (RecyclerView) popupWindow.getContentView().findViewById(R.id.cart_recycler);
        mCartRecyclerAdapter = new CartsRecyclerAdapter(mCarts, this);
        RecyclerView.LayoutManager cartLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerViewCart.setLayoutManager(cartLayoutManager);
        mRecyclerViewCart.setAdapter(mCartRecyclerAdapter);

        cart = (View) view.findViewById(R.id.cart);
        btnCart = (MaterialButton) popupWindow.getContentView().findViewById(R.id.btn_cart);
        btnCheckout = (MaterialButton) popupWindow.getContentView().findViewById(R.id.btn_checkout);
        checkoutLayout = (LinearLayout) popupWindow.getContentView().findViewById(R.id.linear_checkout);
        cartRecycler = (RecyclerView) popupWindow.getContentView().findViewById(R.id.cart_recycler);
        tvEmpty = (TextView) popupWindow.getContentView().findViewById(R.id.tv_empty);

        //Set the location of the window on the screen
        popupWindow.setBackgroundDrawable(view.getResources().getDrawable(R.drawable.popupwindow_bg));
        popupWindow.setElevation(30);
        popupWindow.showAsDropDown(cart, 0, 0, Gravity.CENTER);

        if (!mCarts.isEmpty()) {
            checkoutLayout.setVisibility(View.VISIBLE);
            cartRecycler.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);

            btnCheckout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Haloha ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), LoginActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);
                    popupWindow.dismiss();
                }
            });

            btnCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Just wanna hold your pussy", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), RegisterActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);
                    popupWindow.dismiss();
                }
            });

        } else {
            checkoutLayout.setVisibility(View.GONE);
            cartRecycler.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }

        //Handler for clicking on the inactive zone of the window
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Close the window when clicked
                popupWindow.dismiss();
                return true;
            }
        });

    }

    public void addDataCart() {
        mCarts.add(new Cart(R.drawable.poster_course1,
                "45000",
                "1",
                "BEAUTYPRENEUR: Branding 101: How To Nail The “Beauty Industry”"));
        mCarts.add(new Cart(R.drawable.poster_course2,
                "45000",
                "3",
                "CLOTHINGPRENEUR: How to Increase Revenue for Your Clothing Business"));
        mCarts.add(new Cart(R.drawable.poster_course3,
                "45000",
                "2",
                "FOODPRENEUR: 3 Rahasia FUDGYBRO Menjual 4000 Box Dessert Dalam Waktu 1 Bulan"));
        mCarts.add(new Cart(R.drawable.poster_course4,
                "45000",
                "4",
                "FOODPRENEUR: 3 Rahasia Membuka 200 Cabang Dalam Waktu 5 Bulan Hanya Dengan Modal 5 Juta"));

    }

    @Override
    public void onCartClick(int position) {
        Log.d(TAG, "onCartClick() called with: position = [" + position + "]");
    }
}
