package com.helloreactnative;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.app.Activity;

public class ServiceHandler extends ReactContextBaseJavaModule {

  private Intent trackServiceIntent;
  private TrackMonitorService mService = null;

  public ServiceHandler(ReactApplicationContext reactContext) {
    super(reactContext);

  }

  @Override
  public String getName() {
     return "ServiceExample";
  }

  @Override
  public Map<String, Object> getConstants() {
     final Map<String, Object> constants = new HashMap<>();
     return constants;
  }

  @ReactMethod
  public void start() {
    try {

      trackServiceIntent = new Intent(getCurrentActivity(), TrackMonitorService.class);
      getCurrentActivity().bindService(trackServiceIntent, mConnection, Context.BIND_AUTO_CREATE);

    }catch (Exception e) {
        Toast.makeText(getReactApplicationContext(), e.getMessage(), 5000).show();
    }

  }

  @ReactMethod
  public void stop() {
    try {
      
       getCurrentActivity().unbindService(mConnection);
       Toast.makeText(getReactApplicationContext(), "Service stopped", 5000).show();

    }catch (Exception e) {

    }

  }

  /** Defines callbacks for service binding, passed to bindService() */
 private ServiceConnection mConnection = new ServiceConnection() {

     @Override
     public void onServiceConnected(ComponentName className,
                                    IBinder service) {
         // We've bound to LocalService, cast the IBinder and get LocalService instance
         TrackMonitorService.LocalBinder binder = (TrackMonitorService.LocalBinder) service;
         mService = binder.getService();
     }

     @Override
     public void onServiceDisconnected(ComponentName arg0) {
     }
 };
}
