package com.example.projecttoday;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<Item> {
    private final Activity context;
    public ArrayList<Item> item;

    public CustomListView(Activity context, ArrayList<Item> item) {
        super(context, R.layout.custom_items, item);
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_items, null, true);

        TextView Name = rowView.findViewById(R.id.personName);
        TextView phone = rowView.findViewById(R.id.phone);
        CheckBox check = rowView.findViewById(R.id.checkStatus);
        ImageView imageView= rowView.findViewById(R.id.imgShow);


        Name.setText(item.get(position).fullName);
        phone.setText(item.get(position).phoneNumber);
        check.setChecked(item.get(position).status);
        Uri imgUri=Uri.parse(item.get(position).images);
        Log.d("a1", "getView: "+ imgUri.toString());
        imageView.setImageURI(imgUri);

        return rowView;

    }
}
