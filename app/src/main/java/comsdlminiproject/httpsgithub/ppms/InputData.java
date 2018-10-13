package comsdlminiproject.httpsgithub.ppms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputData extends AppCompatActivity
{
    //TextView tvOprd, tvOprd2, tvClrd, tvClrd2, tvCost, tvCost2;
    //Button btnTally;
    //TextView tvSales, tvSales2, tvEarn, tvEarn2;        //to print results
    //EditText oprd,clrd,oprd2,clrd2,costP,costD;       //doesn't work

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        //setupUIViews();

    }

    /*public void setupUIViews()
    {
        tvSales = findViewById(R.id.tvSales);
        tvSales2 = findViewById(R.id.tvSales2);
        tvEarn = findViewById(R.id.tvEarn);
        tvEarn2 = findViewById(R.id.tvEarn2);
    }*/

    public void showSales(View view)
    {
        double oprdP, clrdP, oprdD, clrdD, msrpP, msrpD;
        double salesRes, earnRes, salesRes2, earnRes2;

        String salesResText,salesRes2Text,earnResText,earnRes2Text;
        String msrpPText,msrpDText;

        EditText oprd = (EditText) findViewById(R.id.tvOprd);
        EditText clrd = (EditText) findViewById(R.id.tvClrd);
        EditText oprd2 = (EditText) findViewById(R.id.tvOprd2);
        EditText clrd2 = (EditText) findViewById(R.id.tvClrd2);
        EditText cost1 = findViewById(R.id.tvCost);
        EditText cost2 = findViewById(R.id.tvCost2);

        /*
        Log.i("oprd", oprd.getText().toString());
        Log.i("clrd", clrd.getText().toString());
        Log.i("oprd2", oprd2.getText().toString());
        Log.i("clrd2", clrd2.getText().toString());
        Log.i("costP", costP.getText().toString());
        Log.i("costD", costD.getText().toString());

        Toast.makeText(this, oprd.getText().toString()+" "+clrd.getText().toString()+" "+costP.getText().toString()+ "\n"+ oprd2.getText().toString()+ " "+clrd2.getText().toString()+ " "+costD.getText().toString(), Toast.LENGTH_SHORT).show();
        */

        oprdP = Double.parseDouble(oprd.getText().toString());
        clrdP = Double.parseDouble(clrd.getText().toString());
        oprdD = Double.parseDouble(oprd2.getText().toString());
        clrdD = Double.parseDouble(clrd2.getText().toString());
        msrpP = Double.parseDouble(cost1.getText().toString());
        msrpD = Double.parseDouble(cost2.getText().toString());

        salesRes = oprdP - clrdP;
        salesRes2 = oprdD - clrdD;
        earnRes = salesRes * msrpP;
        earnRes2 = salesRes2 * msrpD;

        salesResText = Double.toString(salesRes);
        salesRes2Text = Double.toString(salesRes2);
        earnResText = Double.toString(earnRes);
        earnRes2Text = Double.toString(earnRes2);
        msrpDText= Double.toString(msrpD);
        msrpPText= Double.toString(msrpP);


        Intent intent = new Intent(InputData.this, showSales.class);
        intent.putExtra("SALES1", salesResText);
        intent.putExtra("EARN1", earnResText);
        intent.putExtra("SALES2", salesRes2Text);
        intent.putExtra("EARN2", earnRes2Text);
        intent.putExtra("PETROLSOLD", salesResText);
        intent.putExtra("PETROLPRICE", msrpPText);
        intent.putExtra("DIESELSOLD", salesRes2Text);
        intent.putExtra("DIESELPRICE", msrpDText);
        startActivity(intent);

        //tvSales.setText(salesResText);
        //tvSales2.setText(salesRes2Text);
        //tvEarn.setText(earnResText);
        //tvEarn2.setText(earnRes2Text);

    }
}
