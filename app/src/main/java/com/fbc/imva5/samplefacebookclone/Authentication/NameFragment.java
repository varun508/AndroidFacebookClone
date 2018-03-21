package com.fbc.imva5.samplefacebookclone.Authentication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fbc.imva5.samplefacebookclone.R;
import com.fbc.imva5.samplefacebookclone.Utilities.FragmentChangeListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imva5 on 18-03-2018.
 */

public class NameFragment extends Fragment {


    private FragmentChangeListener mListener;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_name, container, false);
        return view;
    }


    public void setupFragmentListener(FragmentChangeListener mListener, Map<String, String> newAccountDetails) {
        this.mListener = mListener;

        if (newAccountDetails != null) {
            newAccountDetails.put("name", "varun");
        }
        mListener.onClick(newAccountDetails);
    }


}
