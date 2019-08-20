package com.studio.yami.cvapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import com.studio.yami.cvapp.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.lt_head);

        anim = new TranslateAnimation(0,0,-1000,0);
        anim.setDuration(1000);
        anim.setStartOffset(3000);
        layout.startAnimation(anim);

        Splash splash = new Splash();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_container, splash).commit();


        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    HomeFragment frHome = HomeFragment.newInstance();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                    ft.replace(R.id.fr_container, frHome).commit();
                }

            }
        };

        timer.start();

    }

    @Override
    public void onBackPressed() {

        onDialog();

    }

    private void onDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Yakin ingin Keluar");
        builder.setPositiveButton("Yakin", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Nanti dulu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog build = builder.create();
        build.show();
    }
}
