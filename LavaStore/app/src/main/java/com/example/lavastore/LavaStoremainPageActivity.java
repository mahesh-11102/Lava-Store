package com.example.lavastore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lavastore.games.Games;
import com.example.lavastore.loadingPages.ArLoadingActivity;
import com.example.lavastore.loadingPages.LoadingGame;
import com.example.lavastore.loadingPages.StreamLoadingActivity;


public class LavaStoremainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lava_storemain_page);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        (findViewById(R.id.gamecard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LavaStoremainPageActivity.this, LoadingGame.class));
            }
        });

        (findViewById(R.id.streamcard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LavaStoremainPageActivity.this, StreamLoadingActivity.class));
            }
        });

        (findViewById(R.id.arcard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LavaStoremainPageActivity.this, ArLoadingActivity.class));
            }
        });


    }
}