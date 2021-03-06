package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StartingPage extends AppCompatActivity implements OnClickListener{

    Animation btnanim1;
    Animation btnanim2;
    Animation btnanim3;
    Animation btnanim4;
    ImageView imageView,imageView1;

    private LinearLayout layout1;
    private LinearLayout layout2;

    //floating action button
    FloatingActionButton floatmain, float1, float2, float3;
    float translationY = 100;
    Boolean isMenuOpen = false;
    private static final String TAG = "LoginActivity";
    OvershootInterpolator interpolator = new OvershootInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        initFloatMenu();

        //declare the animation
        btnanim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btt1);
        btnanim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btt2);
        btnanim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btt3);
        btnanim4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btt4);

       imageView=findViewById(R.id.imageView);
       imageView1=findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AdminActivity = new Intent(StartingPage.this,Login.class);
                startActivity(AdminActivity);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TeacherActivity = new Intent(StartingPage.this,AdminLogin.class);
                startActivity(TeacherActivity);
            }
        });

    }

    private void initFloatMenu() {

        //declare floating buttons
        floatmain = findViewById(R.id.fab);
        float1 = findViewById(R.id.floatingb1);
        float2 = findViewById(R.id.floatingb2);
        float3 = findViewById(R.id.floatingb3);

        float1.setAlpha(0f);
        float2.setAlpha(0f);
        float3.setAlpha(0f);

        float1.setTranslationY(translationY);
        float2.setTranslationY(translationY);
        float3.setTranslationY(translationY);


        //setup floating buttons
        floatmain.setOnClickListener(this);
        float1.setOnClickListener(this);
        float2.setOnClickListener(this);
        float3.setOnClickListener(this);

        float1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingPage.this,AboutCollege.class);
                startActivity(intent);
            }
        });

        float2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingPage.this,AboutDept.class);
                startActivity(intent);
            }
        });

        float3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingPage.this,AboutUs.class);
                startActivity(intent);
            }
        });

    }

    private void openMenu(){

        isMenuOpen = !isMenuOpen;
        floatmain.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();
        float1.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        float2.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        float3.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

    }

    private void closeMenu(){

        isMenuOpen = !isMenuOpen;
        floatmain.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();
        float1.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        float2.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        float3.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.fab:
                Log.i(TAG, "onClick: Float main");
                if (isMenuOpen){
                    closeMenu();
                }else {
                    openMenu();
                }
                break;
            case R.id.floatingb1:
                Log.i(TAG, "onClick:College");
                break;
            case R.id.floatingb2:
                Log.i(TAG, "onClick: Courses");
                break;
            case R.id.floatingb3:
                Log.i(TAG, "onClick: About");
                break;
        }

    }
}