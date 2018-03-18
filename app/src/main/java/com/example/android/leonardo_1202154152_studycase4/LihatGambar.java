package com.example.android.leonardo_1202154152_studycase4;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LihatGambar extends AppCompatActivity {
    private EditText uURL;
    private ImageView iImage;
    private String imageLink;
    private Button btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_gambar);
        uURL = findViewById(R.id.linkImg);
        iImage = findViewById(R.id.imageResult);
        btnImage = findViewById(R.id.btnSearch);

    }

    public void searchPic(View view) {
        imageLink = uURL.getText().toString(); //mengambil url yang ada pada edittext menjadi string
        ImageDownloader imageDownloader = new ImageDownloader(); //deklarasi imagedownloader
        imageDownloader.execute(imageLink); //mengexecute link url
    }


    public class ImageDownloader extends AsyncTask<String, Void, String> {

        //melakukan proses di background
        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(String imageLink) {
            super.onPostExecute(imageLink);
            Picasso.get().load(imageLink).placeholder(R.mipmap.ic_launcher).into(iImage); //mengambil gambar dari internet menggunakan picasso
        }
    }
}
