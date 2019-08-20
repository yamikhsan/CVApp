package com.studio.yami.cvapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

public class MyHelper {

    public void moveFragment(final FragmentActivity context, final long time, final Fragment fragment){

        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fr_container, fragment).commit();
                }

            }
        };

        timer.start();

    }

    public void showAnim(LinearLayout layout, long durasi){
        Animation anim = new TranslateAnimation(0,0,1000,0);
        anim.setDuration(durasi);
        layout.startAnimation(anim);
    }

    public void hideAnim(LinearLayout layout, long durasi){
        Animation anim = new TranslateAnimation(0,0,0,1000);
        anim.setDuration(durasi);
        layout.startAnimation(anim);
    }

}
