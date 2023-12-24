package THUOC;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Thuoc {
    Scanner mayScanner = new Scanner(System.in);
    private String maThuoc;
    private String maNhaSanXuat;
    private String tenThuoc;
    private int soLuong;
    private LocalDate ngaySanXuat;
    private LocalDate hanSuDung;
    private double giaCa; // --> sua thanh don gia

    Thuoc() {
        this.maThuoc = null;
        this.maNhaSanXuat = null;
        this.tenThuoc = null;
        this.soLuong = 0;
        this.ngaySanXuat = LocalDate.of(1970, 1, 1);
        this.hanSuDung = LocalDate.of(1970, 1, 1);
        this.giaCa = 0;
    }

    Thuoc(String maThuoc, String maNhaSanXuat, String tenThuoc, int soLuong, LocalDate ngaySanXuat, LocalDate hanSuDung,
            double giaCa) {
        this.maThuoc = maThuoc;
        this.maNhaSanXuat = maNhaSanXuat;
        this.tenThuoc = tenThuoc;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.hanSuDung = hanSuDung;
        this.giaCa = giaCa;
    }

    Thuoc(Thuoc newThuoc) {
        this.maThuoc = newThuoc.maThuoc;
        this.maNhaSanXuat = newThuoc.maNhaSanXuat;
        this.tenThuoc = newThuoc.tenThuoc;
        this.soLuong = newThuoc.soLuong;
        this.ngaySanXuat = newThuoc.ngaySanXuat;
        this.hanSuDung = newThuoc.hanSuDung;
        this.giaCa = newThuoc.giaCa;
    }

    public String getMaThuoc() {
        return this.maThuoc;
    }

    public String getMaNhaSanXuat() {
        return this.maNhaSanXuat;
    }

    public String getTenThuoc() {
        return this.tenThuoc;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public LocalDate getNgaySanXuat() {
        return this.ngaySanXuat;
    }

    public LocalDate getHanSuDung() {
        return this.hanSuDung;
    }

    public double getGiaCa() {
        return this.giaCa;
    }

    public void setMaThuoc(String newMaThuoc) {
        this.maThuoc = newMaThuoc;
    }

    public void setMaNhaSanXuat(String newMaNhaSanXuat) {
        this.maNhaSanXuat = newMaNhaSanXuat;
    }

    public void setTenThuoc(String newTenThuoc) {
        this.tenThuoc = newTenThuoc;
    }

    public void setSoLuong(int newSoLuong) {
        this.soLuong = newSoLuong;
    }

    public void setNgaySanXuat(LocalDate newNgaySanXuat) {
        this.ngaySanXuat = newNgaySanXuat;
    }

    public void setHanSuDung(LocalDate newHanSuDung) {
        this.hanSuDung = newHanSuDung;
    }

    public void setGiaCa(double newGiaCa) {
        this.giaCa = newGiaCa;
    }
    public void tangSoLuongThuoc(int soLuongThem)
    {
        this.soLuong = soLuongThem+soLuong;
    }

    public void nhapThongTinThuoc() {

        System.out.print("Nhap ma thuoc: ");
        String newMaThuoc = mayScanner.nextLine();
        System.out.print("Nhap nha san xuat: ");
        String newMaNhaSanXuat = mayScanner.nextLine();
        System.out.print("Nhap ten thuoc: ");
        String newTenThuoc = mayScanner.nextLine();
        System.out.print("Nhap so luong thuoc: ");
        int newSoLuong = mayScanner.nextInt();
        mayScanner.nextLine();
        System.out.print("Nhap ngay san xuat thuoc: ");
        String newNgaySanXuat = mayScanner.nextLine();
        System.out.print("Nhap han su dung thuoc: ");
        String newHanSuDung = mayScanner.nextLine();
        System.out.print("Nhap gia ca thuoc: ");
        double newGiaCa = mayScanner.nextDouble();

        this.maThuoc = newMaThuoc;
        this.maNhaSanXuat = newMaNhaSanXuat;
        this.tenThuoc = newTenThuoc;
        this.soLuong = newSoLuong;
        this.ngaySanXuat = LocalDate.parse(newNgaySanXuat);
        this.hanSuDung = LocalDate.parse(newHanSuDung);
        this.giaCa = newGiaCa;

    }

    abstract public void inThongTinThuoc();

    abstract public void suaThongTinThuoc();

  
}

//hello
