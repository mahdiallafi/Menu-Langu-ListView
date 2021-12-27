package com.example.menulanglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Radio extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
        CheckBox checkBox,checkBox1;
        Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        checkBox=findViewById(R.id.checkBox);
        checkBox1=findViewById(R.id.checkBox2);
        button=findViewById(R.id.button2);

        button.setOnClickListener(this);
        ////here two ways to do
        if(checkBox.isChecked()){
            Toast.makeText(Radio.this, "check one is clicked", Toast.LENGTH_SHORT).show();

        }else if(checkBox1.isChecked()){
            Toast.makeText(Radio.this, "check2  is clicked", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(Radio.this, "Nothing checked!", Toast.LENGTH_SHORT).show();
        }



        radioGroup = findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        Toast.makeText(Radio.this, "radio one is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton1:
                        Toast.makeText(Radio.this, "radio two is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                System.out.println("the button is clicked");
                break;
            default:
                break;
        }
    }
}