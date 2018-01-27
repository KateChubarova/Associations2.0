package com.crocodile.myapplication.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.crocodile.myapplication.Country;
import com.crocodile.myapplication.CountryLab;
import com.crocodile.myapplication.LevelButton;
import com.crocodile.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class LevelsActivity extends Activity {

    private LevelButton buttons[];
    private CountryLab countryLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        ButterKnife.bind(this);

        countryLab = CountryLab.get(this);

        TextView chooseLevel = findViewById(R.id.choose_level);
        Typeface face = Typeface.createFromAsset(getAssets(), getString(R.string.head));
        chooseLevel.setTypeface(face);

        buttons = new LevelButton[25];

        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        buttons[9] = findViewById(R.id.button10);
        buttons[10] = findViewById(R.id.button11);
        buttons[11] = findViewById(R.id.button12);
        buttons[12] = findViewById(R.id.button13);
        buttons[13] = findViewById(R.id.button14);
        buttons[14] = findViewById(R.id.button15);
        buttons[15] = findViewById(R.id.button16);
        buttons[16] = findViewById(R.id.button17);
        buttons[17] = findViewById(R.id.button18);
        buttons[18] = findViewById(R.id.button19);
        buttons[19] = findViewById(R.id.button20);
        buttons[20] = findViewById(R.id.button21);
        buttons[21] = findViewById(R.id.button22);
        buttons[22] = findViewById(R.id.button23);
        buttons[23] = findViewById(R.id.button24);
        buttons[24] = findViewById(R.id.button25);

        setLevels();

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LevelButton button = (LevelButton) view;
            if (countryLab.getCountry(button.getIndex()).getIsOpen() != Country.LEVEL_CLOSED) {
//                Intent i = new Intent(LevelsActivity.this, GameActivity.class);
//                i.putExtra("level", Integer.toString(button.getIndex()));
//                startActivityForResult(i, 1);
            } else {
                //dialog
            }
        }
    };

    @OnClick(R.id.replay)
    protected void reply(){
        AlertDialog.Builder builder = new AlertDialog.Builder(LevelsActivity.this);

        builder.setTitle(R.string.new_game).setMessage(R.string.new_game_question).setIcon(R.drawable.ic_true)
                .setCancelable(false).setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                        Intent i = new Intent(LevelsActivity.this, LevelsActivity.class);
                        startActivity(i);
                    }
                }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void setLevels () {
        for (int i=0; i<25; i++) {
            switch (countryLab.getCountry(i).isOpen()) {
                case Country.LEVEL_CLOSED:
                    buttons[i].setBackgroundResource(R.drawable.levellocked);
                    break;
                case Country.LEVEL_OPENED:
                    buttons[i].setBackgroundResource(R.drawable.levelunlocked);
                    break;
                case Country.LEVEL_SOLVED:
                default:
                    buttons[i].setBackgroundResource(R.drawable.levelcompleted);
                    break;

            }
            buttons[i].setIndex(i);
            buttons[i].setOnClickListener(onClickListener);
        }
    }

}
