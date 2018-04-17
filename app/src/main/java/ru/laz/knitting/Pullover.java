package ru.laz.knitting;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.HashMap;

import ru.laz.knitting.custom_view.LoopSelector;
import ru.laz.knitting.custom_view.ParameterEntry;

public class Pullover extends BaseActivity {

    ParameterEntry paeWidtth;
    Spinner loopSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullover);
        setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sviter));
        View topView = (View) findViewById(R.id.include_topping);
        //ImageView imageView = (ImageView) topView.findViewById(R.id.topImageView);
        //setBitmapToImageView(imageView, this.imageBitmap, "normal", bitmapCoords, screenDensity);

        ParameterEntry paeWidtth = (ParameterEntry) findViewById(R.id.paramentry_width);
        ParameterEntry paeHeight = (ParameterEntry) findViewById(R.id.paramentry_height);
        ParameterEntry paeSleeve = (ParameterEntry) findViewById(R.id.paramentry_sleeve);
        paeWidtth.getValueText();

        loopSpinner = (Spinner) findViewById(R.id.loopSpinner);


        loopSpinner = LoopSelector.genLoopSelector(this, loopSpinner);



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