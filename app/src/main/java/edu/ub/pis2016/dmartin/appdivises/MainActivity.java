package edu.ub.pis2016.dmartin.appdivises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView actualCurrency;
    TextView first;
    TextView second;
    TextView result;
    Switch switchCurrency;
    Button btnCalculate;
    EditText value;

    float currencyEurostoDollars = 0.5f;
    float currencyDollarstoEuros = 2;
    float currencyValue = currencyEurostoDollars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actualCurrency = (TextView) findViewById(R.id.actualCurrency);
        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        switchCurrency =  (Switch) findViewById(R.id.switchCurrency);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        value = (EditText) findViewById(R.id.value);
        result = (TextView) findViewById(R.id.result);


        switchCurrency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (switchCurrency.isChecked()){
                    actualCurrency.setText(getString(R.string.dollarToEuro));
                    first.setText(getString(R.string.dollar));
                    second.setText(getString(R.string.euro));
                    currencyValue = currencyDollarstoEuros;
                }else {
                    actualCurrency.setText(getString(R.string.euroToDollar));
                    first.setText(getString(R.string.euro));
                    second.setText(getString(R.string.dollar));
                    currencyValue = currencyEurostoDollars;
                }
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCurrency();
            }
        });


    }

    private void calculateCurrency() {

        float resultat = Float.valueOf(value.getText().toString());
        resultat = resultat*currencyValue;
        result.setText(Float.toString(resultat));
    }

}
