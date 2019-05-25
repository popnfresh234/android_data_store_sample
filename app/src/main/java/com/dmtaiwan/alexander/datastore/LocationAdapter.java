package com.dmtaiwan.alexander.datastore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Location> locations;

    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
        this.context = context;
        this.locations = locations;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Location location = this.locations.get(position);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.location_name);
        TextView typeTextView = (TextView) convertView.findViewById(R.id.location_type);

        nameTextView.setText(location.getName());
        typeTextView.setText(location.getType());

        return convertView;
    }
}
