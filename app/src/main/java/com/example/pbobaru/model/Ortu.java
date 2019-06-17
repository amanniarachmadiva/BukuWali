package com.example.pbobaru.model;

/* Model database Ortu (firebase), berisi data-data siswa dan orang tua siswa yang ditampilkan di
submenu data diri siswa */

/* model ini menggunakan ArrayList karena class Ortu merupakan parent dari class Nilai dan SPP,
sehingga di setiap akun pengguna (dimodelkan dalam "Ortu") terdapat database nilai (dimodelkan
dalam "Nilai") dan database laporan pembayaran SPP (dimodelkan dalam "SPP") sesuai data masing-
masing siswa. */

import java.util.ArrayList;

/* Class Ortu menerapkan konsep Encapsulation dimana variabel-variabel yang terdapat di dalam
class Ortu bersifat private. Meskipun bersifat private, dibuat method set & get yang bersifat
public untuk masing-masing variabel untuk mendapatkan value dari masing-masing variabel. Method-
method tersebut bersifat public sehingga bisa diakses oleh class lain.*/

public class Ortu {
    private String namaOrtu;
    private String noHp;
    private String email;
    private String alamat;
    private String namaAnak;
    private ArrayList<Nilai> nilaiSemester;
    private ArrayList<SPP> sppSemester;

    public Ortu() {
    }

    public ArrayList<SPP> getSppSemester() {
        return sppSemester;
    }

    public String getNamaOrtu() {
        return namaOrtu;
    }

    public void setNamaOrtu(String namaOrtu) {
        this.namaOrtu = namaOrtu;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public ArrayList<Nilai> getNilaiSemester() {
        return nilaiSemester;
    }

    public void setNilaiSemester(ArrayList<Nilai> nilaiSemester) {
        this.nilaiSemester = nilaiSemester;
    }

    public Ortu(String namaOrtu, String noHp, String email, String alamat, String namaAnak, ArrayList<Nilai> nilaiSemester, ArrayList<SPP> sppSemester) {
        this.namaOrtu = namaOrtu;
        this.noHp = noHp;
        this.email = email;
        this.alamat = alamat;
        this.namaAnak = namaAnak;
        this.nilaiSemester = nilaiSemester;
        this.sppSemester = sppSemester;
    }
}
