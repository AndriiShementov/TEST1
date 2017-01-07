package com.example.andreyshem.test1.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andreyshem.test1.R;

/**
 * Created by andreyshem on 06.01.2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgID;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgID) {
        super(context, R.layout.item_for_fragment, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgID =imgID;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View itView=inflater.inflate(R.layout.item_for_fragment, null,true);

        TextView txtTitle = (TextView) itView.findViewById(R.id.mainText);
        ImageView imageView = (ImageView) itView.findViewById(R.id.some_image);
        TextView subTxt = (TextView) itView.findViewById(R.id.subText);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgID[position]);
        subTxt.setText("Available "+itemname[position]);


        return itView;
    }
}
