package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate  extends AppCompatActivity {
    private PerpusDatabase db;
    private EditText Enama, Ejudul, Enobuku, Etanggal;
    private String Snama, Sjudul, Snobuku, Stanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new PerpusDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Enobuku = (EditText) findViewById(R.id.create_no_buku);
        Etanggal = (EditText) findViewById(R.id.create_tanggal);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjudul = String.valueOf(Ejudul.getText());
                Snobuku = String.valueOf(Enobuku.getText());
                Stanggal = String.valueOf(Etanggal.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                }
                else if (Sjudul.equals("")) {
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul buku", Toast.LENGTH_SHORT).show();
                }
                else if (Snobuku.equals("")) {
                    Enobuku.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nomor buku", Toast.LENGTH_SHORT).show();
                }
                else if (Stanggal.equals("")) {
                    Etanggal.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tanggal peminjaman", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Ejudul.setText("");
                    Enobuku.setText("");
                    Etanggal.setText("");
                    Toast.makeText(MainCreate.this, "Data telah disimpan", Toast.LENGTH_SHORT).show();
                    db.CreatePerpustakaan(new Perpustakaan(null, Snama, Sjudul, Snobuku, Stanggal));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
