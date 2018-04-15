package ru.laz.knitting;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

public class Pullover extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullover);
        setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sviter));
        View topView = (View) findViewById(R.id.include_topping);
        ImageView imageView = (ImageView) topView.findViewById(R.id.topImageView);
        setBitmapToImageView(imageView, this.imageBitmap, "normal", bitmapCoords, screenDensity);

    }

    @Override
    protected HashMap<String, Integer[]> makeBitmapCoords(float density) {
        HashMap<String,Integer[]> retCoords = new HashMap<String,Integer[]>();
        retCoords.put("sleeve", new Integer[]{0,0});
        retCoords.put("width", new Integer[]{0,(int)((float)bitmapSize*density)});
        retCoords.put("height", new Integer[]{(int)((float)bitmapSize*density),0});
        retCoords.put("normal", new Integer[]{(int)((float)bitmapSize*density),(int)((float)bitmapSize*density)});
        return retCoords;
    }
}