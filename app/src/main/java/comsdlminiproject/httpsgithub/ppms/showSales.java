package comsdlminiproject.httpsgithub.ppms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showSales extends AppCompatActivity
{
    TextView tvSales, tvSales2, tvEarn, tvEarn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sales);

        setupUIViews();
        //(TextView) tvSales = (TextView) findViewById(R.id.tvSales);
        tvSales.setText(getIntent().getStringExtra("SALES1") + "\t L");
        tvSales2.setText(getIntent().getStringExtra("SALES2") + "\t L");
        tvEarn.setText("Rs." + getIntent().getStringExtra("EARN1"));
        tvEarn2.setText("Rs." + getIntent().getStringExtra("EARN2"));

    }

    public void setupUIViews()
    {
        tvSales = findViewById(R.id.tvSales);
        tvSales2 = findViewById(R.id.tvSales2);
        tvEarn = findViewById(R.id.tvEarn);
        tvEarn2 = findViewById(R.id.tvEarn2);
    }
}
