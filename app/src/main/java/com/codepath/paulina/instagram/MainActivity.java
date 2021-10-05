package com.codepath.paulina.instagram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.paulina.instagram.fragments.ComposeFragment;
import com.codepath.paulina.instagram.fragments.PostsFragment;
import com.codepath.paulina.instagram.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.nux_dayone_landing_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/


        if (ParseUser.getCurrentUser() == null) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        /**
        This are the settings for the navegation bar at the bottom
        */

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch(item.getItemId())
                {
                    case R.id.action_home:
                        //Toast.makeText(MainActivity.this,"Home!", Toast.LENGTH_SHORT).show();
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        //Toast.makeText(MainActivity.this,"Compose!",Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        //Toast.makeText(MainActivity.this,"Profile!",Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                //Begin the frame layout .xml
                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;

            }
        });

        //Set default selection in navigation bar
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }




}