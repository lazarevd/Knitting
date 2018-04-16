package ru.laz.knitting;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.HashMap;

public class ChildActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sviter));


    }

    @Override
    protected HashMap<String,Integer[]> makeBitmapCoords(float density) {
        //zero in upper-left corner
        HashMap<String,Integer[]> retCoords = new HashMap<String,Integer[]>();
        retCoords.put("sleeve", new Integer[]{0,0});
        retCoords.put("width", new Integer[]{0,(int)((float)bitmapSize*density)});
        retCoords.put("height", new Integer[]{(int)((float)bitmapSize*density),0});
        retCoords.put("normal", new Integer[]{(int)((float)bitmapSize*density),(int)((float)bitmapSize*density)});
        return retCoords;
    }


}
