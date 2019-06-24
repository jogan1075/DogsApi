package com.jmc.dogsapi.mapper;

import com.jmc.domain.repository.mapper.Mapper;

import javax.inject.Inject;

public class TypeDogsModelViewPresenterToTypeDogsModelDomainMapper extends Mapper<String, String> {

    @Inject
    public TypeDogsModelViewPresenterToTypeDogsModelDomainMapper() {
    }


    @Override
    public String map(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String reverseMap(String value) {
        return value;
    }
}
