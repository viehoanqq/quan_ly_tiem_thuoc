package HOADON;

import java.util.Scanner;
import java.time.LocalDate;
import THUOC.DANHSACHTHUOC;
import PhieuKham.DANHSACHPHIEUKHAMBENH;
import NHANVIEN.DANHSACHNHANVIEN;
import BacSi.BacSi;
import BacSi.DSBS;
import BENHNHAN.BenhNhan;
import BENHNHAN.DSBN;
import DONTHUOC.DANHSACHDONTHUOC;
public class HOADON {

    private String maHoaDon;
    private String maDonThuoc;
    private String maPhieuKhamBenh;
    private double tongTien;
    private LocalDate ngayTao;
    private String hinhThucThanhToan;
    private String NVThuNgan;

    private DANHSACHDONTHUOC donThuoc;
    private DANHSACHPHIEUKHAMBENH phieuKhamBenh;
    private DANHSACHNHANVIEN dsnv;
    private DSBN dsbn;
    private DSBS dsbs;

    // Getter methods
    public String getThongTin() {
        String s = maHoaDon + "," + maDonThuoc + "," + maPhieuKhamBenh + "," + NVThuNgan + "," + ngayTao + ","
                + hinhThucThanhToan + "," + tongTien;
        return s;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaDonThuoc() {
        return maDonThuoc;
    }

    public String getMaPhieuKhamBenh() {
        return maPhieuKhamBenh;
    }

    public double getTongTien() {
        return tongTien;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public String getNVThuNgan() {
        return NVThuNgan;
    }

    // Setter methods
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaDonThuoc(String maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public void setMaPhieuKhamBenh(String maPhieuKhamBenh) {
        this.maPhieuKhamBenh = maPhieuKhamBenh;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public void setNVThuNgan(String NVThuNgan) {
        this.NVThuNgan = NVThuNgan;
    }

    // 3 ham khoi tao
    public HOADON() {
        maHoaDon = null;
        maDonThuoc = null;
        maPhieuKhamBenh = null;
        tongTien = 0.0;
        ngayTao = null;
        hinhThucThanhToan = null;
        NVThuNgan = null;

    }

    public HOADON(String maHoaDon, String maDonThuoc, String maPhieuKhamBenh, double tongTien, LocalDate ngayTao,
            String hinhThucThanhToan, String NVThuNgan) {
        this.maHoaDon = maHoaDon;
        this.maDonThuoc = maDonThuoc;
        this.maPhieuKhamBenh = maPhieuKhamBenh;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.NVThuNgan = NVThuNgan;

    }

    public HOADON(HOADON hd) {
        maHoaDon = hd.maHoaDon;
        maDonThuoc = hd.maDonThuoc;
        maPhieuKhamBenh = hd.maPhieuKhamBenh;
        tongTien = hd.tongTien;
        ngayTao = hd.ngayTao;
        hinhThucThanhToan = hd.hinhThucThanhToan;
        NVThuNgan = hd.NVThuNgan;

        donThuoc = hd.donThuoc;
        phieuKhamBenh = hd.phieuKhamBenh;
        dsnv = hd.dsnv;
        dsbn = hd.dsbn;
        dsbs = hd.dsbs;
    }

    public void getData() {
        dsnv = new DANHSACHNHANVIEN();
        dsnv.docData("data\\NHANVIEN.TXT");
        donThuoc = new DANHSACHDONTHUOC();
        donThuoc.docData("data\\DONTHUOC.TXT");
        dsbs = new DSBS();
        dsbs.docData("data\\BacSi.txt");
        dsbn = new DSBN();
        dsbn.docData("data\\BenhNhan.txt");
        phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
        try {
            phieuKhamBenh.docData("data\\dataPhieuKham.txt");
        } catch (Exception e) {
            System.out.println("loi doc file!");
            return;
        }

    }

    public void them() {
        getData();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma hoa don : ");
        maHoaDon = input.nextLine();
        ngayTao = ngayTao.now();
        System.out.print("Nhap ma don thuoc: ");
        maDonThuoc = input.nextLine();
        if (donThuoc.timKiemTheoMa(maDonThuoc) == 0) {
            System.out.println("Ma don thuoc nay khong ton tai! nhap lai !!!!");
            them();
        }
        System.out.print("Nhap ma phieu kham benh: ");

        maPhieuKhamBenh = input.nextLine();

        if (phieuKhamBenh.timMaPhieuKham(maPhieuKhamBenh) == -1) {
            System.out.println("Ma phieu kham benh nay khong ton tai ! nhap lai!!!");
            them();
        }

        System.out.print("Hinh thuc thanh toan: (1:CK / 2:Tien mat) ");
        int option = input.nextInt();
        do {
            if (option == 1) {
                hinhThucThanhToan = "CHUYEN KHOAN";
            }
            if (option == 2) {
                hinhThucThanhToan = "TIEN MAT";
            }

        } while (option != 1 && option != 2);
        input.nextLine();
        System.out.print("Ma nhan vien :");
        NVThuNgan = input.nextLine();
        if (dsnv.kiemTraMaNhanVien(NVThuNgan) == 0) {
            System.out.println("Nhan vien khong ton tai!");
            them();
        } else {
            System.out.println("Da xong!");
        }
        tongTien = donThuoc.getDonThuocTuMa(maDonThuoc).getDonGia()
                + phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getTienKham();

    }



    public void xuat() {
        getData();
        System.out.println("=".repeat(100));
    
        // Tiêu đề hoá đơn
        System.out.format("|| %94s ||\n", "HOA DON BAN HANG");
        System.out.format("||       %-47s %40s ||\n", "TIEM THUOC NHOM 10", "Ngay tao: " + ngayTao);
        System.out.format("|| %94s ||\n", "So / Ma: " + maHoaDon);
    
        // Thông tin bác sĩ quản lý
        String maBacSi = phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi();
        BacSi bacSi = dsbs.timKiemTraVeBacSi(maBacSi);
        System.out.format("|| %-94s ||\n", "Bac si quan ly: " + bacSi.getHo() + " " + bacSi.getTen());
        System.out.format("|| %-94s ||\n", "Ma BSI: " + maBacSi);
        System.out.format("|| %-94s ||\n", "SDT: " + bacSi.getSDT());
    
        System.out.format("|| %-94s ||\n", " ");
    
        // Thông tin bệnh nhân
        String maBenhNhan = String.valueOf(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan());
        BenhNhan benhNhan = dsbn.timKiemBenhNhan(maBenhNhan);
        System.out.format("|| %-94s ||\n", "Ten benh nhan: " + benhNhan.getHo() + " " + benhNhan.getTen());
        System.out.format("|| %-94s ||\n", "Ma benh nhan: " + maBenhNhan);
        System.out.format("|| %-94s ||\n", "Ngay sinh: " + benhNhan.getNgaySinh());
        System.out.format("|| %-94s ||\n", "Chuan doan: " + phieuKhamBenh.getChuanDoanTuMa(maPhieuKhamBenh));
    
        System.out.format("|| %-94s ||\n", " ");
    
        System.out.format("|| %-94s ||\n", " ".repeat(38) + "DON THUOC");
    
        // Xuất đơn thuốc
        donThuoc.xuatDonThuocTheoMa(maDonThuoc);
    
        System.out.format("|| %53s %-40s ||\n", " ", "Cong Tien Kham : " + phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getTienKham());
        System.out.format("|| %53s %-40s ||\n", " ", "Tong Tien Thanh Toan : " + tongTien);
        System.out.format("|| %53s %-40s ||\n", " ", "Hinh thuc thanh toan : " + hinhThucThanhToan);
    
        System.out.format("|| %-94s ||\n", " ");
    
        // Thông tin bệnh nhân và người bán hàng
        System.out.format("||          %-48s %-31s      ||\n","Ten Benh Nhan","Ten Nguoi Ban Hang");
        String hoTenThuNgan = dsnv.timkiem(NVThuNgan).getHo() + " " + dsnv.timkiem(NVThuNgan).getTen();
        System.out.format("||          %-48s %-31s      ||\n", benhNhan.getHo() + " " + benhNhan.getTen(), hoTenThuNgan);
    
        System.out.println("=".repeat(100));
    }

}
