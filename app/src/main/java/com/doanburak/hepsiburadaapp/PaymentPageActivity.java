package com.doanburak.hepsiburadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentPageActivity extends AppCompatActivity {

    TextView tv_description, tv_totalPrice;
    EditText et_addressInfo, et_cardNumberInfo;
    ImageView iv_product;

    String emptyAdress = "";
    String emptyCardNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        tv_description = findViewById(R.id.tv_description);
        tv_totalPrice = findViewById(R.id.tv_totalPrice);
        et_addressInfo = findViewById(R.id.et_addressInfo);
        et_cardNumberInfo = findViewById(R.id.et_cardNumberInfo);
        iv_product = findViewById(R.id.iv_product);

        Intent intent = getIntent();

        tv_description.setText(intent.getStringExtra("description"));
        tv_totalPrice.setText(String.valueOf(intent.getIntExtra("totalPrice", 0)) + "₺");
        iv_product.setImageResource(intent.getIntExtra("image",0));

    }

    public void btn_accept(View view){

        if (et_addressInfo.getText().toString().matches(emptyAdress) || et_cardNumberInfo.getText().toString().matches(emptyCardNumber)){

            Toast.makeText(this, "Please fill all the blanks.", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(this, "::INFORMATION OF THE ORDER::\n" + tv_description.getText().toString() +
                    "\n" + tv_totalPrice.getText().toString() + "\n" +
                    et_addressInfo.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }
}