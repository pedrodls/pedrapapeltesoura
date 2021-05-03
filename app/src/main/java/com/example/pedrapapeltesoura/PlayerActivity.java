package com.example.pedrapapeltesoura;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class PlayerActivity extends AppCompatActivity {

    RandomImage randomImage;

    List<RandomImage> randomImages = new ArrayList<RandomImage>();

    Random r = new Random();

    int sorted=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        setBtnInvisible();
    }

    public void setRandomImages() {
        randomImages.clear();
        randomImages.add(new RandomImage("imgPedra", R.drawable.pedra));
        randomImages.add(new RandomImage("imgPapel", R.drawable.papel));
        randomImages.add(new RandomImage("imgTesoura", R.drawable.tesoura));
    }

    public void setBtnVisible(){
        Button btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setVisibility(View.VISIBLE);
    }

    public void setBtnInvisible(){
        Button btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setVisibility(View.INVISIBLE);
    }

    public void setTextResp(String resp){
        TextView txtResp = (TextView) findViewById(R.id.txtRes);
        txtResp.setText(resp);
    }

    public void restart(View view){

        ImageView imgRes = (ImageView) findViewById(R.id.imgRes);

        imgRes.setImageResource(R.drawable.padrao);

        setBtnInvisible();

        setTextResp("Escolha uma opção abaixo");
    }

    @SuppressLint("ResourceType")
    public void play(View view){

        //Metodo que coloca as imagens no vetor
        setRandomImages();

        int rSorted = r.nextInt(randomImages.size());

        //Pegando a imageView da escolha do App
        ImageView imgRes = (ImageView) findViewById(R.id.imgRes);

        //Pegando a imageView da opção escolhida
        ImageView imgReq = (ImageView) findViewById(view.getId());

        //Sorteando imageView da lista
        sorted = randomImages.get(rSorted).getImageId();

        //Alterando a imagem padrão pela imagem sorteada
        imgRes.setImageResource(sorted);

        String optReqName = imgReq.getResources().getResourceEntryName(view.getId()).toString();

        String optResName = randomImages.get(rSorted).getOption().toString();

        if(!(
                (optResName.contains("imgPapel")   && optReqName.contains("imgPedra"))||
                (optResName.contains("imgTesoura") && optReqName.contains("imgPapel"))||
                (optResName.contains("imgPedra")   && optReqName.contains("imgTesoura"))
        )) {
            if (optResName.contains(optReqName))
                setTextResp("Empate!");
            else
                setTextResp("Você Ganhou!");
        }else
            setTextResp("Você Perdeu!");

        setBtnVisible();
    }

}