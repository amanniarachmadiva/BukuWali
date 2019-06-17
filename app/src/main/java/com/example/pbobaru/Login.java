package com.example.pbobaru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/* Class Login berisi method untuk login sesuai username dan password pengguna.*/

/* Class Login menerapkan konsep Inheritance, yaitu pewarisan dari class AppCompatActivity yang
merupakan bawaan dari Android Stuido. Hal ini ditunjukkan dengan keyword "extends". */

/* Class Login juga menerapkan konsep Encapsulation dimana variabel-variabel yang terdapat di
class Login bersifat private. */

public class Login extends AppCompatActivity {

    private Button button;
    private FirebaseAuth firebaseAuth;
    private EditText username, password;
    private ProgressDialog progressDialog;

    /* Override method di bawah merupakan penerapan konsep Polymorphism */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        firebaseAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = (Button) findViewById(R.id.login);

        progressDialog = new ProgressDialog(this);

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            opendashboard();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }

    public void opendashboard(){
        /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void userLogin(){
        String usernameSt = username.getText().toString().trim();
        String passwordSt = password.getText().toString().trim();

        if(TextUtils.isEmpty(usernameSt)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passwordSt)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging in..");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(usernameSt, passwordSt).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    finish();
                    opendashboard();
                } else{
                    Toast.makeText(Login.this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}
