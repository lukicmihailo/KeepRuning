package com.nightwalker.keeprunning.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nightwalker.keeprunning.R;

/**
 * Created by Westi on 7/31/2016.
 */
public class KeepRhytmFragment extends BaseFragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.keep_rhytm_fragment,container,false);
    }

    public static Fragment newInstance() {
        return new KeepRhytmFragment();
    }

    public String getTitle(){
        return getContext().getResources().getString(R.string.keep_rhytm_fragment_title);
    }
}
