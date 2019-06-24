package com.jmc.dogsapi.di;



import com.jmc.dogsapi.ui.MainActivity;

import dagger.Component;

@ActivityScope @Component(modules = DogsModule.class, dependencies = ApplicationComponent.class)
public interface DogsComponent {

    void inject(MainActivity mainActivity);

}
