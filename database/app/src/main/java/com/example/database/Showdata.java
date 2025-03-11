package com.example.database;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Showdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_showdata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewdata();
    }

    private void viewdata() {
        DatabaseHelper db=new DatabaseHelper(this);
        Cursor cursor=db.getAllData();
        if(cursor.getCount()==0) {
            return;
        }
        TableLayout tableLayout=findViewById(R.id.tablelayout);
        while(cursor.moveToNext())
        {
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String mobile=cursor.getString(3);
            int roll=cursor.getInt(4);
            TextView c1= new TextView(this);
            TextView c2= new TextView(this);
            TextView c3= new TextView(this);
            TextView c4= new TextView(this);

            c1.setText(name);
            c2.setText(String.valueOf(age));
            c3.setText(mobile);
            c4.setText(String.valueOf(roll));
            TableRow row=new TableRow(this);
            row.addView(c1);
            row.addView(c2);
            row.addView(c3);
            row.addView(c4);
            tableLayout.addView(row);
        }
        cursor.close();

    }
}