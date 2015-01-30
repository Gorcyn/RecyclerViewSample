package com.gorcyn.sample.recyclerview.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gorcyn.sample.recyclerview.R;
import com.gorcyn.sample.recyclerview.model.Country;

import java.util.LinkedList;
import java.util.List;

public class CountryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<String> entries = new LinkedList<>();
    private List<Integer> headers = new LinkedList<>();

    public void setCountries(List<Country> countries) {
        for (Country country : countries) {
            this.entries.add(country.getName());
            this.headers.add(this.entries.size() - 1);
            this.entries.addAll(country.getCities());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (headers.contains(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_country, viewGroup, false);
            return new HeaderViewHolder(view);
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_city, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).country.setText(entries.get(position));
        } else if (viewHolder instanceof ItemViewHolder) {
            ((ItemViewHolder) viewHolder).city.setText(entries.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView country;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            country = (TextView) itemView.findViewById(R.id.country);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView city;

        public ItemViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.city);
        }
    }
}
