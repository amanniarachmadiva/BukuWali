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

import java.util.ArrayList;

/* Class MainActivity menampilkan menu utama (home) yang akan menampilkan pilihan submenu lain,
* seperti data diri siswa, daftar nilai siswa, dan status pembayaran spp */

/* Class MainActivity menerapkan konsep Inheritance, yaitu pewarisan dari class AppCompatActivity yang
merupakan bawaan dari Android Stuido. Hal ini ditunjukkan dengan keyword "extends". */

/* Class MainActivity menerapkan konsep Encapsulation dimana variabel-variabel yang terdapat di
class MainActivity bersifat private sehingga tidak bisa diakses dari class lain. */


public class MainActivity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3;
    private DatabaseReference refOrtu;
    private Button buttonLogout;
    private TextView tvKid;

    /* Method onCreate merupakan override dari class kosongan bawaan android yang kemudian
    dimodifikasi sesuai activity yang akan dilakukan program sesuai keinginan developer. Override
    yang dilakukan oleh method "onCreate" di bawah merupakan bentuk penerapan konsep Polymorphism. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Sintaks untuk mendapatkan id unser sesuai yang ada di database */
        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        /* Program mengakses data di database (firebase) sesuai id ortu / pengguna */
        refOrtu = FirebaseDatabase.getInstance().getReference("ortu").child(id);

        /* Sintaks di bawah digunakan untuk membuat template penambahan data nilai anak yang sudah
        dimodelkan di model "Nilai" ke firebase menggunakan data "dummy".
        Setelah program di-build dan di-run, model data di firebase akan ter-update.
        Kemudian, sintaks bisa dihapus atau di-comment karena pengubahan data dapat dilakukan
        secara langsung di firebase. */

        ArrayList<Nilai> nilaiAnak = new ArrayList<>();
        // nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        // nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        // nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));
        // nilaiAnak.add(new Nilai(100, 88, 70, 89, 98, 98, 89, 88));

        /* Sintaks di bawah digunakan untuk membuat template penambahan data pembayaran spp anak
        yang sudah dimodelkan di model "SPP". Sama seperti pemodelan nilai, template di bawah
        menggunakan data dummy. */

        ArrayList<SPP> sppAnak = new ArrayList<>();
        // sppAnak.add(new SPP(5000000, "Lunas"));
        // sppAnak.add(new SPP(5000000, "Lunas"));
        // sppAnak.add(new SPP(5000000, "Lunas"));
        // sppAnak.add(new SPP(5000000, "Lunas"));

        /* Sintaks di bawah adalah instantiation = proses pembuatan instance, dimana instantiation
        merupakan salah satu penerapan konsep Inheritance. Sintaks di bawah membuat object ortu dari
        class Ortu (model) yang berisikan atribut namaOrtu, noHp, email, alamat, namaAnak, nilaiAnak,
        dan sppAnak. Data yang digunakan pada sintaks di bawah adalah data dummy untuk ujicoba
        memasukkan data ke firebase pertama kali. */

        Ortu ortu = new Ortu("Ridi", "08123456", "ridi@gmail.com", "Jogja", "febri", nilaiAnak, sppAnak);

        /*Fungsi di bawah digunakan untuk menyimpan value ke firebase. Fungsi di bawah hanya dijalankan
        ketika developer ingin menentukan value pertama kali. Setelah itu, fungsi bisa dihapus / di-comment
        Hal tersebut dikarenakan setiap program dijalankan maka program akan set value ke default value dummy
        yang sudah di-set sebagaimana sintaks di atas. */

        // refOrtu.setValue(ortu);

        buttonLogout = findViewById(R.id.btnLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {

            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });

        /* Sintaks untuk menghubungkan dengan antarmuka (UI) */
        tvKid = findViewById(R.id.tvNamaAnak);
        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);

        cardView1.setOnClickListener(new View.OnClickListener() {
            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onClick(View v) {
                opendatadiri();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onClick(View v) {
                openaktivitas();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onClick(View v) {
                openpembayaranspp();
            }
        });

        getNamaAnak();
    }

    public void opendatadiri() {
        /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        Intent intent = new Intent(this, datadiri.class);
        startActivity(intent);

    }

    public void openaktivitas() {
        /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        Intent intent = new Intent(MainActivity.this, NilaiActivity.class);
        startActivity(intent);

    }

    public void openpembayaranspp() {
        /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        Intent intent = new Intent(this, pembayaranspp.class);
        startActivity(intent);

    }

    public void getNamaAnak() {
        /* Instantiation di bawah merupakan penerapan konsep Inheritance (ditandai dengan keyword : new) */
        refOrtu.addValueEventListener(new ValueEventListener() {

            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaAnak = dataSnapshot.child("namaAnak").getValue(String.class);

                tvKid.setText(namaAnak);
            }

            /* Override method di bawah merupakan penerapan konsep Polymorphism */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
