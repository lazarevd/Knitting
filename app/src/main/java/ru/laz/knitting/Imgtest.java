package ru.laz.knitting;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.HashMap;

public class Imgtest extends AppCompatActivity {

    int bitmapSize = 300;
    HashMap<String,Integer[]> bitmapCoords = new HashMap<String,Integer[]>();
    Bitmap sviter_bitmap = null;
    EditText height_edit = null;
    EditText width_edit = null;
    EditText sleeve_edit = null;

    private void makeBitmapCoords() {
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

    private void setBitmap(Bitmap bitmap, String bitmapName) {
        Integer[] coords = bitmapCoords.get(bitmapName);
        int x = coords[0];
        int y = coords[1];

        Bitmap cropped =  Bitmap.createBitmap(bitmap, x, y, bitmapSize, bitmapSize);

        ImageView im_Cr = (ImageView) findViewById(R.id.imageViewTest);
        im_Cr.setImageBitmap(cropped);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        makeBitmapCoords();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgtest);

        sviter_bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.sviter);//PUT it in drawable-nodpi
/*
        ldpi = 0.00625 * 120 -> 0.75
        mdpi = 0.00625 * 160 -> 1.0
        hdpi = 0.00625 * 240 -> 1.5
        xhdpi = 0.00625 * 320 -> 2.0
        xxhdpi = 0.00625 * 480 -> 3.0
        xxxhdpi = 0.00625 * 640 -> 4.0
*/

        Bitmap cropped =  Bitmap.createBitmap(sviter_bitmap, 0, 0, 600, 600);
        ImageView im_Cr = (ImageView) findViewById(R.id.imageViewTest);
        im_Cr.setImageBitmap(cropped);



        //setBitmap(sviter_bitmap, "normal");

        Button slev = (Button) findViewById(R.id.sleeve);
        slev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBitmap(sviter_bitmap, "sleeve");
            }
        });

        Button heig = (Button) findViewById(R.id.height);
        heig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBitmap(sviter_bitmap, "height");
            }
        });


        Button widt = (Button) findViewById(R.id.width);
        widt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBitmap(sviter_bitmap, "width");
            }
        });


        Button norm = (Button) findViewById(R.id.normal);
        norm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBitmap(sviter_bitmap, "normal");
            }
        });

    }
}
