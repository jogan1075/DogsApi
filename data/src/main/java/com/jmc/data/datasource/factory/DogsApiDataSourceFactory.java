package com.jmc.data.datasource.factory;

import com.jmc.data.datasource.DogsApiDataSource;
import com.jmc.data.remote.retrofit.DogsApiImp;

import javax.inject.Inject;

import io.reactivex.Scheduler;

public class DogsApiDataSourceFactory implements DataSourceFactory<DogsApiDataSource> {

    private Scheduler scheduler;

    @Inject
    public DogsApiDataSourceFactory(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public DogsApiDataSource createDataSource() {
        return new DogsApiDataSource(new DogsApiImp(scheduler));
    }


}
