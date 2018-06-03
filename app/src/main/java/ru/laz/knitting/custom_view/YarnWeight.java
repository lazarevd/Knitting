package ru.laz.knitting.custom_view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import ru.laz.knitting.R;

/**
 * Created by Dmitry Lazarev on 21.04.2018.
 */
public class YarnWeight extends ConstraintLayout {

    EditText valueTxt;
    ImageButton helpBtn;

    public YarnWeight(Context context) {
        super(context);
        init(context);
    }

    public YarnWeight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public YarnWeight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }



    public void addTextChangedListener(android.text.TextWatcher watcher) {
        valueTxt.addTextChangedListener(watcher);
    }

    private void init(final Context con) {
        View.inflate(con, R.layout.yarn_weight_layout, this);
        valueTxt = findViewById(R.id.editTextValue);


        helpBtn = findViewById(R.id.yarnHelpBtn);
        helpBtn.setImageResource(R.drawable.help_button);
        helpBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(con, R.string.yarn_weght_help,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
                toast.show();
            }
        });

        valueTxt = findViewById(R.id.editTextValue);
        valueTxt.setText("10");

    }

    public int getYarnWeight() {
        int ret = 0;
        String weght = "";

        weght = valueTxt.getText().toString();

        if (weght.length() > 0) {
            try {
                ret = Integer.parseInt(weght);
            } catch (NumberFormatException nfe) {
                return 0;
            }
        }
        return ret;
    }

}
