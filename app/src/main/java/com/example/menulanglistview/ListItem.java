package com.example.menulanglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListItem extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
    listView=findViewById(R.id.cities);
    //create list of item in arraylist
      final   ArrayList<String> cities=new ArrayList<>();
        cities.add("A");
        cities.add("B");
        cities.add("C");
        cities.add("D");
        cities.add("E");
        ArrayAdapter<String>citiesAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,cities);
         listView.setAdapter(citiesAdapter);

         //add click on the item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListItem.this, "ITEM SELECTED IS  "+ cities.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}