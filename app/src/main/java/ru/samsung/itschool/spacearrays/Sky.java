package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Sky {
    final int numStars;
    Paint paint;

    int xStar[];
    int yStar[];
    int alphaStar[];

    public Sky(int numStars, Paint paint) {
        this.paint = paint;
        this.numStars = numStars;
        xStar = new int[this.numStars];
        yStar = new int[numStars];
        alphaStar = new int[numStars];
    }

    void makeSky()
    {
        // Звезды генерируются в зоне maxX на maxY
        int maxX = 2000;
        int maxY = 2000;
        for (int i = 0; i < numStars; i++)
        {
            xStar[i] = (int)(Math.random() * maxX);
            yStar[i] = (int)(Math.random() * maxY);
            alphaStar[i] = (int)(Math.random() * 256);
        }
    }

    void drawSky(Canvas canvas)
    {
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2);
        for (int i = 0; i < numStars; i++)
        {
            paint.setAlpha(alphaStar[i]);
            alphaStar[i] += (int)(Math.random() * 11) - 5;
            if (alphaStar[i] > 255) alphaStar[i] = 255;
            if (alphaStar[i] < 0) alphaStar[i] = 0;
            canvas.drawCircle(xStar[i], yStar[i], 3, paint);
        }
    }
}
