package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		makeSky();
		creatRockets();

	}

	Paint paint = new Paint();
	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);

	// size array
	int N = 3;

	// create array of objects
	Rocket[] rockets = new Rocket[N];

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		drawSky(canvas);

		for (int i = 0; i < rockets.length; i++) {
			rockets[i].draw(canvas);
			rockets[i].move();
		}
		
		// Запрос на перерисовку экрана
		invalidate();
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

	void creatRockets() {

		float[] xRocket = {300, 300, 300};
		float[] yRocket = {300, 300, 500};
		float[] vxRocket = {0.5f, -0.5f, 0.5f};
		float[] vyRocket = {-0.5f, 0.5f, -0.5f};

		for (int i = 0; i < rockets.length; i++) {
			Rocket rocket = new Rocket(xRocket[i], yRocket[i], vxRocket[i], vyRocket[i], rocketImage, paint);
			rockets[i] = rocket;
		}
	}
	
}
