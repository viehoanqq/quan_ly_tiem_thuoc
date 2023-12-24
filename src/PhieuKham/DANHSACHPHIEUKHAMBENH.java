package PhieuKham;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import INTERFACE.interfaceDanhSach;
import BacSi.DSBS;
import BENHNHAN.DSBN;
public class DANHSACHPHIEUKHAMBENH implements interfaceDanhSach {
    PHIEUKHAMBENH[] dsPhieuKham;
    int soPhieuKham;

    Scanner mayScanner = new Scanner(System.in);
    DSBS dsbs = new DSBS();
    DSBN dsbn = new DSBN();

    public DANHSACHPHIEUKHAMBENH() {
        this.dsPhieuKham = new PHIEUKHAMBENH[0];
        this.soPhieuKham = 0;
    }

    DANHSACHPHIEUKHAMBENH(PHIEUKHAMBENH[] dsPhieuKham, int soPhieuKham) {
        this.dsPhieuKham = dsPhieuKham;
        this.soPhieuKham = soPhieuKham;
    }

    DANHSACHPHIEUKHAMBENH(DANHSACHPHIEUKHAMBENH dspkb2) {
        this.dsPhieuKham = dspkb2.dsPhieuKham;
        this.soPhieuKham = dspkb2.soPhieuKham;
    }

    public PHIEUKHAMBENH[] getDsPhieuKham() {
        return this.dsPhieuKham;
    }

    public PHIEUKHAMBENH getPhieuKhamBenh(String ma) {
        for (int i = 0; i < soPhieuKham; i++) {
            if (dsPhieuKham[i].getMaPhieuKham().equals(ma))
                return dsPhieuKham[i];

        }
        return null;

    }

    public int getSoPhieuKham() {
        return this.soPhieuKham;
    }

    public String getChuanDoanTuMa(String ma) {
        for (int i = 0; i < soPhieuKham; i++) {
            if (ma.equals(dsPhieuKham[i].getMaPhieuKham())) {
                return dsPhieuKham[i].getChuanDoan();
            }
        }
        return "";
    }

    public void setSoPhieuKham(int soPhieu) {
        this.soPhieuKham = soPhieu;
    }

    public void setDanhSachPhieuKham(PHIEUKHAMBENH[] dspkb) {
        this.dsPhieuKham = dspkb;
    }

    public void getNeedData(String filePathBacSi, String filePathBenhNhan) {
        dsbs.docData(filePathBacSi);
        dsbn.docData(filePathBenhNhan);
    }


    public void themPhieuKhamBenh(PHIEUKHAMBENH newPhieukhambenh) {
        this.soPhieuKham += 1;
        this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, soPhieuKham);
        this.dsPhieuKham[soPhieuKham - 1] = newPhieukhambenh;
    }

    public void taoPhieuKhamBenh() { // them vào cuối index
        String maPhieuKham;
        String maBacSi;
        int maBenhNhan;
        String tempNgayTaiKham;
        mayScanner.nextLine();

        System.out.print("Nhap ma phieu kham: ");
        maPhieuKham = mayScanner.nextLine();

        while (timMaPhieuKham(maPhieuKham) != -1) {
            System.out.print("Ma phieu kham khong co trong CSDL, vui long nhap lai: ");
            maPhieuKham = mayScanner.nextLine();
        }

        dsbs.xuat();
        System.out.print("\nNhap ma bac si: ");
        maBacSi = mayScanner.nextLine();
        while (dsbs.timMaBacSi(maBacSi) == -1) {
            System.out.print("Ma bac si khong co trong CSDL, vui long nhap lai: ");
            maBacSi = mayScanner.nextLine();
        }

        dsbn.XuatBN();
        System.out.print("\nNhap ma benh nhan: ");
        maBenhNhan = mayScanner.nextInt();
        while (dsbn.timMaBenhNhan(maBenhNhan) == -1) {
            System.out.print("Ma benh nhan khong co trong CSDL, vui long nhap lai: ");
            maBenhNhan = mayScanner.nextInt();
        }
        LocalDate ngayKham = LocalDate.now();

        mayScanner.nextLine();
        System.out.print("Nhap chuan doan: ");
        String chuanDoan = mayScanner.nextLine();

        System.out.print("Nhap ngay tai kham (yyyy--MM-dd): ");
        tempNgayTaiKham = mayScanner.nextLine();
        LocalDate ngayTaiKham = LocalDate.parse(tempNgayTaiKham);

    
        while (!(ngayKham.isEqual(ngayTaiKham) || ngayKham.isBefore(ngayTaiKham))) {
            System.out.print("Ngay tai kham khong phu hop, vui long nhap lai: ");
            tempNgayTaiKham = mayScanner.nextLine();
            ngayTaiKham = LocalDate.parse(tempNgayTaiKham);
        }
        

        System.out.print("Nhap tien kham: ");
        double tienKham = mayScanner.nextDouble();

        PHIEUKHAMBENH newPhieuKham = new PHIEUKHAMBENH(maPhieuKham, maBacSi, maBenhNhan, ngayKham, chuanDoan,
                ngayTaiKham, tienKham);
        // PHIEUKHAMBENH newPhieuKham = new PHIEUKHAMBENH();
        this.themPhieuKhamBenh(newPhieuKham);
    }

    public void xoaPhieuKhamBenh(int index) {
        if (index == this.soPhieuKham - 1) {
            this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, this.soPhieuKham - 1);
            this.soPhieuKham -= 1;
        } else {
            for (int i = index; i < this.soPhieuKham - 1; i++) {
                this.dsPhieuKham[i] = this.dsPhieuKham[i + 1];
            }
            this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, this.soPhieuKham - 1);
            this.soPhieuKham -= 1;
        }
    }

    public void suaPhieuKhamBenh(int index) {
        System.out.println("\t\t\tNhap 1 de sua tien kham");
        System.out.println("\t\t\tNhap 2 de sua chuan doan");
        System.out.println("\t\t\tNhap 3 de sua bac si kham");
        System.out.println("\t\t\tNhap 4 de sua benh nhan kham");
        System.out.print("Nhap ten thuoc tinh thuoc can sua: ");
        int newThuocTinhCanSua = mayScanner.nextInt();

        mayScanner.nextLine();
        switch (newThuocTinhCanSua) {

            case 1:
                System.out.print("\t\t\tNhap so tien kham can sua: ");
                double newTienKham = mayScanner.nextDouble();
                this.dsPhieuKham[index].setTienKham(newTienKham);
                break;

            case 2:

                System.out.print("\t\t\tNhap chuan doan can sua: ");
                String newChuanDoan = mayScanner.nextLine();
                this.dsPhieuKham[index].setChuanDoan(newChuanDoan);
                break;
            case 3:
                System.out.print("\t\t\tNhap ma bac si can sua");
                String newMaBacSi = mayScanner.nextLine();
                if (dsbs.timMaBacSi(newMaBacSi) == -1) {
                    System.out.println("\t\t\tKhong tim thay ma bac si");
                } else {
                    this.dsPhieuKham[index].setMaBacSi(newMaBacSi);
                }
                break;
            case 4:
                System.out.print("\t\t\tNhap ma benh nhan can sua");
                int newMaBenhNhan = mayScanner.nextInt();
                if (dsbn.timMaBenhNhan(newMaBenhNhan) == -1) {
                    System.out.println("Khong tim thay ma benh nhan de sua");
                } else {
                    this.dsPhieuKham[index].setMaBenhNhan(newMaBenhNhan);
                }
                break;
            default:
                System.out.print("Khong ton tai thuoc tinh can sua");
                break;
        }
    }

    public int timMaPhieuKham(String findedMaPhieuKham) {
        int index = -1;
        for (int i = 0; i < this.soPhieuKham; i++) {
            if (this.dsPhieuKham[i].getMaPhieuKham().equals(findedMaPhieuKham))
                index = i;
        }
        return index;
    }

    public void timKiemKhoangNgayKham() {
        System.out.print("\tNhap ngay bat dau (yyyy-MM-dd): ");
        String ngayBatDauStr = mayScanner.nextLine();
        System.out.print("\tNhap ngay ket thuc (yyyy-MM-dd): ");
        String ngayKetThucStr = mayScanner.nextLine();

        LocalDate ngayBatDau = LocalDate.parse(ngayBatDauStr);
        LocalDate ngayKetThuc = LocalDate.parse(ngayKetThucStr);
        System.out.println("\u001B[32m" + "-".repeat(50) + " DANH SACH PHIEU KHAM " + "-".repeat(50) + "\u001B[0m");
        System.out.format("\u001B[34m" + "|| %-10s | %-15s | %-15s | %-10s | %-10s | %-15s | %-10s ||\n" + "\u001B[0m",
                "MA Pk", "MA BAC SI", "MA BENH NHAN", "NGAY KHAM", "CHUAN DOAN", "NGAY TAI KHAM", "TIEM KHAM");
        for (int i = 0; i < this.soPhieuKham; i++) {
            if (this.dsPhieuKham[i].getNgayKham().isEqual(ngayBatDau)
                    || this.dsPhieuKham[i].getNgayKham().isEqual(ngayKetThuc)
                    || (this.dsPhieuKham[i].getNgayKham().isAfter(ngayBatDau))
                            && this.dsPhieuKham[i].getNgayKham().isBefore(ngayKetThuc)) {
                this.dsPhieuKham[i].inPhieuKham();
            }
        }
        System.out.println("\u001B[32m" + "-".repeat(117) + "\u001B[0m");

    }

    public void inDanhSachPhieuKham() {
        System.out.println("\tTong so phieu kham: " + PHIEUKHAMBENH.getTongSoPhieu());
        System.out.println("\u001B[32m" + "-".repeat(50) + " DANH SACH PHIEU KHAM " + "-".repeat(50) + "\u001B[0m");
        System.out.format("\u001B[34m" + "|| %-10s | %-15s | %-15s | %-10s | %-10s | %-15s | %-10s ||\n" + "\u001B[0m",
                "MA Pk", "MA BAC SI", "MA BENH NHAN", "NGAY KHAM", "CHUAN DOAN", "NGAY TAI KHAM", "TIEM KHAM");
        for (int i = 0; i < this.soPhieuKham; i++) {
            this.dsPhieuKham[i].inPhieuKham();
        }
        System.out.println("\u001B[32m" + "-".repeat(117) + "\u001B[0m");
    }

    public void inChiTietPhieuKham(int index) {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngayTaiKham = this.dsPhieuKham[index].getNgayTaiKham().format(dinhDangNgayThang);
        String ngayKham = this.dsPhieuKham[index].getNgayKham().format(dinhDangNgayThang);
        LocalDate ngayIn = LocalDate.now();
        String ngayInStr = ngayIn.format(dinhDangNgayThang);

        System.out.format("%80s\n", "=".repeat(84));
        System.out.format("||%80s||\n", " ".repeat(32) + "PHIEU KHAM BENH" + " ".repeat(33));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", "Ngay in phieu kham benh: " + ngayInStr + " ".repeat(2));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Ma benh nhan: " + this.dsPhieuKham[index].getMaBenhNhan());
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Ma bac si kham: " + this.dsPhieuKham[index].getMaBacSi());
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Ngay kham benh: " + ngayKham);
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Chuan doan benh: " + this.dsPhieuKham[index].getChuanDoan());
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Ngay tai kham: " + ngayTaiKham);
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(2) + "Chi phi Kham: " + this.dsPhieuKham[index].getTienKham());
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));

        System.out.format("||%-80s||\n", " ".repeat(16) + "Benh nhan" + " ".repeat(30) + "Bac si");
        System.out.format("||%-80s||\n", " ".repeat(12) + "(Ki ro ho va ten)" + " ".repeat(20) + "(Ki ro ho va ten)");
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("||%80s||\n", " ".repeat(80));
        System.out.format("%80s\n", "=".repeat(84));

    }

    public String getDataPhieuKham(int index) {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder dataPhieuKham = new StringBuilder();
        String ngayKham = this.dsPhieuKham[index].getNgayKham().format(dinhDangNgayThang);
        String ngayTaiKham = this.dsPhieuKham[index].getNgayTaiKham().format(dinhDangNgayThang);
        dataPhieuKham.append(this.dsPhieuKham[index].getMaPhieuKham()).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getMaBacSi()).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getMaBenhNhan()).append(", ");
        dataPhieuKham.append(ngayKham).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getChuanDoan()).append(", ");
        dataPhieuKham.append(ngayTaiKham).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getTienKham());
        return dataPhieuKham.toString();
    }

    public void findOption() {
        int find_option = 0;

        do {
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("Nhap 1 de tim kiem theo ma phieu");
            System.out.println("nhap 2 de tim kiem phieu kham theo ngay");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            find_option = mayScanner.nextInt();

            while (find_option < 0 || find_option > 6) {
                System.out.println("Ban nhap khong dung gia tri, vui long nhap lai: ");
                find_option = mayScanner.nextInt();
            }

            if (find_option == 0) {

                break;
            }

            if (find_option == 1) {
                mayScanner.nextLine();
                System.out.println("Nhap ma phieu can tim kiem: ");
                String maPhieuKhamCanTim = mayScanner.nextLine();
                if (timMaPhieuKham(maPhieuKhamCanTim) == -1) {
                    System.out.println("Khong tim thay ma phieu kham can tim");
                } else {
                    this.dsPhieuKham[timMaPhieuKham(maPhieuKhamCanTim)].inPhieuKham();
                }
            }

            if (find_option == 2) {
                mayScanner.nextLine();
                this.timKiemKhoangNgayKham();
            }

        } while (find_option != 0);
    }

    // ------- XU LI OVERRIDE -----------
    @Override
    public void Them(int soPhieuKhamThem) {
        this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, this.soPhieuKham + soPhieuKhamThem);

        for (int i = 0; i < soPhieuKham; i++) {
            System.out.println("\t\t\tPhieu them thu " + (i + 1));
            this.taoPhieuKhamBenh();
        }
    }

    @Override
    public void Xoa(String maPhieuCanXoa) {
        int index = 0;
        boolean isSuccess = false;
        for (int i = 0; i < this.dsPhieuKham.length; i++) {
            if (this.dsPhieuKham[i].getMaPhieuKham().indexOf(maPhieuCanXoa) != -1) { // da tim thay
                isSuccess = true;
                index = i;
                PHIEUKHAMBENH.giamTongSoPhieu();
                break;
            }
        }
        if (isSuccess) {
            this.xoaPhieuKhamBenh(index);
            System.out.println("\t\t\tDa xoa thanh cong!\n");

        } else {
            System.out.println("\t\t\tXoa that bai do khong tim thay ma thuoc yeu cau\n");
        }
    }

    @Override
    public void Sua(String maPhieuCanSua) {
        
        for (int i = 0; i < this.soPhieuKham; i++) {
            if (maPhieuCanSua.equals(this.dsPhieuKham[i].getMaPhieuKham())) {
                this.suaPhieuKhamBenh(i);
                
            }
        }
        
    }

    @Override
    public void docData(String filePath) {
        File dataFile = new File(filePath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(dataFile);
        } catch (Exception e) {
            System.out.println("\t\t\tDoc du lieu that bai");
            return;
        }
        while (fileScanner.hasNextLine()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String[] danhSachThuocTinh = fileScanner.nextLine().split(", ");
            String tempMaPhieuKham = danhSachThuocTinh[0];
            String tempMaBacSi = danhSachThuocTinh[1];
            int tempMaBenhNhan = Integer.parseInt(danhSachThuocTinh[2]);
            LocalDate tempNgayKham = LocalDate.parse(danhSachThuocTinh[3], formatter);
            String tempChuanDoan = danhSachThuocTinh[4];
            LocalDate tempNgayTaiKham = LocalDate.parse(danhSachThuocTinh[5], formatter);
            double tempTienKham = Double.parseDouble(danhSachThuocTinh[6]);
            PHIEUKHAMBENH newPhieuKhamBenh = new PHIEUKHAMBENH(tempMaPhieuKham, tempMaBacSi, tempMaBenhNhan,
                    tempNgayKham, tempChuanDoan, tempNgayTaiKham, tempTienKham);
            this.themPhieuKhamBenh(newPhieuKhamBenh);
        }
        fileScanner.close();
    }

    @Override
    public void ghiData(String filePath) {
        File dataFile = new File(filePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(dataFile);
            for (int i = 0; i < soPhieuKham; i++) {
                writer.write(getDataPhieuKham(i) + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("\t\t\tGhi file that bai");
        }
    }

    @Override
    public void menuThaoTac() {
        int option = 0;

        do {
            System.out.println("\t\t" + "-".repeat(10) + " Trinh quan li phieu kham benh " + "-".repeat(10));
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("\t\tNhap 1 de in danh sach toan bo phieu kham benh");
            System.out.println("\t\tNhap 2 de nhap them phieu kham benh");
            System.out.println("\t\tNhap 3 de in mot phieu kham benh");
            System.out.println("\t\tNhap 4 de mo trinh tim kiem phieu kham benh");
            System.out.println("\t\tNhap 5 de xoa mot phieu kham benh");
            System.out.println("\t\tNhap 6 de sua mot phieu kham benh");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0 || option > 6) {
                System.out.print("\t\tLua chon nay khong ton tai, vui long nhap lai: ");
                option = mayScanner.nextInt();
            }

            if (option == 0) {

                break;
            }

            if (option == 1) {
                this.inDanhSachPhieuKham();
            }

            if (option == 2) {
                this.taoPhieuKhamBenh();
            }

            if (option == 3) {
                mayScanner.nextLine();
                System.out.print("Nhap ma phieu kham benh: ");
                String maPhieuKhamCanTim = mayScanner.nextLine();

                int index = timMaPhieuKham(maPhieuKhamCanTim);
                if (index == -1) {
                    System.out.println("Ma thuoc khong co trong CSDL");
                }

                else {
                    this.inChiTietPhieuKham(index);
                }

            }

            if (option == 4) {
                this.findOption();
            }

            if(option == 5) {
                mayScanner.nextLine();
                System.out.print("\tNhap ma phieu kham benh can xoa ");
                String maPhieuCanXoa = mayScanner.nextLine();
                this.Xoa(maPhieuCanXoa);
            }

            if(option == 6) {
                mayScanner.nextLine();
                System.out.print("\tNhap ma phieu kham benh can sua ");
                String maPhieuCanSua = mayScanner.nextLine();
                this.Sua(maPhieuCanSua);
            }

        } while (option != 0);
    }

}
