package com.example.thoma.parkingapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by thoma on 11/30/2015.
 */
public class ParkingService extends Service {
    private ParkingApp app;
    private Timer timer;
    private FileIO io;

    @Override
    public void onCreate() {
        Log.d("Parking", "Service created");
        app = (ParkingApp) getApplication();
        io = new FileIO(getApplicationContext());
        startTimer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Parking", "Service started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("Parking", "Service destroyed");
        stopTimer();
    }


    private void startTimer() {
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                Log.d("Parking", "Timer task started");

                io.downloadFile();
                Log.d("Parking", "File downloaded");

                RSSFeed newFeed = io.readFile();
                Log.d("Parking", "File read");

            }
        };

        timer = new Timer(true);
        int delay = 1000* 60 * 60;
        int interval = 1000*60*60;
        timer.schedule(task, delay, interval);

    }

    private void stopTimer()
    {
        if(timer != null)
        {
            timer.cancel();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Parking", "Service bound - not used!");
        return null;
    }

    private void sendNotification(String text)
    {
        Intent notificationIntent = new Intent(this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, flags);

        int icon = R.mipmap.ic_launcher;
        CharSequence tickerText = "Updated parking  is available";
        CharSequence contentTitle = getText(R.string.app_name);
        CharSequence contentText = text;

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(icon)
                .setTicker(tickerText)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        manager.notify(NOTIFICATION_ID, notification);
    }
}
