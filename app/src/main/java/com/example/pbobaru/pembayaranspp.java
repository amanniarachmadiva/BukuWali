package com.example.pbobaru;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/* Class pembayaranspp berfungsi untuk menampilkan status pelunasan spp siswa */

/* Class pembayaranspp menerapkan konsep Inheritance, yaitu pewarisan dari class AppCompatActivity yang
merupakan bawaan dari Android Stuido. Hal ini ditunjukkan dengan keyword "extends". */

public class pembayaranspp extends AppCompatActivity
{
    TextView semester1, semester2, semester3, semester4, status1, status2, status3, status4;
    DatabaseReference db;

    /* Override method di bawah merupakan penerapan konsep Polymorphism */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaranspp);

        /* Sintaks untuk menghubungkan dengan antarmuka (UI) */
        semester1 = findViewById(R.id.semester1);
        semester2 = findViewById(R.id.semester2);
        semester3 = findViewById(R.id.semester3);
        semester4 = findViewById(R.id.semester4);
        status1 = findViewById(R.id.statussm1);
        status2 = findViewById(R.id.statussm2);
        status3 = findViewById(R.id.statussm3);
        status4 = findViewById(R.id.statussm4);

        /* Sintaks untuk mendapatkan id unser sesuai yang ada di database */
        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        /* Program mengakses data di database (firebase) sesuai id ortu / pengguna */
        db = FirebaseDatabase.getInstance().getReference("ortu")
                .child(id)
                .child("sppSemester");

         /* Method di bawah digunakan untuk mendapatkan data dari firebase menggunakan instantiation.
         Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan
         keyword : new) */
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                semester1.setText("Rp " + String.valueOf(dataSnapshot.child("0").child("biaya").getValue(Long.class)));
                status1.setText(dataSnapshot.child("0").child("status").getValue(String.class));
                semester2.setText("Rp " + String.valueOf(dataSnapshot.child("1").child("biaya").getValue(Long.class)));
                status2.setText(dataSnapshot.child("1").child("status").getValue(String.class));
                semester3.setText("Rp " + String.valueOf(dataSnapshot.child("2").child("biaya").getValue(Long.class)));
                status3.setText(dataSnapshot.child("2").child("status").getValue(String.class));
                semester4.setText("Rp " + String.valueOf(dataSnapshot.child("3").child("biaya").getValue(Long.class)));
                status4.setText(dataSnapshot.child("3").child("status").getValue(String.class));
            }

            // bila error terjadi
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
