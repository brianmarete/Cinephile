package com.brianmarete.cinephile.di.module;

import com.brianmarete.cinephile.ui.main.fragment.MovieListFragment;
import com.brianmarete.cinephile.ui.main.fragment.TvListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();

    @ContributesAndroidInjector
    abstract TvListFragment contributeTvListFragment();
}
