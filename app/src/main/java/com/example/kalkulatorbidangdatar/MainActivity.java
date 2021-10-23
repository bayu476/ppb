package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bukaPersegi(View view) {
        Intent intent = new Intent(this, PersegiActivity.class);
        startActivity(intent);
    }
    public void bukaSegitiga(View view) {
        Intent intent = new Intent(this, SegitigaActivity.class);
        startActivity(intent);
    }
    public void bukaLingkaran(View view) {
        Intent intent = new Intent(this, LingkaranActivity.class);
        startActivity(intent);
    }
}