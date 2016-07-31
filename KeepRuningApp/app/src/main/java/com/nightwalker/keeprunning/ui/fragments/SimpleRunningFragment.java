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
public class SimpleRunningFragment extends BaseFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_running_fragment,container,false);
    }

    public String getTitle(){
        return getContext().getResources().getString(R.string.simple_running_fragment_title);
    }

    public static Fragment newInstance() {
        return new SimpleRunningFragment();
    }
}
