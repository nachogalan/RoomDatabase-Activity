package com.example.nacho.room_livedata_viewmodel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "clases_table")
public class Clase {





        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")

        private Integer mClaseId;

        @ColumnInfo(name = "nombre")
        private String mClaseNombre;

        @ColumnInfo(name = "profesor")
        private String mClaseProfe;

        @ColumnInfo(name = "numero_alumnos")
        private Integer mClaseAlumnos;

    @ColumnInfo(name = "horas_semanales")
    private Integer mClaseHoras;

        public Clase(@NonNull Integer claseId, String claseNombre, String claseProfe, Integer claseAlumnos, Integer claseHoras) {
            this.mClaseId = claseId;
            this.mClaseNombre = claseNombre;
            this.mClaseProfe = claseProfe;
            this.mClaseAlumnos = claseAlumnos;
            this.mClaseHoras = claseHoras;}

    @NonNull
    public Integer getClaseId() {
        return mClaseId;
    }

    public void setClaseId(@NonNull Integer mClaseId) {
        this.mClaseId = mClaseId;
    }

    public String getClaseNombre() {
        return mClaseNombre;
    }

    public void setClaseNombre(String mClaseNombre) {
        this.mClaseNombre = mClaseNombre;
    }

    public String getClaseProfe() {
        return mClaseProfe;
    }

    public void setClaseProfe(String mClaseProfe) {
        this.mClaseProfe = mClaseProfe;
    }

    public Integer getClaseAlumnos() {
        return mClaseAlumnos;
    }

    public void setClaseAlumnos(Integer mClaseAlumnos) {
        this.mClaseAlumnos = mClaseAlumnos;
    }

    public Integer getClaseHoras() {
        return mClaseHoras;
    }

    public void setClaseHoras(Integer mClaseHoras) {
        this.mClaseHoras = mClaseHoras;
    }
}

