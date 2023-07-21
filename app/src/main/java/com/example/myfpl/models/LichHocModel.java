package com.example.myfpl.models;

public class LichHocModel {
    private String MonHoc, Ngay, Ca, Phong;

    public LichHocModel(String monHoc, String ngay, String ca, String phong) {
        MonHoc = monHoc;
        Ngay = ngay;
        Ca = ca;
        Phong = phong;
    }

    public String getMonHoc() {
        return MonHoc;
    }

    public void setMonHoc(String monHoc) {
        MonHoc = monHoc;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getCa() {
        return Ca;
    }

    public void setCa(String ca) {
        Ca = ca;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }
}
