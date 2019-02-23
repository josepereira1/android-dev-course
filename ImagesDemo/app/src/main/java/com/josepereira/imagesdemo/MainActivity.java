package com.josepereira.imagesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void beforeFunction(View view){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.car2);
    }

    public void nextFunction(View view){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.car1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
