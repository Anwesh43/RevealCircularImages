package com.anwesome.ui.revealcircularimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 23/05/17.
 */
public class RevealCircularView extends View {
    private int backColor = Color.WHITE;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private int time = 0,w,h,bitmapSize;

    public RevealCircularView(Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmapSize = Math.min(w,h)/3;
            bitmap = Bitmap.createScaledBitmap(bitmap,bitmapSize,bitmapSize,true);
        }
        canvas.drawColor(backColor);

        paint.setStrokeWidth(w/10);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(w/2-bitmapSize/2,h/2-bitmapSize/2,bitmapSize/2,paint);
        canvas.save();
        Path path = new Path();
        path.addCircle(w/2-bitmapSize/2,h/2-bitmapSize/2,bitmapSize/2, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,w/2-bitmapSize/2,h/2-bitmapSize/2,paint);
        canvas.restore();
        time++;

    }
    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }
    public void update(float factor) {
        postInvalidate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return true;
    }
}
