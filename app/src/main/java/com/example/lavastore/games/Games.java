package com.example.lavastore.games;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.lavastore.R;
import com.example.lavastore.loadingPages.LoadingGame;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Games extends AppCompatActivity {


    private  int[]  mImages = new int[]{
            R.drawable.amongus, R.drawable.freefire,R.drawable.goindballs,R.drawable.ludo,
            R.drawable.pokemongo,R.drawable.pubg,R.drawable.roblox
    };

    private  String[] mImagesTitle = new String[]{
            "Among Us","Garena FreeFire", " GoingBalls","ludo King",
            "Pokemon Go", "PlayeUnkown  BattleGround", "Roblox"
    };


    String urlsgames[] = new String[]{
            "https://play.google.com/store/apps/details?id=com.innersloth.spacemafia&hl=en_IN&gl=US","https://play.google.com/store/apps/details?id=com.dts.freefireth&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.pronetis.ironball2&hl=en_IN&gl=US","https://play.google.com/store/apps/details?id=com.ludo.king&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.nianticlabs.pokemongo&hl=en_IN&gl=US", "https://play.google.com/store/apps/details?id=com.pubg.imobile&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.roblox.client&hl=en_IN&gl=US"

    };

    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        click = findViewById(R.id.button);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Games.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomgamelayout);

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM );
            }
        });


        CarouselView carouselView = findViewById(R.id.carouselView);

        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Games.this,mImagesTitle[position]+"",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), com.example.lavastore.webActivity.class );
                i.putExtra("links",urlsgames[position]);

                startActivity(i);
            }
        });


    }
}