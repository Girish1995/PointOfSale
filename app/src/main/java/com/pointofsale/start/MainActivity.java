package com.pointofsale.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.pointofsale.R;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    if (PreferencesService.instance().getLogin_Status().equals("201")){
//                        MainActivity.this.finish();
//                        startActivity(new Intent(MainActivity.this,MainDashboard.class));
//                    }
                   // else {
                        MainActivity.this.finish();
                        startActivity(new Intent(MainActivity.this, SelectBusinessType.class));
                    //}
                }
            }
        };
        timer.start();
    }
}
