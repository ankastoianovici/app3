package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Citire extends AppCompatActivity {
    BottomNavigationView nav;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        nav=findViewById(R.id.nav);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ServerDetails:
                        replaceFragment(new ServerDetails());
                        break;
                    case R.id.Browse:
                        opentest();
                        break;
                    case R.id.DataAccess:
                        replaceFragment(new DataAccess());
                        break;
                    case R.id.AlarmsEvents:
                        openAl();
                        break;
                    case R.id.RuntimeDevelopment:
                        openRuntimeDevelopment();
                        break;
                }
                return false;
            }
        });
    }
    private void openRuntimeDevelopment() {
        Intent intent4 = new Intent(getApplicationContext(), runtime.class);
        startActivity(intent4);
    }
    private void openAl() {
        Intent intent3 = new Intent(getApplicationContext(), test.class);
        startActivity(intent3);
    }
    private void opentest() {
        Intent intent2 = new Intent(getApplicationContext(), testmiscare.class);
        startActivity(intent2);
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }
}
