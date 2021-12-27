package com.example.menulanglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerList extends AppCompatActivity {

    Spinner spinner,spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_list);
        spinner=findViewById(R.id.spinner);
        spinner1=findViewById(R.id.spinner1);
        ArrayList<String>std=new ArrayList<>();
        std.add("tom");
        std.add("jam");
        std.add("Al");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,std);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerList.this, "ITEM SELECTED IS  "+ std.get(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ////here spinner two where we used strings files to create array of items
     spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             Toast.makeText(SpinnerList.this, "ITEM SELECTED IS  "+spinner1.getSelectedItem().toString() , Toast.LENGTH_SHORT).show();

         }

         @Override
         public void onNothingSelected(AdapterView<?> adapterView) {

         }
     });

    }
}