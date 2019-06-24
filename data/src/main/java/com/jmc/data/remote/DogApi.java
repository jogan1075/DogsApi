package com.jmc.data.remote;

import com.jmc.data.entity.NameDogsEntity;
import com.jmc.data.entity.TypeDogsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApi {


    @GET("breeds/list")
    Observable<NameDogsEntity> getDogs();


    @GET("breed/{type}/images")
    Observable<TypeDogsEntity> getDogsbyType(@Path("type") String typeDog);

}
