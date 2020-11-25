package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		spaceObjects = new SpaceObjects[N];
		creatObjects();
		sky = new Sky(500, paint);
		sky.makeSky();
	}

	Paint paint = new Paint();
	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);
	Bitmap planetImage = BitmapFactory.decodeResource(getResources(), R.drawable.planet);
	Sky sky;

	// size array
	int N = 4;

	// create array of objects
	SpaceObjects[] spaceObjects;

	
	@Override
	protected void onDraw(Canvas canvas) {
		sky.drawSky(canvas);

		for (int i = 0; i < N; i++) {
			spaceObjects[i].draw(canvas);
			spaceObjects[i].move();
		}
		
		// Запрос на перерисовку экрана
		invalidate();
	}

	float rnd(double a, double b){
		return (float)(Math.random()*(b-a) + a);
	}

	public void creatObjects() {
		for (int i = 0; i < N; i++) {
			if (i%2 == 0) {
				spaceObjects[i] = new Rocket(rnd(0, 1000), rnd(0, 1000), 0.5f, 0.5f, rocketImage);
			}
			else {
				spaceObjects[i] = new Planet(rnd(0, 1000), rnd(0, 1000), planetImage);
			}
		}
	}
}
