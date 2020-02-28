package com.brianmarete.cinephile.ui.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.brianmarete.cinephile.AppConstants;

public class BaseFragment extends Fragment implements AppConstants {

    protected Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
