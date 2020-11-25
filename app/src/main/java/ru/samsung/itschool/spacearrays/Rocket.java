package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Rocket extends SpaceObject implements SpaceObjects{

    float vx, vy;

    public Rocket(float x, float y, float vx, float vy, Bitmap image) {
        super(x, y, image);
        this.vx = vx;
        this.vy = vy;
    }

    public void move() {
        x += vx;
        y += vy;
    }

    public void draw(Canvas canvas)
    {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
    }
}
