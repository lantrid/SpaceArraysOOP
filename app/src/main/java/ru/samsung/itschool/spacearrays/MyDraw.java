package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


public class MyDraw extends View {

    public static void onAddRocket(){
        i++;
    }
    public static void onAddStar(){
        i1++;
    }

    static int i = 0;
    static int i1 = 0;
    public MyDraw(Context context, AttributeSet attrs) {

        super(context, attrs);

        makeSky();
        for(int i = 0;  i < 11; i++)
            this.rocket[i] = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));

    }



    Rocket[] rocket = new Rocket[11];




    Paint paint = new Paint();

    @Override

    protected void onDraw(Canvas canvas) {
        drawSky(canvas);
        if (i == 0) {
        } else {
            if(i==11) {
                i=10;


            }
            for (int iN = 0; iN < i; iN++) {
                rocket[iN].draw(canvas);
                rocket[iN].move();

            }
        }
        invalidate();
        // Запрос на перерисовку экрана
    }



    final int numStars = 500;



    int xStar[] = new int[numStars];

    int yStar[] = new int[numStars];

    int alphaStar[] = new int[numStars];



    void makeSky()

    {

        // Звезды генерируются в зоне maxX на maxY

        int maxX = 2000;

        int maxY = 2000;

        for(int i1 = 0; i1 < 500; i1++) {
            xStar[i1] = (int) (Math.random() * maxX);

            yStar[i1] = (int) (Math.random() * maxY);

            alphaStar[i1] = (int) (Math.random() * 256);
        }
    }



    void drawSky(Canvas canvas)

    {

        canvas.drawColor(Color.BLACK);

        paint.setColor(Color.YELLOW);

        paint.setStrokeWidth(2);
        if (i1 == 0) {
        } else {
            if(i==500) {
                i=499;
            }
            else {
                for (int iN = 0; iN < i1; iN++) {

                    paint.setAlpha(alphaStar[i1]);

                    alphaStar[iN] += (int) (Math.random() * 11) - 5;

                    if (alphaStar[iN] > 255) alphaStar[iN] = 255;

                    if (alphaStar[iN] < 0) alphaStar[iN] = 0;

                    canvas.drawCircle(xStar[iN], yStar[iN], 10, paint);
                }
            }
        }
    }

}
