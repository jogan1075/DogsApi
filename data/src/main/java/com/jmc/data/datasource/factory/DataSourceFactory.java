package com.jmc.data.datasource.factory;

public interface DataSourceFactory<T> {

    T createDataSource();
}

