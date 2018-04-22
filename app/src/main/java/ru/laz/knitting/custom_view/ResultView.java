package ru.laz.knitting.custom_view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import ru.laz.knitting.R;

/**
 * Created by Dmitry Lazarev on 20.04.2018.
 */
public class ResultView extends ConstraintLayout {

    TextView descrTxt;
    TextView valueTxt;

    public ResultView(Context context) {
        super(context);
        init(context);
    }

    public ResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ResultView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setResult(String resStr) {
        valueTxt.setText(resStr + " " + getResources().getString(R.string.result_unit));
    }

    private void init(Context con) {
        View.inflate(con, R.layout.result_view, this);
        descrTxt = (TextView) findViewById(R.id.result_label);
        valueTxt = (TextView) findViewById(R.id.result_val);
    }

}
