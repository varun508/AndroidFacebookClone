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

public class EmailFragment extends Fragment {


    private View view;
    private EditText emailET;
    private TextView nextButton;


    private FragmentChangeListener fragmentChangeListener;
    private Map<String, String> accountDetails = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_email, container, false);

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
        emailET = view.findViewById(R.id.email_et_FE);
        nextButton = view.findViewById(R.id.next_button_FE);

    }

    public void setupFragmentListener(FragmentChangeListener fragmentChangeListener, Map<String, String> accountDetails) {
        this.fragmentChangeListener = fragmentChangeListener;
        this.accountDetails = accountDetails;
    }


    public void nextButtonClicked() {
        if (fragmentChangeListener != null && accountDetails != null) {
            //pass the data to the next fragment

            if (!emailET.getText().toString().equals("")) {
                accountDetails.put(getActivity().getString(R.string.intent_email), emailET.getText().toString());
                fragmentChangeListener.onNextClicked(accountDetails);
            }
        }
    }
}
