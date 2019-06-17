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

/* Class datadiri berisikan fitur yang terdapat pada submenu "Data Diri Siswa" */

/* Class datadiri menerapkan konsep Inheritance, yaitu pewarisan dari class AppCompatActivity yang
merupakan bawaan dari Android Stuido. Hal ini ditunjukkan dengan keyword "extends". */

/* Class datadiri juga menerapkan konsep Encapsulation dimana variabel-variabel yang terdapat di
class datadiri bersifat private. */

public class datadiri extends AppCompatActivity {

    private DatabaseReference refData;
    private TextView tvNamaSiswa,tvAlamat,tvNoHp, tvNamaOrtu, tvEmail, tvNamaTop;

    /* Override method di bawah merupakan penerapan konsep Polymorphism */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadiri);

        /* Sintaks untuk menghubungkan dengan antarmuka (UI) */
        tvNamaTop = findViewById(R.id.tv_nama_top);
        tvNamaSiswa = findViewById(R.id.tv_nama_siswa);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvNoHp = findViewById(R.id.tv_noHp);
        tvNamaOrtu = findViewById(R.id.tv_nama_ortu);
        tvEmail = findViewById(R.id.tv_nama_email);

        /* Sintaks untuk mendapatkan id unser sesuai yang ada di database */
        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        /* Program mengakses data di database (firebase) sesuai id ortu / pengguna */
        refData = FirebaseDatabase.getInstance().getReference("ortu").child(id);

        /* Method di bawah merupakan method untuk mendapatkan data / value dari database.
        * Method ini menggunakan proses Instantiation.
        * Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        refData.addValueEventListener(new ValueEventListener() {

            /* Override method di bawah merupakan penerapan konsep Polymorphism */
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

            }

            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
