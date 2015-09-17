package br.com.glicheck.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import br.com.glicheck.R;

/**
 * Created by f.de.souza.filho on 9/12/2015.
 */
public class Splash_Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Timer().schedule(new TimerTask()
        {

            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(Splash_Activity.this, Main_Glicheck_Activity.class);
                startActivity(intent);

            }
        }, 3000);


    }

}

