package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LingkaranActivity extends AppCompatActivity{
    private EditText nilai1;
    private TextView hasilkel;
    private TextView hasilluas;
    float phi=3.14F;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        nilai1 = (EditText) findViewById(R.id.editNilai1);
        hasilkel = (TextView) findViewById(R.id.textHasilKe1);
        hasilluas = (TextView) findViewById(R.id.textHasilLuas);
    }
    public void KelilingLingkaran(View view){
        try {
            float nill = Float.parseFloat(nilai1.getText().toString());
            float hasil=2*phi*nill;
            String result=String.valueOf(hasil);
            hasilkel.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error", "error Keliling");
        }
    }
    public void LuasLingkaran(View view){
        try {
            float nill = Float.parseFloat(nilai1.getText().toString());
            float hasil=phi*(float)(Math.pow(nill,2));
            String result=String.valueOf(hasil);
            hasilluas.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error", "error Luas");
        }
    }
}
