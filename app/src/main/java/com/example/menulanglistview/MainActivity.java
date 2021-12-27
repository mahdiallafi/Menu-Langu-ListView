package com.example.menulanglistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    Button button,button4;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    // welcome=findViewById(R.id.textView);
     ///welcome.setText("Hello");
        //here way to use translate
////     welcome.setText(R.string.hello);
        button=findViewById(R.id.button);
        button4=findViewById(R.id.button4);
        progressBar=findViewById(R.id.progressBar);

        ///here way to sleep but if we want to have other type of event there are another way
       /* Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();*/
        Thread thread = new Thread(){
            public void run(){
                runOnUiThread(new Runnable() {
                    public void run() {
                        for (int i=0;i<10;i++){
                            progressBar.incrementProgressBy(10);
                            SystemClock.sleep(500);
                      ///      progressBar.setProgress(i);
                      //  Toast.makeText(getApplicationContext(), "it is increas ", Toast.LENGTH_LONG);
                    }}
                });
            }
        };
        thread.start();
      System.out.println("the value is "+ progressBar.getProgress());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Radio.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NotificationANDDate.class);
                startActivity(intent);
            }
        });
    }

    //call the menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    //add action on the menu item like snack

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"item selected",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,ListItem.class);
                startActivity(intent);
                return  true;
            case R.id.alarm:
                Toast.makeText(this,"item is selected",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(MainActivity.this,SpinnerList.class);
                startActivity(intent1);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }




    }
}