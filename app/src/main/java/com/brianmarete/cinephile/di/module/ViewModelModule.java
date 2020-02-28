package com.brianmarete.cinephile.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.brianmarete.cinephile.factory.ViewModelFactory;
import com.brianmarete.cinephile.ui.detail.viewmodel.MovieDetailViewModel;
import com.brianmarete.cinephile.ui.detail.viewmodel.TvDetailViewModel;
import com.brianmarete.cinephile.ui.main.viewmodel.MovieListViewModel;
import com.brianmarete.cinephile.ui.main.viewmodel.TvListViewModel;
import com.brianmarete.cinephile.ui.search.viewmodel.MovieSearchViewModel;
import com.brianmarete.cinephile.ui.search.viewmodel.TvSearchViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    protected abstract ViewModel movieListViewModel(MovieListViewModel moviesListViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel.class)
    protected abstract ViewModel movieDetailViewModel(MovieDetailViewModel moviesDetailViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MovieSearchViewModel.class)
    protected abstract ViewModel movieSearchViewModel(MovieSearchViewModel movieSearchViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(TvListViewModel.class)
    protected abstract ViewModel tvListViewModel(TvListViewModel tvListViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(TvDetailViewModel.class)
    protected abstract ViewModel tvDetailViewModel(TvDetailViewModel tvDetailViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(TvSearchViewModel.class)
    protected abstract ViewModel tvSearchViewModel(TvSearchViewModel tvSearchViewModel);
}