package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAccounts extends AppCompatActivity {

    EditText etCash,etDtCard,etSwipeCard;
    Button btnTallyValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        etCash= findViewById(R.id.etCash);
        etDtCard= findViewById(R.id.etDtCard);
        etSwipeCard= findViewById(R.id.etSwipeCard);
        btnTallyValues= findViewById(R.id.btnTallyValues);


        final double sumToTallyWith= Double.parseDouble(getIntent().getStringExtra("TotalSumForTally"));


        btnTallyValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                double amtByCash= Double.parseDouble(etCash.getText().toString());
                double amtByDtCard= Double.parseDouble(etDtCard.getText().toString());
                double amtBySwipeCard= Double.parseDouble(etSwipeCard.getText().toString());

                if( (amtByCash)+(amtByDtCard)+(amtBySwipeCard)==sumToTallyWith)
                {
                    Toast.makeText(ActivityAccounts.this, "All values are tallied. Good to go.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),SuccessfullyLoggedIn.class);
                    startActivity(i);


                }
                else
                {
                    Toast.makeText(ActivityAccounts.this, "Cash value mismatch", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
