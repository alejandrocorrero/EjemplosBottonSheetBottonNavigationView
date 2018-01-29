package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;
import com.squareup.picasso.Picasso;

public class FragmentImage extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        Student student = new Student("Baldomero","66666666","https://qzprod.files.wordpress.com/2018/01/falon-heavy-elon-musk-spacex-rocket-static-fire-spacex.jpg?quality=80&strip=all&w=2400");
        Button btnSee=view.findViewById(R.id.btnOptions);
        ImageView imageView = view.findViewById(R.id.ivStudent);
        Picasso.with(getContext()).load(student.getPhotoUrl()).into(imageView);
        btnSee.setOnClickListener(view1 -> startActivity(new Intent(getContext(),ImageActivity.class)));
        return view;
    }


}
