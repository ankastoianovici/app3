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
                       //replaceFragment(new RuntimeDevelopment());
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
 /* private void openAlarmsEvents() {
        Intent intent3 = new Intent(getApplicationContext(), alarms.class);
        startActivity(intent3);
    }

    private void openDataAccess() {
        Intent intent2 = new Intent(getApplicationContext(), data.class);
        startActivity(intent2);
    }

    private void openBrowse() {
        Intent intent1 = new Intent(getApplicationContext(), browse1.class);
        startActivity(intent1);
    }

    private void openServerDetails() {
        Intent intent = new Intent(getApplicationContext(), server.class);
        startActivity(intent);
    }*/
   private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }
}
