package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void submitdata(View view)
    {
        System.out.print("hello");
        Button btn=findViewById(R.id.button);
        btn.setText("Submitted Information");
        EditText tx1=findViewById(R.id.editTextText);
        EditText tx2=findViewById(R.id.editTextText2);
        EditText tx3=findViewById(R.id.editTextText3);
        EditText tx4=findViewById(R.id.editTextText4);

        String name=tx1.getText().toString();
        int age = Integer.parseInt(tx2.getText().toString().trim());
        String mobile=tx3.getText().toString();
        int roll=Integer.parseInt(tx4.getText().toString().trim());
        if(name.isEmpty()||mobile.isEmpty()){
            return;
        }
        db.insertData(name,age,mobile,roll);
    }
    public void showdata(View view)
    {
        Intent intent=new Intent(this,Showdata.class);
        startActivity(intent);
    }

}