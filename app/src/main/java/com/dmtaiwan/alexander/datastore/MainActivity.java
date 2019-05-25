package com.dmtaiwan.alexander.datastore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = findViewById(R.id.location_list_view);

        // Create location store and fetch all locations;
        LocationStore locationStore = new LocationStore();
        ArrayList<Location> allLocations = locationStore.getAllLocations();

        //Create and set Adapter with all locations
        LocationAdapter locationAdapter = new LocationAdapter(this, allLocations);
        listView.setAdapter(locationAdapter);

        //Set up listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent;
                if (position % 2 == 0) {
                    // If a residence is clicked on, open residence page
                    intent = new Intent(MainActivity.this, ResidenceActivity.class);
                } else {
                    // Otherwise open business page
                    intent = new Intent(MainActivity.this, BusinessActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}
