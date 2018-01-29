package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data.DataActivity;

public class FragmentData extends Fragment {

    public FragmentData() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        Button btnOptions=view.findViewById(R.id.btnOptions);
        btnOptions.setOnClickListener(view1 -> startActivity(new Intent(getContext(),DataActivity.class)));
        TextView txtFrg=view.findViewById(R.id.txtFrg);
        return view;
    }

}
