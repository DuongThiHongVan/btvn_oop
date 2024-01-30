package com.van.task;

import com.van.entity.Bao;
import com.van.entity.Sach;
import com.van.entity.TaiLieu;
import com.van.entity.TapChi;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

class QuanLiSach {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<TaiLieu> danhSachTaiLieu = new ArrayList<>();

    public static void main(String[] args) {
        boolean tiepTuc = true;
        while (tiepTuc) {
            hienThiMenu();
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống
            switch (luaChon) {
                case 1:
                    themMoiTaiLieu();
                    break;
                case 2:
                    xoaTaiLieu();
                    break;
                case 3:
                    hienThiTaiLieu();
                    break;
                case 4:
                    timKiemTheoLoai();
                    break;
                case 5:
                    thoat();
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 5.");
            }
        }
        scanner.close();
    }

    private static void hienThiMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Thêm mới tài liệu");
        System.out.println("2. Xoá tài liệu");
        System.out.println("3. Hiển thị thông tin tài liệu");
        System.out.println("4. Tìm kiếm tài liệu theo loại");
        System.out.println("5. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void themMoiTaiLieu() {
        System.out.println("Chọn loại tài liệu muốn thêm (1 - Sách, 2 - Tạp chí, 3 - Báo): ");
        int loaiTaiLieu = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        System.out.print("Nhập mã tài liệu: ");
        String maTaiLieu = scanner.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String tenNhaXuatBan = scanner.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int soBanPhatHanh = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (loaiTaiLieu) {
            case 1:
                System.out.print("Nhập tên tác giả: ");
                String tenTacGia = scanner.nextLine();
                System.out.print("Nhập số trang: ");
                int soTrang = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                danhSachTaiLieu.add(new Sach(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, tenTacGia, soTrang));
                System.out.println("Đã thêm sách mới.");
                break;
            case 2:
                System.out.print("Nhập số phát hành: ");
                int soPhatHanh = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                System.out.print("Nhập tháng phát hành: ");
                String thangPhatHanh = scanner.nextLine();
                danhSachTaiLieu.add(new TapChi(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh));
                System.out.println("Đã thêm tạp chí mới.");
                break;
            case 3:
                System.out.print("Nhập ngày phát hành: ");
                String ngayPhatHanh = scanner.nextLine();
                danhSachTaiLieu.add(new Bao(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, ngayPhatHanh));
                System.out.println("Đã thêm báo mới.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void xoaTaiLieu() {
        System.out.print("Nhập mã tài liệu cần xoá: ");
        String maTaiLieu = scanner.nextLine();
        boolean found = false;
        for (TaiLieu taiLieu : danhSachTaiLieu) {
            if (taiLieu.getMaTaiLieu().equals(maTaiLieu)) {
                danhSachTaiLieu.remove(taiLieu);
                System.out.println("Đã xoá tài liệu có mã " + maTaiLieu);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy tài liệu có mã " + maTaiLieu);
        }
    }


    private static void hienThiTaiLieu() {
        for (TaiLieu taiLieu : danhSachTaiLieu) {
            taiLieu.hienThiThongTin();
        }
    }

    private static void timKiemTheoLoai() {
        System.out.println("Chọn loại tài liệu muốn tìm kiếm (1 - Sách, 2 - Tạp chí, 3 - Báo): ");
        int loaiTaiLieu = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (loaiTaiLieu) {
            case 1:
                System.out.println("Danh sách các sách:");
                for (TaiLieu taiLieu : danhSachTaiLieu) {
                    if (taiLieu instanceof Sach) {
                        taiLieu.hienThiThongTin();
                    }
                }
                break;
            case 2:
                System.out.println("Danh sách các tạp chí:");
                for (TaiLieu taiLieu : danhSachTaiLieu) {
                    if (taiLieu instanceof TapChi) {
                        taiLieu.hienThiThongTin();
                    }
                }
                break;
            case 3:
                System.out.println("Danh sách các báo:");
                for (TaiLieu taiLieu : danhSachTaiLieu) {
                    if (taiLieu instanceof Bao) {
                        taiLieu.hienThiThongTin();
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void thoat() {
        System.out.println("Thoát khỏi chương trình.");
    }
}
