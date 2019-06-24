package com.jmc.dogsapi.di;

import android.app.Application;


import com.jmc.dogsapi.DogsApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

    Application getApplication();

    void inject(DogsApplication dogsApplication);
}
