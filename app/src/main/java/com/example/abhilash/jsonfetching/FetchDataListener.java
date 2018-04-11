package com.example.abhilash.jsonfetching;

/**
 * Created by abhilash on 10/4/18.
 */

import java.util.List;

public interface FetchDataListener {
    public void onFetchComplete(List<Application> data);
    public void onFetchFailure(String msg);
}


