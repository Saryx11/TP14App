package com.example.benjaminlouis.tp14app;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Handler handlerTest;
    ProgressBar barre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go = (Button) findViewById(R.id.go);
        barre = (ProgressBar) findViewById(R.id.progress);

        handlerTest = new Handler(){
        public void handleMessage(Message msg){
            int progress=msg.getData().getInt("PROGRESS");
            MainActivity.this.barre.incrementProgressBy(progress);
        }  };


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread prog = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Bundle messageBundle = new Bundle();
                        try {
                            while (MainActivity.this.barre.getProgress() < MainActivity.this.barre.getMax()) {
                                Thread.sleep(300);
                                Message msg = handlerTest.obtainMessage();
                                messageBundle.putInt("PROGRESS",1);
                                msg.setData(messageBundle);
                                handlerTest.sendMessage(msg);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                prog.start();
            }
        });
    }
}
