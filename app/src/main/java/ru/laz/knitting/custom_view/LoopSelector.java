package ru.laz.knitting.custom_view;

import android.content.Context;
import android.widget.Spinner;

import java.util.ArrayList;

import ru.laz.knitting.R;

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

        ArrayList<LoopTypeElement> arrSiList = new ArrayList<>();

        arrSiList.add(new LoopTypeElement("цобако", "кусако"));
        arrSiList.add(new LoopTypeElement("кысь", "брысь"));
        arrSiList.add(new LoopTypeElement("борода", "холода"));


        CustomLoopTypeSpinnerAdapter adapter = new CustomLoopTypeSpinnerAdapter(context, R.layout.loop_selector_spinner_item, arrSiList);
        adapter.setDropDownViewResource(R.layout.loop_selector_spinner_item);
        inputSpinner.setAdapter(adapter);

        return inputSpinner;
    }
}
