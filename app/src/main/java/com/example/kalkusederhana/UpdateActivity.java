package com.example.kalkusederhana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText angka1, angka2;
    Button hitung;
    OperasiModel model;
    DatabaseHelper dbhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = (EditText)findViewById(R.id.angka1);
        angka2 = (EditText)findViewById(R.id.angka2);
        hitung = (Button)findViewById(R.id.hitung);
        dbhelp = new DatabaseHelper(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            model = dbhelp.getData(bundle.getInt("ID"));
            angka1.setText(model.getAngka1());
            angka2.setText(model.getAngka2());
        }
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelp.updateData(model.getId(), angka1.getText().toString(), angka2.getText().toString(), model.getJenis_operasi(), model.getJumlahh());
                finish();
            }
        });
    }
}
