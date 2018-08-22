package com.example.andi.rc_app_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Setup extends AppCompatActivity {

    public static String SERVER_IP;
    EditText sIP;
    Button bRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        bRC = findViewById(R.id.bRC);
        sIP = findViewById(R.id.eIP);
        bRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemoteControl();
                SERVER_IP = null;
                SERVER_IP = sIP.getText().toString();
            }
        });
    }

    public void openRemoteControl(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
