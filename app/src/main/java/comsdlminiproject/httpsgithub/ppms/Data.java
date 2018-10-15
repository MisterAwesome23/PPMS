package comsdlminiproject.httpsgithub.ppms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Document;

import java.sql.SQLException;

public class Data extends AppCompatActivity {

    TextView tvShowRecords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvShowRecords = findViewById(R.id.tvShowRecords);
        tvShowRecords.setMovementMethod(new ScrollingMovementMethod());

        PetrolPumpDB db = new PetrolPumpDB(this);
        db.open();
        tvShowRecords.setText(db.getEntry());
        db.close();


    }
}


