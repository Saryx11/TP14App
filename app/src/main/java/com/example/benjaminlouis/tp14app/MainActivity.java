package com.example.benjaminlouis.tp14app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go = (Button) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread prog = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ProgressBar barre = (ProgressBar) findViewById(R.id.progress);
                        try {
                            while (barre.getProgress() < barre.getMax()) {
                                barre.incrementProgressBy(1);
                                Thread.sleep(300);
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
