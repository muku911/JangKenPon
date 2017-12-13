package com.example.muku.jankenpon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by MUKU on 26/04/2016.
 */
public class Game extends Activity {

    Button bt_gou, bt_choki, bt_paa;
    ImageView bot, player;
    TextView skor, hina;

    String playerChoise, botChoise, hasil, pemenang;
    float score = 0, win = 3, loose = -3;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        bt_paa = (Button)findViewById(R.id.paa);
        bt_choki = (Button)findViewById(R.id.choki);
        bt_gou = (Button)findViewById(R.id.gou);

        hina = (TextView)findViewById(R.id.textView);

        bot = (ImageView)findViewById(R.id.bot);
        player = (ImageView)findViewById(R.id.player);

        skor = (TextView)findViewById(R.id.text_score);

        r = new Random();


        bt_gou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "batu";
                player.setImageResource(R.drawable.batu);
                calculate();
            }
        });

        bt_choki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "gunting";
                player.setImageResource(R.drawable.gunting);
                calculate();
            }
        });

        bt_paa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerChoise = "kertas";
                player.setImageResource(R.drawable.kertas);
                calculate();
            }
        });
    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if (cpu == 0){
            botChoise = "batu";
            bot.setImageResource(R.drawable.batu);
        }else if (cpu == 1){
            botChoise = "gunting";
            bot.setImageResource(R.drawable.gunting);
        }else  if (cpu == 2){
            botChoise = "kertas";
            bot.setImageResource(R.drawable.kertas);
        }

        if(playerChoise.equals("batu") && botChoise.equals("gunting")){
            hasil = "You Win!! Hoki LOE!!";
            score++;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("gunting") && botChoise.equals("batu")){
            hasil = "You LOSSER!! DASAR CUPU!!";
            score--;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("kertas") && botChoise.equals("batu")){
            hasil = "You Win!! Hoki LOE!!";
            score++;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("batu") && botChoise.equals("kertas")){
            hasil = "You LOSSER!! DASAR CUPU!!";
            score--;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("gunting") && botChoise.equals("kertas")){
            hasil = "You Win!! Hoki LOE!!";
            score++;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("kertas") && botChoise.equals("gunting")){
            hasil = "You LOSSER!! DASAR CUPU!!";
            score--;
            skor.setText("Score = "+score);
        }else if(playerChoise.equals("gunting") && botChoise.equals("gunting")){
            hasil = "Draw!! Cie~ samaan.. :P!!";
        }else if(playerChoise.equals("batu") && botChoise.equals("batu")){
            hasil = "Draw!! Cie~ samaan.. :P!!";
        }else if(playerChoise.equals("kertas") && botChoise.equals("kertas")){
            hasil = "Draw!! Cie~ samaan.. :P!!";
        }

        hina.setText(hasil);

        if(score == win){
            pemenang = "Selamat deh Anda menang.. :)";
            Toast.makeText(Game.this, pemenang,Toast.LENGTH_LONG).show();
            finish();
        }else if (score == loose){
            pemenang = "DASAR CUPU LAWAN KOMPUTER AJA KALAH FUCK YOU NOOB :P";
            Toast.makeText(Game.this, pemenang,Toast.LENGTH_LONG).show();
            finish();
        }



    }
}
