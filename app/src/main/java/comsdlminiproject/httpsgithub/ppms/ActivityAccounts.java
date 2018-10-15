package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityAccounts extends AppCompatActivity {

    EditText etCash,etDtCard,etSwipeCard;
    Button btnTallyValues,btnAddToRecords;

    DatabaseReference dbPetPump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        etCash= findViewById(R.id.etCash);
        etDtCard= findViewById(R.id.etDtCard);
        etSwipeCard= findViewById(R.id.etSwipeCard);
        btnTallyValues= findViewById(R.id.btnTallyValues);


        final double sumToTallyWith= Double.parseDouble(getIntent().getStringExtra("TotalSumForTally"));

        java.util.Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        dbPetPump = FirebaseDatabase.getInstance().getReference("Daily Details");



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

                String petprice,petsold,dieprice,diesold,date,petearn,dieearn,totearn;

                String id = dbPetPump.push().getKey();

                //String amtByCashText = Double.toString(amtByCash);

                petprice= getIntent().getStringExtra("PETROLPRICE");
                petsold= getIntent().getStringExtra("PETROLSOLD");
                dieprice= getIntent().getStringExtra("DIESELPRICE");
                diesold= getIntent().getStringExtra("DIESELSOLD");
                petearn = getIntent().getStringExtra("PETROLEARN");
                dieearn = getIntent().getStringExtra("DIESELEARN");
                totearn = getIntent().getStringExtra("TOTALEARN");

                java.util.Date c = Calendar.getInstance().getTime();
                //System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);


                PetPumpDB obj = new PetPumpDB(petsold,petprice,diesold,dieprice,petearn,dieearn,totearn,c.toString());

                dbPetPump.child(c.toString()).setValue(obj);

                Toast.makeText(ActivityAccounts.this, "Record Added.", Toast.LENGTH_SHORT).show();


                //PetrolPumpDB db= new PetrolPumpDB(ActivityAccounts.this);
                //db.open();
                //String petprice,petsold,dieprice,diesold,date;

                /*

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

                db.close();     */

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