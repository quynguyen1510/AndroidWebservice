package com.example.quynguyen.webservicejson;

public class SinhVien {
    private int idSinhVien;
    private String hoTen;
    private String namSinh;
    private String queQuan;

    public SinhVien(int idSinhVien, String hoTen, String namSinh, String queQuan) {
        this.idSinhVien = idSinhVien;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }

    public int getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
}
