package THUOC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class THUOCCHICH extends Thuoc {
    private int dungTichThuoc;

    public THUOCCHICH() {
        super();
        this.dungTichThuoc = 0;
    }

    THUOCCHICH(String maThuoc, String maNhaSanXuat, String tenThuoc, int soLuong, LocalDate ngaySanXuat, LocalDate hanSuDung, double giaCa, int dungTichThuoc) {
        super(maThuoc, maNhaSanXuat, tenThuoc, soLuong, ngaySanXuat, hanSuDung, giaCa);
        this.dungTichThuoc = dungTichThuoc;
    }

    THUOCCHICH(THUOCCHICH newThuocChich) {
        super((Thuoc) newThuocChich);
        this.dungTichThuoc = newThuocChich.dungTichThuoc;
    }

    public int getDungTichThuoc() {
        return this.dungTichThuoc;
    }

    public void setDungTichThuoc(int newDungTichThuoc) {
        this.dungTichThuoc = newDungTichThuoc;
    }

    public void suaThongTinThuoc() {
        System.out.println("\t\t\tNhap 1 de sua so luong thuoc");
        System.out.println("\t\t\tNhap 2 de sua gia ca thuoc");
        System.out.println("\t\t\tNhap 3 de sua dung tich thuoc");
        System.out.print("\t\t\tNhap ten thuoc tinh thuoc can sua: ");
        int newThuocTinhCanSua = mayScanner.nextInt();

        switch (newThuocTinhCanSua) {
            
            case 1:
                System.out.print("\t\t\tNhap so luong thuoc: ");
                int newSoLuong = mayScanner.nextInt();
                this.setSoLuong(newSoLuong);
                break;
            case 2:
                System.out.print("\t\t\tNhap gia ca thuoc: ");
                double newGiaCa = mayScanner.nextDouble();
                this.setGiaCa(newGiaCa);
                break;
            case 3:
                System.out.print("\t\t\tNhap dung tich thuoc: ");
                int newDungTichThuoc = mayScanner.nextInt();
                this.dungTichThuoc = newDungTichThuoc;
                break;
            default:
                System.out.println("Khong ton tai thuoc tinh can sua");
                break;
        }
    }

    public void inThongTinThuoc() {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngaySanXuat = this.getNgaySanXuat().format(dinhDangNgayThang);
        String hanSuDung = this.getHanSuDung().format(dinhDangNgayThang);
        System.out.format("|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n", "Thuoc vi",this.getMaThuoc(), this.getMaNhaSanXuat(), this.getTenThuoc(), this.getSoLuong(), ngaySanXuat, hanSuDung, this.getGiaCa());
    }

    public void nhapThongTinThuoc() {
        super.nhapThongTinThuoc();
        mayScanner.nextLine();
        System.out.print("Nhap dung tich thuoc: ");
        int newDungTichThuoc = mayScanner.nextInt();
        this.dungTichThuoc = newDungTichThuoc;
    }

}
