package CHITIETPHIEUNHAP;


import java.util.Arrays;
import java.util.Scanner;

import java.io.*;

import THUOC.THUOCVI;
import THUOC.Thuoc;

public class DANHSACHCHITHIETPHIEUNHAP {
    private CHITIETPHIEUNHAP[] dsctpn;
    private int soLuong = 0;

    // 3 ham khoi tao
    // HAM DOC FILE
    public void docfile(String path) {
        Scanner read = null;
        File file = new File(path);
        try {
            read = new Scanner(file);

        } catch (Exception e) {
            System.out.println("Loi doc file!");
            e.printStackTrace();

        }
        if (read.hasNextLine()) {
            soLuong= Integer.parseInt(read.nextLine());
            dsctpn = new CHITIETPHIEUNHAP[soLuong];
        } else
            return;
        int i = 0;

        while (read.hasNextLine()) {
            dsctpn[i] = new CHITIETPHIEUNHAP();
            String line = read.nextLine();
            String[] arr = line.split(",");
            dsctpn[i].setMaCTPhieuNhap(arr[0]);
            dsctpn[i].setSoLoaiThuocNhap(Integer.parseInt(arr[1]));
            dsctpn[i].dsThuocNhap = new Thuoc[Integer.parseInt(arr[1])];
            for (int j = 0; j < dsctpn[i].getSoLoaiThuocNhap(); j++) {
                dsctpn[i].dsThuocNhap[j] = new THUOCVI();
                dsctpn[i].dsThuocNhap[j].setMaThuoc(arr[j * 3 + 2]);
                dsctpn[i].dsThuocNhap[j].setSoLuong(Integer.parseInt(arr[j * 3 + 3]));
                dsctpn[i].dsThuocNhap[j].setGiaCa(Double.parseDouble(arr[j * 3 + 4]));
                dsctpn[i].setThanhTien(Double.parseDouble(arr[arr.length - 1]));

            }
            i++;

        }
        read.close();

    }

    // HAM GHI FILE
    public void ghiFile(String path) {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.print("Loi ghi file!");
        }
        write.println(soLuong);
        for (int i = 0; i < soLuong; i++) {
            write.print(dsctpn[i].getChuoiThuocNhap());
            write.println();
        }
        write.close();
    }

    // HAM THEM
    public void them() {

        soLuong++;
        if (soLuong == 1) {
            dsctpn = new CHITIETPHIEUNHAP[1];
            dsctpn[0] = new CHITIETPHIEUNHAP();
            dsctpn[0].nhap();
        } else {
            this.dsctpn = Arrays.copyOf(this.dsctpn, soLuong);
            dsctpn[soLuong - 1] = new CHITIETPHIEUNHAP();
            dsctpn[soLuong - 1].nhap();
        }
    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap ma phieu nhap:");
        String ma = input.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ma.equals(dsctpn[i].getMaCTPhieuNhap())) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsctpn[j] = dsctpn[j + 1];
                }
                soLuong--;
            }
        }
    }

    public void timKiem() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet nhap hang can tim kiem: ");
        String ma = input.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (dsctpn[i].getMaCTPhieuNhap().equals(ma)) {
                dsctpn[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay !");
    }

    public void xuat() {
        for (int i = 0; i < soLuong; i++) {
            dsctpn[i].xuat();
            System.out.println();
        }
    }

    public void thaoTac() {
        System.out.println("\u001B[34m\n\t\t==> QUAN LY CHI TIET PHIEU NHAP:");
        System.out.println("\t\t0: BACK");
        System.out.println("\t\t1: Them chi tiet phieu nhap");
        System.out.println("\t\t2: Xoa chi tiet phieu nhap");
        System.out.println("\t\t3: Tim kiem tiet phieu nhap");
        System.out.println("\t\t4: Xem tat ca chi tiet phieu nhap \u001B[0m");
        int i;
        do {
            System.out.print("\t\tlua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch (i) {
                case 0: {
                    
                } break;
                case 1: {
                    them();
                }
                    break;

                case 2: {
                    xoa();
                }
                    break;
                case 3: {
                    timKiem();
                }
                    break;
                case 4: {
                    xuat();
                }
                    break;

            }
        } while (i != 0);
    }
    
}
