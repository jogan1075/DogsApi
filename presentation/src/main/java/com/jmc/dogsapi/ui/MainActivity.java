package com.jmc.dogsapi.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.jmc.dogsapi.DogsApplication;
import com.jmc.dogsapi.R;
import com.jmc.dogsapi.contract.DogsContract;
import com.jmc.dogsapi.di.DaggerDogsComponent;
import com.jmc.dogsapi.di.DogsModule;
import com.jmc.dogsapi.presenter.DogsPresenter;
import com.jmc.dogsapi.ui.adapter.DogsAdapter;
import com.jmc.dogsapi.utils.commons.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements DogsContract.View, DogsAdapter.ListItemClickListener {

    @Inject
    DogsPresenter presenter;

    RecyclerView recyclerView;
    DogsAdapter adapter;
    ProgressDialog progressDialog;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> arrayList;

    @Override
    protected void onPrepareActivity() {
        super.onPrepareActivity();

        progressDialog = new ProgressDialog(this);
        recyclerView = findViewById(R.id.recicler);
        setupRecyclerView();
    }


    @Override
    protected void onPreparePresenter() {
        presenter.attachView(this);
        presenter.loadNameDogs();
    }


    @Override
    protected void onInject() {
        DaggerDogsComponent.builder()
                .applicationComponent(DogsApplication.getApplicationComponent())
                .dogsModule(new DogsModule())
                .build().inject(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    private void setupRecyclerView() {

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void showLoading() {
        progressDialog.setMessage(getString(R.string.Msg_Loading_Dialog));
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, "No hay conexion a internet", Toast.LENGTH_LONG).show();
    }


    @Override
    public void setNameDogsItems(List<String> movieItems) {
        adapter = new DogsAdapter(movieItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setTypeDogsItems(List<String> movieItems) {
        hideLoading();
        movieItems.size();


        arrayList = new ArrayList<>();
        for (int i = 0; i < movieItems.size(); i++) {

            arrayList.add(movieItems.get(i));
        }


        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("itemSelected", arrayList);
        startActivity(intent);
    }

    @Override
    public void onListItemClick(String name) {
        showLoading();
        presenter.loadTyoeDogsbyName(name);
    }
}
