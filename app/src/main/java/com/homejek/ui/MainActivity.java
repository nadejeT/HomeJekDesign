package com.homejek.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_accueil:
                    getSupportFragmentManager().beginTransaction().addToBackStack("fragment").replace(R.id.container, new fragments.Home()).commit();
                   item.setChecked(true);
                   Log.d("Erreur","Loading Home");
                    Log.i("Fragment","Profile");
                   // return true;
                case R.id.navigation_achat:
                    //mTextMessage.setText(R.string.title_achat);
                    return true;
                case R.id.navigation_about:
                   // mTextMessage.setText(R.string.title_about);
                    return true;
                case R.id.navigation_profile:
                    getSupportFragmentManager().beginTransaction().addToBackStack("fragment").replace(R.id.container, new fragments.Profile()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_accueil); // change to whichever id should be default
            navigation.getMenu().findItem(R.id.navigation_accueil).setChecked(true);
        }
    }

}
