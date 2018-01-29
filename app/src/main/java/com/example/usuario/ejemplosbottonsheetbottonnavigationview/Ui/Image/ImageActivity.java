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

public class ImageActivity extends AppCompatActivity {
     private BottomSheetBehavior bsb;
    private static final String EXTRA_STUDENT = "EXTRA_STUDENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        initviews();
    }

    private void initviews() {
        Student student=getIntent().getParcelableExtra(EXTRA_STUDENT);ImageView imageView = findViewById(R.id.ivContent);
        Picasso.with(this).load(student.getPhotoUrl()).into(imageView);
        RelativeLayout rlPanel = findViewById(R.id.rlPanel);
        bsb = BottomSheetBehavior.from(rlPanel);
        setupBottomSheet(student);

    }

    private void setupBottomSheet(Student student) {
        TextView lblName= findViewById(R.id.lblName);
        TextView lblPhone= findViewById(R.id.lblPhone);
        TextView lblUrl= findViewById(R.id.lblUrl);
        lblName.setText(student.getName());
        lblPhone.setText(student.getPhone());
        lblUrl.setText(student.getPhotoUrl());
        bsb.setState(BottomSheetBehavior.STATE_EXPANDED);
        bsb.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:

                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                    case BottomSheetBehavior.STATE_HIDDEN:

                        break;
                    default:
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }

    public static void start(Context context, Student student) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        context.startActivity(intent);
    }
}
