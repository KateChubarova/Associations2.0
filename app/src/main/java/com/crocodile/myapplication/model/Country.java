package com.crocodile.myapplication.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ekaterinachubarova on 22.08.16.
 */
public class Country {

    private boolean isOpenPicture[];
    private int isOpen;
    private int count = 6;

    private static final String JSON_IS_OPEN_PICTURES = "is_open_pictures";
    private static final String JSON_IS_OPEN = "is_open";

    public static final int LEVEL_OPENED = 2;
    public static final int LEVEL_SOLVED = 1;
    public static final int LEVEL_CLOSED = 3;

    public Country(){
        isOpen = 3;
        isOpenPicture = new boolean[count];
        for (int i=0; i<count; i++)
            isOpenPicture[i] = false;
    }

    public JSONObject toJSON() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_IS_OPEN_PICTURES, isOpenPicture);
        jsonObject.put(JSON_IS_OPEN, isOpen);

        return jsonObject;
    }

    public Country(JSONObject jsonObject) throws JSONException {
        isOpenPicture = (boolean [])jsonObject.get(JSON_IS_OPEN_PICTURES);
        isOpen = jsonObject.getInt(JSON_IS_OPEN);
    }

    public boolean getIsOpenPicture(int i) {
        return isOpenPicture[i];
    }

    public void setIsOpenPicture(boolean[] isOpenPicture) {
        this.isOpenPicture = isOpenPicture;
    }

    public int isOpen() {
        return isOpen;
    }

    public int decOpen() {
        isOpen -= 1;
        return isOpen;
    }

    public void setIsOpen (int isOPen){
        this.isOpen = isOPen;
    }

    public void setIsOpenPicture (int index) {
        isOpenPicture[index] = true;
    }

    public int getIsOpen (){
        return isOpen;
    }
}
