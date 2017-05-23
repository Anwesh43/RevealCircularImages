package com.anwesome.ui.circularrevealimagelistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.revealcircularimagelist.RevealCircularView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        RevealCircularView revealCircularView = new RevealCircularView(this,bitmap);
        addContentView(revealCircularView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500));
    }
}
