package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private ArrayList<String> infoMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoMakanan, namaMakanan, infoMakanan, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){
        namaMakanan.add("Pecel Lele");
        fotoMakanan.add("https://img.qraved.co/v2/image/data/24838765-180436195887369-594329036025495552-n-1527026471430-m.jpeg");
        infoMakanan.add("Pecel lele dan lalapan segar");

        namaMakanan.add("Pecel Ayam");
        fotoMakanan.add("https://obs.line-scdn.net/0hEiCxl03xGkZ-ATHoQHdlEURXGSlNbQlFGjdLWC5vRHIGY1USQGRVKF1RFyVUYV0YEDdVI1sJAXcAMFkUEmdV/w644");
        infoMakanan.add("Pecel ayam dan lalapan segar");

        namaMakanan.add("Lunpia");
        fotoMakanan.add("https://cdn1.katadata.co.id/media/images/temp/2020/05/26/Lumpia-Semarang-2020_05_26-17_50_16_a5ddc796ff28186fde5d4a967f236c73.jpg");
        infoMakanan.add("Lunpia goreng dan kukus. Berisi rebung dan daging");

        namaMakanan.add("Getuk");
        fotoMakanan.add("https://cdn.idntimes.com/content-images/post/20210209/144086332-115845280439768-2876090057827827612-n-fc498fdaabd7d3eeadbc4fee41d116b1.jpg");
        infoMakanan.add("Makanan tradisional yang melegenda");

        prosesRecyclerViewAdapter();
    }

}