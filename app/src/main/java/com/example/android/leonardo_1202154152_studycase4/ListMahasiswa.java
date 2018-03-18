package com.example.android.leonardo_1202154152_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {
    //pendeklarasian variabel
    public ListView mList;
    private Button mButton;
    private ProgressBar mBar;
    private ItemList itemList;
    private String[] mahasiswa = {
            "Leo", "Regina", "Helen", "Gary", "Nathan", "Noni", "Randy", "Lauren", "Vanny", "Angelina"}; //array yang akan digunakan


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);
        //meset variabel diatas ke id-id yang sesuai
        mList = findViewById(R.id.listView);
        mButton = findViewById(R.id.btnAsync);
        mBar = findViewById(R.id.bar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());

        mList.setAdapter(adapter);
    }


    //meset listener ketika button diklik
    public void startAsync(View view) {
        itemList = new ItemList();
        itemList.execute();
    }


    public class ItemList extends AsyncTask<Void, String, Void> {

        private ArrayAdapter<String> mAdapter; //membuat array adapter
        private int mCounter = 1;
        ProgressDialog mDialog = new ProgressDialog(ListMahasiswa.this);


        @Override
        protected void onPreExecute() {
            mAdapter = (ArrayAdapter<String>) mList.getAdapter();
            mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mDialog.setTitle("Please wait while the data is being loaded");

            mDialog.setProgress(0);
            mDialog.show();
        }

        //melakukan proses di background
        @Override
        protected Void doInBackground(Void... params) {
            for (String data : mahasiswa){
                publishProgress(data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mAdapter.add(values[0]);

            //menghitung persen pada dialog
            Integer status = (int) ((mCounter / (float) mahasiswa.length) * 100);
            mBar.setProgress(status);

            //set status pada ProgressDialog
            mDialog.setProgress(status);

            //set message will not working when using horizontal loading
            mDialog.setMessage(String.valueOf(status + "%"));
            mCounter++;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            //hide progreebar
            mBar.setVisibility(View.GONE);

            //remove progress dialog
            mDialog.dismiss();
            mList.setVisibility(View.VISIBLE);
        }
    }
}
