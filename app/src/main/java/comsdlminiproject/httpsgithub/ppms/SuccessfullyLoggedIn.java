package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessfullyLoggedIn extends AppCompatActivity {


    Button btnOpenMap,btnGetLatestPetrolPrice;
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


    }
}
