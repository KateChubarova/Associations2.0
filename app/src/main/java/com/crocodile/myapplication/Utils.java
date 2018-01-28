package com.crocodile.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.crocodile.myapplication.model.Country;

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

    public static int[] generateSmallPictures(int index) {
        int smallPictures[] = new int[6];
        switch (index) {
            case 0:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 1:
                smallPictures[0] = R.drawable.ic_france1;
                smallPictures[1] = R.drawable.ic_france2;
                smallPictures[2] = R.drawable.ic_france3;
                smallPictures[3] = R.drawable.ic_france4;
                smallPictures[4] = R.drawable.ic_france5;
                smallPictures[5] = R.drawable.ic_france6;
                break;
            case 2:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 3:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 4:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 5:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 6:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 7:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 8:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 9:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 10:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 11:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 12:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 13:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 14:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 15:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 16:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 17:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 18:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 19:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 20:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 21:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 22:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 23:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 24:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
            case 25:
                smallPictures[0] = R.drawable.ic_india1;
                smallPictures[1] = R.drawable.ic_india2;
                smallPictures[2] = R.drawable.ic_india3;
                smallPictures[3] = R.drawable.ic_india4;
                smallPictures[4] = R.drawable.ic_india5;
                smallPictures[5] = R.drawable.ic_india6;
                break;
        }
        return smallPictures;
    }

    public static int getMainPicture(int index) {
        int picture = -1;
        switch (index) {
            case 0:
                picture = R.drawable.ic_india;
                break;
            default:
                picture = R.drawable.ic_india;
                break;
        }
        return picture;
    }

    public static int getColor(int index) {
        int color = -1;
        switch (index) {
            case 0:
                color = R.color.india;
                break;
            default:
                color = R.color.india;
                break;
        }
        return color;
    }

}
