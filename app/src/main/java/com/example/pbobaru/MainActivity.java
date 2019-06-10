package com.example.pbobaru;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pbobaru.model.Nilai;
import com.example.pbobaru.model.Ortu;
import com.example.pbobaru.model.SPP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3;
    private DatabaseReference refOrtu;
    private Button buttonLogout;
    private TextView tvKid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        refOrtu = FirebaseDatabase.getInstance().getReference("ortu").child(id);

        ArrayList<Nilai> nilaiAnak = new ArrayList<>();
        nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));

        ArrayList<SPP> sppAnak = new ArrayList<>();
        sppAnak.add(new SPP(5000000, "Lunas"));
        sppAnak.add(new SPP(5000000, "Lunas"));
        sppAnak.add(new SPP(5000000, "Lunas"));
        sppAnak.add(new SPP(5000000, "Lunas"));

        Ortu ortu = new Ortu("Ridi", "08123456", "ridi@gmail.com", "Jogja", "febri", nilaiAnak, sppAnak);

        refOrtu.setValue(ortu);

        buttonLogout = findViewById(R.id.btnLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });

        tvKid = findViewById(R.id.tvNamaAnak);

        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendatadiri();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaktivitas();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpembayaranspp();
            }
        });

        getNamaAnak();
    }

    public void opendatadiri() {
        Intent intent = new Intent(this, datadiri.class);
        startActivity(intent);

    }

    public void openaktivitas() {
        Intent intent = new Intent(MainActivity.this, NilaiActivity.class);
        startActivity(intent);

    }

    public void openpembayaranspp() {
        Intent intent = new Intent(this, pembayaranspp.class);
        startActivity(intent);

    }

    public void getNamaAnak() {
        refOrtu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaAnak = dataSnapshot.child("namaAnak").getValue(String.class);

                tvKid.setText(namaAnak);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
