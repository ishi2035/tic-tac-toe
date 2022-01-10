package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // player
    // 0 = O
    // 1 = x
    boolean gameActive = true;
    int ActivePlayer = 1;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    /*
    game state:
    1= X
    0 = O
    2 = null
     */
    int[][] WinningPositions ={
            {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };

    public void playATab(View view ){
        ImageView img = (ImageView)view;
        int tabbedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tabbedImage]==2){
            gameState[tabbedImage]= ActivePlayer;
//            img.setTranslationY(-1000f);
            if(ActivePlayer==1) {
                img.setImageResource(R.drawable.x);
                ActivePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                ActivePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - tap to play");
            }
            int c=9;
            for(int i= 0; i<gameState.length; i++ ){
                if(gameState[i]!=2){
                    c--;
                }
            }
            if(c==0){
                gameActive=false;
            }
        }
        for(int[] WinningPosition:WinningPositions ){
            if(gameState[WinningPosition[0]]==gameState[WinningPosition[1]] && gameState[WinningPosition[2]]==gameState[WinningPosition[1]] && gameState[WinningPosition[0]]!=2 ){
                String winner;
                gameActive = false;
                if(gameState[WinningPosition[0]]==1){
                    winner = " x has won";
                }
                else{
                    winner = " y has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);

            }

        }
//        img.animate().translationXBy(1000f).setDuration();
    }
    public void gameReset(View view){
        gameActive = true;
        ActivePlayer=1;
        for(int i =0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ( (ImageView)findViewById(R.id.c1)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c2)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c3)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c4)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c5)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c6)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c7)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c8)).setImageResource(0);
        ( (ImageView)findViewById(R.id.c9)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's turn - tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
