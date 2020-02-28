package com.brianmarete.cinephile.ui.detail.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.brianmarete.cinephile.data.local.dao.MovieDao;
import com.brianmarete.cinephile.data.local.entity.MovieEntity;
import com.brianmarete.cinephile.data.remote.api.MovieApiService;
import com.brianmarete.cinephile.data.repository.MovieRepository;

import javax.inject.Inject;

public class MovieDetailViewModel extends ViewModel {

    @Inject
    public MovieDetailViewModel(MovieDao movieDao, MovieApiService movieApiService) {
        movieRepository = new MovieRepository(movieDao, movieApiService);
    }

    private MovieRepository movieRepository;

    private MutableLiveData<MovieEntity> movieDetailsLiveData = new MutableLiveData<>();

    public void fetchMovieDetail(MovieEntity movieEntity) {
        movieRepository.fetchMovieDetails(movieEntity.getId())
        .subscribe(resource -> {
            if(resource.isLoaded()) getMovieDetailsLiveData().postValue(resource.data);
        });
    }

    public MutableLiveData<MovieEntity> getMovieDetailsLiveData() {
        return movieDetailsLiveData;
    }
}
