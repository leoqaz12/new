package com.example.sendemailauto;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.androimail.R;

import java.util.Random;

public class SendActivity extends Activity {
    Button button;
    GMailSender sender;
    String info1 = MainActivity.edit1;
    String info2 = MainActivity.edit2;
    String info3 = MainActivity.edit3;
    String textSubject;
    String textMessage;
    String textTo;

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_activity);
        button = (Button) findViewById(R.id.buttonSend);
        // Add your mail Id and Password
        sender = new GMailSender("eg8625@gmail.com", "Eg86starlook");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                try {
                    new MyAsyncClass().execute();

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        button.performClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(SendActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add subject, Body, your mail Id, and receiver mail Id.
                sender.sendMail(setTextSubject(), setTextMessage(), "eg8625@gmail.com", setTextTo1());
                sender.sendMail(setTextSubject(), setTextMessage(), "eg8625@gmail.com", setTextTo2());
                sender.sendMail(setTextSubject(), setTextMessage(), "eg8625@gmail.com", setTextTo3());

            } catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
            Toast.makeText(getApplicationContext(), "Email send", Toast.LENGTH_SHORT).show();
        }
    }

    public String setTextSubject(){
        textSubject = "SENDING EMAIL TO YOUR FRIENDS";
        return textSubject;
    }

    public String setTextMessage() {
        String[] myArray = new String[3];
        myArray[0]="YOU LOSE└(゜∀゜└)(┘゜∀゜)┘";
        myArray[1]="ε=ε=ε=ε=ε=ε=┌(￣◇￣)┘";
        //myArray[1]="LAUGHING AT YOU";
        myArray[2]="YOU ARE SILLY(#`Д´)ﾉ(#`Д´)ﾉ(#`Д´)ﾉ";
        int idx = new Random().nextInt(myArray.length);
        String random = (myArray[idx]);
        textMessage = random;
        return textMessage;
    }

    public String setTextTo1(){
        //String[] emailArray = new String[3];
        //emailArray[0]=info1;
        //emailArray[1]=info2;
        //emailArray[2]=info3;
        //myArray[3]="ε=ε=ε=ε=ε=ε=┌(￣◇￣)┘";
        //"als.mer622@gmail.com"
        //"leoqaz12@yahoo.com.tw"
        //"yuwenpan0531@gmail.com"
        //int idd = new Random().nextInt(emailArray.length);
        //String random2 = (emailArray[idd]);
        textTo = info1;
        return textTo;
    }

    public String setTextTo2(){
        textTo = info2;
        return textTo;
    }

    public String setTextTo3(){
        textTo = info3;
        return textTo;
    }
}