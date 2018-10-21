package com.foodproject.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.ProductAdapter;
import com.foodproject.adapter.TrendingProductAdapter;
import com.foodproject.model.Products;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class RestaurantActivity extends AppCompatActivity implements TrendingProductAdapter.OnClickItemListner{

    RecyclerView mProductDayRecycler, mProductRecycler;
    private ImageView mNoFavorite, mFavorite;

    private static final int ACTIVITY_NUM = 2;
    private Context mContext = RestaurantActivity.this;
    private static final String TAG = "RestaurantActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
//        setContentView(R.layout.activity_profile_polygon);

        initComponents();
        setupWidgets();
        setupBottomNavigationView();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.white));
//        }

    }

    private void initComponents() {
//        mProductDayRecycler = findViewById(R.id.product_day_recycler_view);
        mProductRecycler = findViewById(R.id.feature_recycler);
        mNoFavorite = findViewById(R.id.no_favorite);
        mFavorite = findViewById(R.id.favorite);
    }

    private void setupWidgets() {

        //setup category recycler view
//        LinearLayoutManager llmProductDay = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mProductDayRecycler.setLayoutManager(llmProductDay);
//        ProductAdapter mProductDayAdapter = new ProductAdapter(this);
//        mProductDayRecycler.setAdapter(mProductDayAdapter);

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        TrendingProductAdapter mProductAdapter1 = new TrendingProductAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter1);

        mNoFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNoFavorite.setVisibility(View.GONE);
                mFavorite.setVisibility(View.VISIBLE);
            }
        });

        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNoFavorite.setVisibility(View.VISIBLE);
                mFavorite.setVisibility(View.GONE);
            }
        });
    }

    //    BottomNavigationView setup
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


    @Override
    public void onNoFavoriteClick(Products products) {

    }

    @Override
    public void onFavoriteClick(Products products) {

    }
}
