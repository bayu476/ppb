package com.example.kalkusederhana;

public class OperasiModel {
    int id;
    String angka1, angka2, jenis_operasi, jumlah;

    public OperasiModel(int id, String angka1, String angka2, String jenis_operasi, String jumlah) {
        this.id = id;
        this.angka1 = angka1;
        this.angka2 = angka2;
        this.jenis_operasi = jenis_operasi;
        this.jumlah = jumlah;
    }


    public int getId() {
        return id;
    }
    public String getAngka1() {
        return angka1;
    }
    public String getAngka2() {
        return angka2;
    }
    public String getJenis_operasi() {
        return jenis_operasi;
    }
    public String getJumlahh() {
        return jumlah;
    }
}
