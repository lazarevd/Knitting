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

        arrSiList.add(new LoopTypeElement("Резинки", "+10%", "kos_dummy"));
        arrSiList.add(new LoopTypeElement("Косы/араны", "+13%", "kos_dummy"));
        arrSiList.add(new LoopTypeElement("Рельефные", "+8%", "kos_dummy"));
        arrSiList.add(new LoopTypeElement("Узоры", "+5%", "kos_dumm"));
        arrSiList.add(new LoopTypeElement("Гладь", "+0%", "kos_dummy"));
        arrSiList.add(new LoopTypeElement("Ажуры", "+10%", "kos_dummy"));

        CustomLoopTypeSpinnerAdapter adapter = new CustomLoopTypeSpinnerAdapter(context, R.layout.loop_selector_spinner_item, arrSiList);
        adapter.setDropDownViewResource(R.layout.loop_selector_spinner_item);
        inputSpinner.setAdapter(adapter);

        return inputSpinner;
    }
}
