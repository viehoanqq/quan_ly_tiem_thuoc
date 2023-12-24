	package NHACUNGCAP;


import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DANHSACHNHACUNGCAP {
    NHACUNGCAP[] dsncc;
    int soLuongNCC;
    public DANHSACHNHACUNGCAP() {
        dsncc = new NHACUNGCAP[0];
        soLuongNCC = 0;
    }

    public DANHSACHNHACUNGCAP(NHACUNGCAP[] dsncc) {
        this.dsncc = dsncc;
        this.soLuongNCC = dsncc.length;
    }

    public void them(NHACUNGCAP ncc) {
        soLuongNCC++;
        dsncc = Arrays.copyOf(dsncc, soLuongNCC);
        dsncc[soLuongNCC - 1] = ncc;
    }

    public void ghiData(String path) {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("LOi mo file!");
        }
        write.println(soLuongNCC);
        for (int i = 0; i < soLuongNCC; i++) {
            write.println(dsncc[i].getLine());
        }

        write.close();
    }

    public void docData(String path) {
        File file = new File(path);
        Scanner read = null;
        try {
            read = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Khong the mo file!");
        }
        if (read.hasNextLine()) {
            soLuongNCC = Integer.parseInt(read.nextLine());
            dsncc = new NHACUNGCAP[soLuongNCC];
        } else
            return;
        int i = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split(",");
            dsncc[i] = new NHACUNGCAP();
            dsncc[i].setMaNhaCungCap(arr[0]);
            dsncc[i].setTenNhaCungCap(arr[1]);
            dsncc[i].setDiaChi(arr[2]);
            dsncc[i].setSDT(arr[3]);
            i++;
        }
    }

    public void them() {
        Scanner input = new Scanner(System.in);
        soLuongNCC++;
        if (soLuongNCC == 1) {
            dsncc = new NHACUNGCAP[1];
            dsncc[0] = new NHACUNGCAP();
            dsncc[0].nhap();
        } else {
            this.dsncc = Arrays.copyOf(this.dsncc, soLuongNCC);
            dsncc[soLuongNCC - 1] = new NHACUNGCAP();
            dsncc[soLuongNCC - 1].nhap();
        }

    }

    public void xuat() {
        for (int i = 0; i < soLuongNCC; i++) {
            System.out.print((i + 1) + " ");
            dsncc[i].xuat();
            System.out.println();
        }
    }
    public void timKiem()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma nha cung cap: ");
        String ten = input.nextLine();
        for (int i=0;i<soLuongNCC;i++)
        {
            if (ten.equals(dsncc[i].getMaNhaCungCap()))
            {
                dsncc[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap nay!!!");
    }
    public void menuThaoTac()
    {
        int i;
        do
        {
            System.out.println("0: Thoat");
            System.out.println("1: Nhap Nha Cung Cap");
            System.out.println("2: Tim kiem nha cung cap");
            System.out.println("3: Xuat danh sach cac nha Cung Cap");
            System.out.print("Lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch (i) {
                case 1:
                    them();
                    break;
                case 2:
                    timKiem();
                    break;
                case 3: 
                    xuat();
                case 0:
                {
                    
                } break;
            }
        }
        while (i!=0);
    }
    public NHACUNGCAP[] getDsncc() {
        return dsncc;
    }

    public void setDsncc(NHACUNGCAP[] dsncc) {
        this.dsncc = dsncc;
        this.soLuongNCC = dsncc.length;
    }

    public int getSoLuongNCC() {
        return soLuongNCC;
    }

    public void setSoLuongNCC(int soLuongNCC) {
        this.soLuongNCC = soLuongNCC;
    }
}
