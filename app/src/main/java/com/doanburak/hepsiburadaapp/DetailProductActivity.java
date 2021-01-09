package com.doanburak.hepsiburadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailProductActivity extends AppCompatActivity {

    ImageView iv_product;
    TextView tv_description, tv_oldPrice, tv_newPrice;
    RatingBar rb_rating;
    Button btn_back, btn_payment;

    public String description;
    public int totalPrice;
    public int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        iv_product = findViewById(R.id.iv_product);
        tv_description = findViewById(R.id.tv_description);
        rb_rating = findViewById(R.id.rb_rating);
        tv_oldPrice = findViewById(R.id.tv_oldPrice);
        tv_newPrice = findViewById(R.id.tv_newPrice);
        btn_back = findViewById(R.id.btn_back);
        btn_payment = findViewById(R.id.btn_payment);

        Intent intent = getIntent();
        Product selectedProduct = (Product) intent.getSerializableExtra("selectedProductInfo");

        iv_product.setImageResource(selectedProduct.getImage());
        tv_description.setText(selectedProduct.getDescription());
        rb_rating.setRating(selectedProduct.getRating());
        tv_oldPrice.setText(String.valueOf(selectedProduct.getOldPrice()) + "₺");
        tv_newPrice.setText(String.valueOf(selectedProduct.getNewPrice()) + "₺");

        description = selectedProduct.getDescription();
        totalPrice = selectedProduct.getNewPrice();
        image = selectedProduct.getImage();

    }

    public void btn_back(View view){

        Intent intentToMainPage = new Intent(this, MainPageActivity.class);
        startActivity(intentToMainPage);

    }

    public void btn_payment(View view){

        Intent intentToPayment = new Intent(this, PaymentPageActivity.class);
        intentToPayment.putExtra("image", image);
        intentToPayment.putExtra("description", description);
        intentToPayment.putExtra("totalPrice", totalPrice);

        startActivity(intentToPayment);

    }
}