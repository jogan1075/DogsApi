package com.jmc.domain.usercases;

import com.jmc.domain.common.UseCaseParam;
import com.jmc.domain.repository.DogsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetTypeDogsUseCase extends UseCaseParam<String,List<String>> {

    private DogsRepository dogsRepository;

    @Inject
    public GetTypeDogsUseCase(DogsRepository dogsRepository, Scheduler scheduler) {
        super(scheduler);
        this.dogsRepository = dogsRepository;
    }



    @Override
    protected Observable<List<String>> buildUseCaseObservable(String type) {
        return dogsRepository.getTypeDogsByName(type);
    }
}
