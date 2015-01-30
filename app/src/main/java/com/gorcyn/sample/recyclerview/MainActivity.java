package com.gorcyn.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gorcyn.sample.recyclerview.model.Country;
import com.gorcyn.sample.recyclerview.provider.CountryProvider;
import com.gorcyn.sample.recyclerview.widget.CountryRecyclerAdapter;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    RecyclerView recyclerView;
    CountryRecyclerAdapter adapter = new CountryRecyclerAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        List<Country> countries = CountryProvider.getCountries();
        adapter.setCountries(countries);
        adapter.notifyDataSetChanged();
    }
}
