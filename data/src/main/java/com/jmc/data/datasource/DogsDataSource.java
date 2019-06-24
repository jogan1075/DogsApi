package com.jmc.data.datasource;


import java.util.List;

import io.reactivex.Observable;

public interface DogsDataSource {


    Observable<List<String>> getDogs();

    Observable<List<String>> getDogsbyType(String type);
}
