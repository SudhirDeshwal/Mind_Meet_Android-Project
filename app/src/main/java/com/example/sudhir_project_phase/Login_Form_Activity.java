package com.example.sudhir_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_Form_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form_);
      //  getSupportActionBar().setTitle("Login");
    }

    public void btn_signup_form(View view) {

        startActivity(new Intent(getApplicationContext(),SignUp_Form_Activity.class));
    }
}
