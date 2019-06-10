package com.example.pbobaru.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
