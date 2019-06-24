package com.jmc.data.remote.retrofit;

import com.jmc.data.entity.NameDogsEntity;
import com.jmc.data.entity.TypeDogsEntity;
import com.jmc.data.remote.DogApi;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import static com.jmc.data.remote.Constants.URL_BASE;

public class DogsApiImp extends RetrofitApiClient<DogApi> implements DogsRestApi {

    private Scheduler scheduler;

    public DogsApiImp(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


    @Override
    protected Class<DogApi> getApiService() {
        return DogApi.class;
    }

    @Override
    protected String getBaseURL() {
        return URL_BASE;
    }


    @Override
    public Observable<NameDogsEntity> getDogs() {
        return apiService.getDogs().subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }

    @Override
    public Observable<TypeDogsEntity> getDogsbyType(String type) {
        return apiService.getDogsbyType(type).subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }
}
