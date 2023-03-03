package com.example.week9app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView textView = findViewById(R.id.txtOutputText);
        String temp = "";
//        int c;
//        char ch;

//        try{
//            FileInputStream fin = openFileInput("MyFile.txt");
//            while((c = fin.read()) != -1){
//                ch = (char)c;
//                temp += Character.toString(ch);
//            }
//            textView.setText(temp);
//            fin.close();
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
        try{
            InputStream inputStream = openFileInput("MyFile.txt");
            String str;
            if(inputStream != null){
                InputStreamReader  inputStreamReader =new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((str = bufferedReader.readLine()) != null){
                    stringBuilder.append(str);
                }
                textView.setText(stringBuilder.toString());
                inputStream.close();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}