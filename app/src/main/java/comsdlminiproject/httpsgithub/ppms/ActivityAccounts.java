package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityAccounts extends AppCompatActivity {

    EditText etCash,etDtCard,etSwipeCard;
    Button btnTallyValues,btnAddToRecords;

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
                }
                else
                {
                    Toast.makeText(ActivityAccounts.this, "Value mismatch", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAddToRecords= findViewById(R.id.btnAddToRecords);
        btnAddToRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PetrolPumpDB db= new PetrolPumpDB(ActivityAccounts.this);
                db.open();
                String petprice,petsold,dieprice,diesold,date;



                petprice= getIntent().getStringExtra("PETROLPRICE");
                petsold= getIntent().getStringExtra("PETROLSOLD");
                dieprice= getIntent().getStringExtra("DIESELPRICE");
                diesold= getIntent().getStringExtra("DIESELSOLD");

                java.util.Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);


                db.createEntry(petprice,petsold,dieprice,diesold,formattedDate);
                Toast.makeText(ActivityAccounts.this, "Added to database.", Toast.LENGTH_SHORT).show();

                db.close();

                Intent intent = new Intent(getApplicationContext(),SuccessfullyLoggedIn.class);
                startActivity(intent);
            }
        });






    }
}


        /*
Date c = Calendar.getInstance().getTime();
System.out.println("Current time => " + c);

SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
String formattedDate = df.format(c);
* */