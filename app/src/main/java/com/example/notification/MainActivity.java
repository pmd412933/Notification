package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Switch aSwitch1,aSwitch2;
    public String Channel_ID = "Notification";
    public int Notification_ID = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window g=getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imagenotification);

        textView=findViewById(R.id.texviewNotification);

        aSwitch1=findViewById(R.id.simpleSwitch1);

        aSwitch1.setTextOn("On");
        aSwitch1.setTextOff("Off");

        aSwitch2=findViewById(R.id.simpleSwitch2);
        aSwitch2.setTextOn("On");
        aSwitch2.setTextOff("Off");

        aSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationMethod3();
                notificationmethod4();
            }
        });


        aSwitch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notificationMethod();
                notificationmethod2();

            }
        });


    }

    private void notificationmethod4() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification title";
            String description = "Teha  nie";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(Channel_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);



        }
    }




    private void notificationMethod3() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_ID)
                .setContentTitle("Notification")
                .setContentText("Teha  nie")
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        NotificationManagerCompat notificationcompat = NotificationManagerCompat.from(this);
        notificationcompat.notify(Notification_ID, builder.build());

    }


    private void notificationMethod() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_ID)
                .setContentTitle("Notification")
                .setContentText("Teha dey")
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        NotificationManagerCompat notificationcompat = NotificationManagerCompat.from(this);
        notificationcompat.notify(Notification_ID, builder.build());
    }
    private void notificationmethod2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification title";
            String description = "Teha dey";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(Channel_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);



        }
    }}


