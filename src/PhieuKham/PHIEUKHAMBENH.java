package PhieuKham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PHIEUKHAMBENH { // phieu kham chi thay doi chuan doan ngay tai kham va tien kham
    Scanner mayScanner = new Scanner(System.in);

    private String maPhieuKham;
    private String maBacSi;
    private int maBenhNhan;
    private LocalDate ngayKham; // lay ngay hien tai
    private String chuanDoan;
    private LocalDate ngayTaiKham;
    private double tienKham;

    private static int tongSoPhieu = 0;



    // thieu 3 ham tao nua ....
    PHIEUKHAMBENH() {
        tongSoPhieu ++;
        this.maPhieuKham = null;
        this.maBacSi = null;
        this.maBenhNhan = 0;
        this.ngayKham = LocalDate.of(1970, 1, 1);
        this.chuanDoan = null;
        this.ngayTaiKham = LocalDate.of(1970, 1, 1);
        this.tienKham = 0;
    }

    PHIEUKHAMBENH(String maPhieuKham, String maBacSi, int maBenhNhan, LocalDate ngayKham, String chuanDoan,
            LocalDate ngayTaiKham, double tienKham) {

        tongSoPhieu ++;
        this.maPhieuKham = maPhieuKham;
        this.maBacSi = maBacSi;
        this.maBenhNhan = maBenhNhan;
        this.ngayKham = ngayKham;
        this.chuanDoan = chuanDoan;
        this.ngayTaiKham = ngayTaiKham;
        this.tienKham = tienKham;
    }

    PHIEUKHAMBENH(PHIEUKHAMBENH pkb2) {
        tongSoPhieu ++;
        this.maPhieuKham = pkb2.maPhieuKham;
        this.maBacSi = pkb2.maBacSi;
        this.maBenhNhan = pkb2.maBenhNhan;
        this.ngayKham = pkb2.ngayKham;
        this.chuanDoan = pkb2.chuanDoan;
        this.ngayTaiKham = pkb2.ngayTaiKham;
        this.tienKham = pkb2.tienKham;
    }

    public String getMaPhieuKham() {
        return this.maPhieuKham;
    }

    public String getMaBacSi() {
        return this.maBacSi;
    }

    public int getMaBenhNhan() {
        return this.maBenhNhan;
    }

    public LocalDate getNgayKham() {
        return this.ngayKham;
    }

    public String getChuanDoan() {
        return this.chuanDoan;
    }

    public LocalDate getNgayTaiKham() {
        return this.ngayTaiKham;
    }

    public double getTienKham() {
        return this.tienKham;
    }

    public static int getTongSoPhieu() {
        return tongSoPhieu;
    }


    public static void giamTongSoPhieu() {
        tongSoPhieu --;
    }

    public void setMaBacSi(String newMaBacSi) {
        this.maBacSi = newMaBacSi;
    }

    public void setMaBenhNhan(int newMaBenhNhan) {
        this.maBenhNhan = newMaBenhNhan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public void setNgayTaiKham(LocalDate ngayTaiKham) {
        this.ngayTaiKham = ngayTaiKham;
    }

    public void setTienKham(double tienKham) {
        this.tienKham = tienKham;
    }


    public void inPhieuKham() {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngayTaiKham = this.ngayTaiKham.format(dinhDangNgayThang);
        String ngayKham = this.ngayKham.format(dinhDangNgayThang);
        System.out.format("|| %-10s | %-15s | %-15s | %-10s | %-10s | %-15s | %-10s ||\n",
                this.maPhieuKham, this.maBacSi, this.maBenhNhan, ngayKham, this.chuanDoan, ngayTaiKham, this.tienKham);
    }


}
