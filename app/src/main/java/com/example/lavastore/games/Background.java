package com.example.lavastore.games;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.lavastore.R;


public class Background {

    int x,y;
    Bitmap background;

    public Background(int screenX, int screenY, Resources resources) {
        background = BitmapFactory.decodeResource(resources, R.drawable.background);

        background = Bitmap.createScaledBitmap(background,screenX,screenY,false);

    }


}
