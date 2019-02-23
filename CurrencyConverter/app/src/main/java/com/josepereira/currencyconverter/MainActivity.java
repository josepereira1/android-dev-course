package com.josepereira.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){
        EditText text = (EditText) findViewById(R.id.text);

        if(text.getText().toString().equals("")){

        }else {
            Double dollars = Double.parseDouble(text.getText().toString()), euros = 0.0;
            euros = dollars * 0.87;
            Toast.makeText(this, String.format("%.2f", euros) + "€", Toast.LENGTH_SHORT).show();
        }

        /**
         * Nesta app temos um bocado de tudo o que é o básico a saber, o EditText é a class para os
         * textos, e para conseguirmos ir buscar os valores inseridos pelo utilizador, o Toast serve para
         * mostrar mensagens em "balões" ao utilizador, depois existem características em cada widget importantes,
         * a função convert está associada ao botão através do atributo onclick.
         *
         */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
