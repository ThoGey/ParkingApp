package com.example.thoma.parkingapp;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

/**
 * Created by thoma on 11/30/2015.
 */
public class ParkingApp extends Application {
    private long feedMillis = 1;

    void setFeedMillis(long feedMillis)
    {
        this.feedMillis = feedMillis;
    }

    long getFeedMillis()
    {
        return feedMillis;
    }

    public void onCreate()
    {
        super.onCreate();

        Log.d("Parking", "App started");

        Intent service = new Intent(this, ParkingService.class);
        startService(service);
    }
}
