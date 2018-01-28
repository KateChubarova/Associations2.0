package com.crocodile.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ekaterinacubarova on 1/27/18.
 */

public class Preferences {

    private static final String LANGUAGE = "LANGUAGE";
    private static final String IS_FIRST_TIME_LAUNCH = "IS_FIRST_TIME_LAUNCH";
    private static final String MONEY = "MONEY";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Preferences (Context context){
        preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public String getLanguage(){
        return preferences.getString(LANGUAGE, "ru");
    }

    public void saveLanguage(String language){
        editor.putString(LANGUAGE, language).apply();
    }

    public boolean isFirstTimeLaunch(){
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void saveIsFirstTimeLaunch(){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, false).apply();
    }

    public void saveMoney(int money){
        editor.putInt(MONEY, money).apply();
    }

    public int getMoney(){
        return preferences.getInt(MONEY, 25);
    }

}
