
package ru.laz.knitting;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.HashMap;

public class Sweater_T extends AppCompatActivity {

    int bitmapSize = 300;
    float screenDensity = 1.0f;
    HashMap<String,Integer[]> bitmapCoords = new HashMap<String,Integer[]>();
    Bitmap sviter_bitmap = null;
    EditText height_edit = null;
    EditText width_edit = null;
    EditText sleeve_edit = null;

    private HashMap<String,Integer[]> makeBitmapCoords(float density) {
        //zero in upper-left corner
        HashMap<String,Integer[]> retCoords = new HashMap<String,Integer[]>();
        retCoords.put("sleeve", new Integer[]{0,0});
        retCoords.put("width", new Integer[]{0,(int)((float)bitmapSize*density)});
        retCoords.put("height", new Integer[]{(int)((float)bitmapSize*density),0});
        retCoords.put("normal", new Integer[]{(int)((float)bitmapSize*density),(int)((float)bitmapSize*density)});
        return retCoords;
    }

    private void makeBitmapCoords1(float density) {
        //zero in upper-left corner

        bitmapCoords.put("sleeve", new Integer[]{0,0});
        bitmapCoords.put("width", new Integer[]{0,bitmapSize});
        bitmapCoords.put("height", new Integer[]{bitmapSize,0});
        bitmapCoords.put("normal", new Integer[]{bitmapSize,bitmapSize});
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void setBitmap(Bitmap bitmap, String bitmapName, HashMap<String,Integer[]> bitmapCoords, float density) {
        Integer[] coords = bitmapCoords.get(bitmapName);
        int x = coords[0];
        int y = coords[1];

        Bitmap cropped =  Bitmap.createBitmap(bitmap, x, y, (int)((float)bitmapSize*density), (int)((float)bitmapSize*density));

        Log.i("XXX: ", x+"");
        Log.i("YYY: ", y+"");
        ImageView im_Cr = (ImageView) findViewById(R.id.imageView);
        im_Cr.setImageBitmap(cropped);;//PUT it in drawable-nodpi
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
        setContentView(R.layout.sweater);


        sviter_bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sviter);
        Log.i("sviter_bitmap", sviter_bitmap.getHeight()+"");
        setBitmap(sviter_bitmap, "height", bitmapCoords, screenDensity);


        height_edit = (EditText) findViewById(R.id.height_edit);//Определяем поле исходного текста
        height_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setBitmap(sviter_bitmap, "height", bitmapCoords, screenDensity);
                return false;
            }
        });

        height_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });


        width_edit = (EditText) findViewById(R.id.width_edit);//Определяем поле исходного текста
        width_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setBitmap(sviter_bitmap, "width", bitmapCoords, screenDensity);
                return false;
            }
        });

        width_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });


        sleeve_edit = (EditText) findViewById(R.id.sleeve_edit);//Определяем поле исходного текста
        sleeve_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setBitmap(sviter_bitmap, "sleeve", bitmapCoords, screenDensity);
                return false;
            }
        });

        sleeve_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

    }
}
