package com.fbc.imva5.samplefacebookclone.Authentication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fbc.imva5.samplefacebookclone.R;
import com.fbc.imva5.samplefacebookclone.Utilities.FragmentChangeListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imva5 on 18-03-2018.
 */

public class GenderFragment extends Fragment {

    private View view;
    private RadioGroup radioGroup;
    private TextView nextButton;


    private FragmentChangeListener fragmentChangeListener;
    private Map<String, String> accountDetails = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gender, container, false);
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
        radioGroup = view.findViewById(R.id.gender_radio_grp_FG);
        nextButton = view.findViewById(R.id.next_button_FG);

    }

    public void setupFragmentListener(FragmentChangeListener fragmentChangeListener, Map<String, String> accountDetails) {
        this.fragmentChangeListener = fragmentChangeListener;
        this.accountDetails = accountDetails;
    }


    public void nextButtonClicked() {
        if (fragmentChangeListener != null && accountDetails != null) {
            //pass the data to the next fragment

            String gender = null;
            if (radioGroup.getCheckedRadioButtonId() == R.id.male_radio_button_FG) {
                gender = "male";
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.female_radio_button_FG) {
                gender = "female";
            } else {
                Toast.makeText(getActivity(), "Select a gender", Toast.LENGTH_SHORT).show();
            }
            if (gender != null) {
                accountDetails.put(getActivity().getString(R.string.intent_gender), gender);
                fragmentChangeListener.onNextClicked(accountDetails);
            }
        }
    }


}
