package com.example.android.bucharestguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Eugen on 26-Feb-18.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    public LocationAdapter(@NonNull Context context, List<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);
        //setting the location name
        TextView attractionNameTextView = listItemView.findViewById(R.id.location_name_text_view);
        attractionNameTextView.setText(currentLocation.getName());
        //setting the short description
        TextView attractionDescriptionTextView = listItemView.findViewById(R.id.location_short_description_text_view);
        attractionDescriptionTextView.setText(currentLocation.getShortDescription());
        //setting the image
        ImageView imageView = listItemView.findViewById(R.id.location_image_view);
        imageView.setImageResource(currentLocation.getImageID());

        return listItemView;
    }
}
