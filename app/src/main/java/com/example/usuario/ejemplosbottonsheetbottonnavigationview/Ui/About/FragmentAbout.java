package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.About;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;


public class FragmentAbout extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView txtFrg=view.findViewById(R.id.txtName);
        return view;
    }

}
