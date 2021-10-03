package com.codepath.paulina.instagram;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    //Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("QdtAqdbDvOJ0VDKEggPqPnSBSd47au1Sa7N6x6uA")
                .clientKey("iNwiZp4mHT8D5NnPi1bWGBiIn9ffxwU9zuiPQJxD")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
