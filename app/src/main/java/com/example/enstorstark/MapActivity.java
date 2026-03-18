package com.example.enstorstark;

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

public class MapActivity extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Must be done before setContentView
        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_map);

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);

        // Set start position and zoom
        map.getController().setZoom(15.0);
        map.getController().setCenter(new GeoPoint(57.7089, 11.9746)); // Gothenburg

        // Show my location
        MyLocationNewOverlay locationOverlay = new MyLocationNewOverlay(
                new GpsMyLocationProvider(this), map);
        locationOverlay.enableMyLocation();
        map.getOverlays().add(locationOverlay);

        // Compass
        CompassOverlay compassOverlay = new CompassOverlay(this, map);
        compassOverlay.enableCompass();
        map.getOverlays().add(compassOverlay);
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
