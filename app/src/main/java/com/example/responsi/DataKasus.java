package com.example.responsi;


public class DataKasus {
    private String tanggal;
    private String CONFIRMATION;
    private String confirmation_meninggal;
    private String confirmation_selesai;

    public DataKasus() {
        this.tanggal = tanggal;
        this.CONFIRMATION = CONFIRMATION;
        this.confirmation_meninggal = confirmation_meninggal;
        this.confirmation_selesai = confirmation_selesai;
    }



    @Override
    public String toString() {
        return "DataKasus{" +
                "tanggal='" + tanggal + '\'' +
                ", CONFIRMATION='" + CONFIRMATION + '\'' +
                ", confirmation_meninggal='" + confirmation_meninggal + '\'' +
                ", confirmation_selesai='" + confirmation_selesai + '\'' +
                '}';
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getCONFIRMATION() {
        return CONFIRMATION;
    }

    public void setCONFIRMATION(int CONFIRMATION) {
        this.CONFIRMATION = String.valueOf(CONFIRMATION);
    }

    public String getConfirmation_meninggal() {
        return confirmation_meninggal;
    }

    public void setConfirmation_meninggal(int confirmation_meninggal) {
        this.confirmation_meninggal = String.valueOf(confirmation_meninggal);
    }

    public String getConfirmation_selesai() {
        return confirmation_selesai;
    }

    public void setConfirmation_selesai(int confirmation_selesai) {
        this.confirmation_selesai = String.valueOf(confirmation_selesai);
    }


}
