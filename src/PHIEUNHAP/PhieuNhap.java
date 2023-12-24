package PHIEUNHAP;


import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import NHACUNGCAP.DANHSACHNHACUNGCAP;
 class PHIEUNHAP {
    private String maPhieuNhap;
    private String[] maCTPhieuNhap;
    private String maNhanVien, maNhaCungCap;
    private LocalDate ngayNhap;
    private double tongTien=0;
    public PHIEUNHAP() {
        maPhieuNhap = null;
        maCTPhieuNhap = null;
        maNhaCungCap = null;
        maNhanVien = null;
        ngayNhap = null;
        tongTien = 0;
    }

    public PHIEUNHAP(String mpn, String[] mctpn, String mnv, String mncc, LocalDate nn) {
        maPhieuNhap = mpn;
        maCTPhieuNhap = mctpn;
        maNhanVien = mnv;
        maNhaCungCap = mncc;
        ngayNhap = nn;

    }

    public double tongtien() {
        return this.tongTien;
    }
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma Phieu nhap:");
        maPhieuNhap = input.nextLine();
        System.out.print("So phieu nhap: ");
        int n = input.nextInt();
        maCTPhieuNhap = new String[n];
        input.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Ma chi tiet phieu nhap: ");
            maCTPhieuNhap[i] = new String();
            maCTPhieuNhap[i] = input.nextLine();
        
            // doc file chi tiet phieu nhap xem ma nay co ton tai khong !
            File file = new File("data\\chitietphieunhap.txt");
            Scanner read = null;
            try {
                read = new Scanner(file);
            } catch (Exception e) {
                System.out.println("loi doc file!");
                return;
            }
            if (read.hasNextLine()) {
                read.nextLine();
            } else{
                read.close();
                return;
            }
            boolean flag = false;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String arr[] = line.split(",");
                    if (arr[0].equals(maCTPhieuNhap[i])) {
                        flag = true;
                        tongTien = tongTien + Double.parseDouble(arr[arr.length-1]);
                    }
                }
            if (!flag)
            {
                System.out.println("khong tim thay ma!");
                nhap();
            } 
             read.close();
        
        }
        System.out.print("Ma nhan vien: ");
        maNhanVien = input.nextLine();
        File f = new File("data\\NhanVien.txt");
        Scanner readf = null;
        try {
            readf = new Scanner(f);
        } catch (Exception e) {
            System.out.println("loi doc file nhan vien!");
            return;
        }
        if (readf.hasNextLine()) {
            readf.nextLine();
        } else {
            nhap();
        }

        boolean flag1 = false;
        boolean onlineFlag = false;
        while (readf.hasNextLine()) {
            String line1 = readf.nextLine();
            String[] arr1 = line1.split(",");
            if (arr1[0].equals(maNhanVien))
                flag1 = true;
            if (Boolean.parseBoolean(arr1[8])) {
                onlineFlag = true;
            }

        }
        if (!flag1)
                {
                    System.out.println("khong tim thay nhan vien nay!");
                    return;
                }
        if (!onlineFlag) {
            System.out.println("Nhan vien nay khong hoat dong!");
        }
        readf.close();

        System.out.print("Ma nha cung cap: ");
        maNhaCungCap = input.nextLine();
        //doc nha cung cap de xem nha cung cap co ton tai trong du lieu khong!
        File filencc = new File("data\\nhacungcap.txt" );
        Scanner readncc = null;
        try{ readncc = new Scanner(filencc);} catch(Exception e){System.out.println("loi doc file nha cung cap");}
        String soLuongNCC = readncc.nextLine();
        boolean falgNCC=false;
        while(readncc.hasNextLine())
        {
            String linencc = readncc.nextLine();
            String arrncc[] = linencc.split(",");

            if (maNhaCungCap.toUpperCase().equals(arrncc[0].toUpperCase()))
            falgNCC =true;
        }
        if (!falgNCC)
        {
            System.out.println("Nha cung cap nay khong ton tai! ");
            System.out.println("1/ them nha cung cap \n2/Nhap lai!");
            System.out.print("Lua chon:");
            int luachon= input.nextInt();
            if (luachon ==1) 
            {
                DANHSACHNHACUNGCAP ncc = new DANHSACHNHACUNGCAP();
                ncc.them();
                nhap();
            }
            else if (luachon ==2) 
            {   
                nhap();
            }
            else return;
            
        }
        System.out.print("Ngay nhap (yyyy-mm-dd): ");
        String ngayNhapTemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngayNhap = LocalDate.parse(ngayNhapTemp, formatter);
    }

    public void xuatPhieuNhap() {

        System.out.println("========= PHIEU NHAP HANG =========");
        System.out.format( "|| %-29s ||\n","Ma phieu nhap : " + maPhieuNhap.trim());
        ;
        System.out.format( "|| %-29s ||\n","Ma chi tiet phieu nhap : ");
        for (int i=0;i<maCTPhieuNhap.length;i++)
        {
            System.out.format( "|| %-29s ||\n"," - "+ maCTPhieuNhap[i]);
        }
        System.out.format( "|| %-29s ||\n","Ma nhan vien : " + maNhanVien);
        System.out.format( "|| %-29s ||\n","Ma nha cung cap : " + maNhaCungCap);
        System.out.format( "|| %-29s ||\n","Ngay nhap: " + ngayNhap);
        System.out.format( "|| %-29s ||\n","");
        System.out.format( "|| %-29s ||\n","   --- CHI TIET ---   ");
        System.out.format( "|| %-9s %-9S %-9s ||\n","Ten","SOLUONG","GIA");
        File file = new File("data\\chitietphieunhap.txt");
        Scanner read = null;
        try {
            read = new Scanner(file);
        } catch (Exception e) {
            System.out.println("loi doc file!");
            return;
        }

        String soLuong = read.nextLine();
        String temp = "";
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String arr[] = line.split(",");
            for (int k=0;k<maCTPhieuNhap.length;k++){
            if (arr[0].equals(maCTPhieuNhap[k])) {
                for (int i = 2; i <= arr.length - 2; i++) {
                    temp+= arr[i]+"     ";
                    if (i%3==1) temp+="\n|| ";
                }
                System.out.format( "|| %-29s ||\n",temp);
                temp="";

               
            }
            }

        }
        System.out.format( "|| %-29s ||\n","Tong tien nhap hang : "+ tongTien);
        System.out.println("===================================");
        read.close();

    }

    // SET
    public void setMaPhieuNhap(String data) {
        maPhieuNhap = data;
    }

    public void setMaCTPhieuNhap(String[] data) {
        maCTPhieuNhap = data;
    }

    public void setMaNhanVien(String data) {
        maNhanVien = data;
    }

    public void setMaNhaCungCap(String data) {
        maNhaCungCap = data;
    }

    public void setNgayNhap(LocalDate data) {
        ngayNhap = data;
    }

    public void setTongTien(Double data) {
        tongTien = data;
    }

    // get
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public String[] getMaChiTietPhieuNhap() {
        return maCTPhieuNhap;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public String getLine() {
        String s = "";
        s = s + maPhieuNhap + "," + maNhanVien + "," + maNhaCungCap + "," + ngayNhap + ","+maCTPhieuNhap.length;
        for (int i=0;i<maCTPhieuNhap.length;i++)
        {
            s=s+","+maCTPhieuNhap[i];
        }
        s=s+","+tongTien;
     
        return s;
    }

}
