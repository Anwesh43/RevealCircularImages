package com.anwesome.ui.revealcircularimagelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 23/05/17.
 */
public class ListLayout extends ViewGroup{
    private int w,h;
    public void onMeasure(int wspec,int hspec) {
        int hMax = h/30;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            hMax += (h/3+h/30);
        }
        setMeasuredDimension(w,Math.max(h,hMax));
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void onLayout(boolean reloaded,int a,int b,int wa,int ha) {
        int y = h/30;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(w/20,y,19*w/20,y+h/3);
            y+=(h/3+h/30);
        }
    }
    public void addImage(Bitmap bitmap) {
        RevealCircularView revealCircularView = new RevealCircularView(getContext(),bitmap);
        addView(revealCircularView,new LayoutParams(9*w/10,h/3));
        requestLayout();
    }
    public ListLayout(Context context) {
        super(context);
        initDimension(context);
    }
}
