package com.crocodile.myapplication.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.crocodile.myapplication.Preferences;
import com.crocodile.myapplication.R;
import com.crocodile.myapplication.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StartActivity extends Activity implements Animation.AnimationListener {

    private static final String TAG = StartActivity.class.getName();

    private int animationIndex = 0;
    private final int ANIMATION_INDEX_ZERO = 0;
    private final int ANIMATION_INDEX_NEW_INTENT = 1;
    private final int ANIMATION_INDEX_GO_TO_MARKET = 2;
    private final int ANIMATION_INDEX_CHANGE_LANGUAGE = 3;
    private final int ANIMATION_INDEX_ROTATE_FROG = 4;

    private Animation myAnimation;
    private Animation frogAnimation;

    private Preferences preferences;

    @BindView(R.id.play)
    protected ImageView playButton;
    @BindView(R.id.help)
    protected ImageView helpButton;
    @BindView(R.id.frog)
    protected ImageView frogButton;
    @BindView(R.id.rate)
    protected ImageView rateButton;
    @BindView(R.id.start_rus)
    protected ImageView russian;
    @BindView(R.id.start_eng)
    protected ImageView english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButterKnife.bind(this);

        myAnimation = AnimationUtils.loadAnimation(StartActivity.this, R.anim.disapear);
        myAnimation.setAnimationListener(StartActivity.this);

        frogAnimation = AnimationUtils.loadAnimation(StartActivity.this, R.anim.rotate);
        frogAnimation.setAnimationListener(StartActivity.this);

        preferences = new Preferences(this);

        Typeface face = Typeface.createFromAsset(getAssets(), getString(R.string.roboto_head));
        ((TextView) findViewById(R.id.appName)).setTypeface(face);

        setLanguage();
    }

    @OnClick(R.id.play)
    protected void play() {
        animationIndex = ANIMATION_INDEX_NEW_INTENT;
        myAnimation.setAnimationListener(StartActivity.this);
        playButton.startAnimation(myAnimation);
    }

    @OnClick(R.id.frog)
    protected void frog() {
        animationIndex = ANIMATION_INDEX_ROTATE_FROG;
        frogButton.startAnimation(frogAnimation);
    }

    @OnClick(R.id.rate)
    protected void rate() {
        animationIndex = ANIMATION_INDEX_GO_TO_MARKET;
        rateButton.startAnimation(myAnimation);
    }

    @OnClick(R.id.help)
    protected void help() {
        animationIndex = ANIMATION_INDEX_CHANGE_LANGUAGE;
        helpButton.startAnimation(myAnimation);
    }

    @OnClick(R.id.start_eng)
    public void selectEnglish() {
        english.setSelected(true);
        russian.setSelected(false);
        Utils.changeLanguage(this, "us");
        preferences.saveLanguage("us");
    }

    @OnClick(R.id.start_rus)
    public void selectRussian() {
        english.setSelected(false);
        russian.setSelected(true);
        Utils.changeLanguage(this, "ru");
        preferences.saveLanguage("ru");
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        switch (animationIndex) {
            case ANIMATION_INDEX_NEW_INTENT:
                if (preferences.isFirstTimeLaunch()) {
                    Intent intent = new Intent(StartActivity.this, GameActivity.class);
                    intent.putExtra(GameActivity.LEVEL, 1);
                    startActivity(intent);
                } else {
                    preferences.saveIsFirstTimeLaunch();
                    Intent intent = new Intent(StartActivity.this, LevelsActivity.class);
                    startActivity(intent);
                }
                break;
            case ANIMATION_INDEX_GO_TO_MARKET:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {

                }
                break;
            case ANIMATION_INDEX_CHANGE_LANGUAGE:
                AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setTitle(R.string.game_rules_title).setMessage(R.string.game_rules)
                        .setIcon(R.drawable.help)
                        .setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        animationIndex = ANIMATION_INDEX_ZERO;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                StartActivity.this);
        quitDialog.setTitle(R.string.exit).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                finish();
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        quitDialog.show();
    }

    private void setLanguage() {
        String language;
        if (preferences.isFirstTimeLaunch()) {
            language = getResources().getConfiguration().locale.getCountry().toLowerCase();
            preferences.saveLanguage(language);
        } else {
            language = preferences.getLanguage();
        }
        switch (language) {
            case "ru":
                selectRussian();
                break;
            case "us":
                selectEnglish();
                break;
        }
    }

}