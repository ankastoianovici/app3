package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.opcfoundation.ua.builtintypes.NodeId;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.core.Attributes;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;

public class test extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private LinearLayout btn_hide_show,layout_hide_show;
    private Spinner spinner, spinner1;
    private Spinner spinner2,spinner3;
    //private static final String[] security_policy={"None","Basic256","Basic128Rsa15"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Spinner spinner=findViewById(R.id.spinner_security_mode);
        Spinner spinner1=findViewById(R.id.spinner_message_encoding);
        Spinner spinner2=findViewById(R.id. spinner_security_policy);
        Spinner spinner3=findViewById(R.id.  spinner_user_identity);


        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.security_mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this, R.array.security_policy, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this, R.array.user_identity, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3= ArrayAdapter.createFromResource(this, R.array.mesage_encoding, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter3);
        spinner1.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
