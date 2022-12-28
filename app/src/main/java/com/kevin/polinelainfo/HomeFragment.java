package com.kevin.polinelainfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    CardView cvPangan, cvKebun, cvTektan, cvTernak, cvEkbis;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        cvPangan = v.findViewById(R.id.cvPangan);
        cvPangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), JurusanPangan.class);
                startActivity(a);
            }
        });

        cvKebun = v.findViewById(R.id.cvKebun);
        cvKebun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getActivity(), JurusanKebun.class);
                startActivity(b);
            }
        });

        cvTektan = v.findViewById(R.id.cvTektan);
        cvTektan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getActivity(), JurusanTektan.class);
                startActivity(c);
            }
        });

        cvTernak = v.findViewById(R.id.cvTernak);
        cvTernak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(getActivity(), JurusanPeternakan.class);
                startActivity(d);
            }
        });

        cvEkbis = v.findViewById(R.id.cvEkbis);
        cvEkbis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(getActivity(), JurusanEkbis.class);
                startActivity(e);
            }
        });

        return v;
    }
}