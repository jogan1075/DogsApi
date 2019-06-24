package com.jmc.domain.repository.mapper;

import javax.inject.Inject;

public class TypeDogsModelDomainToTypeDogsEntityDataMapper extends Mapper<String, String> {

    @Inject
    public TypeDogsModelDomainToTypeDogsEntityDataMapper() {
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