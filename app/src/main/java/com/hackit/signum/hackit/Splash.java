package com.hackit.signum.hackit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;


public class Splash extends Activity {
    protected  static final long TIEMPO =2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timer=new Thread(){

            @Override
            public void run() {
                try {
                    sleep(TIEMPO);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally {

                    Intent miIntento =new Intent(Splash.this,MainActivity.class);
                    startActivity(miIntento);


                }

            }


        };
        timer.start();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

}


