package com.studio.yami.cvapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Splash extends Fragment {


    public Splash() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.splash, container, false);

        TextView splash = (TextView) v.findViewById(R.id.tv_splash);

        Animation anim = new AlphaAnimation(1,0);
        anim.setDuration(1200);
        anim.setStartOffset(1900);
        splash.startAnimation(anim);

        return v;
    }

}
