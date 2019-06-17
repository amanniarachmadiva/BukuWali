package com.example.pbobaru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/* Class NilaiActivity berfungsi untuk menampilkan menu dimana pengguna bisa memilih untuk melihat
daftar nilai siswa di semester tertentu. */

/* Class NilaiActivity menerapkan konsep Inheritance, yaitu pewarisan dari class AppCompatActivity yang
merupakan bawaan dari Android Stuido. Hal ini ditunjukkan dengan keyword "extends". */

/* Class NilaiActivity juga menerapkan konsep Inheritance dan Polymorphism dengan mengimplementasikan
interface dari View.OnClickListener, sebuah method bawaan Android Studio yang kemudian dimodifikasi
sesuai kebutuhan oleh developer. */

/* Adanya interface yang disediakan oleh Android Studio merupakan salah satu penerapan konsep
Abstraction. */

public class NilaiActivity extends AppCompatActivity implements View.OnClickListener {

    CardView sem1, sem2, sem3, sem4;
    Intent intent;
    String semester;

    /* Method onCreate di bawah merupakan penerapan konsep Polymorphism */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        /* Sintaks untuk menghubungkan dengan antarmuka (UI) */
        sem1 = findViewById(R.id.cardSemester1);
        sem2 = findViewById(R.id.cardSemester2);
        sem3 = findViewById(R.id.cardSemester3);
        sem4 = findViewById(R.id.cardSemester4);

        sem1.setOnClickListener(this);
        sem2.setOnClickListener(this);
        sem3.setOnClickListener(this);
        sem4.setOnClickListener(this);
    }

    /* Method onCreate di bawah merupakan penerapan konsep Polymorphism */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.cardSemester1:
                semester = "0";
                /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan
                keyword : new) */
                intent = new Intent(this, NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester2:
                semester = "1";
                /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan
                keyword : new) */
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester3:
                semester = "2";
                /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan
                keyword : new) */
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

            case R.id.cardSemester4:
                semester = "3";
                /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan
                keyword : new) */
                intent = new Intent(this,  NilaiSemester.class);
                intent.putExtra("EXTRA_SEMESTER", semester);
                startActivity(intent);
                break;

        }
    }
}
