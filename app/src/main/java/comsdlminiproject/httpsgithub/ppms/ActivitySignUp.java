package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class ActivitySignUp extends AppCompatActivity implements View.OnClickListener {

    EditText etEnterEmail;
    EditText etEnterPassword;
    ProgressBar progresscircle;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEnterEmail= findViewById(R.id.etEnterEmail);
        etEnterPassword=findViewById(R.id.etEnterPassword);
        //progresscircle=findViewById(R.id.progesscircle);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.cardView1).setOnClickListener(this);
        findViewById(R.id.btnGoToLoginPage).setOnClickListener(this);

    }

    private void registerUser(){

        String email = etEnterEmail.getText().toString().trim();
        String password = etEnterPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEnterEmail.setError("Email is required");
            etEnterEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEnterEmail.setError("Please enter a valid email");
            etEnterEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etEnterPassword.setError("Password is required");
            etEnterPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etEnterPassword.setError("Minimum length of password should be 6");
            etEnterPassword.requestFocus();
            return;
        }

        //progresscircle.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    //progresscircle.setVisibility(View.GONE);
                    Toast.makeText(ActivitySignUp.this, "User is registered now", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SuccessfullyLoggedIn.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(ActivitySignUp.this, "You are already registered :)", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ActivitySignUp.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cardView1:
                registerUser();
                break;

            case R.id.btnGoToLoginPage:
                Intent intent= new Intent(getApplicationContext(),ActivityLogIn.class);
                startActivity(intent);
                break;
        }
    }
}
