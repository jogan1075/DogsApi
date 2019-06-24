package com.jmc.domain.repository;

import com.jmc.data.datasource.DogsDataSource;
import com.jmc.domain.repository.mapper.NameDogsModelDomainToNameDogsEntityDataMapper;
import com.jmc.domain.repository.mapper.TypeDogsModelDomainToTypeDogsEntityDataMapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DogsApiRepository implements DogsRepository {

    private DogsDataSource dogsDataSource;
    private NameDogsModelDomainToNameDogsEntityDataMapper nameDogsModelDomainToNameDogsEntityDataMapper;
    private TypeDogsModelDomainToTypeDogsEntityDataMapper typeDogsModelDomainToTypeDogsEntityDataMapper;

    @Inject
    public DogsApiRepository(DogsDataSource dogsDataSource, NameDogsModelDomainToNameDogsEntityDataMapper nameDogsModelDomainToNameDogsEntityDataMapper, TypeDogsModelDomainToTypeDogsEntityDataMapper typeDogsModelDomainToTypeDogsEntityDataMapper) {
        this.dogsDataSource = dogsDataSource;
        this.nameDogsModelDomainToNameDogsEntityDataMapper = nameDogsModelDomainToNameDogsEntityDataMapper;
        this.typeDogsModelDomainToTypeDogsEntityDataMapper = typeDogsModelDomainToTypeDogsEntityDataMapper;
    }

    @Override
    public Observable<List<String>> getDogs() {
        return dogsDataSource.getDogs().delay(2000, TimeUnit.MILLISECONDS)
                .map(new Function<List<String>, List<String>>() {
                    @Override
                    public List<String> apply(List<String> strings) throws Exception {
                        return nameDogsModelDomainToNameDogsEntityDataMapper.reverseMap(strings);
                    }
                });
    }

    @Override
    public Observable<List<String>> getTypeDogsByName(String type) {
        return dogsDataSource.getDogsbyType(type).delay(2000, TimeUnit.MILLISECONDS).map(new Function<List<String>, List<String>>() {
            @Override
            public List<String> apply(List<String> strings) throws Exception {
                return typeDogsModelDomainToTypeDogsEntityDataMapper.reverseMap(strings);
            }
        });
    }

}


