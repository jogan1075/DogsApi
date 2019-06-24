package com.jmc.dogsapi.di;

import com.jmc.data.datasource.factory.DogsApiDataSourceFactory;
import com.jmc.dogsapi.mapper.NameDogsModelViewPresenterToNameDogsModelDomainMapper;
import com.jmc.dogsapi.mapper.TypeDogsModelViewPresenterToTypeDogsModelDomainMapper;
import com.jmc.dogsapi.observer.NameDogsObserver;
import com.jmc.dogsapi.observer.TypeDogsObserver;
import com.jmc.dogsapi.presenter.DogsPresenter;
import com.jmc.domain.repository.DogsApiRepository;
import com.jmc.domain.repository.DogsRepository;
import com.jmc.domain.repository.mapper.NameDogsModelDomainToNameDogsEntityDataMapper;
import com.jmc.domain.repository.mapper.TypeDogsModelDomainToTypeDogsEntityDataMapper;
import com.jmc.domain.usercases.GetNameDogsUseCase;
import com.jmc.domain.usercases.GetTypeDogsUseCase;


import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class DogsModule {


    @Provides
    public NameDogsModelDomainToNameDogsEntityDataMapper provideNameDogsModelDomainToNameDogsEntityDataMapper() {
        return new NameDogsModelDomainToNameDogsEntityDataMapper();
    }


    @Provides
    public TypeDogsModelDomainToTypeDogsEntityDataMapper typeDogsModelDomainToTypeDogsEntityDataMapper() {

        return new TypeDogsModelDomainToTypeDogsEntityDataMapper();
    }

    @Provides
    public NameDogsModelViewPresenterToNameDogsModelDomainMapper provideNameDogsModelViewPresenterToNameDogsModelDomainMapper() {
        return new NameDogsModelViewPresenterToNameDogsModelDomainMapper();
    }

    @Provides
    public TypeDogsModelViewPresenterToTypeDogsModelDomainMapper provideTypeDogsModelViewPresenterToTypeDogsModelDomainMapper() {
        return new TypeDogsModelViewPresenterToTypeDogsModelDomainMapper();
    }


    @Provides
    public DogsApiDataSourceFactory provideDogsApiDataSourceFactory(Scheduler scheduler) {
        return new DogsApiDataSourceFactory(scheduler);
    }

    @Provides
    public DogsRepository provideDogsRepository(DogsApiDataSourceFactory movieApiDataSourceFactory,
                                                NameDogsModelDomainToNameDogsEntityDataMapper provideNameDogsModelDomainToNameDogsEntityDataMapper,
                                                TypeDogsModelDomainToTypeDogsEntityDataMapper provideTypeDogsModelDomainToTypeDogsEntityDataMapper) {
        return new DogsApiRepository(movieApiDataSourceFactory.createDataSource(),
                provideNameDogsModelDomainToNameDogsEntityDataMapper, provideTypeDogsModelDomainToTypeDogsEntityDataMapper);
    }

    @Provides
    public Scheduler provideAndroidProvide() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    public GetNameDogsUseCase provideGetMoviesMoreRatedUseCase(DogsRepository dogsRepository,
                                                               Scheduler scheduler) {
        return new GetNameDogsUseCase(dogsRepository, scheduler);
    }

    @Provides
    public GetTypeDogsUseCase provideGetMoviesPopulatedUseCase(DogsRepository dogsRepository, Scheduler scheduler) {
        return new GetTypeDogsUseCase(dogsRepository, scheduler);
    }

    @Provides
    public DogsPresenter provideDogsPresenter(GetNameDogsUseCase getNameDogsUseCase, GetTypeDogsUseCase getTypeDogsUseCase,
                                              NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper,
                                              TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper) {
        return new DogsPresenter(getNameDogsUseCase, getTypeDogsUseCase, nameDogsModelViewPresenterToNameDogsModelDomainMapper, typeDogsModelViewPresenterToTypeDogsModelDomainMapper);
    }

    @Provides
    public NameDogsObserver provideNameDogsObserver(
            NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper) {
        return new NameDogsObserver(nameDogsModelViewPresenterToNameDogsModelDomainMapper);
    }

    @Provides
    public TypeDogsObserver provideTypeDogsObserver(
            TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper) {
        return new TypeDogsObserver(typeDogsModelViewPresenterToTypeDogsModelDomainMapper);
    }
}
