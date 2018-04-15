package ru.laz.knitting.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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

    public EditText getValueText() {
        return valueText;
    }

    public void setValueText(EditText valueText) {
        this.valueText = valueText;
    }


}
