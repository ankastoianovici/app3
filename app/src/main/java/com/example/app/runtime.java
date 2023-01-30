package com.example.app;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class runtime extends AppCompatActivity {

    private LinearLayout btn_hide_show,layout_hide_show;
    private LinearLayout btn_hide_show_test,layout_hide_show_test;
    private ImageView imageView,imageView1,imageView2,imageView3;
    private LinearLayout miscare;
    BottomNavigationView nav;
    float xCoordonate, yCoordonate;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_runtime_development);

        imageView = findViewById(R.id.analizorclor);
        imageView1 = findViewById(R.id.bazinempty);
        imageView2 = findViewById(R.id.bazinful);
        //textView = findViewById(R.id.bazinful);
        miscare= findViewById(R.id.miscare);

        nav=findViewById(R.id.nav);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });
        imageView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });
        /*imageView2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("use")
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData= ClipData.newPlainText("tetz",textView.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.bazinful));

                Toast.makeText(runtime.this, "", Toast.LENGTH_SHORT).show();
            }
        });*/
        miscare.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onViewTouch(v, event);
                return true;
            }
        });
        nav=findViewById(R.id.nav);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ServerDetails:
                        //replaceFragment(new ServerDetails());
                        replaceFragment(new ServerDetails());
                        break;
                    case R.id.Browse:
                        replaceFragment(new Browse());
                        break;
                    case R.id.DataAccess:
                        replaceFragment(new DataAccess());
                        break;
                    case R.id.AlarmsEvents:
                        replaceFragment(new Alarmas());
                        //openAlarmsEvents();
                        break;
                    case R.id.RuntimeDevelopment:
                        openRuntimeDevelopment();
                        // replaceFragment(new RuntimeDevelopment());
                        break;
                }
                return false;
            }
        });
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

        btn_hide_show_test=findViewById(R.id.btn_cash_test);
        layout_hide_show_test = findViewById(R.id.layout_hide_show_test);
        btn_hide_show_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int invisible=layout_hide_show_test.getVisibility();
                if(invisible==View.VISIBLE){
                    layout_hide_show_test.setVisibility(View.GONE);
                }
                else {
                    layout_hide_show_test.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void openRuntimeDevelopment() {

        Intent intent4 = new Intent(getApplicationContext(), runtime.class);
        startActivity(intent4);

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