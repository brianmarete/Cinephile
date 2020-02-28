package com.brianmarete.cinephile.ui.search.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.brianmarete.cinephile.data.Resource;
import com.brianmarete.cinephile.data.local.dao.TvDao;
import com.brianmarete.cinephile.data.local.entity.TvEntity;
import com.brianmarete.cinephile.data.remote.api.TvApiService;
import com.brianmarete.cinephile.data.repository.TvRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TvSearchViewModel extends ViewModel {

    @Inject
    public TvSearchViewModel(TvDao tvDao, TvApiService tvApiService) {
        tvRepository = new TvRepository(tvDao, tvApiService);
    }

    private TvRepository tvRepository;

    private MutableLiveData<Resource<List<TvEntity>>> tvsLiveData = new MutableLiveData<>();

    public void searchTv(String text) {
        tvRepository.searchTvs(1l, text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resource -> getTvsLiveData().postValue(resource));
    }

    public MutableLiveData<Resource<List<TvEntity>>> getTvsLiveData() {
        return tvsLiveData;
    }
}
