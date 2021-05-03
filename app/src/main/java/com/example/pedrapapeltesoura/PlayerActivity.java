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

        setRandomImages();

        ImageView imgRes = (ImageView) findViewById(R.id.imgRes);

        ImageView imgReq = (ImageView) findViewById(view.getId());

        sorted = randomImages.get(r.nextInt(randomImages.size())).getImageId();

        imgRes.setImageResource(sorted);

        setTextResp(imgReq.getResources().getResourceEntryName(view.getId())+"");

        setBtnVisible();
    }
}