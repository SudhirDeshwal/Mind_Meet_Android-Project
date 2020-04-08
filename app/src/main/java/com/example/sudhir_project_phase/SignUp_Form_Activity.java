package com.example.sudhir_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp_Form_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form_);
        getSupportActionBar().setTitle("Sign UP");
    }

    public void btn_details_1(View view) {

        startActivity(new Intent(getApplicationContext(),Details_Page_1.class));
    }
}