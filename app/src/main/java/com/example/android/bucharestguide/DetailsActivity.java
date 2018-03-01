package com.example.android.bucharestguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView detailsImage = findViewById(R.id.details_image_view);
        TextView detailsDescriptionTextView = findViewById(R.id.details_description_text_view);
        final TextView detailsAddressTextView = findViewById(R.id.details_address_text_view);
        TextView detailsPhoneTextView = findViewById(R.id.details_phone_text_view);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String text = "";
            text += extras.getString(Location.NAME_STRING) + "\n\n";
            text += extras.getString(Location.SHORT_DESCRIPTION_STRING) + "\n";
            detailsDescriptionTextView.setText(text);
            detailsImage.setImageResource(extras.getInt(Location.IMAGE_ID_STRING));
            detailsPhoneTextView.setText(extras.getString(Location.PHONE_STRING));
            detailsAddressTextView.setText(extras.getString(Location.ADDRESS_STRING));
        }
        else {
            //On Bucharest gif click
            detailsImage.setImageResource(R.drawable.bucharest_collage);
            View addressLayout = findViewById(R.id.details_layout_address);
            addressLayout.setVisibility(View.GONE);
            View phoneLayout = findViewById(R.id.details_layout_phone);
            phoneLayout.setVisibility(View.GONE);

        }

        //Open Google maps on address click
        detailsAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri addressUri = Uri.parse("geo:0,0?q=" + detailsAddressTextView.getText());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, addressUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
