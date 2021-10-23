package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegitigaActivity extends AppCompatActivity{
    private EditText nilai1;
    private EditText nilai2;
    private TextView hasilkel;
    private TextView hasilluas;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        nilai1 = (EditText) findViewById(R.id.editNilai1);
        nilai2 = (EditText) findViewById(R.id.editNilai2);
        hasilkel = (TextView) findViewById(R.id.textHasilKe1);
        hasilluas = (TextView) findViewById(R.id.textHasilKe2);
    }
    public float cariSisiMiring(float a, float b){
        float nil3 = a+b;
        return nil3;
    }
    float nil3;
    public void KelilingSegitiga(View view){
        try {
            float nil1 = Float.parseFloat(nilai1.getText().toString());
            float nil2 = Float.parseFloat(nilai2.getText().toString());
            float nil3 = (float) (Math.sqrt(Math.pow(nil1,2)+Math.pow(nil2,2)));
            float hasil=nil1+nil2+nil3;
            String result=String.valueOf(hasil);
            hasilkel.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error", "error Keliling");
        }
    }
    public void LuasSegitiga(View view){
        try {
            float setengah= 0.5F;
            float nil1 = Float.parseFloat(nilai1.getText().toString());
            float nil2 = Float.parseFloat(nilai2.getText().toString());
            float hasil=setengah*nil1*nil2;
            String result=String.valueOf(hasil);
            hasilluas.setText(result);
        }
        catch (NumberFormatException e){
            Log.d("Error", "error Luas");
        }
    }
}

