package com.example.andi.rc_app_main;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float initX =0;
    private float initY =0;
    private float disX =0;
    private float disY =0;

    TextView mousePad;
    Button buttonRestart;
    Button buttonScreenLock;
    Button buttonShutdown;
    Button buttonSleep;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mousePad = findViewById(R.id.mousePad);
        buttonRestart = findViewById(R.id.bRestart);
        buttonScreenLock = findViewById(R.id.bLock);
        buttonShutdown = findViewById(R.id.bShutdown);
        buttonSleep = findViewById(R.id.bSleep);

        buttonShutdown.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                MessageSender messageSender = new MessageSender();
                messageSender.execute("shutdown");
                return false;
            }
        });
        buttonScreenLock.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                MessageSender messageSender = new MessageSender();
                messageSender.execute("screenlock");
                return false;
            }
        });
        buttonSleep.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                MessageSender messageSender = new MessageSender();
                messageSender.execute("sleep");
                return false;
            }
        });
        buttonRestart.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                MessageSender messageSender = new MessageSender();
                messageSender.execute("restart");
                return false;
            }
        });

        //capture movement on the textview
        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            //save X and Y positions when user touches the TextView
                            initX =event.getX();
                            initY =event.getY();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            disX = event.getX()- initX; //Mouse movement in x direction
                            disY = event.getY()- initY; //Mouse movement in y direction
                            initX = event.getX();
                            initY = event.getY();
                            if(disX !=0 || disY !=0){
                                MessageSender messageSender = new MessageSender();
                                messageSender.execute(disX +","+ disY);
                            }
                    }
                return true;
            }
        });
    }

    public void sendUp(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("up");
    }
    public void sendDown(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("down");
    }
    public void sendLeft(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("left");
    }
    public void sendRight(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("right");
    }
    public void sendSpace(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("space");
    }
    public void sendEnter(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("enter");
    }

    public void sendVolumeUp(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("volumeup");
    }
    public void sendVolumeDown(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("volumedown");
    }

    public void sendLeftClick(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("leftclick");
    }
    public void sendMiddleClick(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("middleclick");
    }
    public void sendRightClick(View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute("rightclick");
    }
}