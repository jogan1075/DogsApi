package com.jmc.domain.repository;

import java.util.List;

import io.reactivex.Observable;

public interface DogsRepository {

    Observable<List<String>> getDogs();

    Observable<List<String>> getTypeDogsByName(String type);
}
