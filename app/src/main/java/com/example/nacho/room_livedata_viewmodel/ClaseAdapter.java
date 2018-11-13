package com.example.nacho.room_livedata_viewmodel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ClaseAdapter extends RecyclerView.Adapter<ClaseAdapter.ClaseViewHolder> {

    private final LayoutInflater mInflater;
    private List<Clase> mClases; // Cached copy of words

    ClaseAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ClaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ClaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClaseViewHolder holder, int position) {
        if (mClases != null) {
            Clase current = mClases.get(position);
            holder.claseItemView.setText(current.getClaseNombre());
        } else {
            // Covers the case of data not being ready yet.
            holder.claseItemView.setText("No Class");
        }
    }

    void setClases(List<Clase> clases){
        mClases = clases;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mClases != null)
            return mClases.size();
        else return 0;
    }

    class ClaseViewHolder extends RecyclerView.ViewHolder {
        private final TextView claseItemView;

        private ClaseViewHolder(View itemView) {
            super(itemView);
            claseItemView = itemView.findViewById(R.id.textView);
        }
    }
}
