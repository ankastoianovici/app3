package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RuntimeDevelopment extends Fragment  {

    private ImageView imageView;
    View view;
    float xCoordonate, yCoordonate;
  /*  @Override
  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = imageView.findViewById(R.id.bazinempty);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        view= inflater.inflate(R.layout.fragment_runtime_development, null);
        imageView = imageView.findViewById(R.id.bazinempty);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });
        return view;
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