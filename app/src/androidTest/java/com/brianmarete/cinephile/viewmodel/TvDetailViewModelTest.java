package com.brianmarete.cinephile.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;
import android.support.test.InstrumentationRegistry;

import com.brianmarete.cinephile.data.local.entity.TvEntity;
import com.brianmarete.cinephile.ui.detail.viewmodel.TvDetailViewModel;
import com.brianmarete.cinephile.util.MockTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.brianmarete.cinephile.AppConstants.MOVIES_POPULAR;

@RunWith(MockitoJUnitRunner.class)
public class TvDetailViewModelTest {

    private TvDetailViewModel tvDetailViewModel;

    @Mock
    Observer<TvEntity> observer;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void init() {
        Application app =
                (Application) InstrumentationRegistry
                        .getTargetContext()
                        .getApplicationContext();
        tvDetailViewModel = new TvDetailViewModel(app);
    }

    @Test
    public void loadTvDetails() {

        TvEntity tvEntity = MockTestUtil.mockTvDetail(MOVIES_POPULAR);

        tvDetailViewModel.getTvDetailsLiveData().observeForever(observer);
        tvDetailViewModel.fetchMovieDetail(tvEntity);

        assert(tvDetailViewModel.getTvDetailsLiveData().getValue() == tvEntity);
        assert(tvDetailViewModel.getTvDetailsLiveData().getValue()
                .getCrews().size() == tvEntity.getCrews().size());
        assert(tvDetailViewModel.getTvDetailsLiveData().getValue()
                .getCasts().size() == tvEntity.getCasts().size());
    }
}
