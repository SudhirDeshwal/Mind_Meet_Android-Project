package com.example.sudhir_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Form_Activity extends AppCompatActivity {
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databasereference;
    EditText et_username,et_email,et_phone,et_password,et_confirmpassword;
    RadioGroup rg_gender;
    RadioButton radioMale,radioFemale;

    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form_);
        getSupportActionBar().setTitle("Sign UP");

        firebasedatabase= FirebaseDatabase.getInstance();
        databasereference=firebasedatabase.getReference().child("Users");

        et_email=(EditText)findViewById(R.id.et_email);
        et_username=(EditText)findViewById(R.id.et_userename);
        et_phone=(EditText)findViewById(R.id.et_phone);
        et_password=(EditText)findViewById(R.id.et_password);
        et_confirmpassword=(EditText)findViewById(R.id.et_confirm_password);

        rg_gender=(RadioGroup)findViewById(R.id.radio_gender);

        radioMale=(RadioButton)findViewById(R.id.radio_male);
        radioFemale=(RadioButton)findViewById(R.id.radio_female);
    }

    public void btn_details_1(View view) {

        startActivity(new Intent(getApplicationContext(),Details_Page_1.class));
        if(et_phone.getText()==null){
            Toast t =Toast.makeText(getApplicationContext(),"phone field cant be left empty",Toast.LENGTH_LONG);
            t.show();
            saveUser();
        }
    }

    public void RadioClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender="male";
                    break;
            case R.id.radio_female:
                if (checked)
                    gender="female";
                    break;
        }
    }

    private void saveUser(){

        String username=et_username.getText().toString();
        String email=et_email.getText().toString();
        String password =et_password.getText().toString();
        String phone=et_phone.getText().toString();
        User user=new User(email,username,password,phone,gender,"");
        System.out.println(username+email+password+phone+username);
        databasereference.push().setValue(user);
    }
    private void clean(){
        et_email.setText("");
        et_username.setText("");
        et_confirmpassword.setText("");
        et_password.setText("");
        et_phone.setText("");
    }
}