package com.brianmarete.cinephile.util;

import io.reactivex.Observable;

public class ApiTestUtil<T> {

    public Observable<T> createCall(T data) {
        return Observable.just(data);
    }
}
