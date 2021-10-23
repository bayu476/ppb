package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PersegiActivity extends AppCompatActivity{
    private EditText nilai1;
    private TextView hasilke1;
    private TextView hasilluas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        nilai1 = (EditText) findViewById(R.id.editNilai1);
        hasilke1 = (TextView) findViewById(R.id.textHasilKe1);
        hasilluas = (TextView) findViewById(R.id.textHasilLuas);
    }
    public void KelilingPersegi (View view) {
        try {
            float nill = Float.parseFloat(nilai1.getText().toString());
            float hasil=nill*4;
            String result=String.valueOf(hasil);
            hasilke1.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error", "error Keliling");
        }
    }
    public void LuasPersegi(View view) {
        try {
            float nill = Float.parseFloat(nilai1.getText().toString());
            float hasil=nill*nill;
            String result=String.valueOf(hasil);
            hasilluas.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error","error Luas");
        }
    }
}