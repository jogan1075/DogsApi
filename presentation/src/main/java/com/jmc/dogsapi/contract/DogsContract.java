package com.jmc.dogsapi.contract;



import com.jmc.dogsapi.utils.commons.BasePresenter;

import java.util.List;

public interface DogsContract {


    interface View extends BasePresenter.View{
        void setNameDogsItems(List<String> movieItems);
        void setTypeDogsItems(List<String> movieItems);
    }

    interface Presenter {
        void loadNameDogs();

        void loadTyoeDogsbyName(String name);
    }
}
