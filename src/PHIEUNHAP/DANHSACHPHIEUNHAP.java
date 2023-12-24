package PHIEUNHAP;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DANHSACHPHIEUNHAP {
    private PHIEUNHAP[] dspn;
    private int soLuong = 0;
    // 3 ham khoi tao

    // HAM GHI FILE
    public void ghiFile(String path) {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("loi ghi file!");
        }
        write.println(soLuong);
        for (int i = 0; i < soLuong; i++) {
            write.println(dspn[i].getLine());
        }
        write.close();
    }

    // HAM DOC FILE
    public void docfile(String path) {
        File file = new File(path);
        Scanner read = null;
        try {

            read = new Scanner(file);

        } catch (Exception e) {
            System.out.println("Loi doc file!");
            return;

        }
        if (read.hasNextLine()) {
            soLuong = Integer.parseInt(read.nextLine());
            dspn = new PHIEUNHAP[soLuong];
        } else
            return;
        int i = 0;
        while (read.hasNextLine()) {
            String maCT[];
            dspn[i] = new PHIEUNHAP();
            String line = read.nextLine();
            String[] arr = line.split(",");
            dspn[i].setMaPhieuNhap(arr[0]);
            dspn[i].setMaNhanVien((arr[1]));
            dspn[i].setMaNhaCungCap(arr[2]);
            String ngayNhapTemp = arr[3];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            dspn[i].setNgayNhap(LocalDate.parse(ngayNhapTemp, formatter));
            maCT = new String[Integer.parseInt(arr[4])];
            for (int j = 0; j < Integer.parseInt(arr[4]); j++)
                maCT[j] = arr[5 + j];
            dspn[i].setMaCTPhieuNhap(maCT);
            dspn[i].setTongTien(Double.parseDouble(arr[arr.length - 1]));
            i++;

        }
        read.close();

    }

    public void them() {

        soLuong++;
        if (soLuong == 1) {
            dspn = new PHIEUNHAP[1];
            dspn[0] = new PHIEUNHAP();
            dspn[0].nhap();
        } else {
            this.dspn = Arrays.copyOf(this.dspn, soLuong);
            dspn[soLuong - 1] = new PHIEUNHAP();
            dspn[soLuong - 1].nhap();

        }
    }

    public void xuat() {

        for (int i = 0; i < soLuong; i++) {
            dspn[i].xuatPhieuNhap();
            System.out.println();
        }
    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap ma phieu nhap:");
        String ma = input.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ma.equals(dspn[i].getMaPhieuNhap())) {
                for (int j = i; j < soLuong - 1; j++) {
                    dspn[j] = dspn[j + 1];
                }
                soLuong--;
            }
        }
    }

    public void timKiem() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma: ");
        String ma = input.nextLine();
        boolean flag = true;
        for (int i = 0; i < soLuong; i++) {
            if (ma.equals(dspn[i].getMaPhieuNhap())) {
                dspn[i].xuatPhieuNhap();
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Khong tim thấy phieu nhap!");
        }
       

    }

    public void timKiemTheoNgayToiNgay() {
        LocalDate ngaydau;
        LocalDate ngaycuoi;
        Scanner input = new Scanner(System.in);
        System.out.println("ngay dau (yyyy-MM-dd):");
        String ngaydautemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngaydau = LocalDate.parse(ngaydautemp, formatter);
        System.out.println("Ngay cuoi (yyyy-MM-dd) ");
        String ngaycuoitemp = input.nextLine();
        ngaycuoi = LocalDate.parse(ngaycuoitemp, formatter);
        int ngay = ngaydau.getDayOfMonth();
        int thang = ngaydau.getMonthValue();
        int nam = ngaydau.getYear();
        while (!ngaydau.isEqual(ngaycuoi)) {
            ngay++;
            ngaydau = LocalDate.of(nam, thang, ngay);
            for (int i = 0; i < soLuong; i++) {
                if (ngaydau.isEqual(dspn[i].getNgayNhap())) {
                    dspn[i].xuatPhieuNhap();
                    System.out.println();
                }
            }
            if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
                if (ngay == 31) {
                    if (thang == 12) {
                        nam++;
                        thang = 1;
                        ngay = 0;

                    } else {
                        ngay = 0;
                        thang++;
                    }
                }

            } else if (thang == 2) {
                if ((nam % 400 == 0 || nam % 4 == 0) && nam % 100 != 0) {
                    if (ngay == 29) {
                        ngay = 0;
                        thang++;
                    }
                } else {
                    if (ngay == 28) {
                        ngay = 0;
                        thang++;
                    }
                }
            } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
                if (ngay == 30) {
                    ngay = 0;
                    thang++;
                }
            }

        }
        

    }
    

    public void timKiem(String ma) {

        boolean flag = true;
        for (int i = 0; i < soLuong; i++) {
            if (ma.equals(dspn[i].getMaPhieuNhap())) {
                dspn[i].xuatPhieuNhap();
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Khong tim thhay phieu nhap!");
        }

    }

    public void timKiemTheoNgay() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ngay can tim kiem");
        String ngayTemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngay = LocalDate.parse(ngayTemp, formatter);
        boolean flag = true;
        System.out.println("Ket qua: ");
        for (int i = 0; i < soLuong; i++) {
            if (ngay.equals(dspn[i].getNgayNhap())) {
                dspn[i].xuatPhieuNhap();
                flag = false;
            }
        }
        if (flag)
            System.out.println("Ngay " + ngay + " khong co du lieu!");
        

    }

    public void thongKeTheoThang() {
        System.out.println("------ THONG KE THEO CAC THANG ------");
        for (int i = 1; i <= 12; i++) {
            boolean flag = false;
            for (int j = 0; j < soLuong; j++) {
                if (dspn[j].getNgayNhap().getMonthValue() == i) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("thang " + i + " :");
                for (int k = 0; k < soLuong; k++) {
                    if (dspn[k].getNgayNhap().getMonthValue() == i) {

                        System.out.println(dspn[k].getLine());

                    }
                }
                System.out.println();
            }
        }
    }

    public void thaoTac() {
        System.out.println("\u001B[34m\n\t\t ==>MENU QUAN LY PHIEU NHAP: ");
        System.out.println("\t\t0: BACK");
        System.out.println("\t\t1: Them phieu nhap");
        System.out.println("\t\t2: Xoa phieu nhap");
        System.out.println("\t\t3: Tim kiem phieu nhap");
        System.out.println("\t\t4: Thong ke theo thang");
        System.out.println("\t\t5: In danh sach phieu nhap \u001B[0m");
        int i;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("\t\tlua chon: ");
            i = input.nextInt();
            switch (i) {
                case 0:
                    {}
                    break;
                case 1:
                    them();
                    break;
                case 2:
                    xoa();
                    break;
                case 3:
                    System.out.println("TIM KIEM :");
                    System.out.println("0. BACK");
                    System.out.println("1. tim theo ma ");
                    System.out.println("2. tim theo ngay");
                    System.out.println("3. Tim kiem theo ngay toi ngay");
                    System.out.print("Lua chon: ");
                    int dem = input.nextInt();
                    input.nextLine();
                    switch (dem) {
                        case 0:
                            break;
                        case 1:
                            timKiem();
                            break;
                        case 2:
                            timKiemTheoNgay();
                            break;
                        case 3:
                            timKiemTheoNgayToiNgay();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    thongKeTheoThang();
                    break;
                case 5:
                    xuat();
                    break;
            }
        } while (i != 0);
    }


    public void ABC() {
        Scanner mayScanner = new Scanner(System.in);
        
        System.out.println("Nhap ngay bat dau(yyyy-MM-dd): ");
        String tempNgayBatDau = mayScanner.nextLine();

        System.out.println("Nhap ngay ket thuc: ");
        String tempNgayKetThuc = mayScanner.nextLine();

        LocalDate ngayBatDau = LocalDate.parse(tempNgayBatDau);
        LocalDate ngayKetThuc = LocalDate.parse(tempNgayKetThuc);



        double sum = 0;
        for(PHIEUNHAP pn : this.dspn) {
            if(pn.getNgayNhap().isBefore(ngayKetThuc) && pn.getNgayNhap().isAfter(ngayBatDau)) {
                sum += pn.tongtien();
            }
        }

        System.out.println("Tong tien la: " + sum);

        

    } // xuat ra phieu nhap tu ngay den ngay
    


}
