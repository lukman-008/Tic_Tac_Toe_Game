package com.example.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeplayer =0;
    boolean act=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int [][]winning={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6}};
    public void dropin(View view){
        ImageView counter = (ImageView)view;
        int tap=Integer.parseInt(counter.getTag().toString());
        if(gameState[tap]==2 && act){
        gameState[tap]=activeplayer;

        counter.setTranslationY(-1500);
        if(activeplayer==0) {
            counter.setImageResource(R.drawable.cross);
            activeplayer = 1;
        }else
        {
            counter.setImageResource(R.drawable.circle);
            activeplayer = 0;
        }
        counter.animate().translationYBy(1500).setDuration(300);
        for(int []winning:winning){
            String winner="";
            if(gameState[winning[0]]==gameState[winning[1]]&&gameState[winning[1]]==gameState[winning[2]]&& gameState[winning[0]]!=2){
               act=false;
                if(activeplayer==1)
                {
                    winner="Player 1";
                }else{
                    winner="Player 2";
                }
                Toast.makeText(this,winner+" Won!! Yayayayaya",Toast.LENGTH_SHORT).show();
                ImageView imageView13=(ImageView)findViewById(R.id.imageView13);
                imageView13.setVisibility(View.VISIBLE);

            }}
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}