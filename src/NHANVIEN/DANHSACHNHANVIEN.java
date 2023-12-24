package NHANVIEN;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DANHSACHNHANVIEN {
    private NHANVIEN[] dsnv = new NHANVIEN[1];
    private int soLuongNV;
    Scanner input = new Scanner(System.in);
    public DANHSACHNHANVIEN()
    {
        soLuongNV = 0;
        dsnv[0] = new NHANVIEN();
        dsnv[0] = null;
    }
    DANHSACHNHANVIEN(NHANVIEN [] ds, int sl)
    {
        dsnv = ds;
        soLuongNV = sl;
    }
    DANHSACHNHANVIEN(DANHSACHNHANVIEN ds)
    {
        dsnv = ds.dsnv;
        soLuongNV = ds.soLuongNV;
    }


    void ghiData(String path)
    {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("loi ghi file!");
        }
        write.println(soLuongNV);
        for (int i = 0; i < soLuongNV; i++) {
            write.println(dsnv[i].getThongTin());
        }
        write.close();
    }
    void nhap()
        {
            Scanner input = new Scanner(System.in);
            System.out.print(" - So nhan vien: "); 
            soLuongNV = input.nextInt();
            dsnv = new NHANVIEN[soLuongNV];
            for (int i=0;i<soLuongNV;i++)
            {
                dsnv[i] = new NHANVIEN();
                System.out.print("Nhan vien ["+(i+1)+"] :\n");
                dsnv[i].nhap();
                System.out.print("\n");
            }
        }
        public void docData(String path)
        {
            File inFile = new File(path);
            Scanner read = null;
            try
            {
                read = new Scanner(inFile);
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file NhanVien.txt");
                return ;
            }
            String sl = read.nextLine();
            soLuongNV = Integer.parseInt(sl);
            dsnv = new NHANVIEN[soLuongNV];
            for (int i=0;i<soLuongNV;i++)
            {
                dsnv[i] = new NHANVIEN();
                String line = read.nextLine();
                String [] str = line.split(",");
                dsnv[i].setMaNV(str[0]);
                dsnv[i].setHo(str[1]);
                dsnv[i].setTen(str[2]);
                dsnv[i].setGioiTinh(str[3]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ngaySinh = LocalDate.parse(str[4], formatter);
                dsnv[i].setNgaySinh(ngaySinh);
                dsnv[i].setChucVu(str[5]);
                dsnv[i].setHeSoLuong(Double.parseDouble(str[6]));
                dsnv[i].setSDT(str[7]);
                dsnv[i].setHoatDong(Boolean.parseBoolean(str[8]));
            }
            read.close();
        }
    void xuat()
        {
            System.out.println("===================================================================[ DANH SACH NHAN VIEN ]=========================================================================");
            System.out.format("|| %1s | %15s | %28s | %10s | %5s | %15s | %15s | %13s | %10s | %15s ||\n", "STT", "MA NV", "HO", "TEN", "GIOI TINH", "NGAY SINH", "CHUC VU", "HE SO LUONG", "SDT", "HOAT DONG");
            for (int i=0;i<soLuongNV;i++)
            {
                System.out.format("|| %3s |", (i + 1));
                dsnv[i].xuat();
            }
             System.out.println("====================================================================================================================================================================");
        }


    void them()
    {
        dsnv= Arrays.copyOf(dsnv,soLuongNV+1);
        dsnv[soLuongNV] = new NHANVIEN();
        dsnv[soLuongNV].nhap();
        soLuongNV++;
    }

    void sua()
    {
        Scanner input = new Scanner(System.in);
        System.out.print(" - Nhap ma nhan vien can sua: ");
        String ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            
            {
                flag = true;
                dsnv[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");
        
    }

    
    void sua(String ma)
    {
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            
            {
                flag = true;
                dsnv[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");;


    }
    boolean locThongTin(String line,String s)
    {
        if (line.indexOf(s) == -1)
        return false;
        else
        return true;
    }




    void xoa()
    {
        System.out.print(" - Nhap ma nhan vien can xoa: ");
        Scanner input = new Scanner(System.in);
        String ma;
        ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            {
                flag = true;
                for (int j=i;j<soLuongNV-1;j++)
                {
                    dsnv[j] = dsnv [ j+1];
                }
                soLuongNV--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }

    }



    void xoa(String ma)
    {

        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            {
                flag = true;
                for (int j=i;j<soLuongNV-1;j++)
                {
                    dsnv[j] = dsnv [ j+1];
                }
                soLuongNV--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }
    }

    public NHANVIEN timkiem()
    {
        Scanner input = new Scanner(System.in);
        System.out.print(" - Nhap ma nhan vien hoac ten nhan vien can tim kiem: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongNV;i++)
        {
            if ((ma.equals(dsnv[i].getMaNV())) || (ma.equals(dsnv[i].getTen())) )
            {
                return dsnv[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        NHANVIEN nv = new NHANVIEN();
        return nv;
    }

    public NHANVIEN timkiem(String ma)
    {
       for (int i=0;i<soLuongNV;i++)
        {
            if ((ma.equals(dsnv[i].getMaNV())) || (ma.equals(dsnv[i].getTen())) )
            {
                return dsnv[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        NHANVIEN nv = new NHANVIEN();
        return nv;
    }
    public int kiemTraMaNhanVien(String ma){
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV())){
                return 1;
            }
        }
        return 0;
    }
    public void thongKeHoatDong()
    {
        int hd =0;
        for (int i=0;i<soLuongNV;i++)
        {
            if (dsnv[i].getHoatDong())
            {
                hd++;
            }
        }
        System.out.print("So nhan vien dang hoat dong: "+ hd +" : ");
        for (int i=0;i<soLuongNV;i++)
        {
            if (dsnv[i].getHoatDong())
            {
                System.out.print(dsnv[i].getHo()+" "+dsnv[i].getTen()+"  ,  ");
            }
        }

        System.out.print("\n");
        System.out.print("So nhan vien khong hoat dong: "+ (soLuongNV - hd) +" : ");
        for (int i=0;i<soLuongNV;i++)
        {
            if (!dsnv[i].getHoatDong())
            {
                System.out.print(dsnv[i].getHo()+" "+dsnv[i].getTen()+"  ,  ");
            }
        }
        System.out.println("\n");

    }



     public void menu()
    {
    System.out.println("[==============  QUAN LY NHAN VIEN ============]");
    System.out.println(" 0. Quay tro lai");    
    System.out.println(" 1. Xem danh sach nhan vien");
    System.out.println(" 2. Them nhan vien");
    System.out.println(" 3. Xoa nhan vien");
    System.out.println(" 4. Sua thong tin nhan vien");
    System.out.println(" 5. Tim kiem nhan vien");
    System.out.println(" 6. Thong ke hoat dong cua nhan vien");
    System.out.println(" 7. Nhap danh sach nhan vien");
    int k=1;
    while (k!=0)
    {
    System.out.print("Lua chon: ");
    k = input.nextInt();
    switch(k)
        {
            case 0:
            {
            } break;
            case 1: 
            {
                xuat();
            } break;
            case 2: 
            {
                them();
            } break;
            case 3: 
            {
                xoa();
            } break;
            case 4: 
            {
                sua();
            } break;
            case 5:
            {
                timkiem().xuat();
                System.out.println("\n");
            } break;
            case 6:
            {
                thongKeHoatDong();
            } break;
            case 7:
            {
                nhap();
            }
            }
        }
    }
}
