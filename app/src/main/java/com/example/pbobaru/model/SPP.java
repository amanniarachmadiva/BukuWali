package com.example.pbobaru.model;

public class SPP {
    private long biaya;
    private String status;

    public SPP(){

    }

    public SPP(long biaya, String status) {
        this.biaya = biaya;
        this.status = status;
    }

    public long getBiaya() {
        return biaya;
    }

    public String getStatus() {
        return status;
    }
}
