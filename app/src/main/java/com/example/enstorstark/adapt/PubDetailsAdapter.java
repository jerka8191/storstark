package com.example.enstorstark.adapt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.enstorstark.PubDetail;
import com.example.enstorstark.R;

import java.util.List;

public class PubDetailsAdapter extends RecyclerView.Adapter<PubDetailsAdapter.ViewHolder> {

    private List<PubDetail> details;

    public PubDetailsAdapter(List<PubDetail> details) {
        this.details = details;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView label;
        TextView value;

        public ViewHolder(View view) {
            super(view);
            label = view.findViewById(R.id.textLabel);
            value = view.findViewById(R.id.textValue);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pub_detail, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PubDetail detail = details.get(position);

        holder.label.setText(detail.label());
        holder.value.setText(detail.value());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}

