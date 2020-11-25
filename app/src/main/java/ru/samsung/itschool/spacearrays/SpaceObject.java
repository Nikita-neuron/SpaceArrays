package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class SpaceObject{
    float x, y;
    Bitmap image;
    Paint paint = new Paint();

    public SpaceObject(float x, float y, Bitmap image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public abstract void draw(Canvas canvas);
    public abstract void move();
}
