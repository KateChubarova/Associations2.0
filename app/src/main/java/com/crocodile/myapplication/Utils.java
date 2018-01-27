package com.crocodile.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by ekaterinacubarova on 1/27/18.
 */

public class Utils {

    public static void changeLanguage(Context context, String locale){
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(locale.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }

}
