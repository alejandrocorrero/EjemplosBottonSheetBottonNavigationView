package com.example.usuario.ejemplosbottonsheetbottonnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment1Activity extends AppCompatActivity {
    private BottomSheetBehavior<RelativeLayout> bsb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);
        initviews();
    }

    private void initviews() {
        TextView txtNombre = findViewById(R.id.txtFrg1);
        txtNombre.setText("Prueba");
        RelativeLayout rlPanel = findViewById(R.id.rlPanel);
        bsb = BottomSheetBehavior.from(rlPanel);
        setupBottomSheet();
    }
    private void setupBottomSheet() {

        bsb.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //imgDetail.setImageResource(R.drawable.ic_arrow_drop_down_white_24dp);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //imgDetail.setImageResource(R.drawable.ic_arrow_drop_up_white_24dp);
                        break;
                    default:
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }
}
