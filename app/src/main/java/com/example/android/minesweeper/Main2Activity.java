package com.example.android.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    public int SIZE=0;
    public ArrayList<LinearLayout> rows = new ArrayList<>();
    public GameButton[][] board;
    LinearLayout rootLayout;
    public int MINES=0;
    int table[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rootLayout=findViewById(R.id.rootlayout);
        Intent intent = getIntent();
        String level = intent.getStringExtra(MainActivity.DIFFICULTY);
       if(level.equals("Beginner")){
           SIZE=8;
           MINES=12;
       }
       else if(level.equals("Normal")){
            SIZE=10;
            MINES=20;
        }
        if(level.equals("Hard")){
            SIZE=14;
            MINES=25;
        }
        table=new int[SIZE][SIZE];
      //  String toast=Integer.toString(SIZE);
      //  Toast.makeText(this,toast,Toast.LENGTH_LONG).show();
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        setupBoard();
        setRandomMines();
    }
    public void setupBoard() {
        rows = new ArrayList<>();
        board = new GameButton[SIZE][SIZE];
        rootLayout.removeAllViews();
        for (int i = 0; i < SIZE; i++) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
            linearLayout.setLayoutParams(layoutParams);
            rootLayout.addView(linearLayout);
            rows.add(linearLayout);

        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                GameButton button = new GameButton(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                button.setLayoutParams(layoutParams);
                button.setOnClickListener(this);

                LinearLayout row = rows.get(i);
                row.addView(button);
                board[i][j] = button;
            }
        }
    }
    public void setRandomMines(){
        for(int i=0;i<MINES;i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(SIZE);
            int rand_int2 = rand.nextInt(SIZE);
            //String str=Integer.toString(rand_int1)+ " " +Integer.toString(rand_int2);
           // Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
            table[rand_int1][rand_int2]=-1;

        }

    }
    @Override
    public void onClick(View view) {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
        }
    }

