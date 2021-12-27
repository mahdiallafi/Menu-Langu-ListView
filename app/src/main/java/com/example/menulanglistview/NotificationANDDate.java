package com.example.menulanglistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationANDDate extends AppCompatActivity {

    Button button;
    public static final String text_reply="text_reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_anddate);
        button=findViewById(R.id.button3);

        // Notification Channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Notification", "Notification name", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        ///reply the message


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationANDDate.this, "Notification");
                builder.setSmallIcon(R.drawable.ic_message);
                builder.setContentTitle("New Message");
                builder.setContentText("you get the message from");
          /*      builder.setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("You have registered an appointment for " + simpleDateFormat.format(appointment.getDate()) + " / " + appointment.getTime()));
            */    builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
             /*   if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    RemoteInput remoteInput=new RemoteInput.Builder(text_reply).setLabel("replay....").build();
                   Intent intent=new Intent(NotificationANDDate.this,Reply.class);
               //     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    PendingIntent pendingIntent=PendingIntent.getBroadcast(NotificationANDDate.this,0,intent,0);
                    NotificationCompat.Action action=new NotificationCompat.Action.Builder(R.drawable.ic_replay,"Replay"
                            ,pendingIntent).addRemoteInput(remoteInput).build();


                    builder.addAction(action);


                }*/




                // Call the notification using builder instance above
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(NotificationANDDate.this);
                managerCompat.notify(0, builder.build());
            }
        });

    }
}