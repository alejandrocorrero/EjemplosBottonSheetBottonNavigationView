package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Main;


import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Database;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.About.FragmentAbout;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Data.FragmentData;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Ui.Image.FragmentImage;
import com.example.usuario.ejemplosbottonsheetbottonnavigationview.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_FRAGMENT_IMAGE = "TAG_FRAGMENT_IMAGE";
    private static final String TAG_FRAGMENT_DATA = "TAG_FRAGMENT_DATA";
    private static final String TAG_FRAGMENT_ABOUT = "TAG_FRAGMENT_ABOUT";
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=Database.getInstance();
        initViews();
    }

    private void initViews() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    switch (item.getItemId()) {
                        case R.id.mnuFrgImage:
                            if (fragmentManager.findFragmentByTag(TAG_FRAGMENT_IMAGE) == null) {
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.frameLayout, FragmentImage.newInstance(database.getStudent()), TAG_FRAGMENT_IMAGE);
                                transaction.commit();
                            }
                            break;
                        case R.id.mnuFrgData:
                            if (fragmentManager.findFragmentByTag(TAG_FRAGMENT_DATA) == null) {
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.frameLayout, FragmentData.newInstance(database.getStudent()), TAG_FRAGMENT_DATA);
                                transaction.commit();
                            }
                            break;
                        case R.id.mnuFrgAbout:
                            if (fragmentManager.findFragmentByTag(TAG_FRAGMENT_ABOUT) == null) {
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.frameLayout, new FragmentAbout(), TAG_FRAGMENT_ABOUT);
                                transaction.commit();
                            }
                            break;
                    }
                    return true;
                });
       if(getSupportFragmentManager().findFragmentById(R.id.frameLayout)==null){
           bottomNavigationView.findViewById(R.id.mnuFrgImage).performClick();
       }
    }
}
