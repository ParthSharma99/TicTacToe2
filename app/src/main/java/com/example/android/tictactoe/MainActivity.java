package com.example.android.tictactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    int[] pos = {10,10,10,10,10,10,10,10,10};
    boolean gameStop = false;
    int[][] winningPos = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    // 0 : cross , 1 : circle
    String[] player_name = {"Circle","Cross"};
    int user = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void restart(View view){
        Log.i("as","Started......");
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.constraintLayout);


        ImageView img_pos = (ImageView)findViewById(R.id.imageView1);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView2);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView3);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView4);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView5);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView6);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView7);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView8);
        img_pos.setImageDrawable(null);
        img_pos = (ImageView)findViewById(R.id.imageView9);
        img_pos.setImageDrawable(null);



        gameStop = false;
        for (int i = 0; i <pos.length ;i++){
            pos[i] = 10;
        }
        user = 0;
        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setVisibility(View.INVISIBLE);

        Button playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
    }


    public boolean check_win(){
        for (int[] i : winningPos){
            if ( (pos[i[0]] == pos[i[1]]) && (pos[i[1]]==pos[i[2]]) && pos[i[0]]!= 10 ){
                return true;
            }
        }
        return false;
    }


    public boolean check_draw(){
        for (int i : pos){
            if (i == 10)    return  false;
        }
        return true;
    }


    public void show_move(View view){

        if (gameStop == false) {
            ImageView image = (ImageView) view;

            int clickedTag = Integer.parseInt(image.getTag().toString());

            Button playAgain = (Button) findViewById(R.id.playAgain);
            TextView txt = (TextView)findViewById(R.id.textView);


            if (pos[clickedTag] == 10 && user == 0) {
                //image.setTranslationY(-2000);
                image.setImageResource(R.drawable.cross);
                image.animate().alpha(0).setDuration(0);
                //image.animate().translationYBy(2000).setDuration(100);
                image.animate().alpha(1).setDuration(300);
                user = 1;
                pos[clickedTag] = user;
                if (check_win()) {
                    gameStop = true;
                    txt.setText(player_name[user] + " has won.");
                    txt.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);
                }
                if(check_draw()) {
                    gameStop = true;
                    txt.setText("Its a Draw!");
                    txt.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);

                }


            } else if (pos[clickedTag] == 10 && user == 1) {

                //image.setTranslationY(-2000);
                image.setImageResource(R.drawable.circle);
                image.animate().alpha(0).setDuration(0);
                //image.animate().translationYBy(2000).setDuration(100);
                image.animate().alpha(20).setDuration(10000);
                user = 0;
                pos[clickedTag] = user;
                if (check_win()) {
                    gameStop = true;
                    txt.setText(player_name[user] + " has won.");
                    txt.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);
                }
                if(check_draw()) {
                    gameStop = true;
                    txt.setText("Its a Draw!");
                    txt.setVisibility(View.VISIBLE);
                    playAgain.setVisibility(View.VISIBLE);

                }

            }

        }
    }
}
