package com.myprojects.coupon1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCoupon extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView iv;
    Button addCoupon;
    Spinner spinner;
    EditText descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coupon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        final FloatingActionButton fb = findViewById(R.id.floating);
        iv = findViewById(R.id.picture);
        addCoupon = findViewById(R.id.add_button);
        spinner = findViewById(R.id.category);
        descriptionText = findViewById(R.id.description);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);



        View.OnClickListener onClickListener= new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == fb) {
                    //our intent is to capture an image
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    //check if there is any application capable of handling the intent
                    if (intent.resolveActivity(getPackageManager()) != null) {

                            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                        fb.hide();
                        }



                }
                else if (v == addCoupon) {
                    Intent intent = new Intent(getApplicationContext(), MyCoupons.class);
                String spinnerTextCoupon = spinner.getSelectedItem().toString();
                iv.invalidate();
                BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
                Bitmap bitmapCoupon = drawable.getBitmap();
                String editTextCoupon = descriptionText.getText().toString();

                Coupon newCoupon = new Coupon(spinnerTextCoupon, bitmapCoupon, editTextCoupon);
                intent.putExtra("coupon_object", newCoupon);
                //this should be fixed we want to update the my coupons tab, but its a fragment
                startActivity(intent);
                }

            }
        };

        fb.setOnClickListener((View.OnClickListener) onClickListener);
        addCoupon.setOnClickListener((View.OnClickListener) onClickListener);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = null;
            if (extras != null) {
                bitmap = (Bitmap) extras.get("data");
            }
            Bitmap reSize = Bitmap.createScaledBitmap(bitmap,200,200,true);
            iv.setImageBitmap(reSize);


        }
    }
}
