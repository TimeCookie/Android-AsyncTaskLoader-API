package com.example.lifecost;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView itemName, categoryName, currency, averagePrice;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.item_name);
        categoryName = itemView.findViewById(R.id.category_name);
        currency = itemView.findViewById(R.id.currency);
        averagePrice = itemView.findViewById(R.id.avg_price);
    }
}
