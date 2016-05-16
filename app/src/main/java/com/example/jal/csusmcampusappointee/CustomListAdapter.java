package com.example.jal.csusmcampusappointee;

/**
 * Created by Jal on 4/16/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
public class CustomListAdapter extends  ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private RatingBar rb;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
       // this.rb = rb;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        //RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.courserating);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+itemname[position]);
        //ratingBar.setRating(4.2f);
        return rowView;

    };
}
