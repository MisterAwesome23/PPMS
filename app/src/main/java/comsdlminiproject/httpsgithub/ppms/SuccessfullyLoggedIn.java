package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class SuccessfullyLoggedIn extends AppCompatActivity {


    Button btnOpenMap,btnGetLatestPetrolPrice,btnTallyAccount,btnViewRecords,btnOpenCctv;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logoutmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.LOGOUT:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),ActivityLogIn.class));
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_logged_in);

        btnOpenMap= findViewById(R.id.btnOpenMap);
        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Nearest petrol pump"));
                startActivity(intent);
            }
        });

        btnGetLatestPetrolPrice=findViewById(R.id.btnGetLatestPetrolPrice);
        btnGetLatestPetrolPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.bankbazaar.com/fuel/petrol-price-pune.html?ck=Y%2BziX71XnZjIM9ZwEflsyDYlRL7gaN4W0xhuJSr9Iq7aMYwRm2IPACTQB2XBBtGG&rc=1"));
                startActivity(intent);
            }
        });

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnTallyAccount= findViewById(R.id.btnTallyAccount);
        btnTallyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),InputData.class);
                startActivity(intent);
            }
        });


        btnViewRecords = findViewById(R.id.btnViewRecords);
        btnViewRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getApplicationContext(),Data.class));
                startActivity(new Intent(getApplicationContext(),DataRetrieved.class));
            }
        });

        btnOpenCctv= findViewById(R.id.btnOpenCctv);
        btnOpenCctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.mcu.iVMSHD");
                startActivity(intent);
            }
        });





    }


}
