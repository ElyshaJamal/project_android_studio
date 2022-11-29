package com.android.miniprojectf1015f1070f1063f1030;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notification extends AppCompatActivity {

    Button notifyBtn;
    Button backBtn, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notifyBtn = findViewById(R.id.btnNoti);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "My Notification";
            String description = "My Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("My First Notification", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(notification.this, "My First Notification");
                builder.setContentTitle("Selamat Datang ke Kelas DDT5B");
                builder.setContentText("Hello everyone, We are in semester 5, Pray for us to get excellent results Aamiin..🤲🤲 ThankYou❤❤");
                builder.setSmallIcon(R.drawable.ic_message);
                builder.setChannelId("My First Notification");
                builder.setAutoCancel(true);
                builder.build();

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(notification.this);
                managerCompat.notify(1, builder.build());

            }
        });

        backBtn = findViewById(R.id.btnhomepage);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }

            private void openActivity1() {
                Intent intent1 = new Intent(notification.this, homepage.class);
                startActivity(intent1);
            }
        });

    }
}