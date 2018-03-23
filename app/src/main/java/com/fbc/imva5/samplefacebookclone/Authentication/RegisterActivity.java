package com.fbc.imva5.samplefacebookclone.Authentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fbc.imva5.samplefacebookclone.R;
import com.fbc.imva5.samplefacebookclone.Utilities.FragmentChangeListener;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements FragmentChangeListener {

    private static final String TAG = "RegisterActivity";


    private Context mContext;
    private Toolbar toolbar;
    private Map<String, String> accountDetails = new HashMap<>();
    private Fragment currentFragment;

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        //Responsible for adding the fragment to the screen
        currentFragment = new NameFragment();
        ((TextView) toolbar.findViewById(R.id.action_bar_title)).setText(getString(R.string.name));
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_RA, currentFragment)
                .commit();
        ((NameFragment) currentFragment).setupFragmentListener(this, accountDetails);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonPressed();
            }
        });

    }


    public void init() {
        mContext = RegisterActivity.this;
        toolbar = findViewById(R.id.action_bar_RA);
        backButton = findViewById(R.id.back_arrow_RA);
    }


    @Override
    public void onNextClicked(Map<String, String> accountDetails) {
        this.accountDetails = accountDetails;

        if (currentFragment instanceof NameFragment) {
            currentFragment = new BirthdayFragment();
            ((TextView) toolbar.findViewById(R.id.action_bar_title)).setText(getString(R.string.birthday));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_RA, currentFragment)
                    .addToBackStack(getString(R.string.fragment_birthday)).commit();
            ((BirthdayFragment) currentFragment).setupFragmentListener(this, accountDetails);
        } else if (currentFragment instanceof BirthdayFragment) {

            currentFragment = new GenderFragment();
            ((TextView) toolbar.findViewById(R.id.action_bar_title)).setText(getString(R.string.gender));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_RA, currentFragment)
                    .addToBackStack(getString(R.string.gender)).commit();
            ((GenderFragment) currentFragment).setupFragmentListener(this, accountDetails);

        } else if (currentFragment instanceof GenderFragment) {

            currentFragment = new EmailFragment();
            ((TextView) toolbar.findViewById(R.id.action_bar_title)).setText(getString(R.string.email));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_RA, currentFragment)
                    .addToBackStack(getString(R.string.fragment_email)).commit();
            ((EmailFragment) currentFragment).setupFragmentListener(this, accountDetails);

        } else if (currentFragment instanceof EmailFragment) {

            currentFragment = new PasswordFragment();
            ((TextView) toolbar.findViewById(R.id.action_bar_title)).setText(getString(R.string.password));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_RA, currentFragment)
                    .addToBackStack(getString(R.string.fragment_password)).commit();
            ((PasswordFragment) currentFragment).setupFragmentListener(this, accountDetails);

        } else if (currentFragment instanceof PasswordFragment) {
            Log.d(TAG, "onNextClicked: " + accountDetails.toString());
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backButtonPressed();
    }

    public void backButtonPressed() {


    }


}
