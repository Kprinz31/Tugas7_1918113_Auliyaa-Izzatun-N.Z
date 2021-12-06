package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private PerpusDatabase db;
    private List<Perpustakaan> ListPerpustakaan = new ArrayList<Perpustakaan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new PerpusDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPerpustakaan);
        mListView = (ListView) findViewById(R.id.list_peminjam);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPerpustakaan.clear();
        List<Perpustakaan> perpustakaan = db.ReadPerpustakaan();
        for (Perpustakaan prs : perpustakaan) {
            Perpustakaan daftar = new Perpustakaan();
            daftar.set_id(prs.get_id());
            daftar.set_nama(prs.get_nama());
            daftar.set_judul(prs.get_judul());
            daftar.set_no_buku(prs.get_no_buku());
            daftar.set_tanggal(prs.get_tanggal());
            ListPerpustakaan.add(daftar);
            if ((ListPerpustakaan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Perpustakaan detailPrs = (Perpustakaan) o;
        String Sid = detailPrs.get_id();
        String Snama = detailPrs.get_nama();
        String Sjudul = detailPrs.get_judul();
        String Snobuku = detailPrs.get_no_buku();
        String Stanggal = detailPrs.get_tanggal();
        Intent goUpdate = new Intent(MainRead.this, MainUpdate.class);
        goUpdate.putExtra("Iid", Sid);
        goUpdate.putExtra("Inama", Snama);
        goUpdate.putExtra("Ijudul", Sjudul);
        goUpdate.putExtra("Inobuku", Snobuku);
        goUpdate.putExtra("Itanggal", Stanggal);
        startActivity(goUpdate);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPerpustakaan.clear();
        mListView.setAdapter(adapter_off);
        List<Perpustakaan> perpustakaan = db.ReadPerpustakaan();
        for (Perpustakaan prs : perpustakaan) {
            Perpustakaan daftar = new Perpustakaan();
            daftar.set_id(prs.get_id());
            daftar.set_nama(prs.get_nama());
            daftar.set_judul(prs.get_judul());
            daftar.set_no_buku(prs.get_no_buku());
            daftar.set_tanggal(prs.get_tanggal());
            ListPerpustakaan.add(daftar);
            if ((ListPerpustakaan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}