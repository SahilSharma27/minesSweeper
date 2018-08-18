package com.example.android.minesweeper;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.widget.GridView;

/**
 * Created by Sahil Sharma on 24-06-2018.
 */

public class GameButton extends AppCompatButton {
    private int value=0;
    private boolean isRevealed;
    private int i,j;


    public GameButton(Context context){
        super(context);
    }

    public int getI() {
        return this.i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return this.j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void reveal() {
        if (value == -1) {
            setBackgroundResource(R.drawable.mine1);
        } else {
            String str = Integer.toString(value);
            setText(str);
            setRevealed(true);
        }
    }
    public int getValue() {
        return value;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public boolean isMine(){
        if(getValue()==-1){
            return true;
        }
        else return false;


    }
}
