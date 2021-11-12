package com.example.recyclerviewandfragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private String[] dataSet;
    private RecyclerView.LayoutManager layoutManager;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LeftFragment leftFragment;
    private RightFragment rightFragment;

    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = getResources().getStringArray(R.array.List_Items);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.initialize();

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            leftFragment = LeftFragment.newInstance(dataSet);
            rightFragment = RightFragment.newInstance();
            fragmentTransaction.replace(R.id.leftFrame, leftFragment);
            fragmentTransaction.replace(R.id.rightFrame, rightFragment);
            fragmentTransaction.commitNow();
        }else {
            recyclerView = findViewById(R.id.recyclerViewActivity);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            customAdapter = new CustomAdapter(dataSet, this);
            recyclerView.setAdapter(customAdapter);
        }
    }
}