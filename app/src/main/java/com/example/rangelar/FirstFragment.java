package com.example.rangelar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlanetAdapter adapter;
    private ArrayList<Planeta> planetArrayList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        planetArrayList = new ArrayList<>();
        adapter = new PlanetAdapter(this, planetArrayList);
        recyclerView.setAdapter(adapter);
        createListData();
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
    private void createListData() {
        Planeta planet = new Planeta("Earth", 150, 10, 12750);
        planetArrayList.add(planet);
        planet = new Planeta("Jupiter", 778, 26, 143000);
        planetArrayList.add(planet);
        planet = new Planeta("Mars", 228, 4, 6800);
        planetArrayList.add(planet);
        planet = new Planeta("Pluto", 5900, 1, 2320);
        planetArrayList.add(planet);
        planet = new Planeta("Venus", 108, 9, 12750);
        planetArrayList.add(planet);
        planet = new Planeta("Saturn", 1429, 11, 120000);
        planetArrayList.add(planet);
        planet = new Planeta("Mercury", 58, 4, 4900);
        planetArrayList.add(planet);
        planet = new Planeta("Neptune", 4500, 12, 50500);
        planetArrayList.add(planet);
        planet = new Planeta("Uranus", 2870, 9, 52400);
        planetArrayList.add(planet);
        adapter.notifyDataSetChanged();
    }
}