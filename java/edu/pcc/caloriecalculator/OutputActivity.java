package edu.pcc.caloriecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OutputActivity extends AppCompatActivity {

    public static final String TAG = "OutputActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();

        float weightAsLb = intent.getFloatExtra(MainActivity.EXTRA_WEIGHT, 0.0f);
        float metValue = intent.getFloatExtra(MainActivity.EXTRA_MET, 0);

        // Log.d(TAG, "metValue: " + metValue);

        float weightAsKg = weightAsLb * 0.454f;
        float burnRate = weightAsKg * metValue;

        // Log.d(TAG, "weightAsLb: " + weightAsLb);
        // Log.d(TAG, "weightAsKg: " + weightAsKg);

        TextView calorieBurnRate = (TextView) findViewById(R.id.calorieBurnRate);

        DecimalFormat format = new DecimalFormat("#.##");
        calorieBurnRate.setText(format.format(burnRate));
    }
}
