package com.example.week9app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int yearsEntered;
    float lAmount;
    float interestRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText years = findViewById(R.id.editxtYears);
        EditText amount = findViewById(R.id.editxtAmount);
        EditText iRate = findViewById(R.id.editxtInterest);
        Button button = findViewById(R.id.btnPayment);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                yearsEntered = Integer.parseInt(years.getText().toString());
                lAmount = Float.parseFloat(amount.getText().toString());
                interestRate = Float.parseFloat(iRate.getText().toString());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("YEARS", yearsEntered);
                editor.putFloat("AMOUNT", lAmount);
                editor.putFloat("IRATE", interestRate);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Second.class));

            }
        });
    }
}