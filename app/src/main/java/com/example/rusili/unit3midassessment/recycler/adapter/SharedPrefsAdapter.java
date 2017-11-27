package com.example.rusili.unit3midassessment.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.unit3midassessment.R;
import com.example.rusili.unit3midassessment.recycler.view.SharedPrefsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/27/17.
 */

public class SharedPrefsAdapter extends RecyclerView.Adapter<SharedPrefsViewHolder> {
    private List<Object> objectList = new ArrayList<>();

    public SharedPrefsAdapter(List<Object> objectList){
        this.objectList = objectList;
    }

    @Override
    public SharedPrefsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shared_prefs_viewholder, parent, false);
        return new SharedPrefsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SharedPrefsViewHolder holder, int position) {
        holder.bind(objectList.get(position));
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }
}
