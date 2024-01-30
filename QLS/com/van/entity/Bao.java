package com.van.entity;

public class Bao extends TaiLieu{
    private String ngayPhatHanh;

    public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ngày phát hành: " + ngayPhatHanh);
    }
    public String toString(){
        return"Bao" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNhaXuatBan+ '\'' +
                ", soBanPhatHanh='" + soBanPhatHanh + '\'' +
                ", ngayPhatHanh= '" + ngayPhatHanh + '\'' +
                '}';
    }
}
