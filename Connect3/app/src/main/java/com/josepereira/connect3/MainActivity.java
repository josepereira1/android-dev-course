package com.josepereira.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 - jogador da bola & 1 - jogador do x;

    int activePlayer = 0;
    int[]game = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winingPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameIsActive = true;

    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        if(game[Integer.parseInt(view.getTag().toString())] == -1 && gameIsActive){
            counter.setTranslationY(-1000f);
            game[Integer.parseInt(view.getTag().toString())] = activePlayer;
            if(activePlayer == 0){
                counter.setImageResource(R.drawable.o);

                activePlayer = 1;
            }else{
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);

            TextView gameOverText = findViewById(R.id.gameOverTextView);

            for(int[] winingPositions : winingPositions){
                if(game[winingPositions[0]] == game[winingPositions[1]] && game[winingPositions[1]] == game[winingPositions[2]] && game[winingPositions[0]] != -1){
                    System.out.println("Ganhou o jogador número "+game[winingPositions[0]]+"!");
                    this.gameIsActive = false;
                    if(game[winingPositions[0]] == 0){
                        gameOverText.setText("Balls win!");
                    }else{
                        gameOverText.setText("Red win!");
                    }
                    LinearLayout gameOverLayout = (LinearLayout) findViewById(R.id.gameOverLinearLayout);
                    gameOverLayout.animate().setDuration(15000);
                    gameOverLayout.setVisibility(View.VISIBLE);
                }
            }
            if(noWinners() == true){
                this.gameIsActive = false;
                gameOverText.setText("No winners!");
                LinearLayout gameOverLayout = (LinearLayout) findViewById(R.id.gameOverLinearLayout);
                gameOverLayout.animate().setDuration(15000);
                gameOverLayout.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playAgainButton(View view){
        this.activePlayer = 0;
        this.gameIsActive = true;
        LinearLayout gameOverLayout = (LinearLayout) findViewById(R.id.gameOverLinearLayout);
        gameOverLayout.setVisibility(View.INVISIBLE);

        for(int i = 0; i < this.game.length; i++){
            this.game[i] = -1;
        }

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    public boolean noWinners(){
        for(int i = 0; i < game.length; i++){
            if(game[i] == -1)return false;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
