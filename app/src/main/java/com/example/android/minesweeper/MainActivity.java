package com.example.android.minesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    public static String DIFFICULTY="difficulty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.rg);
        btn=findViewById(R.id.play);
    }
    public void startMain2Activity(View view){

        String level=((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        Toast.makeText(this,level,Toast.LENGTH_LONG).show();
       Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra(DIFFICULTY,level);
        startActivity(intent);


    }



}
