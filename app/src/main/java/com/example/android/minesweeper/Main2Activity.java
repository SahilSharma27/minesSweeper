package com.example.android.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    public int SIZE = 9;
    public ArrayList<LinearLayout> rows = new ArrayList<>();
    public GameButton[][] board;
    LinearLayout rootLayout;
    public int MINES = 0;
    GameButton button;
  //  int ja[] = {-1, -1, -1, 0, 0, 1, 1, 1};
  //  int ia[] = {-1, 0, 1, 1, -1, -1, 0, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rootLayout = findViewById(R.id.rootlayout);
        Intent intent = getIntent();
        String level = intent.getStringExtra(MainActivity.DIFFICULTY);
        if (level.equals("Beginner")) {
          //  SIZE = 9;
            MINES = 10;
        } else if (level.equals("Normal")) {
         //   SIZE = 9;
            MINES = 15;
        }
        if (level.equals("Hard")) {
          //  SIZE = 14;
            MINES = 20;
        }

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
                button = new GameButton(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                button.setLayoutParams(layoutParams);
                button.setOnClickListener(this);

                LinearLayout row = rows.get(i);
                row.addView(button);
                board[i][j] = button;
             //  String str=Integer.toString(i)+","+Integer.toString(j);
               //Toast.makeText(this,str,Toast.LENGTH_SHORT);
               board[i][j].setI(i);
               board[i][j].setJ(j);

            }


        }
    }

    public void setRandomMines() {
        for (int i = 0; i < MINES; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(SIZE);
            int rand_int2 = rand.nextInt(SIZE);
            if(board[rand_int1][rand_int2].isMine()==false) {
                board[rand_int1][rand_int2].setValue(-1);
                //  String str=Integer.toString(rand_int1)+ " " +Integer.toString(rand_int2);
                // Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
                setNeighbours(rand_int1, rand_int2);
            }
            else{
                i--;
            }
        }

    }

    boolean isValid(int row, int col) {

        return (row >= 0) && (row < SIZE) &&
                (col >= 0) && (col < SIZE);
    }

    public void setNeighbours(int row, int col) {

        if (isValid(row - 1, col) == true) {
            if (board[row - 1][col].isMine() == false) {
                int x = board[row - 1][col].getValue();
                board[row - 1][col].setValue(x + 1);

            }
        }
        if (isValid(row + 1, col) == true) {
            if (board[row + 1][col].isMine() == false) {
                int x = board[row + 1][col].getValue();
                board[row + 1][col].setValue(x + 1);

            }
        }

        if (isValid(row, col + 1) == true) {
            if (board[row][col + 1].isMine() == false) {
                int x = board[row][col + 1].getValue();
                board[row ][col+1].setValue(x + 1);

            }
        }


        if (isValid(row, col - 1) == true) {
            if (board[row][col - 1].isMine() == false) {
                int x = board[row][col - 1].getValue();
                board[row][col - 1].setValue(x + 1);

            }
        }


        if (isValid(row - 1, col + 1) == true) {
            if (board[row - 1][col + 1].isMine() == false) {
                int x = board[row - 1][col + 1].getValue();
                board[row - 1][col + 1].setValue(x + 1);

            }
        }


        if (isValid(row - 1, col - 1) == true) {
            if (board[row - 1][col - 1].isMine() == false) {
                int x = board[row - 1][col - 1].getValue();
                board[row - 1][col - 1].setValue(x + 1);

            }
        }


        if (isValid(row + 1, col + 1) == true) {
            if (board[row + 1][col + 1].isMine() == false) {
                int x = board[row + 1][col + 1].getValue();
                board[row + 1][col + 1].setValue(x + 1);

            }
        }


        if (isValid(row + 1, col - 1) == true) {
            if (board[row + 1][col - 1].isMine() == false) {
                int x = board[row + 1][col - 1].getValue();
                board[row + 1][col - 1].setValue(x + 1);

            }
        }

    }
    public void revealAllMines(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int x=board[i][j].getValue();

                        if(x==-1){
                            board[i][j].reveal();
                        }

            }
        }
        Toast.makeText(this,"YOU LOSE!",Toast.LENGTH_LONG).show();
    }
    public void revealNeighbours(int row ,int col){
        if (isValid(row - 1, col) == true) {
            board[row-1][col].reveal();



        }
        if (isValid(row + 1, col) == true) {
            board[row+1][col].reveal();


        }

        if (isValid(row, col + 1) == true) {
            board[row][col+1].reveal();



        }


        if (isValid(row, col - 1) == true) {
            board[row][col-1].reveal();

        }


        if (isValid(row - 1, col + 1) == true) {
            board[row-1][col+1].reveal();

        }


        if (isValid(row - 1, col - 1) == true) {
            board[row - 1][col - 1].reveal();


        }


        if (isValid(row + 1, col + 1) == true) {
            board[row+1][col+1].reveal();

        }


        if (isValid(row + 1, col - 1) == true) {
            board[row+1][col-1].reveal();

        }

    }


    @Override
    public void onClick(View view) {
        GameButton btn=new GameButton(this);
        btn=(GameButton)view;
       // String s=Integer.toString(btn.getI())+Integer.toString(btn.getJ());
       // Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        if(btn.isMine()){
        //  Toast.makeText(this, " mine clicked", Toast.LENGTH_SHORT).show();
          revealAllMines();
            }
            else if(btn.getValue()==0){
            btn.reveal();
            revealNeighbours(btn.getI(),btn.getJ());

            }
            else {
            btn.reveal();
            btn.setRevealed(true);
           // Toast.makeText(this, " not mine", Toast.LENGTH_SHORT).show();
        }
    }
}

