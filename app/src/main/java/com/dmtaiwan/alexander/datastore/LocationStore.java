package com.dmtaiwan.alexander.datastore;

import java.util.ArrayList;

public class LocationStore {

    private ArrayList<Location> locations;

    public LocationStore() {
        locations = createLocations();
    }

    private ArrayList<Location> createLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Location location;
            String indexStr = String.valueOf((i));
            if (i % 2 == 0) {
                location = new Location("Test Residence " + indexStr, "Residence");
            } else {
                location = new Location("Test Business " + indexStr, "Business");
            }
            locations.add(location);
        }
        return locations;
    }

    public ArrayList<Location> getAllLocations() {
        return locations;
    }

    public ArrayList<Location> getBusinessLocations() {
        ArrayList<Location> businesses = new ArrayList<>();
        for (int i = 0; i < locations.size(); i++) {
            if (i % 2 != 0) {
                businesses.add(locations.get(i));
            }
        }
        return businesses;
    }

    public ArrayList<Location> getResidentalLocations() {
        ArrayList<Location> residences = new ArrayList<>();
        for (int i = 0; i < locations.size(); i++) {
            if (i % 2 == 0) {
                residences.add(locations.get(i));
            }
        }
        Utils.Log(residences);
        return residences;
    }
}
