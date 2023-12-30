package RUN;

import java.util.Scanner;
import THUOC.QUANLIDSTHUOC;
import NHANVIEN.QUANLIDSNhanVien;
import QUANLYNHAPHANG.QUANLYNHAPHANG;
import NHACUNGCAP.QUANLIDSNhaCungCap;
import DONTHUOC.QUANLIDSDonThuoc;
import BENHNHAN.QuanLyDSBN;
import BacSi.QUANLIDSBACSI;
import HOADON.QUANLIDSHoaDon;
import PhieuKham.QLDSPHIEUKHAM;
public class Menu {
    Scanner mayScanner = new Scanner(System.in);

    QUANLIDSTHUOC trinhqlThuoc = new QUANLIDSTHUOC();
    QUANLIDSNhanVien trinhqlNhanVien = new QUANLIDSNhanVien();
    QUANLYNHAPHANG trinhqlNhapHang = new QUANLYNHAPHANG();
    QUANLIDSNhaCungCap trinhqlNCC = new QUANLIDSNhaCungCap();
    QUANLIDSDonThuoc trinhqlDONTHUOC = new QUANLIDSDonThuoc();
    QuanLyDSBN trinhqlBenhNhan = new QuanLyDSBN();
    QUANLIDSBACSI trinhqlBacSi = new QUANLIDSBACSI();
    QLDSPHIEUKHAM trinhQlPhieuKham = new QLDSPHIEUKHAM();
    QUANLIDSHoaDon trinhQLDSHoaDon = new QUANLIDSHoaDon();
    QUANLIDSTHUOC trinhQuanlidsthuoc = new QUANLIDSTHUOC();

    public void MainMenu() {

        // khong biet doc o dau nen doc o day

        int option = 0;
        do {
            System.out.println(
                    "\u001B[31m" + "-".repeat(20) + "CHUONG TRINH QUAN LI PHONG MACH" + "-".repeat(20) + "\u001B[0m");
            System.out.println("\tNhan phim 0 de thoat");
            System.out.println("\tNhan phim 1 de vao trinh quan li danh sach thuoc");
            System.out.println("\tNhan phim 2 de vao trinh quan li nhan vien");
            System.out.println("\tNhan phim 3 de vao trinh quan li nhap hang");
            System.out.println("\tNhan phim 4 de vao trinh quan li nha cung cap");
            System.out.println("\tNhan phim 5 de vao trinh quan li don thuoc");
            System.out.println("\tNhan phim 6 de vao trinh quan li benh nhan");
            System.out.println("\tNhan phim 7 de vao trinh quan li bac si");
            System.out.println("\tNhan phim 8 de vao trinh quan li phieu kham benh");
            System.out.println("\tNhan phim 9 de vao trinh quan li hoa don");
            System.out.print("\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0) {
                System.out.print("\tKhong hop le. Vui long nhap lai lua chon cua ban: ");
                option = mayScanner.nextInt();
            }

            if(option == 0) {
                break;
            }

            if(option == 1) {
                trinhqlThuoc.trinhQuanLiDanhSachThuoc();
                // trinhQuanlidsthuoc.trinhQuanLiDanhSachThuoc();
            }
            if(option == 2) {
                trinhqlNhanVien.thaoTac();
            }

            if(option == 3) {
                trinhqlNhapHang.menu();
            }
             if(option == 4) {
                trinhqlNCC.thaoTac();
            }
            if (option == 5){
                trinhqlDONTHUOC.thaoTac();
            }
            if (option == 6){
                trinhqlBenhNhan.thaoTac();
            }
            if (option == 7){
                trinhqlBacSi.thaoTac();;
            }

            if(option == 8) {
                trinhQlPhieuKham.trinhQuanLiDanhSachPhieuKhamBenh();
            }

            if(option == 9) {
                trinhQLDSHoaDon.thaoTac();
            }
        } while (option != 0);
    }
}
