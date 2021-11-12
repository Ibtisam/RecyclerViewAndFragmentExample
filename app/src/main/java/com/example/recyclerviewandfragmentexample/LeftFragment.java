package com.example.recyclerviewandfragmentexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment {
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private String[] dataSet;
    private RecyclerView.LayoutManager layoutManager;

    public LeftFragment() {
        // Required empty public constructor
    }

    public static LeftFragment newInstance(String[] dataSet) {
        LeftFragment fragment = new LeftFragment();
        fragment.dataSet = dataSet;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewFragment);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customAdapter = new CustomAdapter(dataSet, getActivity());
        recyclerView.setAdapter(customAdapter);
    }
}