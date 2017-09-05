package com.helloreactnative;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class TrackMonitorService extends Service {

    private static final int ONGOING_NOTIFICATION_ID = 15;
    private final IBinder mBinder = new LocalBinder();  // Binder given to clients

    public TrackMonitorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Intent notificationIntent = new Intent(this, TrackMonitorService.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification =
                new Notification.Builder(this)
                        .setContentTitle("Track Monitor")
                        .setContentText("Monitoring your tracking")
                        .setContentIntent(pendingIntent)
                        .setTicker("Ticker text")
                        .build();
                        

        startForeground(ONGOING_NOTIFICATION_ID, notification);

        Toast.makeText(this.getApplicationContext(), "On binder", 10000).show();

        //pull
        return mBinder;
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        TrackMonitorService getService() {
            // Return this instance of LocalService so clients can call public methods
            return TrackMonitorService.this;
        }
    }
}
