package com.jmc.dogsapi.ui;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.jmc.dogsapi.R;
import com.jmc.dogsapi.ui.adapter.DogsImageAdapter;
import com.jmc.dogsapi.utils.commons.BaseActivity;

import java.util.ArrayList;

//import static com.jmc.movies.ui.adapter.MovieAdapter.URL_POSTER;

public class DetalleActivity extends BaseActivity {

    private ArrayList<String> imagesDogs;
    RecyclerView recyclerView;
    DogsImageAdapter adapter;
    ProgressDialog progressDialog;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detalle;
    }

    @Override
    protected void onPrepareActivity() {
        super.onPrepareActivity();

        Intent intent = getIntent();
        imagesDogs = intent.getExtras().getStringArrayList("itemSelected");

        recyclerView = findViewById(R.id.recicler);

        setupScreen();

    }


    public void setupScreen() {

        mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new DogsImageAdapter(imagesDogs);

        recyclerView.setAdapter(adapter);

    }
}
