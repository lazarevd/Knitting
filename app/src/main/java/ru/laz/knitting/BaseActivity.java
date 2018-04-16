package ru.laz.knitting;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.HashMap;

public abstract class BaseActivity extends Activity {

    int bitmapSize = 300;
    float screenDensity = 1.0f;
    HashMap<String,Integer[]> bitmapCoords = new HashMap<String,Integer[]>();
    Bitmap imageBitmap = null;
    Spinner loopType;





    protected void setBitmapToImageView(ImageView imageView, Bitmap bitmap, String bitmapName, HashMap<String,Integer[]> bitmapCoords, float density) {
        Integer[] coords = bitmapCoords.get(bitmapName);
        int x = coords[0];
        int y = coords[1];
        Bitmap cropped =  Bitmap.createBitmap(bitmap, x, y, (int)((float)bitmapSize*density), (int)((float)bitmapSize*density));
        imageView.setImageBitmap(cropped);;//PUT it in drawable-nodpi
/*
        ldpi = 0.00625 * 120 -> 0.75
        mdpi = 0.00625 * 160 -> 1.0
        hdpi = 0.00625 * 240 -> 1.5
        xhdpi = 0.00625 * 320 -> 2.0
        xxhdpi = 0.00625 * 480 -> 3.0
        xxxhdpi = 0.00625 * 640 -> 4.0
*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        screenDensity = getResources().getDisplayMetrics().density;
        bitmapCoords = makeBitmapCoords(screenDensity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }





    protected abstract HashMap<String,Integer[]> makeBitmapCoords(float density);

    protected void setBitmap(Bitmap bitmap){
        this.imageBitmap = bitmap;
    }

}
