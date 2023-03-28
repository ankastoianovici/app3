package com.example.app;

import android.app.Activity;


import android.app.AlertDialog;
        import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
        import android.os.Bundle;
        //import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
        import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class testmiscare extends AppCompatActivity implements View.OnTouchListener {

    private EditText editText;
    private ImageView imageView;
    private RelativeLayout relativeLayout;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmiscare);

        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        relativeLayout = findViewById(R.id.relative_layout);

        // Setarea evenimentelor de atingere și mutare
        imageView.setOnTouchListener(this);
        editText.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int x = (int) event.getRawX();
        final int y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                xDelta = x - lParams.leftMargin;
                yDelta = y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = x - xDelta;
                layoutParams.topMargin = y - yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        relativeLayout.invalidate();
        return true;
    }
}
