package com.example.lavastore.streams;

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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lavastore.R;
import com.example.lavastore.games.Games;
import com.example.lavastore.webActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class StreamActivity extends AppCompatActivity {


    private  int[]  movies = new int[]{
            R.drawable.movie1,R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
        R.drawable.movie5,R.drawable.movie6,R.drawable.movie7
    };

    private String[] movieTitle = new String[]{
        "Mirzapur ", "The Big Day","Bombay Begums" , "Tandav", "The Family Man: Part- 2",
            "Inside Edge", "Radhe"
    };

    String[] urlsmovie = new String[]{
            "https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&hl=en_IN&gl=US","https://play.google.com/store/apps/details?id=com.netflix.mediaclient&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.netflix.mediaclient&hl=en_IN&gl=US","https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&hl=en_IN&gl=US",
            "https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&hl=en_IN&gl=US","https://play.google.com/store?utm_source=apac_med&utm_medium=hasem&utm_content=Oct0121&utm_campaign=Evergreen&pcampaignid=MKT-EDR-apac-in-1003227-med-hasem-py-Evergreen-Oct0121-Text_Search_BKWS-BKWS%7cONSEM_kwid_43700065205026379_creativeid_535350509666_device_c&gclid=Cj0KCQiAqvaNBhDLARIsAH1Pq50iastyJP8GHS5KrfF1mMoGzi2YQhQkIwoqpkclvYXY3GlG2Dn6IQYaAmFcEALw_wcB&gclsrc=aw.ds"


    };


    Button stream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        stream = findViewById(R.id.streambtn);

        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(StreamActivity.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetgamelayout);
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM );
            }
        });


        CarouselView carouselView2 = findViewById(R.id.carouselView2);


        carouselView2.setPageCount(movies.length);
        carouselView2.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(movies[position]);
            }
        });

        carouselView2.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(StreamActivity.this,movieTitle[position]+"",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), webActivity.class);
                i.putExtra("links",urlsmovie[position]);
                startActivity(i);
            }
        });
    }
}
