package com.example.tugas7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Perpustakaan> Perpustakaan;
    public CustomListAdapter(Activity activity, List<Perpustakaan> Perpustakaan) {
        this.activity = activity;
        this.Perpustakaan = Perpustakaan;
    }
    @Override
    public int getCount() {
        return Perpustakaan.size();
    }
    @Override
    public Object getItem(int location) {
        return Perpustakaan.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView judul = (TextView) convertView.findViewById(R.id.text_judul);
        TextView no_buku = (TextView) convertView.findViewById(R.id.text_no_buku);
        TextView tanggal = (TextView) convertView.findViewById(R.id.text_tanggal);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Perpustakaan m = Perpustakaan.get(position);
        nama.setText("Nama : "+ m.get_nama());
        judul.setText("Judul Buku : "+ m.get_judul());
        no_buku.setText("No Buku : "+ m.get_no_buku());
        tanggal.setText("Tanggal Pinjam : "+ m.get_tanggal());
        return convertView;
    }
}
