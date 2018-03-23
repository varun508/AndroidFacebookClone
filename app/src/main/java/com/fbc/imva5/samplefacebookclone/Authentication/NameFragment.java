package com.fbc.imva5.samplefacebookclone.Authentication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.fbc.imva5.samplefacebookclone.R;
import com.fbc.imva5.samplefacebookclone.Utilities.FragmentChangeListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imva5 on 18-03-2018.
 */

public class NameFragment extends Fragment {


    private FragmentChangeListener fragmentChangeListener;
    private Map<String, String> accountDetails = new HashMap<>();

    private View view;
    private EditText firstNameET, lastNameET;
    private TextView nextButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_name, container, false);
        initWidgets();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });

        return view;
    }

    public void initWidgets() {
        firstNameET = view.findViewById(R.id.first_name_et_FN);
        lastNameET = view.findViewById(R.id.last_name_et_FN);
        nextButton = view.findViewById(R.id.next_button_FN);
    }


    public void setupFragmentListener(FragmentChangeListener fragmentChangeListener, Map<String, String> accountDetails) {
        this.fragmentChangeListener = fragmentChangeListener;
        this.accountDetails = accountDetails;
    }


    public void nextButtonClicked() {
        if (fragmentChangeListener != null && accountDetails != null) {
            //pass the data to the next fragment

            String first_name = firstNameET.getText().toString();
            String last_name = lastNameET.getText().toString();

            if (!first_name.equals("") && !last_name.equals("")) {
                accountDetails.put(getActivity().getString(R.string.intent_first_name), first_name);
                accountDetails.put(getActivity().getString(R.string.intent_last_name), last_name);
                fragmentChangeListener.onNextClicked(accountDetails);
            }


        }
    }


}
