package com.jmc.dogsapi.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.jmc.dogsapi.R;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.MyViewHolder> {
    public static final String URL_POSTER = "http://image.tmdb.org/t/p/w500";
    private List<String> values;

    final private ListItemClickListener mOnClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
//        public AppCompatImageView mPosterView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.titleView);
//            mPosterView = v.findViewById(R.id.posterView);
        }
    }

    public DogsAdapter(List<String> values, ListItemClickListener listener) {
        this.values = values;
        this.mOnClickListener = listener;
    }

    @Override
    public DogsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dogs, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText(values.get(position).toString());
//        Glide.with(holder.mPosterView.getContext())
//                .load(URL_POSTER + movieModelViews.get(position).posterPath)
//                .into(holder.mPosterView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mOnClickListener.onListItemClick(values.get(position));
            }
        });

        holder.itemView.toString();

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(String name);
    }
}
