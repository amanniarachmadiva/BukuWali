package com.example.pbobaru;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class NilaiSemester extends AppCompatActivity {

    DatabaseReference db;
    TextView agama, bindo, bing, ipa, mat, mulok, pkn, seni, title, ratarata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai_semester);

        title = findViewById(R.id.tvTitle);
        agama = findViewById(R.id.tvNilaiAgama);
        bindo = findViewById(R.id.tvNilaiBindo);
        bing = findViewById(R.id.tvNilaiBinggris);
        ipa = findViewById(R.id.tvNilaiIpa);
        mat = findViewById(R.id.tvNilaiMate);
        mulok = findViewById(R.id.tvNilaiMulok);
        pkn = findViewById(R.id.tvNilaiPkn);
        seni = findViewById(R.id.tvNilaiSeni);
        ratarata = findViewById(R.id.tv_ratarata);

        Intent intent = getIntent();

        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        title.setText("Nilai Semester " + (Integer.valueOf(intent.getStringExtra("EXTRA_SEMESTER")) + 1));

        db = FirebaseDatabase.getInstance().getReference("ortu")
                .child(id)
                .child("nilaiSemester")
                .child(intent.getStringExtra("EXTRA_SEMESTER"));

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                agama.setText(String.valueOf(dataSnapshot.child("agama").getValue(Long.class)));
                bindo.setText(String.valueOf(dataSnapshot.child("bahasaIndonesia").getValue(Long.class)));
                bing.setText(String.valueOf(dataSnapshot.child("bahasaInggris").getValue(Long.class)));
                ipa.setText(String.valueOf(dataSnapshot.child("ipa").getValue(Long.class)));
                mat.setText(String.valueOf(dataSnapshot.child("matematika").getValue(Long.class)));
                mulok.setText(String.valueOf(dataSnapshot.child("mulok").getValue(Long.class)));
                pkn.setText(String.valueOf(dataSnapshot.child("pkn").getValue(Long.class)));
                seni.setText(String.valueOf(dataSnapshot.child("seni").getValue(Long.class)));

                ratarata.setText(String.valueOf(findRataRata()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private int findRataRata(){
        int agamaInt = Integer.parseInt(agama.getText().toString());
        int bindoInt = Integer.parseInt(bindo.getText().toString());
        int bingInt = Integer.parseInt(bing.getText().toString());
        int ipaInt = Integer.parseInt(ipa.getText().toString());
        int matInt = Integer.parseInt(mat.getText().toString());
        int mulokInt = Integer.parseInt(mulok.getText().toString());
        int pknInt = Integer.parseInt(pkn.getText().toString());
        int seniInt = Integer.parseInt(seni.getText().toString());

        int ratarataInt = (agamaInt+bindoInt+bingInt+ipaInt+matInt+mulokInt+pknInt+seniInt)/8;
        return ratarataInt;
    }
}
