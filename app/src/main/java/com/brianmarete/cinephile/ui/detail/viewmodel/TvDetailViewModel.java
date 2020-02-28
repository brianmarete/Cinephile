package com.brianmarete.cinephile.ui.detail.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.brianmarete.cinephile.data.local.dao.TvDao;
import com.brianmarete.cinephile.data.local.entity.TvEntity;
import com.brianmarete.cinephile.data.remote.api.TvApiService;
import com.brianmarete.cinephile.data.repository.TvRepository;
import javax.inject.Inject;


public class TvDetailViewModel extends ViewModel {

    @Inject
    public TvDetailViewModel(TvDao tvDao, TvApiService tvApiService) {
        tvRepository = new TvRepository(tvDao, tvApiService);
    }

    private TvRepository tvRepository;

    private MutableLiveData<TvEntity> tvDetailsLiveData = new MutableLiveData<>();


    public void fetchMovieDetail(TvEntity tvEntity) {
        tvRepository.fetchTvDetails(tvEntity.getId())
        .subscribe(resource -> {
            if(resource.isLoaded()) getTvDetailsLiveData().postValue(resource.data);
        });
    }

    public MutableLiveData<TvEntity> getTvDetailsLiveData() {
        return tvDetailsLiveData;
    }
}
