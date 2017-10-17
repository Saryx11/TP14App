package com.example.benjaminlouis.tp14app;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * Created by benjaminlouis on 17/10/2017.
 */

public class AsyncTaskClass extends AsyncTask<String,Integer,String> {
    private Activity activity;
    private int max;

    public AsyncTaskClass(Activity act) {
        this.activity=act;
        ProgressBar barre=(ProgressBar)activity.findViewById(R.id.progress);
        max=barre.getMax();

    }

    @Override
    protected String doInBackground(String... params) {
        ProgressBar barre=(ProgressBar)activity.findViewById(R.id.progress);
        for(int i=0;i<max;i++){
            try {
                Thread.sleep(3000);
                publishProgress(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onCancelled(String result){

    }

    @Override
    protected void onPostExecute(String result){

    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values[0]);
        ProgressBar p=activity.findViewById(R.id.progress);
        p.incrementProgressBy(values[0]);

    }

}
