package ru.laz.knitting.custom_view;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Dmitry Lazarev on 16.04.2018.
 *
 *
 *
 */
public class LoopSelector {


    public static class SpinnerItem {
        private String displayName;

        public SpinnerItem(String dispName) {
            displayName = dispName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }



    public static Spinner genLoopSelector(Context context, Spinner inputSpinner){

        ArrayList<SpinnerItem> arrSiList = new ArrayList<>();

        arrSiList.add(new SpinnerItem("цобако"));
        arrSiList.add(new SpinnerItem("кысь"));
        arrSiList.add(new SpinnerItem("борода"));

        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, arrSiList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);

        return inputSpinner;
    }
}
