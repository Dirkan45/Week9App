package com.example.week9app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.txtOutput);
        ImageView imageView = findViewById(R.id.imageSec);
        Button btnWrite = findViewById(R.id.btnWrite);
        Button btnThird = findViewById(R.id.btnThird);

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Second.this, Third.class));
            }
        });

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        int years = preferences.getInt("YEARS", 0);
        float amount = preferences.getFloat("AMOUNT", 0);
        float iRate = preferences.getFloat("IRATE", 0);

        float interestAmount = iRate/(years * 12) * amount;
        float total = amount + interestAmount;
        float monthlyPayment = total / (years * 12);
        DecimalFormat format = new DecimalFormat("$##.##");
        String str = "The monthly payment is"+ format.format(monthlyPayment);
        textView.setText(str);

        if(years == 3)
            imageView.setImageResource(R.drawable.three);
        else if (years == 4)
            imageView.setImageResource(R.drawable.four);
        else if (years == 5)
            imageView.setImageResource(R.drawable.five);
        else
            textView.setText("Enter 3 or 4 or 5 for years");

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //One method
//                    FileOutputStream fout = openFileOutput("MyFile.txt", MODE_APPEND);
//                    fout.write(str.getBytes(StandardCharsets.UTF_8));
//                    fout.write("\n".getBytes(StandardCharsets.UTF_8));
                    //Another method
                    OutputStreamWriter fout =
                            new OutputStreamWriter(openFileOutput("MyFile.txt", MODE_APPEND));
                    fout.write(str + "\n");
                    Toast.makeText(Second.this, "data is saved in the file",
                            Toast.LENGTH_LONG).show();
                    fout.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}