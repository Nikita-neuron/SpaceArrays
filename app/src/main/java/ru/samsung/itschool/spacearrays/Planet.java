package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Planet extends SpaceObject implements SpaceObjects{
    float angel = 0;
    final float v = 1;

    public Planet(float x, float y, Bitmap image) {
        super(x, y, image);
    }

    public void draw(Canvas canvas) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
//        matrix.postRotate((float)Math.toDegrees(angel));
        matrix.setRotate((float)Math.toDegrees(angel), image.getWidth() / 2, image.getHeight() / 2);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
    }

    public void move() {
        angel += 0.01;
    }
}
