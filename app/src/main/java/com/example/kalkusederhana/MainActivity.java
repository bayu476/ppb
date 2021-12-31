package com.example.kalkusederhana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText angka1, angka2;
    RadioGroup operasi;
    RadioButton operasi_hitung;
    Button hitung;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<OperasiModel> list = new ArrayList<>();
    DatabaseHelper dbhelp;

    int jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();

        dbhelp = new DatabaseHelper(this);
        recyclerView = (RecyclerView)findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        operasi = (RadioGroup) findViewById(R.id.operasi);
        hitung = (Button) findViewById(R.id.hitung);

        hitung = findViewById(R.id.hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = operasi.getCheckedRadioButtonId();
                String jenis_operasi = "";

                operasi_hitung = (RadioButton) findViewById(selectedId);

                switch(operasi_hitung.getText().toString()) {
                    case "Tambah" :
                        jumlah = Integer.parseInt(angka1.getText().toString()) + Integer.parseInt(angka2.getText().toString());
                        jenis_operasi = " + ";
                        break;
                    case "Kurang" :
                        jumlah = Integer.parseInt(angka1.getText().toString()) - Integer.parseInt(angka2.getText().toString());
                        jenis_operasi = " - ";
                        break;
                    case "Kali" :
                        jumlah = Integer.parseInt(angka1.getText().toString()) * Integer.parseInt(angka2.getText().toString());
                        jenis_operasi = " x ";
                        break;
                    case "Bagi" :
                        jumlah = Integer.parseInt(angka1.getText().toString()) / Integer.parseInt(angka2.getText().toString());
                        jenis_operasi = " : ";
                        break;
                    default:
                        jumlah = 0;
                }

                dbhelp.insertData(angka1.getText().toString(), angka2.getText().toString(), jenis_operasi, String.valueOf(jumlah));
                Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                angka1.getText().clear();
                angka2.getText().clear();
                list = dbhelp.getAll();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        list = dbhelp.getAll();
        adapter = new MainAdapter(this, list);

        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public class MainAdapter extends RecyclerView.Adapter<MainActivity.MainAdapter.ListHolder>{
        Context context;
        List<OperasiModel> list;

        public MainAdapter(Context context, List<OperasiModel> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public MainAdapter.ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
            return new MainActivity.MainAdapter.ListHolder(v);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
            final OperasiModel model = list.get(position);
            holder.operasi.setText(model.getAngka1() + " " + model.getJenis_operasi() + " " + model.getAngka2());
            holder.jumlah.setText("= " + model.getJumlahh());

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Yakin Menghapus Data?");
                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dbhelp.deleteData(model.getId());
                            dialogInterface.dismiss();
                            list = dbhelp.getAll();
                            adapter.notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        public class ListHolder extends RecyclerView.ViewHolder{
            TextView operasi, jumlah;
            Button delete;
            public ListHolder(View itemView) {
                super(itemView);
                operasi = (TextView)itemView.findViewById(R.id.operasi);
                jumlah = (TextView)itemView.findViewById(R.id.jumlah);
//                update = (ImageButton)itemView.findViewById(R.id.btnUpdate);
                delete = (Button) itemView.findViewById(R.id.hapus);
            }
        }
    }
}