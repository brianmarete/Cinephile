package com.brianmarete.cinephile.ui.main.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import com.brianmarete.cinephile.data.Resource;
import com.brianmarete.cinephile.data.local.dao.MovieDao;
import com.brianmarete.cinephile.data.local.entity.MovieEntity;
import com.brianmarete.cinephile.data.remote.api.MovieApiService;
import com.brianmarete.cinephile.data.repository.MovieRepository;
import com.brianmarete.cinephile.ui.base.BaseViewModel;
import java.util.List;
import javax.inject.Inject;

public class MovieListViewModel extends BaseViewModel {

    @Inject
    public MovieListViewModel(MovieDao movieDao, MovieApiService movieApiService) {
        movieRepository = new MovieRepository(movieDao, movieApiService);
    }

    private String type;
    private MovieRepository movieRepository;
    private MutableLiveData<Resource<List<MovieEntity>>> moviesLiveData = new MutableLiveData<>();

    public void setType(String type) {
        this.type = type;
    }

    public void loadMoreMovies(Long currentPage) {
        movieRepository.loadMoviesByType(currentPage, type)
                .doOnSubscribe(disposable -> addToDisposable(disposable))
                .subscribe(resource -> getMoviesLiveData().postValue(resource));
    }

    public boolean isLastPage() {
        return moviesLiveData.getValue() != null &&
                !moviesLiveData.getValue().data.isEmpty() ?
                moviesLiveData.getValue().data.get(0).isLastPage() :
                false;
    }

    public MutableLiveData<Resource<List<MovieEntity>>> getMoviesLiveData() {
        return moviesLiveData;
    }
}
