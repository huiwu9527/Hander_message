package com.example.administrator.hander_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private Button add_button;
    private ProgressBar text_bar;
    private Button sub_button;
    int i;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_button = (Button) findViewById(R.id.add_button);
        sub_button = (Button) findViewById(R.id.sub_button);
        text_bar = (ProgressBar) findViewById(R.id.text_par);
         handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1: {
                        text_bar.setProgress(i);
                    }break;
                    case 2:{
                        text_bar.setProgress(i);
                    }break;
                }
            }
        };
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message =new Message();
                        message.what=1;
                        i+=10;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message =new Message();
                        message.what=2;
                        i-=10;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}
