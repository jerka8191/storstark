package com.example.enstorstark.adapt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enstorstark.R;
import com.example.enstorstark.items.Pub;

import java.util.List;
import java.util.Locale;

public class PubsAdapter extends RecyclerView.Adapter<PubsAdapter.PubViewHolder> {
    private List<Pub> pubList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Pub pub);
    }

    public PubsAdapter(List<Pub> pubList, OnItemClickListener listener) {
        this.pubList = pubList;
        this.listener = listener;
    }

    public static class PubViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textApk;

        public PubViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textApk = itemView.findViewById(R.id.textApk);
        }
    }

    @NonNull
    @Override
    public PubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new PubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PubViewHolder holder, int position) {
        Pub currentItem = pubList.get(position);
        holder.textName.setText(currentItem.name());
        holder.textApk.setText(String.format(Locale.getDefault(),
                "%.3f", currentItem.getApk()));
        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(currentItem);
        });
    }

    @Override
    public int getItemCount() {
        return pubList.size();
    }
}
