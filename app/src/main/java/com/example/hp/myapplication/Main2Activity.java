package com.example.hp.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Log;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab,fabOne,fabTwo,fabThree;
    Float translationY = 100f;
    Boolean isMenuOpen = false;
    OvershootInterpolator interpolator =new OvershootInterpolator();

    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Survey");

        fabmenu();

    }

    private void fabmenu() {

        fab = findViewById(R.id.fab);
        fabOne = findViewById(R.id.fabOne);
        fabTwo = findViewById(R.id.fabTwo);
        fabThree = findViewById(R.id.fabThree);

        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        fabThree.setAlpha(0f);

        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);
        fabThree.setTranslationY(translationY);


        fab.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
    }

    private void openMenu(){
        isMenuOpen = !isMenuOpen;

        fab.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        fabOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }

    private void closeMenu(){
        isMenuOpen =! isMenuOpen;

        fab.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        fabOne.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.fab:
                if(isMenuOpen){
                    closeMenu();
                }else {
                    openMenu();
                }
                break;
            case R.id.fabOne:

                addbutton();
                break;
            case R.id.fabTwo:
                break;
            case R.id.fabThree:
                break;
        }

    }

    public void addbutton() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.toolbar );
        b1 = new Button(this);

    }

    private class FloatingActionButton {
        public void setOnClickListener(Main2Activity main2Activity) {
        }

        public ViewPropertyAnimatorCompat animate() {
            return null;
        }
    }
}

