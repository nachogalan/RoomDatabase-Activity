package com.example.nacho.room_livedata_viewmodel;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Clase.class}, version = 1)
public abstract class ClaseRoomDatabase extends RoomDatabase {

    public abstract ClaseDao claseDao();
    private static ClaseRoomDatabase INSTANCE;

    static ClaseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClaseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ClaseRoomDatabase.class, BuildConfig.DATABASE_NAME)
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsyncClase(INSTANCE).execute();
                }
            };
}

class PopulateDbAsyncClase extends AsyncTask<Void, Void, Void> {

    private final ClaseDao mDao;

    Integer[] idClases = {1,2,3,4,5};
    String[] nombreClases = {"Lengua","Matemáticas","Inglés","Sociales","Física"};
    String[] profeClases = {"Maria","Juan","Laura","Estronzo","Gabriela"};
    Integer[] alumnosClases = {30, 28, 13, 31, 22};
    Integer[] horasClases = {12,6,2,6,4};

    PopulateDbAsyncClase(ClaseRoomDatabase db) {
        mDao = db.claseDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        // Start the app with a clean database every time.
        // Not needed if you only populate the database
        // when it is first created
        mDao.deleteAll();

        for (int i = 0; i <= idClases.length - 1; i++) {
            Clase clase = new Clase(idClases[i], nombreClases[i],profeClases[i], alumnosClases[i], horasClases[i]);
            mDao.insert(clase);
        }
        return null;
    }
}
