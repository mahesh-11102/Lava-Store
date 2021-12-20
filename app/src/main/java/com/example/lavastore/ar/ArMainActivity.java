package com.example.lavastore.ar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.lavastore.R;

public class ArMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("LAVA AR Zone");

        (findViewById(R.id.Arcard1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArMainActivity.this, Ar1Activity.class));
            }
        });

        (findViewById(R.id.Arcard2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArMainActivity.this, Ar2Activity.class));
            }
        });

        (findViewById(R.id.Arcard3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArMainActivity.this, Ar3Activity.class));
            }
        });

        (findViewById(R.id.Arcard4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArMainActivity.this, Ar4Activity.class));
            }
        });

    }
}