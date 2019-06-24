package com.jmc.domain.usercases;

import com.jmc.domain.common.UseCase;
import com.jmc.domain.repository.DogsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetNameDogsUseCase extends UseCase<List<String>> {

    private DogsRepository dogsRepository;

    @Inject
    public GetNameDogsUseCase(DogsRepository dogsRepository, Scheduler scheduler) {
        super(scheduler);
        this.dogsRepository = dogsRepository;
    }

    @Override
    protected Observable<List<String>> buildUseCaseObservable() {

        return dogsRepository.getDogs();
    }
}
