package com.example.enstorstark;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enstorstark.adapt.PubsAdapter;
import com.example.enstorstark.appdata.PlaceholderData;
import com.example.enstorstark.items.Pub;

import java.util.List;

public class PubsActivity extends AppCompatActivity implements PubsAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private PubsAdapter adapter;
    private List<Pub> pubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubs);
        recyclerView = findViewById(R.id.recyclerView);
        pubs = PlaceholderData.get(); // remove this when database exists
        pubs.sort((p1, p2) -> Double.compare(p2.getApk(), p1.getApk()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PubsAdapter(pubs, this);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(Pub pub) {
        Toast.makeText(this,
                "TODO: Launch activity to display details on " + pub.name(),
                Toast.LENGTH_LONG).show();
    }
}