package com.jmc.dogsapi.di;

import android.app.Application;

import com.jmc.domain.di.DomainModule;

import dagger.Module;
import dagger.Provides;

@Module(includes = DomainModule.class)
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application providesApplication() {
        return mApplication;
    }
}
