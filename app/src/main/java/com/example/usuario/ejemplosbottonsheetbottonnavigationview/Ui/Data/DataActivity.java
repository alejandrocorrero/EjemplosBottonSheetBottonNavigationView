package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Image.ImageActivity;

public class DataActivity extends AppCompatActivity {
    private static final String EXTRA_STUDENT = "EXTRA_STUDENT";
    private static final String TAG_BOTTOMSHEET_FRAGMENT = "TAG_BOTTOMSHEET_FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_options);
        initViews();
    }

    private void initViews() {
        Student student= getIntent().getParcelableExtra(EXTRA_STUDENT);
        Button options = findViewById(R.id.btnEdit);
        EditText edtName=findViewById(R.id.edtName);
        EditText edtPhone=findViewById(R.id.edtPhone);
        edtName.setText(student.getName());
        edtPhone.setText(student.getPhone());
        options.setOnClickListener(view -> showBottomSheetDialogFragment(student,edtName.getText().toString(),edtPhone.getText().toString()));
    }


    private void showBottomSheetDialogFragment(Student student, String name, String phone) {
        FragmentBottomSheet dialogFragment = FragmentBottomSheet.newInstance(
                student,name,phone);
        dialogFragment.show(getSupportFragmentManager(), TAG_BOTTOMSHEET_FRAGMENT);
    }
    public static void start(Context context, Student student) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        context.startActivity(intent);
    }
}
