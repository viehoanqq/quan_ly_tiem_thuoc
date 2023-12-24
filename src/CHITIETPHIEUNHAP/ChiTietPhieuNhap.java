package CHITIETPHIEUNHAP;

import THUOC.THUOCCHICH;
import THUOC.THUOCVI;
import THUOC.Thuoc;
import THUOC.DANHSACHTHUOC;
import java.io.File;
import java.util.Scanner;

class CHITIETPHIEUNHAP {
    private String maCTPhieuNhap;
    Thuoc[] dsThuocNhap;
    int soLoaiThuocNhap;
    double thanhTien;

    // 3 HÀM KHƠI TẠO
    public CHITIETPHIEUNHAP() {
        maCTPhieuNhap = null;
        thanhTien = 0;
        soLoaiThuocNhap = 0;
        dsThuocNhap = new Thuoc[0];
        thanhTien = 0;
    }

    public CHITIETPHIEUNHAP(CHITIETPHIEUNHAP ctpn) {
        maCTPhieuNhap = ctpn.maCTPhieuNhap;
        dsThuocNhap = ctpn.dsThuocNhap;
        soLoaiThuocNhap = ctpn.soLoaiThuocNhap;
        thanhTien = ctpn.thanhTien;

    }

    // HÀM NHẬP
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma phieu nhap: ");
        maCTPhieuNhap = input.nextLine();
        System.out.print("So loai thuoc nhap: ");
        soLoaiThuocNhap = input.nextInt();
        dsThuocNhap = new Thuoc[soLoaiThuocNhap];
        input.nextLine();
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            System.out.print("Nhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
            int typeThuoc = input.nextInt();
            if (typeThuoc == 0) {
                dsThuocNhap[i] = new THUOCCHICH();

            } else if (typeThuoc == 1) {
                dsThuocNhap[i] = new THUOCVI();
            }
            input.nextLine();
            System.out.print("Ma thuoc: ");
            String maThuoc = input.nextLine();
            // doc data thuoc de check xem thuoc co ton tai hay khong ?
            DANHSACHTHUOC dstchinh = new DANHSACHTHUOC();
            try{
            dstchinh.docData("data\\dataThuoc.txt");
            } catch ( Exception E){
                System.out.println("loi doc file thuoc");

            }
            if (dstchinh.isExists(maThuoc) == 0){
                System.out.println("loi !");
                nhap();
            }
            dsThuocNhap[i].setMaThuoc(maThuoc);
            System.out.print("So luong :");
            int soLuong = input.nextInt();
            dsThuocNhap[i].setSoLuong(soLuong);
            DANHSACHTHUOC ql = new DANHSACHTHUOC();
            ql.themSoLuongChoThuoc(maThuoc, soLuong);
            System.out.print("Gia nhap hang / 1 : ");
            double giaCa = input.nextDouble();
            thanhTien = thanhTien + giaCa * soLuong;
            dsThuocNhap[i].setGiaCa(giaCa);
            dstchinh.themSoLuongChoThuoc(maThuoc, soLuong);
            try{
            dstchinh.ghiData("data\\dataThuoc.txt");
            } catch  (Exception e){
            }

        }
    }

    public void xuatThuocDaNhap() {
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            System.out.println(1 + ": " + dsThuocNhap[i].getMaThuoc() + "        " + dsThuocNhap[i].getSoLuong()
                    + "         " + dsThuocNhap[i].getGiaCa());
        }
    }

    public void xuat() {
        System.out.format( "|| %-29s ||\n","         ===CHI TIET PN===");
        System.out.format( "|| %-29s ||\n","Ma: " + maCTPhieuNhap);
        System.out.format( "|| %-29s ||\n","So loai thuoc: " , soLoaiThuocNhap);
        System.out.format("|| %-29s ||\n" ," ---- CHI TIET ----");
        xuatThuocDaNhap();
         System.out.format( "|| %-29s ||\n","Tong tien: " + thanhTien);
        System.out.println();

    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet phieu nhap can xoa:");
        String ma = input.nextLine();
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            if (dsThuocNhap[i].getMaThuoc().equals(ma)) {
                for (int j = i; j < soLoaiThuocNhap - 1; j++) {
                    dsThuocNhap[i] = dsThuocNhap[i + 1];
                }
            }
        }
        soLoaiThuocNhap--;
    }

    // GET
    public int getSoLoaiThuocNhap() {
        return soLoaiThuocNhap;
    }

    public String getMaCTPhieuNhap() {
        return maCTPhieuNhap;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public Thuoc[] getDanhSachThuocNhap() {
        return dsThuocNhap;
    }

    public String getChuoiThuocNhap() // ham de viet vao file
    {
        String line = maCTPhieuNhap + "," + String.valueOf(soLoaiThuocNhap);
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            line = line + "," + dsThuocNhap[i].getMaThuoc() + "," + dsThuocNhap[i].getSoLuong() + ","
                    + dsThuocNhap[i].getGiaCa();
        }
        line = line + "," + thanhTien;
        return line;
    }

    // SET
    public void setSoLoaiThuocNhap(int sl) {
        soLoaiThuocNhap = sl;
    }

    public void setMaCTPhieuNhap(String data) {
        maCTPhieuNhap = data;
    }

    public void setDanhSachThuocNhap(Thuoc[] data) {
        dsThuocNhap = data;
    }

    public void setThanhTien(Double tt) {
        thanhTien = tt;
    }

    public static void main(String[] args) {
        CHITIETPHIEUNHAP ql = new CHITIETPHIEUNHAP();
        ql.xuat();
    }
}