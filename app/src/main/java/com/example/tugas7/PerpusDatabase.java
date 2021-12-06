package com.example.tugas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PerpusDatabase  extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_perpus";
    private static final String tb_perpustakaan = "tb_perpustakaan";
    private static final String tb_perpustakaan_id = "id";
    private static final String tb_perpustakaan_nama = "nama";
    private static final String tb_perpustakaan_judul = "judul";
    private static final String tb_perpustakaan_nobuku = "nobuku";
    private static final String tb_perpustakaan_tanggal = "tanggal";
    private static final String CREATE_TABLE_PERPUSTAKAAN = "CREATE TABLE " +
    tb_perpustakaan +"("
            + tb_perpustakaan_id + " INTEGER PRIMARY KEY ,"
            + tb_perpustakaan_nama + " TEXT ,"
            + tb_perpustakaan_judul + " TEXT ,"
            + tb_perpustakaan_nobuku + " TEXT ,"
            + tb_perpustakaan_tanggal + " TEXT " + ")";
    public PerpusDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERPUSTAKAAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreatePerpustakaan(Perpustakaan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perpustakaan_id, data.get_id());
        values.put(tb_perpustakaan_nama, data.get_nama());
        values.put(tb_perpustakaan_judul, data.get_judul());
        values.put(tb_perpustakaan_nobuku, data.get_no_buku());
        values.put(tb_perpustakaan_tanggal, data.get_tanggal());
        db.insert(tb_perpustakaan, null, values);
        db.close();
    }
    public List<Perpustakaan> ReadPerpustakaan() {
        List<Perpustakaan> listPrs = new ArrayList<Perpustakaan>();
        String selectQuery = "SELECT * FROM " + tb_perpustakaan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Perpustakaan data = new Perpustakaan();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_judul(cursor.getString(2));
                data.set_no_buku(cursor.getString(3));
                data.set_tanggal(cursor.getString(4));
                listPrs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listPrs;
    }
    public int UpdatePerpustakaan (Perpustakaan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perpustakaan_nama, data.get_nama());
        values.put(tb_perpustakaan_judul, data.get_judul());
        values.put(tb_perpustakaan_nobuku, data.get_no_buku());
        values.put(tb_perpustakaan_tanggal, data.get_tanggal());
        return db.update(tb_perpustakaan, values, tb_perpustakaan_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePerpustakaan(Perpustakaan data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_perpustakaan,tb_perpustakaan_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
