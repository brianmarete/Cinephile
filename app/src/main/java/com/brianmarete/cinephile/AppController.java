package com.brianmarete.cinephile;

import android.app.Activity;
import android.app.Application;
import com.brianmarete.cinephile.di.component.DaggerApiComponent;
import com.brianmarete.cinephile.di.module.ApiModule;
import com.brianmarete.cinephile.di.module.DbModule;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class AppController extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApiComponent.builder()
                .application(this)
                .apiModule(new ApiModule())
                .dbModule(new DbModule())
                .build()
            .inject(this);
    }
}
