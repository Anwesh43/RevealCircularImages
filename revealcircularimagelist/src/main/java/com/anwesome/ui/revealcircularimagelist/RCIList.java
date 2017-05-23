package com.anwesome.ui.revealcircularimagelist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 23/05/17.
 */
public class RCIList {
    private Activity activity;
    private boolean isShown = false;
    private ScrollView scrollView;
    public RCIList(Activity activity){
        this.activity = activity;
        scrollView = new ScrollView(activity);
    }
    public void addImage(Bitmap bitmap) {
        if(!isShown) {

        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
