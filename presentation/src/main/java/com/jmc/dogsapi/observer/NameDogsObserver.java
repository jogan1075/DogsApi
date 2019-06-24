package com.jmc.dogsapi.observer;


import com.jmc.dogsapi.contract.DogsContract;
import com.jmc.dogsapi.mapper.NameDogsModelViewPresenterToNameDogsModelDomainMapper;
import com.jmc.domain.common.UseCaseViewObserver;

import java.util.List;

import javax.inject.Inject;

public class NameDogsObserver extends UseCaseViewObserver<DogsContract.View, List<String>> {

    private NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper;

    @Inject
    public NameDogsObserver(NameDogsModelViewPresenterToNameDogsModelDomainMapper nameDogsModelViewPresenterToNameDogsModelDomainMapper) {
        this.nameDogsModelViewPresenterToNameDogsModelDomainMapper = nameDogsModelViewPresenterToNameDogsModelDomainMapper;
    }

    @Override protected void onStart() {
        getView().showLoading();
    }

    @Override public void onComplete() {
        getView().hideLoading();
    }

    @Override public void onNext(List<String> value) {

        List<String> productViews = nameDogsModelViewPresenterToNameDogsModelDomainMapper.reverseMap(value);
        getView().setNameDogsItems(productViews);
    }

    @Override public void onError(Throwable e) {
        getView().hideLoading();
        getView().showConnectionError();
    }
}
