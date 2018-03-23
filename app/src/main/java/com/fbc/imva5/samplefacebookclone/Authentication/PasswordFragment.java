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

public class PasswordFragment extends Fragment {

    private View view;
    private EditText passwordET;
    private TextView nextButton;

    private FragmentChangeListener fragmentChangeListener;
    private Map<String, String> accountDetails = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_password, container, false);
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
        passwordET = view.findViewById(R.id.password_et_FP);
        nextButton = view.findViewById(R.id.next_button_FP);
    }

    public void setupFragmentListener(FragmentChangeListener fragmentChangeListener, Map<String, String> accountDetails) {
        this.fragmentChangeListener = fragmentChangeListener;
        this.accountDetails = accountDetails;
    }


    public void nextButtonClicked() {
        if (fragmentChangeListener != null && accountDetails != null) {
            //pass the data to the next fragment

            if (!passwordET.getText().toString().equals("") && passwordET.getText().toString().length() >= 8) {
                accountDetails.put(getActivity().getString(R.string.intent_password), passwordET.getText().toString());
                fragmentChangeListener.onNextClicked(accountDetails);
            }
        }
    }
}
