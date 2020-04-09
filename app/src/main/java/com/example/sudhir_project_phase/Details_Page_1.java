package com.example.sudhir_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Details_Page_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__page_1);
    }

    public void btn_detailsPage_1(View view) {

        startActivity(new Intent(getApplicationContext(),Details_Page_2.class));

    }
}
