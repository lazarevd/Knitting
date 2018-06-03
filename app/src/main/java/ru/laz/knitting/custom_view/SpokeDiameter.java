package ru.laz.knitting.custom_view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import ru.laz.knitting.R;

/**
 * Created by Dmitry Lazarev on 22.04.2018.
 */
public class SpokeDiameter extends ConstraintLayout {

    TextView descrText;
    TextView valueText;

    public SpokeDiameter(Context context) {
        super(context);
        View.inflate(context, R.layout.spoke_diameter, this);
        init();
    }

    public SpokeDiameter(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        View.inflate(context, R.layout.spoke_diameter, this);
        init();
    }

    public void addTextChangedListener(android.text.TextWatcher watcher) {
        valueText.addTextChangedListener(watcher);
    }

    public SpokeDiameter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.spoke_diameter, this);
        init();
    }


    private void init() {
        descrText = findViewById(R.id.spoke_descr);
        valueText = findViewById(R.id.spoke_value);
        valueText.setHint(R.string.measure_unit_mm);
    }

    public float getSpokeDiameter() {
        float retVal = 0;
        String txtVal = valueText.getText().toString();

        if (txtVal.length() > 0) {
            try {
                retVal = Float.parseFloat(txtVal);
            } catch (NumberFormatException nfe) {
                retVal = 0;
            }
        }
        return retVal;
    }

}
