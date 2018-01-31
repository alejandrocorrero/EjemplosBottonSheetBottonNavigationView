package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Database;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;

public class FragmentBottomSheet extends BottomSheetDialogFragment implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final String ARG_STUDENT = "ARG_STUDENT";
    private static final String ARG_NAME = "ARG_NAME";
    private static final String ARG_PHONE = "ARG_PHONE";
    private static final int SHEET_PEAK_HEIGHT = 650;

    private Student student;
    private NavigationView navigationView;
    private String name;
    private String phone;
    Database database;

    static FragmentBottomSheet newInstance(Student student, String name, String phone) {
        FragmentBottomSheet frg = new FragmentBottomSheet();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_STUDENT, student);
        arguments.putString(ARG_NAME, name);
        arguments.putString(ARG_PHONE, phone);
        frg.setArguments(arguments);
        return frg;
    }

    private final BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new
            BottomSheetBehavior.BottomSheetCallback() {

                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN
                            || newState == BottomSheetBehavior.STATE_SETTLING) {
                        dismiss();
                    }

                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                }

            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        database = Database.getInstance();
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        obtainArguments();
        initViews(getView());
    }

    private void initViews(View view) {
        navigationView = view.findViewById(R.id.navigationView);
        setupBottomSheet(view);
    }

    private void setupBottomSheet(View view) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view
                .getParent())
                .getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();
        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
            bottomSheetBehavior.setBottomSheetCallback(mBottomSheetBehaviorCallback);
            // To assure sheet is completely shown.
            bottomSheetBehavior.setPeekHeight(SHEET_PEAK_HEIGHT);//get the height dynamically
        }
        setupNavigationView();
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (student != null) {
            navigationView.getMenu().findItem(R.id.mnuTitle).setTitle(student.getName());
        }
    }

    private void obtainArguments() {
        if (getArguments() != null) {
            student = getArguments().getParcelable(ARG_STUDENT);
            name = getArguments().getString(ARG_NAME);
            phone = getArguments().getString(ARG_PHONE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuSave:
                save();
                dismiss();

                return true;
            case R.id.mnuDial:
                call();
                dismiss();
                return true;

        }
        return false;
    }

    private void call() {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + database.getStudent().getPhone().trim())));
    }

    private void save() {
        database.getStudent().setName(name);
        database.getStudent().setPhone(phone);
    }


}
