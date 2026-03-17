package com.example.enstorstark;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enstorstark.adapt.PubDetailsAdapter;
import com.example.enstorstark.items.Pub;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PubDetailsActivity extends AppCompatActivity {

    private static final String APK_FORMAT = "%.3f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_details);
        RecyclerView recycler = findViewById(R.id.detailsRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Pub pub = getIntent().getParcelableExtra("pub");
        TextView textPubName = findViewById(R.id.textPubName);
        textPubName.setText(pub.name());
        List<PubDetail> details = new ArrayList<>();
        double apk = pub.beer().getApk();
        Locale locale = java.util.Locale.getDefault();
        PubDetail detail = new PubDetail("APK", String.format(locale, APK_FORMAT, apk));
        details.add(detail);
        PubDetailsAdapter adapter = new PubDetailsAdapter(details);
        recycler.setAdapter(adapter);
    }
}