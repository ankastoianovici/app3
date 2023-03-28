package com.example.app;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class runtime extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    private LinearLayout btn_hide_show, layout_hide_show;
    private ImageView imageView;
    BottomNavigationView nav;
    //test nou pentru miscare*****************
    ImageView img, img1;
    float xDown = 0, yDown = 0;
    private static final String TAG = test.class.getSimpleName();
    private ImageView imageView1;
    private static final String IMAGE_VIEW_TAG = "LAUNCHER LOGO";



    //****************************************
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_runtime_development);
        findViews();
        implementEvents();
        imageView = findViewById(R.id.analizorclor);
        img = findViewById(R.id.analizorclor1 );

        Button deploy= findViewById(R.id.deploy);
        deploy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Deploy.class);
                startActivity(intent);
            }
        });


        img1 = findViewById(R.id.analizorclor1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new FragmentDialogBox().show(getSupportFragmentManager(),"frajed");
                showAlertDialog();



            }
        });

//*********************************************************************************************************************************************
        //test nou pentru miscare
        /*img = findViewById(R.id.analizorclor1 );
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    //userul doar apasa pe imagine
                    case MotionEvent.ACTION_DOWN:
                        xDown = event.getX();
                        yDown = event.getY();
                        break;
                    //userul se poate misca
                    case MotionEvent.ACTION_MOVE:
                        float movedX, movedY;
                        movedX = event.getX();
                        movedY = event.getY();

                        //calcul cat de mult se misca

                        float distanceX = movedX - xDown;
                        float distanceY = movedY - yDown;

                        //muta imaginea in pozitia rspectiva
                        img.setX(img.getX() + distanceX);
                        img.setY(img.getY() + distanceY);
                        xDown = movedX;
                        yDown = movedY;
                        break;
                }
                return true;
            }
        });*/
        //SFARSIT
//***********************************************************************************************************************************************************


        nav = findViewById(R.id.nav);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
        btn_hide_show = findViewById(R.id.btn_cash);
        layout_hide_show = findViewById(R.id.layout_hide_show);
        btn_hide_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int invisible = layout_hide_show.getVisibility();
                if (invisible == View.VISIBLE) {
                    layout_hide_show.setVisibility(View.GONE);
                } else {
                    layout_hide_show.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(runtime.this);
        //alertDialog.setTitle("Select item");
        String[] items = {"Edit Text","Edit Node","Delete"};
        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which) {
                    case 0:
                        Toast.makeText(runtime.this,"Clicked on edit text",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(runtime.this,"Clicked on edit node",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(runtime.this,"Item deleted",Toast.LENGTH_LONG).show();
                        Hide();
                        break;

                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }


    //nu sterg in sine obiectul ci doar il ascund
    private void Hide() {
        img.setVisibility(View.INVISIBLE);
    }

    private void implementEvents() {
        imageView1.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.layout_1).setOnDragListener(this);
        findViewById(R.id.layout_mare).setOnDragListener(this);
        findViewById(R.id.layout_hide_show).setOnDragListener(this);
    }

    private void findViews() {
        imageView1 = (ImageView) findViewById(R.id.analizorclor);
        imageView1.setTag(IMAGE_VIEW_TAG);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void openRuntimeDevelopment() {

        Intent intent4 = new Intent(getApplicationContext(), runtime.class);
        startActivity(intent4);

    }

//*******************************************************************************************************************************************************************************
@Override
public boolean onDrag(View view, DragEvent dragEvent) {

    int action = dragEvent.getAction();


    switch (action) {
        case DragEvent.ACTION_DRAG_STARTED:

            if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                return true;
            }
            return false;

        case DragEvent.ACTION_DRAG_ENTERED:


            view.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);

            view.invalidate();

            return true;

        case DragEvent.ACTION_DRAG_LOCATION:
            return true;

        case DragEvent.ACTION_DRAG_EXITED:

            view.getBackground().clearColorFilter();

            view.invalidate();

            return true;

        case DragEvent.ACTION_DROP:


            ClipData.Item item = dragEvent.getClipData().getItemAt(0);

            String dragData = item.getText().toString();

            view.getBackground().clearColorFilter();

            view.invalidate();


            View v = (View) dragEvent.getLocalState();
            ViewGroup owner = (ViewGroup) v.getParent();
            owner.removeView(v);
            FrameLayout container = (FrameLayout) view;
            container.addView(v);
            v.setVisibility(View.VISIBLE);

            return true;

        case DragEvent.ACTION_DRAG_ENDED:


            view.invalidate();

            /*if (dragEvent.getResult())
                Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();*/
            return true;

       /* default:
            Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
            break;*/
    }
    return false;
}


    @Override
    public boolean onLongClick(View view) {

        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);


        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);


        view.startDrag(data //data to be dragged
                , shadowBuilder //drag shadow
                , view //local data about the drag and drop operation
                , 0 //flags (not currently used, set to 0)
        );


        view.setVisibility(View.INVISIBLE);

        return true;
    }

}