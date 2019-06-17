package com.example.pbobaru.model;

/* Model database SPP (firebase), berfungsi untuk mengisi laporan pembayaran spp yang ada di aplikasi */

/* Class SPP menerapkan konsep Encapsulation dimana variabel-variabel yang terdapat di dalam
class SPP bersifat private. */
public class SPP {
    private long biaya;
    private String status;

    public SPP()
    {
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
