package com.example.jailmanagement;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyApp extends AppCompatActivity {

    ListView listView;
    private EditText in_name, in_location;
    private ArrayList<String> name;
    private CustomAdapter customAdapter;

    Button add;
    Button update;


    ArrayList<String> location = new ArrayList<String>();

    Integer indexVal;
    String item;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_app);

        in_name = (EditText) findViewById(R.id.name);
        in_location = (EditText) findViewById(R.id.location);
        add= (Button) findViewById(R.id.btnadd);
        update = (Button) findViewById(R.id.updatebtn);
        listView = (ListView) findViewById(R.id.listView);

        name = new ArrayList<>();
        customAdapter = new CustomAdapter(this,name);
        listView.setAdapter(customAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in_name.getText().toString().isEmpty() && in_location.getText().toString().isEmpty())
                {
                    Toast.makeText(MyApp.this, "NO DATA SUBMITTED, FILL INPUTS!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String data1 = in_name.getText().toString();
                    String data2 = in_location.getText().toString();
                    String merge = data1 + " imprisoned in " + data2;
                    name.add(merge);
                    customAdapter.notifyDataSetChanged();
                    in_name.setText("");
                    in_location.setText("");
                }
            }
        });

        //for selecting
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                item = adapterView.getItemAtPosition(i).toString() + " has been selected";
                indexVal = i;
                Toast.makeText(MyApp.this, item, Toast.LENGTH_SHORT).show();
            }
        });


        //for Update
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in_name.getText().toString().isEmpty() && in_location.getText().toString().isEmpty())
                {
                    Toast.makeText(MyApp.this, "NO DATA SUBMITTED, FILL INPUTS!", Toast.LENGTH_SHORT).show();
                }else {
                    String val = in_name.getText().toString();
                    String val2 = in_location.getText().toString();
                    String merge = val + " imprisoned in " + val2;
                    name.set(indexVal, merge);
                    customAdapter.notifyDataSetChanged();
                    in_name.setText("");
                    in_location.setText("");
                }
            }
        });
        //for deleting
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                item = adapterView.getItemAtPosition(i).toString() + " has been Deleted";
                Toast.makeText(MyApp.this, item, Toast.LENGTH_SHORT).show();
                name.remove(i);
                customAdapter.notifyDataSetChanged();
                return true;
            }
        });


    }
}