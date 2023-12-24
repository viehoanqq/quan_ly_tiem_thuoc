package DONTHUOC;
import java.util.Arrays;
import java.util.Scanner;

import THUOC.DANHSACHTHUOC;
import THUOC.THUOCCHICH;
import THUOC.THUOCVI;
import THUOC.Thuoc;

public class DONTHUOC {
    private String maDonThuoc;
    private Thuoc[] dst;
    private int soLuongThuocBoc;
    private double donGia;

    public DONTHUOC() {
        maDonThuoc = null;
        soLuongThuocBoc = 0;
        donGia = 0;
    }

    public DONTHUOC(String ma, Thuoc[] thuoc, int sl, double gia) {
        this.maDonThuoc = ma;
        this.dst = thuoc;
        this.soLuongThuocBoc = sl;
        this.donGia = gia;
    }

    public DONTHUOC(DONTHUOC dt) {
        this.maDonThuoc = dt.maDonThuoc;
        this.dst = dt.dst;
        this.soLuongThuocBoc = dt.soLuongThuocBoc;
        this.donGia = dt.donGia;
    }

    public void them() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma don thuoc: ");
        maDonThuoc = input.nextLine();
        System.out.print("So loai thuoc boc: ");
        soLuongThuocBoc = input.nextInt();
        dst = new Thuoc[soLuongThuocBoc];
        input.nextLine();
        for (int i = 0; i < soLuongThuocBoc; i++) {

            System.out.print("Thuoc " + (i + 1) + " : ");
            System.out.println("0: Thuoc chinh ");
            System.out.println("1: Thuoc vi ");
            int option = input.nextInt();
            input.nextLine();
            if (option ==0 )
            {
                dst[i] = new THUOCCHICH();
            }
            if (option ==1 )
            {
                dst[i] = new THUOCVI();
            }
            System.out.print("Ma: ");
            DANHSACHTHUOC dstchinh = new DANHSACHTHUOC();
            try{
                dstchinh.docData("data\\dataThuoc.txt");
            } catch ( Exception e){
            }
            String ma = input.nextLine();
            if (dstchinh.isExists(ma) == 0) {
                System.out.println("Thuoc khong ton tai ! Nhap lai!");
                them();
            } else {
                dst[i].setMaThuoc(ma);
                dst[i].setTenThuoc(dstchinh.getTenThuocTheoMa(ma));
                System.out.print("So luong: ");
                int soluong = input.nextInt();
                input.nextLine();
                if ((soluong >= 0) && soluong <= dstchinh.getSoLuongThuocTheoLoai(ma)) {
                    dst[i].setSoLuong(soluong);
                    dst[i].setGiaCa(dstchinh.getGiaCaTheoMa(ma));
                    // tinh don gia
                    donGia += dst[i].getGiaCa() * dst[i].getSoLuong();
                    dstchinh.themSoLuongChoThuoc(ma, -1*soluong);
                    try{
                        dstchinh.ghiData("data\\dataThuoc.txt");
                    } catch ( Exception e){
                        
                    }
                

                } else {
                    System.out.println("So luong thuoc khong phu hop!");
                    them();
                }

            }

        }
    }

    public void xuat() {
        Scanner input = new Scanner(System.in);
        System.out.format("=".repeat(100) + "\n");
        System.out.format("|| %-103s || \n", "\u001B[34mMa don thuoc: " + maDonThuoc + "\u001B[0m");
        System.out.format("|| %-94s || \n", "So loai thuoc boc: " + soLuongThuocBoc);
        System.out.format("|| %-10s %-15s %-35s %-15s %-15s ||\n", "STT", "Ma", "Ten", "So luong", "gia ca");
        for (int i = 0; i < soLuongThuocBoc; i++) {
            System.out.format("|| %-10s %-15s %-35s %-15s %-15s ||\n", i + 1, dst[i].getMaThuoc(), dst[i].getTenThuoc(),
                    dst[i].getSoLuong(), dst[i].getGiaCa());
        }
        System.out.format("|| %-94s || \n", "DON GIA: " + donGia);
        System.out.format("=".repeat(100) + "\n");
    }

    public void xuaHD() {
        Scanner input = new Scanner(System.in);
        System.out.format("-".repeat(100) + "\n");
        System.out.format("|| %-10s %-15s %-35s %-15s %-15s ||\n", "STT", "Ma", "Ten", "So luong", "gia ca");
        for (int i = 0; i < soLuongThuocBoc; i++) {
            System.out.format("|| %-10s %-15s %-35s %-15s %-15s ||\n", i + 1, dst[i].getMaThuoc(), dst[i].getTenThuoc(),
                    dst[i].getSoLuong(), dst[i].getGiaCa());
        }
        System.out.format("|| %53s %-40s ||\n", " ", "Tong Tien Thuoc : " + donGia);
        System.out.format("-".repeat(100) + "\n");
    }

    public String getThongTin() {
        String s = maDonThuoc + "," + soLuongThuocBoc;
        for (int i = 0; i < soLuongThuocBoc; i++) {
            if (dst[i] == null)
                return null;
            s = s + "," + dst[i].getMaThuoc() + "," + dst[i].getTenThuoc() + "," + dst[i].getGiaCa() + ","
                    + dst[i].getSoLuong();
        }
        s = s + "," + donGia;
        return s;
    }

    public String getMaDonThuoc() {
        return maDonThuoc;
    }

    public void setMaDonThuoc(String maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public Thuoc[] getDst() {
        return dst;
    }

    public void setDst(int soluong, Thuoc[] newdst) {
        this.dst = new Thuoc[soLuongThuocBoc + soluong];
        this.dst = newdst;
        soLuongThuocBoc += soluong;

    }

    public int getSoLuongThuocBoc() {
        return soLuongThuocBoc;
    }

    public void setSoLuongThuocBoc(int soLuongThuocBoc) {
        this.soLuongThuocBoc = soLuongThuocBoc;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

}