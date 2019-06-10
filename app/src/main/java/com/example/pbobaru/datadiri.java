package com.example.pbobaru;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pbobaru.model.Nilai;
import com.example.pbobaru.model.Ortu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class datadiri extends AppCompatActivity {

    private DatabaseReference refData;
    private TextView tvNamaSiswa,tvAlamat,tvNoHp, tvNamaOrtu, tvEmail, tvNamaTop;

    private static final String TAG = "datadiri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadiri);

        tvNamaTop = findViewById(R.id.tv_nama_top);
        tvNamaSiswa = findViewById(R.id.tv_nama_siswa);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvNoHp = findViewById(R.id.tv_noHp);
        tvNamaOrtu = findViewById(R.id.tv_nama_ortu);
        tvEmail = findViewById(R.id.tv_nama_email);

        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        refData = FirebaseDatabase.getInstance().getReference("ortu").child(id);

        refData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Ortu ortu = dataSnapshot.getValue(Ortu.class);
                assert ortu != null;
                tvNamaTop.setText(ortu.getNamaAnak());
                tvNamaSiswa.setText(": " + ortu.getNamaAnak());
                tvAlamat.setText(": " + ortu.getAlamat());
                tvEmail.setText(": " + ortu.getEmail());
                tvNamaOrtu.setText(": " + ortu.getNamaOrtu());
                tvNoHp.setText(": " + ortu.getNoHp());
                ArrayList<Nilai> nilaiAnak = new ArrayList<>();
                nilaiAnak = ortu.getNilaiSemester();
                for(Nilai nilai : nilaiAnak){
                    Log.d(TAG, "onDataChange: nilai: " + nilai.toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
