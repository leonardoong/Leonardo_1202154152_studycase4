package com.example.android.leonardo_1202154152_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void allList(View view) {
        Intent x = new Intent(this, ListMahasiswa.class); //pembuatan intent untuk ke class list mahasiswa
        startActivity(x); //memulai intent x
    }

    public void lihatGambar(View view) {
        Intent y = new Intent(this, LihatGambar.class); // pembuatan intent untuk ke class lihat gambar
        startActivity(y); //memulai intent y
    }
}
