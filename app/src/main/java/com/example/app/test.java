package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {

    private LinearLayout btn_hide_show,layout_hide_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        btn_hide_show=findViewById(R.id.btn_cash);
        layout_hide_show = findViewById(R.id.layout_hide_show);
             btn_hide_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int invisible=layout_hide_show.getVisibility();
                if(invisible==View.VISIBLE){
                    layout_hide_show.setVisibility(View.GONE);
                }
                else {
                    layout_hide_show.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
