package com.theroungelounge.freestyleapplication1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RefresherService extends Service {

    private static final String TAG = "com.trl.freestyleapp1";

    public RefresherService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand method called");
        /**
         * Thread made to SIMULATE the "refreshing" of a service.
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 10; i++) {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service Refreshed " + (i+1) + " times");
                            } catch (Exception e) {}
                        }
                    }
                }
            }
        };
        Thread roungeThread = new Thread(r);
        roungeThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
