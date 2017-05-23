package com.anwesome.ui.circularrevealimagelistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.revealcircularimagelist.RCIList;
import com.anwesome.ui.revealcircularimagelist.RevealCircularView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        RCIList rciList = new RCIList(this);
        for(int i=0;i<6;i++) {
            rciList.addImage(bitmap);
        }
        rciList.show();
    }
}
