package com.van.entity;

public class TaiLieu {
    /**
     * 1. thuoc tinh
     * 2. geter/ seter
     * 3. ham khoi tao
     * 4 phuong thuc
     */

        protected String maTaiLieu;
        protected String tenNhaXuatBan;
        protected int soBanPhatHanh;

        public TaiLieu(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh) {
            this.maTaiLieu = maTaiLieu;
            this.tenNhaXuatBan = tenNhaXuatBan;
            this.soBanPhatHanh = soBanPhatHanh;
        }

        public void hienThiThongTin() {
            System.out.println("Mã tài liệu: " + maTaiLieu);
            System.out.println("Tên nhà xuất bản: " + tenNhaXuatBan);
            System.out.println("Số bản phát hành: " + soBanPhatHanh);
        }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    @Override
    public String toString() {
        return "TaiLieu{" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNhaXuatBan + '\'' +
                ", soBanPhatHanh='" + soBanPhatHanh + '\'' +
                '}';
    }
}
