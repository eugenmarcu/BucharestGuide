package com.example.android.bucharestguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugen on 26-Feb-18.
 */

public class CategoryFragment extends Fragment {
    /**
     * The fragment argument representing the category number for this
     * fragment.
     */
    private static final String ARG_CATEGORY_NUMBER = "categoryNumber";

    public CategoryFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given category
     * number and stores the number
     */
    public static CategoryFragment newInstance(int categoryNumber) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY_NUMBER, categoryNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //find out which category page is being displayed
        final int categoryNumber = getArguments().getInt(ARG_CATEGORY_NUMBER);

        // Create a list of locations
        List<Location> locations = new ArrayList<>();
        createLocations(categoryNumber, locations);


        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml file.
        final ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        //When item is clicked a new activity is called
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location listItem = (Location) listView.getItemAtPosition(position);
                Intent informationIntent = new Intent(getContext(), DetailsActivity.class);
                informationIntent.putExtra(Location.NAME_STRING, listItem.getName());
                informationIntent.putExtra(Location.SHORT_DESCRIPTION_STRING, listItem.getShortDescription());
                informationIntent.putExtra(Location.IMAGE_ID_STRING, listItem.getImageID());
                informationIntent.putExtra(Location.ADDRESS_STRING, listItem.getAddress());
                informationIntent.putExtra(Location.PHONE_STRING, listItem.getPhone());
                startActivity(informationIntent);
            }
        });

        return rootView;
    }

    /**
     * Creates the list for each category
     */
    private void createLocations(int categoryNumber, final List<Location> locations) {
        switch (categoryNumber) {
            //Restaurants
            case 0:
                locations.add(new Location(getString(R.string.restaurant_1_name), getString(R.string.restaurant_1_description), R.drawable.restaurants_caju, getString(R.string.restaurant_1_address), getString(R.string.restaurant_1_phone)));
                locations.add(new Location(getString(R.string.restaurant_2_name), getString(R.string.restaurant_2_description), R.drawable.restaurants_pow_wow, getString(R.string.restaurant_2_address), getString(R.string.restaurant_2_phone)));
                locations.add(new Location(getString(R.string.restaurant_3_name), getString(R.string.restaurant_3_description), R.drawable.restaurants_megoo, getString(R.string.restaurant_3_address), getString(R.string.restaurant_3_phone)));
                locations.add(new Location(getString(R.string.restaurant_4_name), getString(R.string.restaurant_4_description), R.drawable.restaurants_atelierul_de_tarte, getString(R.string.restaurant_4_address), getString(R.string.restaurant_4_phone)));
                locations.add(new Location(getString(R.string.restaurant_5_name), getString(R.string.restaurant_5_description), R.drawable.restaurants_ribs, getString(R.string.restaurant_5_address), getString(R.string.restaurant_5_phone)));
                locations.add(new Location(getString(R.string.restaurant_6_name), getString(R.string.restaurant_6_description), R.drawable.restaurants_temple, getString(R.string.restaurant_6_address), getString(R.string.restaurant_6_phone)));
                locations.add(new Location(getString(R.string.restaurant_7_name), getString(R.string.restaurant_7_description), R.drawable.restaurants_britannia, getString(R.string.restaurant_7_address), getString(R.string.restaurant_7_phone)));
                locations.add(new Location(getString(R.string.restaurant_8_name), getString(R.string.restaurant_8_description), R.drawable.restaurants_joben, getString(R.string.restaurant_8_address), getString(R.string.restaurant_8_phone)));
                locations.add(new Location(getString(R.string.restaurant_9_name), getString(R.string.restaurant_9_description), R.drawable.restaurants_upstairs, getString(R.string.restaurant_9_address), getString(R.string.restaurant_9_phone)));
                locations.add(new Location(getString(R.string.restaurant_10_name), getString(R.string.restaurant_10_description), R.drawable.restaurants_bocca_lupo, getString(R.string.restaurant_10_address), getString(R.string.restaurant_10_phone)));
                break;
            //Entertainment
            case 1:
                locations.add(new Location(getString(R.string.entertainment_1_name), getString(R.string.entertainment_1_description), R.drawable.entertainment_therme, getString(R.string.entertainment_1_address), getString(R.string.entertainment_1_phone)));
                locations.add(new Location(getString(R.string.entertainment_2_name), getString(R.string.entertainment_2_description), R.drawable.entertainment_divertiland, getString(R.string.entertainment_2_address), getString(R.string.entertainment_2_phone)));
                locations.add(new Location(getString(R.string.entertainment_3_name), getString(R.string.entertainment_3_description), R.drawable.entertainment_edenland, getString(R.string.entertainment_3_address), getString(R.string.entertainment_3_phone)));
                locations.add(new Location(getString(R.string.entertainment_4_name), getString(R.string.entertainment_4_description), R.drawable.entertainment_museum_of_senses, getString(R.string.entertainment_4_address), getString(R.string.entertainment_4_phone)));
                locations.add(new Location(getString(R.string.entertainment_5_name), getString(R.string.entertainment_5_description), R.drawable.entertainment_city_bus, getString(R.string.entertainment_5_address), getString(R.string.entertainment_5_phone)));
                break;
            //Culture
            case 2:
                locations.add(new Location(getString(R.string.culture_1_name), getString(R.string.culture_1_description), R.drawable.culture_casa_poporului, getString(R.string.culture_1_address), getString(R.string.culture_1_phone)));
                locations.add(new Location(getString(R.string.culture_2_name), getString(R.string.culture_2_description), R.drawable.culture_muzeul_satului, getString(R.string.culture_2_address), getString(R.string.culture_2_phone)));
                locations.add(new Location(getString(R.string.culture_3_name), getString(R.string.culture_3_description), R.drawable.culture_arcul_de_triumf, getString(R.string.culture_3_address), getString(R.string.culture_3_phone)));
                locations.add(new Location(getString(R.string.culture_4_name), getString(R.string.culture_4_description), R.drawable.culture_ateneul_roman, getString(R.string.culture_4_address), getString(R.string.culture_4_phone)));
                locations.add(new Location(getString(R.string.culture_5_name), getString(R.string.culture_5_description), R.drawable.culture_caruresti, getString(R.string.culture_5_address), getString(R.string.culture_5_phone)));
                break;
            //Parks
            case 3:
                locations.add(new Location(getString(R.string.park_1_name), getString(R.string.park_1_description), R.drawable.parks_cismigiu, getString(R.string.park_1_address), getString(R.string.park_1_phone)));
                locations.add(new Location(getString(R.string.park_2_name), getString(R.string.park_2_description), R.drawable.parks_mihai, getString(R.string.park_2_address), getString(R.string.park_2_phone)));
                locations.add(new Location(getString(R.string.park_3_name), getString(R.string.park_3_description), R.drawable.parks_carol, getString(R.string.park_3_address), getString(R.string.park_3_phone)));
                locations.add(new Location(getString(R.string.park_4_name), getString(R.string.park_4_description), R.drawable.parks_tineretului, getString(R.string.park_4_address), getString(R.string.park_4_phone)));
                locations.add(new Location(getString(R.string.park_5_name), getString(R.string.park_5_description), R.drawable.parks_ior, getString(R.string.park_5_address), getString(R.string.park_5_phone)));
                locations.add(new Location(getString(R.string.park_6_name), getString(R.string.park_6_description), R.drawable.parks_mogosoaia, getString(R.string.park_6_address), getString(R.string.park_6_phone)));
                locations.add(new Location(getString(R.string.park_7_name), getString(R.string.park_7_description), R.drawable.parks_moghioros, getString(R.string.park_7_address), getString(R.string.park_7_phone)));
                locations.add(new Location(getString(R.string.park_8_name), getString(R.string.park_8_description), R.drawable.parks_circului, getString(R.string.park_8_address), getString(R.string.park_8_phone)));
                break;
            default:
                break;
        }
    }
}

