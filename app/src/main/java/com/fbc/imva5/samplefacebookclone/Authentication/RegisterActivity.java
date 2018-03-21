package com.fbc.imva5.samplefacebookclone.Authentication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fbc.imva5.samplefacebookclone.R;
import com.fbc.imva5.samplefacebookclone.Utilities.FragmentChangeListener;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements FragmentChangeListener {

    private static final String TAG = "RegisterActivity";

    private Fragment currentFragment;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = RegisterActivity.this;
        currentFragment = new NameFragment();

        loadFirst();
    }


    public void loadFirst() {
        if (currentFragment != null) {
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        }
    }


    @Override
    public void onClick(Map<String, String> newAccountDetails) {

        if (currentFragment instanceof NameFragment) {
            ((NameFragment) currentFragment).setupFragmentListener(this,newAccountDetails);
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        } else if (currentFragment instanceof EmailFragment) {
            ((EmailFragment) currentFragment).setupFragmentListener(this);
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        } else if (currentFragment instanceof GenderFragment) {
            ((GenderFragment) currentFragment).setupFragmentListener(this);
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        } else if (currentFragment instanceof BirthdayFragment) {
            ((BirthdayFragment) currentFragment).setupFragmentListener(this);
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        } else if (currentFragment instanceof PasswordFragment) {
            ((PasswordFragment) currentFragment).setupFragmentListener(this);
            getSupportFragmentManager().beginTransaction().add(currentFragment, "Name")
                    .addToBackStack("name_frag").commit();
        }
    }


    public void setupToolbar()
    {}

}
