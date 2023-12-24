package THUOC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class THUOCVI extends Thuoc {
    private int soLuongVi;
    private int soThuocMoiVi;

    public THUOCVI() {
        super();
        this.soLuongVi = 0;
        this.soThuocMoiVi = 0;
    }

    THUOCVI(String maThuoc, String maNhaSanXuat, String tenThuoc, int soLuong, LocalDate ngaySanXuat,
            LocalDate hanSuDung, double giaCa, int soLuongVi, int soThuocMoiVi) {

        super(maThuoc, maNhaSanXuat, tenThuoc, soLuong, ngaySanXuat, hanSuDung, giaCa);
        this.soLuongVi = soLuongVi;
        this.soThuocMoiVi = soThuocMoiVi;
    }

    THUOCVI(THUOCVI newThuocVi) {
        super((Thuoc) newThuocVi);
        this.soLuongVi = newThuocVi.soLuongVi;
        this.soThuocMoiVi = newThuocVi.soThuocMoiVi;
    }

    public int getSoLuongVi() {
        return this.soLuongVi;
    }

    public int getSoThuocMoiVi() {
        return this.soThuocMoiVi;
    }

    public int getTongSoThuoc() {
        return this.soLuongVi * this.soThuocMoiVi;
    }

    public void setSoLuongVi(int newSoLuongVi) {
        this.soLuongVi = newSoLuongVi;
    }

    public void setSoThuocMoiVi(int newSoThuocMoiVi) {
        this.soThuocMoiVi = newSoThuocMoiVi;
    }

    public void inThongTinThuoc() {

        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngaySanXuat = this.getNgaySanXuat().format(dinhDangNgayThang);
        String hanSuDung = this.getHanSuDung().format(dinhDangNgayThang);
        System.out.format("|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n", "Thuoc chich",this.getMaThuoc(), this.getMaNhaSanXuat(), this.getTenThuoc(), this.getSoLuong(), ngaySanXuat, hanSuDung, this.getGiaCa());

    }

    public void suaThongTinThuoc() {
        System.out.println("\t\t\tNhap 1 de sua so luong thuoc");
        System.out.println("\t\t\tNhap 2 de sua gia ca thuoc");
        System.out.println("\t\t\tNhap 3 de sua so vi");
        System.out.println("\t\t\tNhap 4 de sua so thuoc moi vi");
        System.out.print("Nhap ten thuoc tinh thuoc can sua: ");
        int newThuocTinhCanSua = mayScanner.nextInt();

        switch (newThuocTinhCanSua) {
            
            case 1:
                System.out.print("Nhap so luong thuoc: ");
                int newSoLuong = mayScanner.nextInt();
                this.setSoLuong(newSoLuong);
                break;
           
            case 2:
                System.out.print("Nhap gia ca thuoc: ");
                double newGiaCa = mayScanner.nextDouble();
                this.setGiaCa(newGiaCa);
                break;
            case 3:
                System.out.print("Nhap so luong vi: ");
                int newSoLuongVi = mayScanner.nextInt();
                this.soLuongVi = newSoLuongVi;
                break;
            case 4:
                System.out.print("Nhap so thuoc moi vi: ");
                int newSoThuocMoiVi = mayScanner.nextInt();
                this.soThuocMoiVi = newSoThuocMoiVi;
                break;
            default:
                System.out.println("Khong ton tai thuoc tinh can sua");
                break;
        }
    }

    public void nhapThongTinThuoc() {

        super.nhapThongTinThuoc();
        mayScanner.nextLine();
        System.out.print("Nhap so luong vi: ");
        int newSoLuongVi = mayScanner.nextInt();
        System.out.print("Nhap so luong thuoc moi vi: ");
        int newSoThuocMoiVi = mayScanner.nextInt();
        this.soLuongVi = newSoLuongVi;
        this.soThuocMoiVi = newSoThuocMoiVi;
    }

}
