package com.example.diettracker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class BMIReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        double bmiValue = intent.getDoubleExtra("BMI", 0.0);

        String channelId = "com.example.diettracker.notification_channel";
        String channelName = "BMI Notifications";

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName,
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        Notification.Builder builder = new Notification.Builder(context, channelId)
                .setContentTitle("BMI Notification")
                .setSmallIcon(R.mipmap.ic_launcher);

        if (bmiValue < 18.5) {
            builder.setContentText("BMI is too low. Plan your meal from our app.");


        } else if (bmiValue > 24.9) {
            builder.setContentText("BMI is too high. Plan your meal from our app.");
        } else {
            // Handle other BMI ranges if needed
            return;
        }

        notificationManager.notify(1, builder.build());
    }
}

