package com.example.kalkusederhana;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DBNAME = "db_kalkulator";
    private static final String TABLENAME = "kalkulator";

    private static String colID = "id";
    private static String colangka1 = "angka1";
    private static String colangka2 = "angka2";
    private static String coljenis_operasi = "jenis_operasi";
    private static String coljumlah = "jumlah";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLENAME + " (" +
                colID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colangka1 + " TEXT,"
                + colangka2 + " TEXT,"  + coljenis_operasi + " TEXT," + coljumlah + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
        onCreate(db);
    }

    public void insertData(String angka1, String angka2, String jenis_operasi, String jumlah){
        String insertData = "INSERT INTO "+ TABLENAME + " ("+ colangka1 +","+colangka2+","+ coljenis_operasi+","+ coljumlah+") VALUES ('"+angka1 +"', '"+angka2+"','"+jenis_operasi+"','"+jumlah+"')";
        this.getWritableDatabase().execSQL(insertData);
    }

    public void updateData(int id, String angka1, String angka2, String jenis_operasi, String jumlah){
        String updateData = "UPDATE "+TABLENAME+ " SET "+ colangka1 + "= '"+angka1 +"', "+colangka2 + "= '"+angka2 + "', "+coljenis_operasi+"= '"+jenis_operasi+"', "+jumlah+"='"+jumlah+"' WHERE "+colID +" ="+id;
        this.getWritableDatabase().execSQL(updateData);
    }

    public void deleteData(int id){
        String deleteData = "DELETE FROM "+TABLENAME +" WHERE id="+id;
        this.getWritableDatabase().execSQL(deleteData);
    }

    @SuppressLint("Range")
    public OperasiModel getData(int id){
        OperasiModel model = null;
        String selectData = "SELECT * FROM "+TABLENAME + " WHERE id="+String.valueOf(id);
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            model = new OperasiModel(Integer.parseInt(data.getString(data.getColumnIndex(colID))), data.getString(data.getColumnIndex(colangka1)), data.getString(data.getColumnIndex(colangka2)), data.getString(data.getColumnIndex(coljenis_operasi)), data.getString(data.getColumnIndex(coljumlah)));
        }
        return model;
    }

    @SuppressLint("Range")
    public List<OperasiModel> getAll() {
        List<OperasiModel> model = new ArrayList<>();
        String selectData = "SELECT * FROM " + TABLENAME;
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if (data.moveToFirst()) {
            do {

                model.add(new OperasiModel(Integer.parseInt(data.getString(data.getColumnIndex(colID))), data.getString(data.getColumnIndex(colangka1)), data.getString(data.getColumnIndex(colangka2)), data.getString(data.getColumnIndex(coljenis_operasi)), data.getString(data.getColumnIndex(coljumlah))));

            } while (data.moveToNext());
        }
        return model;
    }
}
