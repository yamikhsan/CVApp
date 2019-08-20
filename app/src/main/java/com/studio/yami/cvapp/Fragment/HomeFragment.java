package com.studio.yami.cvapp.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.studio.yami.cvapp.MyHelper;
import com.studio.yami.cvapp.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    LinearLayout mainLayout, btDatadiri, btPendidikan, btPengalaman, btSkill, btHobi,
            btEmail, btPhone, btMap;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    MyHelper helper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_home, container, false);

        mainLayout = (LinearLayout) v.findViewById(R.id.lt_fr_home);
        btDatadiri = (LinearLayout) v.findViewById(R.id.bt_datadiri);
        btPendidikan = (LinearLayout) v.findViewById(R.id.bt_pendidikan);
        btPengalaman = (LinearLayout) v.findViewById(R.id.bt_pengalaman);
        btSkill = (LinearLayout) v.findViewById(R.id.bt_skill);
        btHobi = (LinearLayout) v.findViewById(R.id.bt_hobi);

        btEmail = (LinearLayout) v.findViewById(R.id.btn_email);
        btPhone = (LinearLayout) v.findViewById(R.id.btn_phone);
        btMap = (LinearLayout) v.findViewById(R.id.btn_map);

        btDatadiri.setOnClickListener(this);
        btPendidikan.setOnClickListener(this);
        btPengalaman.setOnClickListener(this);
        btSkill.setOnClickListener(this);
        btHobi.setOnClickListener(this);

        btEmail.setOnClickListener(this);
        btPhone.setOnClickListener(this);
        btMap.setOnClickListener(this);

        helper = new MyHelper();
        helper.showAnim(mainLayout,1000);

        return v;
    }

    private void onEmail(){
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:yahyamaulana450@gmail.com"));
        if (email.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(email);
        } else {
            handleToast("Tidak ada bisa menangani intent ini");
        }

    }

    private void onPhone(){
        Intent phone = new Intent(Intent.ACTION_DIAL);
        phone.setData(Uri.parse("tel:0895610754586"));
        if (phone.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(phone);
        } else {
            handleToast("Tidak ada bisa menangani intent ini");
        }
    }

    private void onSms(){
        Intent sms = new Intent(Intent.ACTION_VIEW);
        sms.setData(Uri.parse("sms:0895610754586"));
        if (sms.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(sms);
        } else {
            handleToast("Tidak ada bisa menangani intent ini");
        }
    }

    private void onWhatsApp(){
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        whatsapp.setData(Uri.parse("https://api.whatsapp.com/send?phone=62895610754586"));
        if (whatsapp.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(whatsapp);
        } else {
            handleToast("Anda Belum install WhatsApp");
        }
    }

    private void onMap(){
        Intent map = new Intent(Intent.ACTION_VIEW);
        map.setData(Uri.parse("geo:0,0?q=Pinang Tangerang"));
        if (map.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(map);
        } else {
            handleToast("Tidak ada bisa menangani intent ini");
        }
    }

    private void onDialog(){
        String[] nomor = {"Telpon", "Sms", "WhatsApp"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Hubungi Menggunakan")
                .setItems(nomor, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                onPhone();
                                break;
                            case 1:
                                onSms();
                                break;
                            case 2:
                                onWhatsApp();
                                break;
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void handleToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_email:
                onEmail();
                break;
            case R.id.btn_phone:
                onDialog();
                break;
            case R.id.btn_map:
                onMap();
                break;
            case R.id.bt_datadiri:
                DatadiriFragment datadiri = DatadiriFragment.newInstance();
                onAction(datadiri);
                break;
            case R.id.bt_pendidikan:
                PendidikanFragment pendidikan = PendidikanFragment.newInstance();
                onAction(pendidikan);
                break;
            case R.id.bt_pengalaman:
                PengalamanFragment pengalaman = PengalamanFragment.newInstance();
                onAction(pengalaman);
                break;
            case R.id.bt_skill:
                SkillFragment skill = SkillFragment.newInstance();
                onAction(skill);
                break;
            case R.id.bt_hobi:
                HobiFragment hobi = HobiFragment.newInstance();
                onAction(hobi);
                break;
        }
    }

    private void onAction(Fragment fragment){
        helper.moveFragment(getActivity(), 900, fragment);
        helper.hideAnim(mainLayout,1000);
    }

}
