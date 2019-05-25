package com.dmtaiwan.alexander.datastore;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

public class BusinessActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.location_list_view);

        //Create locationStore and get business locations
        LocationStore locationStore = new LocationStore();
        ArrayList<Location> businessLocations = locationStore.getResidentalLocations();

        //Create and set adapter
        LocationAdapter adapter = new LocationAdapter(this, businessLocations);
        listView.setAdapter(adapter);
    }
}
