package com.jmc.dogsapi.mapper;

import com.jmc.domain.repository.mapper.Mapper;

import javax.inject.Inject;

public class NameDogsModelViewPresenterToNameDogsModelDomainMapper extends Mapper<String, String> {

    @Inject
    public NameDogsModelViewPresenterToNameDogsModelDomainMapper() {
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
