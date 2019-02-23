package com.josepereira.bigorsmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    double value = 0;
    StringBuilder jogadas = new StringBuilder();

    public void start(View view){
        RelativeLayout layout = findViewById(R.id.relativeLayout);

        layout.setVisibility(View.INVISIBLE);

        TextView valorInserido = findViewById(R.id.valorInserido);

        value = Double.parseDouble(valorInserido.getText().toString());
        TextView valor = findViewById(R.id.value);

        valor.setText(String.valueOf(value)+"€");
    }

    public void jogar(View view){

        if(value <= 0){
            Toast.makeText(this, "GAME OVER, choose a new value!", Toast.LENGTH_SHORT).show();

            RelativeLayout layout = findViewById(R.id.relativeLayout);

            layout.setVisibility(View.VISIBLE);
        }

        Random random = new Random();

        boolean resultado = random.nextBoolean();

        EditText betTextView = findViewById(R.id.bet);

        double bet = Double.parseDouble(betTextView.getText().toString());

        String res = null;

        TextView resultadoTextView = findViewById(R.id.resultado);

        if(resultado)res = "BIG";else res="SMALL";

        if(res == "BIG"){
            jogadas.append("B");
        }else{
            jogadas.append("S");
        }

        TextView jogadasTextView = findViewById(R.id.jogadasTextView);

        jogadasTextView.setText(jogadas.toString());

        resultadoTextView.setText(res);

        if(bet > value){
            Toast.makeText(this, "No money to this Bet!", Toast.LENGTH_SHORT).show();
        }else {

            Log.i("BET", String.valueOf(bet));

            // true == BIG and false == SMALL

            if (resultado == true && Integer.parseInt(view.getTag().toString()) == 0) {
                value = value + bet;
            } else {
                if (resultado == false && Integer.parseInt(view.getTag().toString()) == 1) {
                    value = value + bet;
                } else {
                    value = value - bet;
                }
            }

            TextView valueTextView = findViewById(R.id.value);

            valueTextView.setText(String.valueOf(value));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView res = findViewById(R.id.resultado);
        TextView money = findViewById(R.id.value);

        res.setText("Result");
        money.setText("Your Money");

    }
}
