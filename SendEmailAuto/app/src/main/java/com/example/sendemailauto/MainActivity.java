package com.example.sendemailauto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.androimail.R;

public class MainActivity extends AppCompatActivity{
    EditText text1;
    EditText text2;
    EditText text3;
    Button ok;
    public static String edit1; //不管被初始化多少次，都是原值
    public static String edit2;
    public static String edit3;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        text1 = (EditText) findViewById(R.id.send1);
        text2 = (EditText) findViewById(R.id.send2);
        text3 = (EditText) findViewById(R.id.send3);
        ok = (Button) findViewById(R.id.buttonOk);
    }
    public void onInsertClick(View view) {
        edit1 = text1.getText().toString();
        edit2 = text2.getText().toString();
        edit3 = text3.getText().toString();
        Intent intent = new Intent(this, SendActivity.class);
        startActivity(intent);
    }

}
