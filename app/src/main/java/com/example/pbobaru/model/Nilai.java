package com.example.pbobaru.model;

public class Nilai {
    private int BahasaIndonesia;
    private int Matematika;
    private int IPA;
    private int BahasaInggris;
    private int PKn;
    private int Mulok;
    private int Seni;
    private int Agama;

    public Nilai() {
    }

    public int getBahasaIndonesia() {
        return BahasaIndonesia;
    }

    public void setBahasaIndonesia(int bahasaIndonesia) {
        BahasaIndonesia = bahasaIndonesia;
    }

    public int getMatematika() {
        return Matematika;
    }

    public void setMatematika(int matematika) {
        Matematika = matematika;
    }

    public int getIPA() {
        return IPA;
    }

    public void setIPA(int IPA) {
        this.IPA = IPA;
    }

    public int getBahasaInggris() {
        return BahasaInggris;
    }

    public void setBahasaInggris(int bahasaInggris) {
        BahasaInggris = bahasaInggris;
    }

    public int getPKn() {
        return PKn;
    }

    public void setPKn(int PKn) {
        this.PKn = PKn;
    }

    public int getMulok() {
        return Mulok;
    }

    public void setMulok(int mulok) {
        Mulok = mulok;
    }

    public int getSeni() {
        return Seni;
    }

    public void setSeni(int seni) {
        Seni = seni;
    }

    public int getAgama() {
        return Agama;
    }

    public void setAgama(int agama) {
        Agama = agama;
    }

    @Override
    public String toString() {
        return "Nilai{" +
                "BahasaIndonesia=" + BahasaIndonesia +
                ", Matematika=" + Matematika +
                ", IPA=" + IPA +
                ", BahasaInggris=" + BahasaInggris +
                ", PKn=" + PKn +
                ", Mulok=" + Mulok +
                ", Seni=" + Seni +
                ", Agama=" + Agama +
                '}';
    }

    public Nilai(int bahasaIndonesia, int matematika, int IPA, int bahasaInggris, int PKn, int mulok, int seni, int agama) {
        BahasaIndonesia = bahasaIndonesia;
        Matematika = matematika;
        this.IPA = IPA;
        BahasaInggris = bahasaInggris;
        this.PKn = PKn;
        Mulok = mulok;
        Seni = seni;
        Agama = agama;
    }
}
