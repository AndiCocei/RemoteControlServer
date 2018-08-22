package com.example.andi.rc_app_main;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void>{

    static Socket s;

    @Override
    protected Void doInBackground(String... voids){

        String message = voids[0];

        try{
            s = new Socket(Setup.SERVER_IP, 7800);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            s.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
