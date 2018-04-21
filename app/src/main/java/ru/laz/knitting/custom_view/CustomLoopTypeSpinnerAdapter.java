package ru.laz.knitting.custom_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.laz.knitting.R;


public class CustomLoopTypeSpinnerAdapter extends ArrayAdapter<String>{

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<LoopTypeElement> items;
    private final int mResource;

    public CustomLoopTypeSpinnerAdapter(@NonNull Context context, @LayoutRes int resource,
                              @NonNull List objects) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate(mResource, parent, false);

        TextView loopName = (TextView) view.findViewById(R.id.spinTextLeft);
        TextView loopDescr = (TextView) view.findViewById(R.id.spinTextRight);
        ImageView loopImage = (ImageView) view.findViewById(R.id.spinImage);

        LoopTypeElement offerData = items.get(position);

        int resID = mContext.getResources().getIdentifier(offerData.getLoopImg(), "drawable", mContext.getPackageName());

        Bitmap imBit = BitmapFactory.decodeResource(mContext.getResources(),resID);

        loopImage.setImageBitmap(imBit);



        loopName.setText(offerData.getLoopName());
        loopDescr.setText(offerData.getLoopDescr());

        return view;
    }
}