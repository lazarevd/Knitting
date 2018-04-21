package ru.laz.knitting;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Spinner;

import java.util.HashMap;

import ru.laz.knitting.custom_view.LoopSelector;
import ru.laz.knitting.custom_view.ParameterEntry;
import ru.laz.knitting.custom_view.ResultView;
import ru.laz.knitting.custom_view.YarnEntry;


public class Pullover extends BaseActivity {

    ParameterEntry paeWidth;
    ParameterEntry paeHeight;
    ParameterEntry paeSleeve;
    YarnEntry yarnEntry;
    Spinner loopSelector;

    ResultView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullover);
        setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sviter));
        View topView = (View) findViewById(R.id.include_topping);
        //ImageView imageView = (ImageView) topView.findViewById(R.id.topImageView);
        //setBitmapToImageView(imageView, this.imageBitmap, "normal", bitmapCoords, screenDensity);

        paeWidth = (ParameterEntry) findViewById(R.id.paramentry_width);
        paeHeight = (ParameterEntry) findViewById(R.id.paramentry_height);
        paeSleeve = (ParameterEntry) findViewById(R.id.paramentry_sleeve);
        yarnEntry = (YarnEntry) findViewById(R.id.yarnEntry);
        resultView = (ResultView) findViewById(R.id.resultView);
        loopSelector = (Spinner) findViewById(R.id.loopSelector);
        LoopSelector.genLoopSelector(this, loopSelector);



        paeWidth.addTextChangedListener(new TextWatcher() {//TODO Callback
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(android.text.Editable s) {
                resultView.setResult("" + count());
            }
        });

        paeHeight.addTextChangedListener(new TextWatcher() {//TODO Callback
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(android.text.Editable s) {
                resultView.setResult("" + count());
            }
        });

        paeSleeve.addTextChangedListener(new TextWatcher() {//TODO Callback
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(android.text.Editable s) {
                resultView.setResult("" + count());
            }
        });

        yarnEntry.addTextChangedListener(new TextWatcher() {//TODO Callback
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(android.text.Editable s) {
                resultView.setResult("" + count());
            }
        });







    }


    private int count() {
        int wid = paeWidth.getValueInt();
        int heg = paeHeight.getValueInt();
        int sle = paeSleeve.getValueInt();
        int dens = yarnEntry.getYarnDencity();
        return (wid*heg + (2*sle))*dens;
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