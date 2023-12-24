package THUOC;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import INTERFACE.interfaceDanhSach;
public class DANHSACHTHUOC implements interfaceDanhSach {
    Scanner mayScanner = new Scanner(System.in);
    private Thuoc[] dsThuoc;
    private int soLuongThuoc;

    public DANHSACHTHUOC() {
        this.dsThuoc = new Thuoc[0];
        this.soLuongThuoc = 0;
    }

    DANHSACHTHUOC(Thuoc[] dsThuoc, int soLuongThuoc) {
        this.dsThuoc = dsThuoc;
        this.soLuongThuoc = soLuongThuoc;
    }

    DANHSACHTHUOC(DANHSACHTHUOC newDsThuoc) {
        this.dsThuoc = newDsThuoc.dsThuoc;
        this.soLuongThuoc = newDsThuoc.soLuongThuoc;
    }

    public Thuoc[] getDsThuoc() {
        return this.dsThuoc;
    }

    public int getSoLuongThuoc() {
        return this.soLuongThuoc;
    }

    public double getGiaCaTheoMa(String ma) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (ma.equals(dsThuoc[i].getMaThuoc())) {
                return dsThuoc[i].getGiaCa();
            }
        }
        return 0;
    }

    // ???
    public void themSoLuongChoThuoc(String ma, int soluong) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (ma.equals(dsThuoc[i].getMaThuoc())) {
                dsThuoc[i].setSoLuong(dsThuoc[i].getSoLuong() + soluong);
            }
        }
    }

    public void setSoLuongThuoc(int soluong) {
        this.soLuongThuoc = soluong;
    }

    public void giamSoLuongThuocTheoMa(String ma, int soluong) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (ma.equals(dsThuoc[i].getMaThuoc())) {
                dsThuoc[i].setSoLuong(dsThuoc[i].getSoLuong() - soluong);
            }
        }
    }

    public int[] getSoThuocTungLoai() {
        int[] thuocTungLoai = new int[2];
        Arrays.fill(thuocTungLoai, 0);
        // thuoc chich la 0
        // thuoc vi la 1
        for (Thuoc i : this.dsThuoc) {
            if (i instanceof THUOCCHICH)
                thuocTungLoai[0] += 1;
            else if (i instanceof THUOCVI)
                thuocTungLoai[1] += 1;
        }
        return thuocTungLoai;
    }

    public void nhapThuoc(int soThuocCanNhap) {
        for (int i = 0; i < soThuocCanNhap; i++) {
            int typeThuoc;
            do {
                System.out.print("\tNhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
                typeThuoc = mayScanner.nextInt();
                if (typeThuoc == 0) {
                    this.dsThuoc[i] = new THUOCCHICH();
                    this.dsThuoc[i].nhapThongTinThuoc();
                } else if (typeThuoc == 1) {
                    this.dsThuoc[i] = new THUOCVI();
                    this.dsThuoc[i].nhapThongTinThuoc();
                }
            }

            while (typeThuoc < 0 && typeThuoc > 1);

        }
    }

    public void themThuoc(Thuoc newThuoc) {
        this.soLuongThuoc += 1;
        this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc);
        this.dsThuoc[soLuongThuoc - 1] = newThuoc;
    }

    public void xoaThuoc(int index) {
        if (index == this.soLuongThuoc - 1) {
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        } else {
            for (int i = index; i < this.soLuongThuoc - 1; i++)
                this.dsThuoc[i] = this.dsThuoc[i + 1];
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        }
    }

    public void inDanhSachThuoc() {
        int[] thuocTungLoai = this.getSoThuocTungLoai();
        System.out.println("\tSo thuoc chich: " + thuocTungLoai[0]);
        System.out.println("\tSo thuoc vi: " + thuocTungLoai[1]);
        System.out.println("\tTong so thuoc: " + this.soLuongThuoc);

        System.out.println("\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
        System.out.format(
                "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n" + "\u001B[0m",
                "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD", "GIA CA");
        for (int i = 0; i < this.soLuongThuoc; i++) {
            this.dsThuoc[i].inThongTinThuoc();
        }
        System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
    }

    public void timThuocTheoTen(String tenThuocCanTim) {
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getTenThuoc().equals(tenThuocCanTim))
                dsThuoc[i].inThongTinThuoc();
        }
    }

    // ----------- START XU LI THEO MA THOC ---------
    public Thuoc timThuocTheoMa(String maThuocCanTim) {
        int index = 0;
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuocCanTim))
                index = i;
        }
        if (this.dsThuoc[index] instanceof THUOCCHICH) {
            THUOCCHICH thuocchich = new THUOCCHICH();
            thuocchich = (THUOCCHICH) this.dsThuoc[index];
            return thuocchich;
        }
        THUOCVI thuocvi = new THUOCVI();
        thuocvi = (THUOCVI) this.dsThuoc[index];
        return thuocvi;
    }

    public void inThuocTheoMa(String maThuocCanTim) {
        for (Thuoc tempThuoc : this.dsThuoc) {
            if (tempThuoc.getMaThuoc().equals(maThuocCanTim)) {
                tempThuoc.inThongTinThuoc();
            }
        }
    }

    public int isExists(String ma) {
        int result = 0;
        for (int i = 0; i < this.dsThuoc.length; i++) {
            if (this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(ma))
                result = 1;
        }
        return result;
    }

    public int getSoLuongThuocTheoLoai(String ma) {
        int result = 0;
        for (int i = 0; i < this.dsThuoc.length; i++) {
            if (this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(ma))
                result = dsThuoc[i].getSoLuong();
        }
        return result;
    }

    public String getTenThuocTheoMa(String ma) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (ma.equals(dsThuoc[i].getMaThuoc())) {
                return dsThuoc[i].getTenThuoc();
            }

        }
        return "null";
    }

    // ------ START XU LI THUOC THEO MA NHA SAN XUAT ----------
    public int[] thongKeThuocCungMaNSX(String maNSX) {
        int[] index = new int[0];
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaNhaSanXuat().equalsIgnoreCase(maNSX)) {
                index = Arrays.copyOf(index, index.length + 1);
                index[index.length - 1] = i;
            }
        }
        return index;
    }

    public void inThuocCungMaMSX(String maNSX) {
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaNhaSanXuat().equalsIgnoreCase(maNSX)) {
                this.dsThuoc[i].inThongTinThuoc();
            }
        }
    }

    // ---- TIM THUOC THEO NGAY ----------
    public Thuoc[] checkThuocHetHanSuDungChua() {
        Thuoc[] outOfDateTHUOC = new Thuoc[0];
        LocalDate today = LocalDate.now();
        for (int i = 0; i < this.dsThuoc.length; i++) {
            if (!this.dsThuoc[i].getHanSuDung().isEqual(today) && this.dsThuoc[i].getHanSuDung().isBefore(today)) {
                outOfDateTHUOC = Arrays.copyOf(outOfDateTHUOC, outOfDateTHUOC.length + 1);
                outOfDateTHUOC[outOfDateTHUOC.length - 1] = this.dsThuoc[i];
            }
        }
        return outOfDateTHUOC;
    }

    

    // TRA VE DATA CUA CLASS VAO 1 STRING ROI GHI LEN FILE THEO DONG
    public String getDataThuoc(int index) {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder dataThuoc = new StringBuilder();
        String ngaySanXuat = this.dsThuoc[index].getNgaySanXuat().format(dinhDangNgayThang);
        String hanSuDung = this.dsThuoc[index].getHanSuDung().format(dinhDangNgayThang);
        if (this.dsThuoc[index] instanceof THUOCCHICH) {
            THUOCCHICH tempThuocChich = (THUOCCHICH) this.dsThuoc[index];
            dataThuoc.append(this.dsThuoc[index].getMaThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getMaNhaSanXuat()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getTenThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getSoLuong()).append(", ");
            dataThuoc.append(ngaySanXuat).append(", ");
            dataThuoc.append(hanSuDung).append(", ");
            dataThuoc.append(this.dsThuoc[index].getGiaCa()).append(", ");
            dataThuoc.append(tempThuocChich.getDungTichThuoc());
        }
        if (this.dsThuoc[index] instanceof THUOCVI) {
            THUOCVI tempThuocVi = (THUOCVI) this.dsThuoc[index];
            dataThuoc.append(this.dsThuoc[index].getMaThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getMaNhaSanXuat()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getTenThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getSoLuong()).append(", ");
            dataThuoc.append(ngaySanXuat).append(", ");
            dataThuoc.append(hanSuDung).append(", ");
            dataThuoc.append(this.dsThuoc[index].getGiaCa()).append(", ");
            dataThuoc.append(tempThuocVi.getSoLuongVi()).append(", ");
            dataThuoc.append(tempThuocVi.getSoThuocMoiVi());
        }
        return dataThuoc.toString();
    }

    public void findOption() {
        int find_option = 0;
        do {

            System.out.println("\t" + "-".repeat(10) + " TRINH TIM KIEM VA THONG KE THUOC " + "-".repeat(10));
            System.out.println("\tNhap 0 de thoat trinh tim kiem");
            System.out.println("\tNhap 1 de sap xep thuoc theo gia tang dan");
            System.out.println("\tNhap 2 de tim kiem thuoc theo ten ma thuoc");
            System.out.println("\tNhap 3 de tim kiem thuoc theo ten thuoc");
            System.out.println("\tNhap 4 de tim kiem thuoc theo loai thuoc");
            System.out.println("\tNhap 5 de thong ke so thuoc het han ");
            System.out.print("\tVui lonh nhap lua chon cua ban: ");
            find_option = mayScanner.nextInt();

            while (find_option < 0 && find_option > 5) {
                System.out.print("\tVui long nhap lai gia tri: ");
                find_option = mayScanner.nextInt();
            }

            if (find_option == 0) {
                break;
            }

            if (find_option == 1) {
                Thuoc[] sortThuoc = Arrays.copyOf(this.dsThuoc, this.dsThuoc.length);
                Arrays.sort(sortThuoc, Comparator.comparingDouble(Thuoc::getGiaCa));
                System.out.println("\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                System.out.format(
                        "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                + "\u001B[0m",
                        "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD",
                        "GIA CA");
                for (Thuoc i : sortThuoc) {
                    i.inThongTinThuoc();
                }
                System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
            }

            if (find_option == 2) {
                mayScanner.nextLine();
                System.out.print("Nhap ma thuoc can tim: ");
                String maThuocCanTim = mayScanner.nextLine();

                boolean canFind = false;
                for (Thuoc tempThuoc : this.dsThuoc) {
                    if (tempThuoc.getMaThuoc().equalsIgnoreCase(maThuocCanTim)) {
                        System.out.println(
                                "\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                        System.out.format(
                                "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                        + "\u001B[0m",
                                "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX",
                                "HAN SD", "GIA CA");
                        tempThuoc.inThongTinThuoc();
                        canFind = true;
                    }
                }
                if (!canFind) {
                    System.out.println("Khong tim thay ");
                }
                System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
            }

            if (find_option == 3) {
                mayScanner.nextLine();
                System.out.print("Nhap ten thuoc can tim: ");
                String tenThuocCanTim = mayScanner.nextLine();

                boolean canFind = false;
                System.out.println("\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                System.out.format(
                        "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                + "\u001B[0m",
                        "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD",
                        "GIA CA");
                for (Thuoc tempThuoc : this.dsThuoc) {
                    if (tempThuoc.getTenThuoc().contains(tenThuocCanTim)) {

                        tempThuoc.inThongTinThuoc();
                        canFind = true;
                    }
                }
                if (!canFind) {
                    System.out.println("Khong tim thay ");
                }
                System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
            }

            if (find_option == 4) {
                mayScanner.nextLine();
                System.out.print("Nhap loai thuoc can tim (0 la thuoc chich, 1 la thuoc vi): ");
                int type = mayScanner.nextInt();

                if (type == 0) {

                    System.out.println(
                            "\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                    System.out.format(
                            "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                    + "\u001B[0m",
                            "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD",
                            "GIA CA");
                    for (Thuoc i : this.dsThuoc) {
                        if (i instanceof THUOCCHICH) {
                            i.inThongTinThuoc();
                        }
                    }
                    System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
                }

                else if (type == 1) {
                    System.out.println(
                            "\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                    System.out.format(
                            "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                    + "\u001B[0m",
                            "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD",
                            "GIA CA");
                    for (Thuoc i : this.dsThuoc) {
                        if (i instanceof THUOCVI) {
                            i.inThongTinThuoc();
                        }
                    }
                    System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
                }

            }

            if (find_option == 5) {
                Thuoc[] hetHsd;
                hetHsd = checkThuocHetHanSuDungChua();
                if (hetHsd.length == 0) {
                    System.out.println("\t\tChua co thuoc nao het han");
                } else {
                    System.out.println("\t\tCo " + hetHsd.length + " thuoc het han");
                }

                System.out.println("\u001B[32m" + "-".repeat(58) + " DANH SACH THUOC " + "-".repeat(58) + "\u001B[0m");
                System.out.format(
                        "\u001B[34m" + "|| %-13s | %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n"
                                + "\u001B[0m",
                        "LOAI THUOC", "MA THUOC", "MA NHA SAN XUAT", "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD",
                        "GIA CA");
                for (Thuoc thuocHetHan : hetHsd) {
                    thuocHetHan.inThongTinThuoc();
                }
                System.out.println("\u001B[32m" + "-".repeat(133) + "\u001B[0m");
            }

        } while (find_option != 0);

    }

    // ------------- @OVERRIDE O DAY ------------------

    @Override
    public void Them(int soThuocCanThem) {
        this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc + soThuocCanThem);

        for (int i = 0; i < soThuocCanThem; i++) {
            System.out.println("\t\t\tThuoc them thu " + i);
            System.out.print("\t\t\tNhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
            int loaiThuocCanThem = mayScanner.nextInt();
            while (loaiThuocCanThem < 0 || loaiThuocCanThem > 1) {
                System.out.println("\t\t\tBan da nhap sai loai thuoc can them");
                System.out.print("\t\t\tNhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
                loaiThuocCanThem = mayScanner.nextInt();
            }
            if (loaiThuocCanThem == 0) {
                THUOCCHICH tempThuocchich = new THUOCCHICH();
                tempThuocchich.nhapThongTinThuoc();
                this.themThuoc(tempThuocchich);
            }

            else if (loaiThuocCanThem == 1) {
                THUOCVI tempThuocvi = new THUOCVI();
                tempThuocvi.nhapThongTinThuoc();
                this.themThuoc(tempThuocvi);
            }
        }
    }

    @Override
    public void Xoa(String maThuocCanXoa) {
        int index = 0;
        boolean isSuccess = false;
        for (int i = 0; i < this.dsThuoc.length; i++) {
            if (this.dsThuoc[i].getMaThuoc().indexOf(maThuocCanXoa) != -1) { // da tim thay
                isSuccess = true;
                index = i;
                break;
            }
        }
        if (isSuccess) {
            this.xoaThuoc(index);
            System.out.println("\t\t\tDa xoa thanh cong!\n");

        } else {
            System.out.println("\t\t\tXoa that bai do khong tim thay ma thuoc yeu cau\n");
        }
    }

    @Override
    public void Sua(String maThuocCanSua) {
        boolean isFind = false;
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (maThuocCanSua.equals(this.dsThuoc[i].getMaThuoc())) {
                this.dsThuoc[i].suaThongTinThuoc();
                isFind = true;
            }
        }
        if (!isFind)
            System.out.println("Khong tim thay ma can sua");
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
            String tempMaThuoc = danhSachThuocTinh[0];
            String tempMaNhaSanXuat = danhSachThuocTinh[1];
            String tempTenThuoc = danhSachThuocTinh[2];
            int tempSoLuong = Integer.parseInt(danhSachThuocTinh[3]);
            LocalDate tempNgaySanXuat = LocalDate.parse(danhSachThuocTinh[4], formatter);
            LocalDate tempHanSuDung = LocalDate.parse(danhSachThuocTinh[5], formatter);
            double tempGiaCa = Double.parseDouble(danhSachThuocTinh[6]);
            if (danhSachThuocTinh.length == 8) {
                int tempDungTichThuoc = Integer.parseInt(danhSachThuocTinh[7]);
                THUOCCHICH newThuocChich = new THUOCCHICH(tempMaThuoc, tempMaNhaSanXuat, tempTenThuoc, tempSoLuong,
                        tempNgaySanXuat, tempHanSuDung, tempGiaCa, tempDungTichThuoc);
                this.themThuoc(newThuocChich);
            }
            if (danhSachThuocTinh.length == 9) {
                int tempSoLuongVi = Integer.parseInt(danhSachThuocTinh[7]);
                int tempSoThuocMoiVi = Integer.parseInt(danhSachThuocTinh[8]);
                THUOCVI newThuocVi = new THUOCVI(tempMaThuoc, tempMaNhaSanXuat, tempTenThuoc, tempSoLuong,
                        tempNgaySanXuat, tempHanSuDung, tempGiaCa, tempSoLuongVi, tempSoThuocMoiVi);
                this.themThuoc(newThuocVi);
            }
        }
        fileScanner.close();
    }

    @Override
    public void ghiData(String filePath) {

        File dataFile = new File(filePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(dataFile);
            for (int i = 0; i < soLuongThuoc; i++) {
                writer.write(getDataThuoc(i) + "\n");
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
            System.out.println("\t\t" + "-".repeat(5) + " TRINH QUAN LI DANH SACH THUOC " + "-".repeat(5));
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("\t\tNhap 1 de them thuoc");
            System.out.println("\t\tNhap 2 de xoa thuoc");
            System.out.println("\t\tNhap 3 de sua thuoc");
            System.out.println("\t\tNhap 4 de thong ke va tim kiem thuoc");
            System.out.println("\t\tNhap 5 de in danh sach thuoc");
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
                System.out.print("\t\t\tNhap so thuoc can them: ");
                int soThuocCanThem = mayScanner.nextInt();
                this.Them(soThuocCanThem);
                this.ghiData("data/dataThuoc.txt");
            }

            if (option == 2) {
                mayScanner.nextLine();
                System.out.print("\t\t\tNhap ma thuoc can xoa: ");
                String maThuocCanXoa = mayScanner.nextLine();

                this.Xoa(maThuocCanXoa);
                this.ghiData("data/dataThuoc.txt");
            }

            if (option == 3) {
                mayScanner.nextLine();
                System.out.print("\t\t\tNhap ma thuoc can sua: ");
                String maThuocCanSua = mayScanner.nextLine();

                this.Sua(maThuocCanSua);
                this.ghiData("data/dataThuoc.txt");
            }

            if (option == 4) {
                findOption();
            }

            if (option == 5) {
                this.inDanhSachThuoc();
            }

        } while (option != 0);
    }

}
