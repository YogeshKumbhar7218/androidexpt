package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String MSG="notify_me";
    private static final int CHANNEL_ID=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendNotification(View view){
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT>= android.os.Build.VERSION_CODES.O) {
            Notification notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Notification")
                    .setContentText("Hello.....")
                    .setChannelId(MSG)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(MSG,"Nature Notification",NotificationManager.IMPORTANCE_HIGH));
            nm.notify(CHANNEL_ID,notification);
        }
        else{
            Notification notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Tree")
                    .setContentText("Trees.....")
                    .build();
            nm.notify(CHANNEL_ID,notification);
        }
    }

}