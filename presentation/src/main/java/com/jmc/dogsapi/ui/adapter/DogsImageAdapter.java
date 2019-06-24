package com.jmc.dogsapi.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jmc.dogsapi.R;


import java.util.ArrayList;


public class DogsImageAdapter extends RecyclerView.Adapter<DogsImageAdapter.MyViewHolder> {

    private ArrayList<String> values;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView mPosterView;

        public MyViewHolder(View v) {
            super(v);
            mPosterView = v.findViewById(R.id.posterView);
        }
    }

    public DogsImageAdapter(ArrayList<String> values) {
        this.values = values;

    }

    @Override
    public DogsImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_img_dogs, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Glide.with(holder.mPosterView.getContext())
                .load(values.get(position))
                .into(holder.mPosterView);


    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}
