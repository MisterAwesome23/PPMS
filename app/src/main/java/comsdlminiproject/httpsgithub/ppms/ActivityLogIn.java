package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityLogIn extends AppCompatActivity implements View.OnClickListener{


    EditText etEnterEmail,etEnterPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        findViewById(R.id.btnGoToSignup).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);

        etEnterEmail = findViewById(R.id.etEnterEmail);
        etEnterPassword = findViewById(R.id.etEnterPassword);

        mAuth = FirebaseAuth.getInstance();

    }

    private void loginUser(){

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


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),SuccessfullyLoggedIn.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(ActivityLogIn.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnGoToSignup:
                Intent intent =new Intent(getApplicationContext(),ActivitySignUp.class);
                startActivity(intent);
                break;

            case R.id.btnLogin:
                loginUser();
                break;

        }
    }
}
