package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class runtime extends AppCompatActivity {


    private ImageView imageView;
    float xCoordonate, yCoordonate;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_runtime_development);

        imageView = findViewById(R.id.bazinempty);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });

    }

    private void onViewTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xCoordonate = v.getX() - event.getRawX();
                yCoordonate = v.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                v.animate().x(event.getRawX() + xCoordonate).y(event.getRawY() + yCoordonate).setDuration(0).start();
        }
    }
}
