package com.example.lavastore.loadingPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.lavastore.R;
import com.example.lavastore.games.Games;
import com.example.lavastore.streams.StreamActivity;

public class StreamLoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_loading);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent( StreamLoadingActivity.this, StreamActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        td.start();
    }
}