package com.codepath.paulina.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomepageActivity extends AppCompatActivity {
    private ImageView ivTakePictureHP;
    private ImageView ivProfileHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ivTakePictureHP = findViewById(R.id.ivTakePictureHP);
        ivProfileHP = findViewById(R.id.ivProfileHP);

        ivTakePictureHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMainActivity();
            }
        });

        ivProfileHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goProfileActivity();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private void goProfileActivity() {
        Intent i = new Intent(this,ProfileActivity.class);
        startActivity(i);
    }
}