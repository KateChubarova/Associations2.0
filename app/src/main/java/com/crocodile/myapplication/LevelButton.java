package com.crocodile.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by ekaterinachubarova on 18.08.16.
 */
public class LevelButton extends ImageView {
    private int index;

    public LevelButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public LevelButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelButton(Context context) {
        super(context);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
