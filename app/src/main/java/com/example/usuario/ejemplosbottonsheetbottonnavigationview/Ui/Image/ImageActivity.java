package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Image;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {
    @BindView(R.id.rlPanel)
    RelativeLayout rlPanel;
    @BindView(R.id.lblName)
    TextView lblName;
    @BindView(R.id.lblPhone)
    TextView lblPhone;
    @BindView(R.id.lblUrl)
    TextView lblUrl;
    private BottomSheetBehavior bsb;
    private static final String EXTRA_STUDENT = "EXTRA_STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        initviews();
    }

    private void initviews() {
        Student student = getIntent().getParcelableExtra(EXTRA_STUDENT);
        ImageView imageView = findViewById(R.id.ivContent);
        Picasso.with(this).load(student.getPhotoUrl()).into(imageView);
        ButterKnife.bind(this);
        bsb = BottomSheetBehavior.from(rlPanel);
        setupBottomSheet(student);

    }

    private void setupBottomSheet(Student student) {
        lblName.setText(student.getName());
        lblPhone.setText(student.getPhone());
        lblUrl.setText(student.getPhotoUrl());
        bsb.setState(BottomSheetBehavior.STATE_EXPANDED);

    }

    public static void start(Context context, Student student) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        context.startActivity(intent);
    }
}
