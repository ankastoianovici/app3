package com.example.app;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class Save extends AppCompatActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_runtime_development);

        frameLayout= findViewById(R.id.layout_mare);

        Button button=findViewById(R.id.save);
        button.setOnClickListener(V->{
            saveImage();
        });
    }

    private void saveImage() {

        frameLayout.setDrawingCacheEnabled(true);
        frameLayout.buildDrawingCache();
        frameLayout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap =frameLayout.getDrawingCache();
        save(bitmap);
    }

    private void save(Bitmap bitmap) {

        String root= Environment.getExternalStorageDirectory().getAbsolutePath();
        File file=new File(root+"/Deploy");
        String filename="mysimple.jpg";
        File myfile=new File(file, filename);
        frameLayout.setDrawingCacheEnabled(false);

        if(myfile.exists())

        {
            myfile.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "sf", Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(this, "ree", Toast.LENGTH_SHORT).show();
        }

    }
}
