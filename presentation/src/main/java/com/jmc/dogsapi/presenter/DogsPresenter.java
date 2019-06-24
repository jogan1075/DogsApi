package com.jmc.dogsapi.presenter;


import com.jmc.dogsapi.contract.DogsContract;
import com.jmc.dogsapi.mapper.NameDogsModelViewPresenterToNameDogsModelDomainMapper;
import com.jmc.dogsapi.mapper.TypeDogsModelViewPresenterToTypeDogsModelDomainMapper;
import com.jmc.dogsapi.observer.NameDogsObserver;
import com.jmc.dogsapi.observer.TypeDogsObserver;
import com.jmc.dogsapi.utils.commons.BasePresenter;
import com.jmc.domain.usercases.GetNameDogsUseCase;
import com.jmc.domain.usercases.GetTypeDogsUseCase;

import javax.inject.Inject;

public class DogsPresenter extends BasePresenter<DogsContract.View>
        implements DogsContract.Presenter {


    private GetNameDogsUseCase getNameDogsUseCase;
    private GetTypeDogsUseCase getTypeDogsUseCase;

    private NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper;
    private TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper;

    private NameDogsObserver nameDogsObserver;
    private TypeDogsObserver typeDogsObserver;

    @Inject
    public DogsPresenter(GetNameDogsUseCase getNameDogsUseCase,
                         GetTypeDogsUseCase getTypeDogsUseCase,
                         NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper,
                         TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper) {
        this.getNameDogsUseCase = getNameDogsUseCase;
        this.getTypeDogsUseCase = getTypeDogsUseCase;
        this.nameDogsModelViewPresenterToNameDogsModelDomainMapper = nameDogsModelViewPresenterToNameDogsModelDomainMapper;
        this.typeDogsModelViewPresenterToTypeDogsModelDomainMapper = typeDogsModelViewPresenterToTypeDogsModelDomainMapper;
    }


    @Override
    public void loadNameDogs() {
        nameDogsObserver = new NameDogsObserver(nameDogsModelViewPresenterToNameDogsModelDomainMapper);
        nameDogsObserver.attachView(getView());
        getNameDogsUseCase.execute(nameDogsObserver);
    }

    @Override
    public void loadTyoeDogsbyName(String name) {
        typeDogsObserver = new TypeDogsObserver(typeDogsModelViewPresenterToTypeDogsModelDomainMapper);
        typeDogsObserver.attachView(getView());
        getTypeDogsUseCase.execute(typeDogsObserver, name);
    }
}
