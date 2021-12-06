package com.example.drawermenu2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawSinus extends View {

    float Y = 150;
    float X = 160;

    float widthPixels = Resources.getSystem().getDisplayMetrics().widthPixels;
    float heightPixels = Resources.getSystem().getDisplayMetrics().heightPixels;
    float frequency = (float) (X * Math.PI);
    float paintSize = 7;

    Paint paint;
    Paint paint2;

    public DrawSinus(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paintB(canvas);

        for (float x = -widthPixels / 2; x <= widthPixels / 2; x += 1) {
            canvas.drawPoint(x + widthPixels / 2, heightPixels / 2 - (-Y) * (float) Math.sin(-x * Math.PI / frequency), paint);
        }
        canvas.drawLine(0, heightPixels / 2, widthPixels, heightPixels / 2, paint2);
        canvas.drawLine(widthPixels / 2, 0, widthPixels / 2, heightPixels, paint2);
    }

    public void paintB(Canvas canvas) {
        paint = new Paint();
        paint.setColor(Color.rgb(100, 0, 200));
        paint.setStrokeWidth(paintSize);

        paint2 = new Paint();
        paint2.setColor(Color.rgb(100, 100, 100));
        paint2.setStrokeWidth(3);
    }

}
