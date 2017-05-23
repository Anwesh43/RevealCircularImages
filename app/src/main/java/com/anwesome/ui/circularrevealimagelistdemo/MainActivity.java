package com.anwesome.ui.circularrevealimagelistdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.ui.revealcircularimagelist.OnSelectionChangeListener;
import com.anwesome.ui.revealcircularimagelist.RCIList;
import com.anwesome.ui.revealcircularimagelist.RevealCircularView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        RCIList rciList = new RCIList(this);
        for(int i=0;i<6;i++) {
            final int index = i+1;
            rciList.addImage(bitmap, new OnSelectionChangeListener() {
                @Override
                public void onSelected() {
                    Toast.makeText(MainActivity.this, index+" selected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnSelected() {
                    Toast.makeText(MainActivity.this, index+" unselected", Toast.LENGTH_SHORT).show();
                }
            });
        }
        rciList.show();
    }
}
