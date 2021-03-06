package com.aviparshan.tsarandom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView left = (ImageView) findViewById(R.id.left);
        final ImageView right = (ImageView) findViewById(R.id.right);
        final Button tapHere =  (Button) findViewById(R.id.button);

        final Animation fadeout = new AlphaAnimation(1,0);
        fadeout.setStartOffset(1000);
        fadeout.setDuration(1000);
        assert left != null;
        left.setAnimation(fadeout);
        assert right != null;
        right.setAnimation(fadeout);

        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);
                assert tapHere != null;
                tapHere.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        assert tapHere != null;
        tapHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r= new Random();
                int i = r.nextInt(2);
                tapHere.setVisibility(View.GONE);
                if (i == 0){
                    left.setVisibility(View.VISIBLE);
                    left.startAnimation(fadeout);
                }
                else{
                    right.setVisibility(View.VISIBLE);
                    right.startAnimation(fadeout);
                }

            }
        });
    }
}
