package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView adress = (TextView) findViewById(R.id.text_view_address);
        TextView phoneNumber = (TextView) findViewById(R.id.text_view_phone);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMapIntent(view);
            }
        });

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPhoneIntent(view);
            }
        });
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createMapIntent(View view){
        Uri gmAdress = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmAdress);
        mapIntent.setPackage("com.google.android.apps.maps");
        if(mapIntent.resolveActivity(getPackageManager()) != null) { startActivity(mapIntent); }

    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

    public void createPhoneIntent(View view){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        Uri numberToDial = Uri.parse("tel:0123456789");
        dialIntent.setData(numberToDial);
        startActivity(dialIntent);
    }
}
