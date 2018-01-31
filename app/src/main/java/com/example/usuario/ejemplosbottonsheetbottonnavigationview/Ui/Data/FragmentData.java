package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Database;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentData extends Fragment {

    private static final String ARG_STUDENT = "ARG_STUDENT";
    Database database;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtPhone)
    TextView txtPhone;
    @BindView(R.id.btnOptions)
    Button btnOptions;
    Student student;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        ButterKnife.bind(this, view);
        database = Database.getInstance();
        btnOptions.setOnClickListener(view1 -> DataActivity.start(getContext(), student));
        return view;
    }

    public static FragmentData newInstance(Student student) {
        FragmentData frg = new FragmentData();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_STUDENT, student);
        frg.setArguments(arguments);
        return frg;
    }

    @Override
    public void onResume() {
        student = database.getStudent();
        txtName.setText(student.getName());
        txtPhone.setText(student.getPhone());
        super.onResume();
    }
}
