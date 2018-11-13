package com.example.nacho.room_livedata_viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ClaseViewModel extends AndroidViewModel {

    private ClaseRepository mRepository;

    private LiveData<List<Clase>> mAllClases;

    public ClaseViewModel (Application application) {
        super(application);
        mRepository = new ClaseRepository(application);
        mAllClases = mRepository.getmAllClases();
    }

    LiveData<List<Clase>> getAllClases() { return mAllClases; }

    public void insert(Clase clase) { mRepository.insert(clase); }
}
