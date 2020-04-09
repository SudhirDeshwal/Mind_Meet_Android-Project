package com.example.sudhir_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.AppTheme);
    }

    public void detailsPage(View v)
    {
        Intent i=new Intent(this,DetailsPage.class);

        startActivity(i);

    }
}
