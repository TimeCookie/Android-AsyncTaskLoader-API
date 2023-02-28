package com.example.lifecost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context ctx;
    List<Data> data;

    public ViewAdapter(Context ctx, List<Data> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.cost_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(data.get(position).getItemName());
        holder.categoryName.setText(data.get(position).getCategoryName());
        holder.currency.setText(data.get(position).getCurrency());
        holder.averagePrice.setText(data.get(position).getAveragePrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
