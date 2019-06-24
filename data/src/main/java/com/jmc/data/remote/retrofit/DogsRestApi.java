package com.jmc.data.remote.retrofit;

import com.jmc.data.entity.NameDogsEntity;
import com.jmc.data.entity.TypeDogsEntity;

import io.reactivex.Observable;

public interface DogsRestApi {
    Observable<NameDogsEntity> getDogs();

    Observable<TypeDogsEntity> getDogsbyType(String type);
}
