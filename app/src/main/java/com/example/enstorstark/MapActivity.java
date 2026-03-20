package com.example.enstorstark;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.preference.PreferenceManager;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_map);

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);

        map.getController().setZoom(15.0);
        map.getController().setCenter(new GeoPoint(57.7089, 11.9746));

        // My location
        MyLocationNewOverlay locationOverlay = new MyLocationNewOverlay(
                new GpsMyLocationProvider(this), map);
        locationOverlay.enableMyLocation();
        map.getOverlays().add(locationOverlay);

        // Compass
        CompassOverlay compassOverlay = new CompassOverlay(this, map);
        compassOverlay.enableCompass();
        map.getOverlays().add(compassOverlay);

        addMarkers();
    }

    private List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location("Point A", 57.7089, 11.9746));
        locations.add(new Location("Point B", 57.7100, 11.9800));
        locations.add(new Location("Point C", 57.7050, 11.9700));
        return locations;
    }

    private void addMarkers() {
        for (Location loc : getLocations()) {
            Marker marker = new Marker(map);
            marker.setPosition(new GeoPoint(loc.lat, loc.lng));
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
            marker.setTitle(loc.name);
            marker.setSnippet("Lat: " + loc.lat + ", Lng: " + loc.lng);

            marker.setOnMarkerClickListener((m, mapView) -> {
                if (m.isInfoWindowShown()) {
                    Intent intent = new Intent(MapActivity.this, PubDetailsActivity.class);
                    intent.putExtra("name", loc.name);
                    intent.putExtra("lat", loc.lat);
                    intent.putExtra("lng", loc.lng);
                    startActivity(intent);
                } else {
                    m.showInfoWindow();
                }
                return true;
            });

            map.getOverlays().add(marker);
        }
        map.invalidate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }
}