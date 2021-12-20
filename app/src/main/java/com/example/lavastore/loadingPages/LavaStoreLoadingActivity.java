package com.example.lavastore.loadingPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lavastore.LavaStoremainPageActivity;
import com.example.lavastore.R;


public class LavaStoreLoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lava_store_loading);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){
            public void run(){
                try{
                    sleep(5100);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent( LavaStoreLoadingActivity.this, LavaStoremainPageActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        td.start();

    }
}