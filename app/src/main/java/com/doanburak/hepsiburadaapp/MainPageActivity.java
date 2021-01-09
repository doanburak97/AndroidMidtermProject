package com.doanburak.hepsiburadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {

    ListView lv_mainProduct;
    MainProductAdapter mainProductAdapter;

    TextView tv_description, tv_oldPrice, tv_newPrice;
    RatingBar rb_rating;
    ImageView img_product;
    ConstraintLayout lyt_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        lv_mainProduct = findViewById(R.id.lv_mainProducts);

        mainProductAdapter = new MainProductAdapter(MainActivity.productList);
        lv_mainProduct.setAdapter(mainProductAdapter);

    }

    public class MainProductAdapter extends BaseAdapter{

        public ArrayList<Product> productList;

        public MainProductAdapter(ArrayList<Product> mainProductList){
            this.productList = mainProductList;
        }

        @Override
        public int getCount() {
            return productList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.product_row, null);

            final  Product product = productList.get(position);

            tv_description = view.findViewById(R.id.tv_description);
            rb_rating = view.findViewById(R.id.rb_rating);
            tv_oldPrice = view.findViewById(R.id.tv_oldPrice);
            tv_newPrice = view.findViewById(R.id.tv_newPrice);
            img_product = view.findViewById(R.id.iv_product);
            lyt_product = view.findViewById(R.id.lyt_product);

            tv_description.setText(product.getDescription());
            rb_rating.setRating(product.getRating());
            tv_oldPrice.setText(String.valueOf(product.getOldPrice()) + "₺");
            tv_newPrice.setText(String.valueOf(product.getNewPrice()) + "₺");
            img_product.setImageResource(product.getImage());

            lyt_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intentToDetail = new Intent(v.getContext(), DetailProductActivity.class);
                    intentToDetail.putExtra("selectedProductInfo", product);
                    startActivity(intentToDetail);

                }
            });
            return view;
        }
    }
}