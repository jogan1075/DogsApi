package com.jmc.data.datasource;

import com.jmc.data.entity.NameDogsEntity;
import com.jmc.data.entity.TypeDogsEntity;
import com.jmc.data.remote.retrofit.DogsRestApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DogsApiDataSource implements DogsDataSource {

    private DogsRestApi dogsRestApi;

    @Inject
    public DogsApiDataSource(DogsRestApi dogsRestApi) {
        this.dogsRestApi = dogsRestApi;
    }

    @Override
    public Observable<List<String>> getDogs() {
        return dogsRestApi.getDogs().map(new Function<NameDogsEntity, List<String>>() {
            @Override
            public List<String> apply(NameDogsEntity nameDogsEntity) throws Exception {
                return nameDogsEntity.message;
            }
        });
    }

    @Override
    public Observable<List<String>> getDogsbyType(String type) {
        return dogsRestApi.getDogsbyType(type).map(new Function<TypeDogsEntity, List<String>>() {
            @Override
            public List<String> apply(TypeDogsEntity typeDogsEntity) throws Exception {
                return typeDogsEntity.message;
            }
        });
    }


}
