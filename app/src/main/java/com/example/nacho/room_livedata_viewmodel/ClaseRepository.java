package com.example.nacho.room_livedata_viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ClaseRepository {

    private ClaseDao mClaseDao;
    private LiveData<List<Clase>> mAllClases;

    ClaseRepository(Application application) {
        ClaseRoomDatabase db = ClaseRoomDatabase.getDatabase(application);
        mClaseDao = db.claseDao();
        mAllClases = mClaseDao.getAllClases();
    }

    LiveData<List<Clase>> getmAllClases() {
        return mAllClases;
    }

    public void insert (Clase clase) {
        new insertAsyncTask(mClaseDao).execute(clase);
    }

    private static class insertAsyncTask extends AsyncTask<Clase, Void, Void> {

        private ClaseDao mAsyncTaskDao;

        insertAsyncTask(ClaseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Clase... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
