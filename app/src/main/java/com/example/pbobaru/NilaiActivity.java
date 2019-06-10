package com.example.pbobaru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class NilaiActivity extends AppCompatActivity implements View.OnClickListener {

    CardView sem1, sem2, sem3, sem4;
    Intent intent;
    String semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        sem1 = findViewById(R.id.cardSemester1);
        sem2 = findViewById(R.id.cardSemester2);
        sem3 = findViewById(R.id.cardSemester3);
        sem4 = findViewById(R.id.cardSemester4);

        sem1.setOnClickListener(this);
        sem2.setOnClickListener(this);
        sem3.setOnClickListener(this);
        sem4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.cardSemester1:
                semester = "0";
                intent = new Intent(this, NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester2:
                semester = "1";
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester3:
                semester = "2";
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester4:
                semester = "3";
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

        }
    }
}
