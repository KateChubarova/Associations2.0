package com.crocodile.myapplication.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crocodile.myapplication.CountryLab;
import com.crocodile.myapplication.Preferences;
import com.crocodile.myapplication.R;
import com.crocodile.myapplication.Utils;
import com.crocodile.myapplication.model.Country;
import com.crocodile.myapplication.view.PictureButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameFragment extends Fragment implements Animation.AnimationListener {

    public static final String EXTRA_GAME_ID = "country_id";

    private Animation answerAnimation;
    private Animation disappearAnimation;
    private Animation appearAnimation;
    private Animation rotateAnimation;
    private int animationIndex;

    private final int ANIMATION_INDEX_PICTURE = 4;
    private final int ANIMATION_INDEX_DIALOG = 1;
    private final int ANIMATION_INDEX_ZERO = 0;

    @BindView(R.id.check_button)
    protected Button check;
    @BindView(R.id.editText)
    protected EditText editText;
    @BindView(R.id.levelText)
    protected TextView levelText;
    @BindView(R.id.moneyText)
    protected TextView moneyText;
    @BindView(R.id.back)
    protected LinearLayout backgroundLayout;
    @BindView(R.id.imageViewCountry)
    protected PictureButton countryPicture;
    private PictureButton[] images;

    private int indexPicture;
    private int count = 6;
    private Country country;
    private Context context;
    private int currentLevel;
    private CountryLab countryLab;
    private Preferences preferences;
    private int smallPictures[];

    public static GameFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_GAME_ID, id);
        GameFragment gameFragment = new GameFragment();
        gameFragment.setArguments(args);
        return gameFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        animationIndex = ANIMATION_INDEX_ZERO;

        disappearAnimation = AnimationUtils.loadAnimation(context, R.anim.disapear);
        disappearAnimation.setAnimationListener(GameFragment.this);

        appearAnimation = AnimationUtils.loadAnimation(context, R.anim.appear);
        appearAnimation.setAnimationListener(GameFragment.this);

        answerAnimation = AnimationUtils.loadAnimation(context, R.anim.correctanswer);
        answerAnimation.setAnimationListener(GameFragment.this);

        rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        rotateAnimation.setAnimationListener(GameFragment.this);

        currentLevel = (int) getArguments().getSerializable(EXTRA_GAME_ID);
        countryLab = CountryLab.get(context);
        country = countryLab.getCountry(currentLevel);
        preferences = new Preferences(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, parent, false);
        ButterKnife.bind(this, v);

        backgroundLayout.setBackgroundResource(Utils.getColor(currentLevel));

        Typeface face = Typeface.createFromAsset(context.getAssets(), getString(R.string.head));
        levelText.setTypeface(face);
        check.setTypeface(face);
        moneyText.setTypeface(face);

        moneyText.setText(Integer.toString(preferences.getMoney()));
        levelText.setText(R.string.level + " " + currentLevel + 1);
        smallPictures = Utils.generateSmallPictures(currentLevel);

        images = new PictureButton[count];
        images[0] = v.findViewById(R.id.imageView1);
        images[1] = v.findViewById(R.id.imageView2);
        images[2] = v.findViewById(R.id.imageView3);
        images[3] = v.findViewById(R.id.imageView4);
        images[4] = v.findViewById(R.id.imageView5);
        images[5] = v.findViewById(R.id.imageView6);

        for (int i = 0; i < count; i++) {
            images[i].setUsed(country.getIsOpenPicture(i));

            if (country.getIsOpenPicture(i)) {
                images[i].setBackgroundResource(smallPictures[i]);
            }

            images[i].setIndex(i);
            images[i].setOnClickListener(imageClick);
        }
        countryPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryPicture.startAnimation(rotateAnimation);
            }
        });
        return v;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @OnClick(R.id.check_button)
    protected void check() {
        String answer = getResources().getStringArray(R.array.countries)[currentLevel];
        if (editText.getText().toString().equalsIgnoreCase(answer)) {
            check.setClickable(false);
            country.setIsOpen(Country.LEVEL_SOLVED);
            animationIndex = ANIMATION_INDEX_DIALOG;
            countryPicture.setBackgroundResource(Utils.getMainPicture(currentLevel));
            countryPicture.startAnimation(answerAnimation);

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.incorrect_answer).setMessage(R.string.try_again).setIcon(R.drawable.ic_false)
                    .setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    View.OnClickListener imageClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PictureButton button = (PictureButton) view;
            indexPicture = button.getIndex();

            if (!button.isUsed()) {
                if (preferences.getMoney() <= 0) {
                    Toast.makeText(getActivity(), "You have no money", Toast.LENGTH_SHORT).show();
                    return;
                }

                view.startAnimation(disappearAnimation);
                animationIndex = ANIMATION_INDEX_PICTURE;
                button.setUsed(true);
                preferences.saveMoney(preferences.getMoney() - 2);
                moneyText.setText(Integer.toString(preferences.getMoney()));
                country.setIsOpenPicture(indexPicture);
                countryLab.updateCountry(currentLevel, country);
            } else  {
//                MainPictureFragment mainPictureFragment = MainPictureFragment.newInstance(1),
//                        button.getIndex());
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.gameContainer, mainPictureFragment);
            }

        }
    };

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animationIndex == ANIMATION_INDEX_PICTURE) {
            images[indexPicture].setBackgroundResource(smallPictures[indexPicture]);
            images[indexPicture].startAnimation(appearAnimation);
        }

        if (animationIndex == ANIMATION_INDEX_DIALOG) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.new_level).setIcon(R.drawable.ic_true).setCancelable(false);
            if (currentLevel < 25) {
                builder.setMessage(R.string.new_level_available).setPositiveButton(R.string.next_level, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        updateLevelNext();
                    }
                });
            } else {
                builder.setMessage(R.string.final_message).
                        setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
//                                    Intent i = new Intent(context, FrogActivity.class);
//                                    startActivity(i);
                            }
                        }).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        getActivity().finish();
                    }
                });
            }
            AlertDialog alert = builder.create();
            alert.show();
        }
        animationIndex = ANIMATION_INDEX_ZERO;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        countryPicture.setBackgroundResource(Utils.getMainPicture(currentLevel));
    }

    private void updateLevelNext() {
        currentLevel += 1;
        country = countryLab.getCountry(currentLevel);

        if (country.getIsOpen() != Country.LEVEL_SOLVED) {
            country.setIsOpen(Country.LEVEL_OPENED);
        }

        check.setClickable(true);
        for (int i = 0; i < count; i++) {
            images[i].setUsed(false);
            images[i].setBackgroundResource(R.drawable.ic_empty);
        }
        countryPicture.setBackgroundResource(R.drawable.ic_frog);
        animationIndex = 0;
        editText.setText("");
        backgroundLayout.setBackgroundResource(Utils.getColor(currentLevel));
        levelText.setText(R.string.level + " " + currentLevel + 1);

        countryLab.updateCountry(currentLevel, country);
        countryLab.saveCountries();
    }
}

