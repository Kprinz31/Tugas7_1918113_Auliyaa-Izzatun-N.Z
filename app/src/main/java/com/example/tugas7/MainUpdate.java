package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdate  extends AppCompatActivity {
    private PerpusDatabase db;
    private String Sid, Snama, Sjudul, Snobuku, Stanggal;
    private EditText Enama, Ejudul, Enobuku, Etanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);
        db = new PerpusDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjudul = i.getStringExtra("Ijudul");
        Snobuku = i.getStringExtra("Inobuku");
        Stanggal = i.getStringExtra("Itanggal");
        Enama = (EditText) findViewById(R.id.update_nama);
        Ejudul = (EditText) findViewById(R.id.update_judul);
        Enobuku = (EditText) findViewById(R.id.update_no_buku);
        Etanggal = (EditText) findViewById(R.id.update_tanggal);
        Enama.setText(Snama);
        Ejudul.setText(Sjudul);
        Enobuku.setText(Snobuku);
        Etanggal.setText(Stanggal);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjudul = String.valueOf(Ejudul.getText());
                Snobuku = String.valueOf(Enobuku.getText());
                Stanggal = String.valueOf(Etanggal.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi judul buku", Toast.LENGTH_SHORT).show();
                } else if (Snobuku.equals("")){
                    Enobuku.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi nomor buku", Toast.LENGTH_SHORT).show();
                } else if (Stanggal.equals("")){
                    Etanggal.requestFocus();
                    Toast.makeText(MainUpdate.this, "Silahkan isi tanggal pinjam", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePerpustakaan(new Perpustakaan(Sid, Snama, Sjudul, Snobuku, Stanggal));
                    Toast.makeText(MainUpdate.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePerpustakaan(new Perpustakaan(Sid, Snama, Sjudul, Snobuku, Stanggal));
                Toast.makeText(MainUpdate.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

