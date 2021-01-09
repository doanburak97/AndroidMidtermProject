package com.doanburak.hepsiburadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_email, et_password;

    String email = "test@gmail.com";
    String password = "test1234";

    static ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        productList.add(new Product("Xiaomi Mi 10T 128 GB", 5500, 5399, 4, R.drawable.xiaomimi10t));
        productList.add(new Product("IPhone 11 128 GB", 8449, 8149, 5, R.drawable.appleiphone11));
        productList.add(new Product("Huawei Watch GT2 Pro 46mm", 2433, 2239, 4, R.drawable.huaweiwatch));
        productList.add(new Product("Apple Macbook Pro M1 Chip 8GB", 18000, 16075, 5, R.drawable.macbookpro));
        productList.add(new Product("Asus ROG Chakram 16000 DPI", 1599, 1199, 4, R.drawable.asusmouse));
        productList.add(new Product("Samsung QE-65Q80T 65 4K", 22999, 14519, 5, R.drawable.samsungtv));

    }

    public void signIn(View view) {

        if (et_email.getText().toString().matches(email) && et_password.getText().toString().matches(password)) {

            Intent intentToMainPage = new Intent(this, MainPageActivity.class);
            startActivity(intentToMainPage);

        } else {
            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }

    }
}