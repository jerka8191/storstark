package com.example.enstorstark;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
        pubs.sort((p1, p2) -> Double.compare(p2.beer().getApk(), p1.beer().getApk()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PubsAdapter(pubs, this);
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search pub");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
    }

    public void onItemClick(Pub pub) {
        Intent intent = new Intent(this, PubDetailsActivity.class);
        intent.putExtra("pub", pub);
        startActivity(intent);
    }
}