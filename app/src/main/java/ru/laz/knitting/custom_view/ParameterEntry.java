package ru.laz.knitting.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import ru.laz.knitting.R;

/**
 * Created by Dmitry Lazarev on 12.04.2018.
 */
public class ParameterEntry extends ConstraintLayout {


    String descrTextStr = "";
    String helpTextStr = "";

    TextView descriptionText;
    EditText valueText;

    ImageButton helpBtn;


    public ParameterEntry(Context context) {
        super(context);
        View.inflate(context, R.layout.parameter_entry, this);
        init(helpTextStr, descrTextStr);
    }

    public ParameterEntry(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        View.inflate(context, R.layout.parameter_entry, this);
        linkAttrs(context, attrs);
        init(helpTextStr, descrTextStr);
    }



    public ParameterEntry(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(final String hlpTxt, String dscrTxt) {
        helpBtn = findViewById(R.id.helpBtn);
        helpBtn.setImageResource(R.drawable.help_button);
        helpBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), hlpTxt,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
                toast.show();
            }
        });

        descriptionText = findViewById(R.id.textDescr);
        descriptionText.setText(dscrTxt);
        valueText = findViewById(R.id.editTextValue);
        valueText.setHint(R.string.measure_unit_cm);
    }


    public void addTextChangedListener(android.text.TextWatcher watcher) {
        valueText.addTextChangedListener(watcher);
        }


    private void linkAttrs(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.ParameterEntry);
        descrTextStr = ta.getString(R.styleable.ParameterEntry_description);
        helpTextStr = ta.getString(R.styleable.ParameterEntry_help);
        ta.recycle();
    }


    public int getValueInt(){
    String val = valueText.getText().toString();
    int ret = 0;
    if (val.length() > 0) {
        try {
            ret = Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            Log.e("NUMBER FORMAT EXCEPT", val);
            ret = 0;
        }
    }
    return ret;
    }

    public String getValueText() {
        return valueText.getText().toString();
    }

    public void setValueText(String valueText) {
        this.valueText.setText(valueText);
    }


}
