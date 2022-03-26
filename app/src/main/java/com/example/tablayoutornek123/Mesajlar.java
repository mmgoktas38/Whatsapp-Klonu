package com.example.tablayoutornek123;

public class Mesajlar {
    private int mesajId;
    private String mesajResim;
    private String mesajGonderen;
    private String mesajMesaj;
    private String mesajTarih;

    public Mesajlar() {
    }

    public Mesajlar(int mesajId, String mesajResim, String mesajGonderen, String mesajMesaj, String mesajTarih) {
        this.mesajId = mesajId;
        this.mesajResim = mesajResim;
        this.mesajGonderen = mesajGonderen;
        this.mesajMesaj = mesajMesaj;
        this.mesajTarih = mesajTarih;
    }

    public int getMesajId() {
        return mesajId;
    }

    public void setMesajId(int mesajId) {
        this.mesajId = mesajId;
    }

    public String getMesajResim() {
        return mesajResim;
    }

    public void setMesajResim(String mesajResim) {
        this.mesajResim = mesajResim;
    }

    public String getMesajGonderen() {
        return mesajGonderen;
    }

    public void setMesajGonderen(String mesajGonderen) {
        this.mesajGonderen = mesajGonderen;
    }

    public String getMesajMesaj() {
        return mesajMesaj;
    }

    public void setMesajMesaj(String mesajMesaj) {
        this.mesajMesaj = mesajMesaj;
    }

    public String getMesajTarih() {
        return mesajTarih;
    }

    public void setMesajTarih(String mesajTarih) {
        this.mesajTarih = mesajTarih;
    }
}
