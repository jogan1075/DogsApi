package com.jmc.dogsapi.observer;


import com.jmc.dogsapi.contract.DogsContract;
import com.jmc.dogsapi.mapper.TypeDogsModelViewPresenterToTypeDogsModelDomainMapper;
import com.jmc.domain.common.UseCaseViewObserver;

import java.util.List;

import javax.inject.Inject;

public class TypeDogsObserver extends UseCaseViewObserver<DogsContract.View, List<String>> {

    private TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper;

    @Inject
    public TypeDogsObserver(TypeDogsModelViewPresenterToTypeDogsModelDomainMapper typeDogsModelViewPresenterToTypeDogsModelDomainMapper) {
        this.typeDogsModelViewPresenterToTypeDogsModelDomainMapper = typeDogsModelViewPresenterToTypeDogsModelDomainMapper;
    }

    @Override protected void onStart() {
        getView().showLoading();
    }

    @Override public void onComplete() {
        getView().hideLoading();
    }

    @Override public void onNext(List<String> value) {

        List<String> productViews = typeDogsModelViewPresenterToTypeDogsModelDomainMapper.reverseMap(value);
        getView().setTypeDogsItems(productViews);
    }

    @Override public void onError(Throwable e) {
        getView().hideLoading();
        getView().showConnectionError();
    }
}
