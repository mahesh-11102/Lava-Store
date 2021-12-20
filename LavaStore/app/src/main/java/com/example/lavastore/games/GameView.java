package com.example.lavastore.games;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements  Runnable {

    private  Thread thread;
    private  boolean isPlaying;
    private  int screenX, screenY;
    private Paint paint;
    private  float screenratioX, screenRatioY;
    private  Background bg1 , bg2;

    public GameView(Context context,int screenX, int screenY){
        super((context));

        this.screenX = screenX;
        this.screenY = screenY;

        screenratioX = 2340f / screenX;
        screenRatioY = 1080f / screenY;

        bg1 = new Background(screenX,screenY,getResources());
        bg2 = new Background(screenX,screenY,getResources());

        bg2.x = screenX;
        paint = new Paint();

    }

    @Override
    public void run() {
        while (isPlaying){
            update();
            draw();
            sleep();
        }
    }

    private void update() {
        bg1.x-= 10 * screenratioX;
        bg2.x-= 10  * screenratioX;

        if (bg1.x + bg1.background.getWidth() <0){
            bg1.x = screenX;
        }
        if (bg2.x + bg2.background.getWidth() <0){
            bg2.x = screenX;
        }
    }

    private  void sleep(){
        try {
            Thread.sleep(17);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private  void draw()  {
        if( getHolder().getSurface().isValid()){
            Canvas  canvas = getHolder().lockCanvas();
            canvas.drawBitmap(bg1.background,bg1.x, bg1.y, paint);
            canvas.drawBitmap(bg2.background,bg2.x, bg2.y, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public  void resume(){
        thread = new Thread(this);
        thread.start();
    }

    public void pause(){
        try{
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
