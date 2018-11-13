package com.example.nacho.room_livedata_viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordViewModel mWordViewModel;
    private ClaseViewModel mClaseViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final ClaseAdapter adapter1 = new ClaseAdapter(this);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mClaseViewModel = ViewModelProviders.of(this).get(ClaseViewModel.class);
        ClaseRoomDatabase.getDatabase(this).claseDao().getAllClases().observe(this, new Observer<List<Clase>>() {

            @Override
            public void onChanged(@Nullable List<Clase> clases) {

                if (clases != null) {

                    Log.d("Database", clases.toString());

                }

            }




        });

        mClaseViewModel.getAllClases().observe(this, new Observer<List<Clase>>() {
            @Override
            public void onChanged(@Nullable final List<Clase> clases) {
                // Update the cached copy of the words in the adapter.
                adapter1.setClases(clases);
            }
        });


    }
}
