package com.homejek.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        ImageButton droite = (ImageButton) findViewById(R.id.imageButton);
        ImageButton gauche = (ImageButton) findViewById(R.id.muscleBtn);

        gauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2Activity.this, Page1Activity.class);
                startActivity(intent);
            }
        });

        droite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2Activity.this, Page3Activity.class);
                startActivity(intent);
            }
        });
    }
}
