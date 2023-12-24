package HOADON;
import java.util.Arrays;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DANHSACHHOADON {
    private HOADON[] dshd;
    private int soLuongHoaDon;

    // 3 ham khoi tao
    // get

    // ham ghi file
    public void ghiFile(String path) {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("Loi ghi file ");
            return;
        }
        write.println(soLuongHoaDon);
        for (int i = 0; i < soLuongHoaDon; i++) {
            write.println(dshd[i].getThongTin());
        }
        write.close();
    }

    public void docFile(String path) {
        Scanner read = null;
        File file = new File(path);
        try {
            read = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Loi doc file !");
            return;
        }
        if (!read.hasNextLine())
            return;
        soLuongHoaDon = Integer.parseInt(read.nextLine());
        dshd = new HOADON[soLuongHoaDon];
        int i = 0;
        while (read.hasNextLine()) {
            dshd[i] = new HOADON();
            String line = read.nextLine();
            String[] arr = line.split(",");
            dshd[i].setMaHoaDon(arr[0]);
            dshd[i].setMaDonThuoc(arr[1]);
            dshd[i].setMaPhieuKhamBenh(arr[2]);
            dshd[i].setNVThuNgan(arr[3]);
            dshd[i].setNgayTao(LocalDate.parse(arr[4]));
            dshd[i].setHinhThucThanhToan(arr[5]);
            dshd[i].setTongTien(Double.parseDouble(arr[6]));
            i++;
        }
    }
    public void them() {
        soLuongHoaDon++;
        if (soLuongHoaDon == 1) {
            dshd = new HOADON[1];
            dshd[0] = new HOADON();
            dshd[0].them();
        } else {
            this.dshd = Arrays.copyOf(this.dshd, soLuongHoaDon);
            dshd[soLuongHoaDon - 1] = new HOADON();
            dshd[soLuongHoaDon - 1].them();
        }

    }

    public void xuat() {
        System.out.println("\u001B[34m=".repeat(20) + "[ DANH SACH HOA DON ]" + "=".repeat(20) + "\u001B[0m");
        for (int i = 0; i < soLuongHoaDon; i++) {
            System.out.format("STT: " + (i + 1) + "\n");
            dshd[i].xuat();
            System.out.println();
        }
    }

    public void inCuoi() {
        System.out.println("Hoa don moi nhat : ");
        dshd[dshd.length - 1].xuat();
    }

    public void timKiem() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma can tim kiem: ");
        String ma = input.nextLine();
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (ma.equals(dshd[i].getMaHoaDon())) {
                dshd[i].xuat();
                return;
            }
        }
        System.out.println("Ma thuoc khong ton tai!");
    }

    public int timKiemTheoMa(String ma) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (ma.equals(dshd[i].getMaDonThuoc()))
                return 1;
        }
        return 0;
    }

    public void xuatDonThuocTheoMa(String ma) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (ma.equals(dshd[i].getMaDonThuoc())) {
                dshd[i].xuat();
            }
        }
    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma can xoa: ");
        String ma = input.nextLine();
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (ma.equals(dshd[i].getMaHoaDon())) {
                for (int j = i; j < soLuongHoaDon - 1; j++) {
                    dshd[i] = dshd[i + 1];

                }
                System.out.println("Xoa thanh cong!");
                soLuongHoaDon--;
                return;
            }

        }
        System.out.println("Khong tim thay ma nay ! xoa that bai!!!");

    }

    public void xoa(String ma) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (ma.equals(dshd[i].getMaDonThuoc())) {
                for (int j = i; j < soLuongHoaDon - 1; j++) {
                    dshd[i] = dshd[i + 1];

                }
                System.out.println("Xoa thanh cong!");
                soLuongHoaDon--;
                return;
            }

        }
        System.out.println("Khong tim thay ma nay ! xoa that bai!!!");

    }

    public void thaoTac() {
        System.out.println("TRINH QUAN LY HOA DON");
        System.out.println("0: Thoat");
        System.out.println("1: Them hoa don");
        System.out.println("2: Xuat danh sach hoa don");
        System.out.println("3: tim kiem hoa don");
        System.out.println("4: xoa hoa don");

        System.out.println("5: In hoa don moi tao");

        System.out.print("Lua chon: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        do {
            if (i == 0) {

            }

            if (i == 1) {
                them();
                inCuoi();
            }
            ;
            if (i == 2) {
                xuat();
            }
            ;
            if (i == 3) {
                timKiem();
            }
            if (i == 4) {
                xoa();
            }
            if (i == 5) {
                inCuoi();
            }
            System.out.print("Lua chon: ");
            i = input.nextInt();

        } while (i != 0);
    }

    public static void main(String[] args) {
        DANHSACHHOADON ds = new DANHSACHHOADON();
        ds.docFile("data\\HOADON.txt");
        ds.xuat();
    }



    // public void tongtienHoaDonTheoKhachHang(String maNhanVien) {
    //     double sum = 0;

    //     for(HOADON hd: this.dshd){
    //         hd.getNVThuNgan().equals(maNhanVien);
    //         sum += hd.getTongTien();
    //     }

    //     System.out.println("tong tien theo nhan vien ban " + maNhanVien + " la: " + sum);
    // }
}

