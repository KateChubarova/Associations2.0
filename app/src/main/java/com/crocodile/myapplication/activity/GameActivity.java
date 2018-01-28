package com.crocodile.myapplication.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.crocodile.myapplication.CountryLab;
import com.crocodile.myapplication.fragment.GameFragment;
import com.crocodile.myapplication.R;

public class GameActivity extends Activity {

    public static final String LEVEL = "level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.gameContainer,
                GameFragment.newInstance(getIntent().getIntExtra(LEVEL, 1))).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CountryLab.get(this).saveCountries();
    }
}

