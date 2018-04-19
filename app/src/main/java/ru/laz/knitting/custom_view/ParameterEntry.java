package ru.laz.knitting.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.laz.knitting.R;

/**
 * Created by Dmitry Lazarev on 12.04.2018.
 */
public class ParameterEntry extends LinearLayout {


    String descrTextStr = "";
    String helpTextStr = "";

    TextView descriptionText;
    EditText valueText;

    ImageButton helpBtn;


    public ParameterEntry(Context context) {
        super(context);
        View.inflate(context, R.layout.parameter_entry, this);
    }

    public ParameterEntry(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        View.inflate(context, R.layout.parameter_entry, this);
        linkAttrs(context, attrs);
        initDescription(descrTextStr);
        initHelpButton(helpTextStr);
        valueText = (EditText) findViewById(R.id.editTextValue);
        valueText.setHint("0");
    }



        public void addTextChangedListener(android.text.TextWatcher watcher) {
        valueText.addTextChangedListener(watcher);
        }


    private void initDescription(String descr){
        descriptionText = (TextView) findViewById(R.id.textDescr);
        descriptionText.setText(descr);
    }

    private void initHelpButton(final String helpText) {
        ImageButton helpBttn = (ImageButton) findViewById(R.id.helpBtn);
        helpBttn.setImageResource(R.drawable.help_button);
        helpBttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), helpText,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
                toast.show();
            }
        });
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
