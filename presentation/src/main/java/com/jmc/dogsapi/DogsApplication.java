package com.jmc.dogsapi;

import android.app.Application;

import com.jmc.dogsapi.di.ApplicationComponent;
import com.jmc.dogsapi.di.ApplicationModule;
import com.jmc.dogsapi.di.DaggerApplicationComponent;


public class DogsApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        applicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
