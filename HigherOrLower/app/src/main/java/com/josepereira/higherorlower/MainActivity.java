package com.josepereira.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private int random;
    
    public void guessFunction(View view){

        Log.i("Random=", String.valueOf(random));

        EditText input = (EditText) findViewById(R.id.editText);
        
        if(Integer.parseInt(input.getText().toString()) == random){
            Toast.makeText(this, "Correct, try again!", Toast.LENGTH_SHORT).show();
            Random r = new Random();
            random  = r.nextInt(20)+1;
        }else{
              if(Integer.parseInt(input.getText().toString()) > random){
                  Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT).show();
              }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        
        random  = r.nextInt(20)+1;
        
    }
}
