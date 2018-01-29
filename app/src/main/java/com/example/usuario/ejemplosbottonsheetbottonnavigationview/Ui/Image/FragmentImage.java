package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Image;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.squareup.picasso.Picasso;

public class FragmentImage extends Fragment {
    private static final String ARG_STUDENT = "ARG_STUDENT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        Button btnSee = view.findViewById(R.id.btnOptions);
        ImageView imageView = view.findViewById(R.id.ivStudent);

        Student student = getArguments().getParcelable(ARG_STUDENT);
        if (student != null) {
            Picasso.with(getContext()).load(student.getPhotoUrl()).into(imageView);
        }

        btnSee.setOnClickListener(view1 -> ImageActivity.start(getContext(), student));
        return view;
    }

    public static FragmentImage newInstance(Student student) {
        FragmentImage frg = new FragmentImage();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_STUDENT, student);
        frg.setArguments(arguments);
        return frg;
    }
//
}
