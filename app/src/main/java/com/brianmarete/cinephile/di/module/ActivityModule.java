package com.brianmarete.cinephile.di.module;

import com.brianmarete.cinephile.ui.detail.activity.MovieDetailActivity;
import com.brianmarete.cinephile.ui.detail.activity.TvDetailActivity;
import com.brianmarete.cinephile.ui.main.activity.MainActivity;
import com.brianmarete.cinephile.ui.search.activity.MovieSearchActivity;
import com.brianmarete.cinephile.ui.search.activity.TvSearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector()
    abstract MovieDetailActivity contributeMovieDetailActivity();

    @ContributesAndroidInjector()
    abstract TvDetailActivity contributeTvDetailActivity();

    @ContributesAndroidInjector()
    abstract MovieSearchActivity contributeMovieSearchActivity();

    @ContributesAndroidInjector()
    abstract TvSearchActivity contributeTvSearchActivity();
}