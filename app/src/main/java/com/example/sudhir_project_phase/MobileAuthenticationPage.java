package com.example.sudhir_project_phase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MobileAuthenticationPage extends AppCompatActivity {
    private EditText editNum, editCode;
    private Button btnVerify;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String verificationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_authentication_page);
        FirebaseApp.initializeApp(this);
        userIsLoggedIn();
        editCode = (EditText) findViewById(R.id.edcode);

        editNum = (EditText) findViewById(R.id.ednum);

        btnVerify = (Button) findViewById(R.id.verbtn);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificationId !=null)
                {verifyNumberWithCode();}
                else
                    startPhoneNumberVerification();
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCred(phoneAuthCredential);
            }

            @Override
            public void onCodeSent(@NonNull String verifaction, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verifaction, forceResendingToken);
                verificationId=verifaction;
                btnVerify.setText("Verify Code");

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(getApplicationContext(), "Error with msg", Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void verifyNumberWithCode()
    {
        PhoneAuthCredential cred=PhoneAuthProvider.getCredential(verificationId,editCode.getText().toString());
        signInWithPhoneAuthCred(cred);
    }

    private void signInWithPhoneAuthCred(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    userIsLoggedIn();
                }
            }

        });
    }

    private void userIsLoggedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Intent i = new Intent(getApplicationContext(), MainHomePage.class);

            startActivity(i);
            finish();
            return;
        }
    }

    private void startPhoneNumberVerification() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                editNum.getText().toString(), 60, TimeUnit.SECONDS, this, mCallbacks);
    }
}

