package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {

    private LinearLayout btn_hide_show,btn_hide_show1,layout_hide_show,layout_hide_show1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        btn_hide_show=findViewById(R.id.btn_cash);
        layout_hide_show = findViewById(R.id.layout_hide_show);
        btn_hide_show1=findViewById(R.id.btn);
        layout_hide_show1 = findViewById(R.id.layout_hide_show1);

        btn_hide_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int invisible=layout_hide_show.getVisibility();
                int invisible1=layout_hide_show1.getVisibility();
                if(invisible==View.VISIBLE){
                    layout_hide_show.setVisibility(View.GONE);
                }
                else {
                    layout_hide_show.setVisibility(View.VISIBLE);
                }
            }
        });
        btn_hide_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int invisible1=layout_hide_show1.getVisibility();
                if(invisible1==View.VISIBLE){
                    layout_hide_show1.setVisibility(View.GONE);
                }
                else {
                    layout_hide_show1.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
