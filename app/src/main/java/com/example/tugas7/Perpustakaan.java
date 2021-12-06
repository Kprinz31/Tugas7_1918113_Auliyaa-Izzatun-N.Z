package com.example.tugas7;

public class Perpustakaan {
    private String _id, _nama, _judul, _no_buku, _tanggal;
    public Perpustakaan (String id, String nama, String judul, String no_buku, String tanggal) {
        this._id = id;
        this._nama = nama;
        this._judul = judul;
        this._no_buku = no_buku;
        this._tanggal = tanggal;
    }
    public Perpustakaan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_no_buku() {
        return _no_buku;
    }
    public void set_no_buku(String _no_buku) {
        this._no_buku = _no_buku;
    }
    public String get_tanggal() {
        return _tanggal;
    }
    public void set_tanggal(String _tanggal) {
        this._tanggal = _tanggal;
    }
}

