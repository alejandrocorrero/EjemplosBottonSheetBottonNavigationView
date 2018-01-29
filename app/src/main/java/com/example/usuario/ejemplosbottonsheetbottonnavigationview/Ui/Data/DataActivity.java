package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;

public class DataActivity extends AppCompatActivity {

    private Student student;
    private static final String TAG_BOTTOMSHEET_FRAGMENT = "TAG_BOTTOMSHEET_FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_options);
        student= new Student("alex","casa","casa");
        initViews();
    }

    private void initViews() {
        Button options = findViewById(R.id.btnEdit);
        options.setOnClickListener(view -> showBottomSheetDialogFragment(student));
    }


    private void showBottomSheetDialogFragment(Student student) {
        FragmentBottomSheet dialogFragment = FragmentBottomSheet.newInstance(
                student);
        dialogFragment.show(getSupportFragmentManager(), TAG_BOTTOMSHEET_FRAGMENT);
    }
}
