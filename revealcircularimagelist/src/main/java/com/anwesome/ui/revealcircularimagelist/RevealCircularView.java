package com.anwesome.ui.revealcircularimagelist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
    private RevealFilter revealFilter;
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
            revealFilter = new RevealFilter();
        }
        canvas.drawColor(backColor);
        paint.setStrokeWidth(w/10);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(w/2,h/2,bitmapSize/2,paint);
        canvas.save();
        Path path = new Path();
        path.addCircle(w/2,h/2,bitmapSize/2, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,w/2-bitmapSize/2,h/2-bitmapSize/2,paint);
        canvas.restore();
        revealFilter.draw(canvas);
        time++;
    }
    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }
    public void update(float factor) {
        revealFilter.update(factor);
        postInvalidate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && revealFilter.handleTouch(event.getX(),event.getY())) {

        }
        return true;
    }
    private class RevealFilter {
        private float r = 0;
        public RevealFilter() {
            r = bitmapSize/2;
        }
        public void draw(Canvas canvas) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(backColor);
            canvas.drawCircle(w/2,h/2,r,paint);
        }
        public void update(float factor) {
            r = bitmapSize/2*(1-factor);
        }
        public boolean handleTouch(float x,float y) {
            return  x>=w/2-bitmapSize/2 && x<=w/2+bitmapSize/2 && y>=h/2-bitmapSize/2 && y<=h/2+bitmapSize/2;
        }
    }
    private class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener{
        private int dir = 0;
        private boolean isAnimating = false;
        private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
        public AnimationHandler() {
            startAnim.setDuration(500);
            endAnim.setDuration(500);
            startAnim.addUpdateListener(this);
            endAnim.addUpdateListener(this);
            startAnim.addListener(this);
            endAnim.addListener(this);
        }
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            update((float)valueAnimator.getAnimatedValue());
        }
        public void onAnimationEnd(Animator animator) {
            if(isAnimating) {
                if(dir == 0) {

                }
                else {

                }
                dir = dir == 0?1:0;
                isAnimating = false;
            }
        }
        public void start() {
            if(!isAnimating) {
                if (dir == 0) {
                    startAnim.start();
                } else {
                    endAnim.start();
                }
                isAnimating = true;
            }
        }
    }
}
