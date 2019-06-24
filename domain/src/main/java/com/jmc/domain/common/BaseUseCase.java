package com.jmc.domain.common;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseUseCase<T> {

    protected final CompositeDisposable compositeDisposable;

    public BaseUseCase() {
        compositeDisposable = new CompositeDisposable();
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void remove(Disposable disposable) {
        if (disposable != null) compositeDisposable.remove(disposable);
    }
}
