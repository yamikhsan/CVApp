package com.studio.yami.cvapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studio.yami.cvapp.MyHelper;
import com.studio.yami.cvapp.R;

public class PengalamanFragment extends Fragment {


    LinearLayout mainLayout;
    TextView back;

    MyHelper helper;

    public static PengalamanFragment newInstance(){
        return new PengalamanFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fr_pengalaman, container, false);

        mainLayout = (LinearLayout) v.findViewById(R.id.lt_fr_pengalaman);
        back = (TextView) v.findViewById(R.id.bt_pengalaman_back);

        helper = new MyHelper();
        helper.showAnim(mainLayout, 1000);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment fragment = HomeFragment.newInstance();
                helper.moveFragment(getActivity(), 900, fragment);
                helper.hideAnim(mainLayout, 1000);
            }
        });

        return v;
    }

}
