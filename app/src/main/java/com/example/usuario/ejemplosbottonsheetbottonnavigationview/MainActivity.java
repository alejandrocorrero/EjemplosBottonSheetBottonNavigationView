package com.example.usuario.ejemplosbottonsheetbottonnavigationview;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_FRAGMENT1 = "TAG_FRAGMENT1";
    private static final String TAG_FRAGMENT2 = "TAG_FRAGMENT2";
    private static final String TAG_FRAGMENT3 = "TAG_FRAGMENT3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentManager gestorFragmentos = getSupportFragmentManager();
                        switch (item.getItemId()) {
                            case R.id.mnuFrg1:
                                if (gestorFragmentos.findFragmentByTag(TAG_FRAGMENT1) == null) {
                                    FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
                                    transaccion.replace(R.id.frameLayout, new Fragment1(), TAG_FRAGMENT1);
                                    transaccion.commit();
                                }
                                break;
                            case R.id.mnuFrg2:
                                if (gestorFragmentos.findFragmentByTag(TAG_FRAGMENT2) == null) {
                                    FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
                                    transaccion.replace(R.id.frameLayout, new Fragment2(), TAG_FRAGMENT2);
                                    transaccion.commit();
                                }
                                break;
                            case R.id.mnuFrg3:
                                if (gestorFragmentos.findFragmentByTag(TAG_FRAGMENT3) == null) {
                                    FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
                                    transaccion.replace(R.id.frameLayout, new Fragment3(), TAG_FRAGMENT3);
                                    transaccion.commit();
                                }
                                break;
                        }
                        return true;
                    }
                });
        bottomNavigationView.findViewById(R.id.mnuFrg1).performClick();
    }
}
