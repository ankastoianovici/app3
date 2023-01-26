package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.prosysopc.ua.SessionActivationException;
import com.prosysopc.ua.UserIdentity;
import com.prosysopc.ua.client.UaClient;

import org.opcfoundation.ua.transport.security.SecurityMode;

import java.net.URISyntaxException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText serverUriTextField;
    private String serverUri;
    public static UaClient myClient;
    private String error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.connect);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button connectBtn= findViewById(R.id.connectBtn);
        serverUriTextField = findViewById(R.id.serverTf);
        //Button connectBtn= findViewById(R.id.button2);
        //serverUriTextField = findViewById(R.id.serverTf1);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                serverUri = serverUriTextField.getText().toString();

                try {
                    myClient = createClient(serverUri);
                    myClient.connect();
                    Intent intent = new Intent(getApplicationContext(), Citire.class);
                    //Intent intent = new Intent(getApplicationContext(), test.class);
                    startActivity(intent);
                } catch (Exception e) {
                    error = e.toString();
                    showAlert("Error", "Failed to connect");
                }
            }
        });
    }
    private void showAlert(String title, String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
    private UaClient createClient(String serverUri) throws URISyntaxException, SessionActivationException {
        UaClient myClient = new UaClient(serverUri);
        myClient.setLocale(Locale.ENGLISH);
        myClient.setTimeout(60000);
        myClient.setSecurityMode(SecurityMode.NONE);
        myClient.setUserIdentity(new UserIdentity());
        return myClient;
    }
    public static UaClient getMyClient(){
        return myClient;
    }
}