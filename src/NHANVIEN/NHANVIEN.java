package NHANVIEN;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;;
 public class NHANVIEN 
{
    Scanner input = new Scanner(System.in);
    private String maNV,ho,ten,chucVu,gioiTinh,SDT;
    private boolean hoatDong;
    private LocalDate ngaySinh;
    private double heSoLuong;

    public NHANVIEN()
    {
        maNV=  null;
        ho = null;
        ten = null;
        gioiTinh= null;
        ngaySinh = null;
        SDT= null;
        hoatDong = false;
        heSoLuong = 0;
    }
    public NHANVIEN(String maNV,String ho,String ten,String gioiTinh,LocalDate ngaySinh,String chucVu,String SDT,boolean hoatDong,double heSoLuong)
    {
        this.maNV = maNV;
        this.ho=ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.SDT = SDT;
        this.hoatDong = hoatDong;
        this.heSoLuong = heSoLuong;
        
    }
    public NHANVIEN(NHANVIEN nv)
    {
        maNV=nv.maNV;
        ho=nv.ho;
        ten=nv.ten;
        gioiTinh=nv.gioiTinh;
        ngaySinh=nv.ngaySinh;
        chucVu=nv.chucVu;
        SDT= nv.SDT;
        hoatDong = nv.hoatDong;
        heSoLuong= nv.heSoLuong;
    }
    public void nhap()
    {
        System.out.print(" - Ma Nv: ");
        maNV = input.nextLine();
        System.out.print(" - Ho: ");
        ho = input.nextLine();
        System.out.print(" - Ten: ");
        ten = input.nextLine();
        System.out.print(" - Gioi tinh(Nam/Nu)?:  ");
        gioiTinh = input.nextLine();
        System.out.print(" - Ngay sinh(yyyy-mm-dd): ");
        String ngaySinhTemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngaySinh = LocalDate.parse(ngaySinhTemp, formatter);
        System.out.print(" - Chuc vu: ");
        chucVu = input.nextLine();
        System.out.print(" - He so luong: ");
        heSoLuong = input.nextDouble();
        input.nextLine();
        System.out.print(" - SDT: ");
        SDT = input.nextLine();
        System.out.print(" - Hoat dong(True/False)?: ");
        hoatDong = input.nextBoolean();     
    }
    
    public void xuat()
    {
        System.out.format(" %15s | %28s | %10s | %9s | %15s | %15s | %13s | %10s | %15s ||\n", maNV,  ho, ten, gioiTinh, ngaySinh, chucVu, heSoLuong, SDT, hoatDong);
    }

//GET
    public String getMaNV()
    {
        return maNV;
    }
    public String getHo()
    {
        return ho;
    }
    public String getTen()
    {
        return ten;
    }
    public String getGioiTinh()
    {
        return gioiTinh;
    }
    public LocalDate getNgaySinh()
    {
        return ngaySinh;
    }
    public String getChucVu()
    {
        return chucVu;
    }
    public String getSDT()
    {
        return SDT;
    }
    public boolean getHoatDong()
    {
        return hoatDong;
    }
    public Double getHeSoLuong()
    {
        return heSoLuong;
    }
    
//SET
    public void setMaNV(String data)
    {
        maNV = data;
    }
    public void setHo(String data)
    {
        ho = data;
    }
    public void setTen(String data)
    {
        ten = data;
    }
        public void setGioiTinh(String data)
    {
        gioiTinh = data;
    }
    public void setNgaySinh(LocalDate data)
    {
        ngaySinh = data;
    }
    public void setChucVu(String data)
    {
        chucVu = data;
    }
    public void setSDT(String data)
    {
        SDT = data;
    }
    public void setHoatDong(boolean data)
    {
        hoatDong = data;
    }
    public void setHeSoLuong(double data)
    {
        heSoLuong = data;
    }
    public void sua()
    {
        System.out.println("---------------");
        System.out.println("1. Ma nhan vien");
        System.out.println("2. Ho");
        System.out.println("3. Ten");
        System.out.println("4. Gioi tinh");
        System.out.println("5. ngay sinh");
        System.out.println("6. Chuc vu");
        System.out.println("7. He so luong");
        System.out.println("8. SDT");
        System.out.println("9. Hoat dong\n");
        System.out.print("CHon thong tin can sua: ");
        int n = input.nextInt();
        input.nextLine();
        System.out.print("CHon noi dung can sua: ");
        String nd = input.nextLine();
        
        switch(n)
        {
            case 1:
            {
                setMaNV(nd);
            } break;

            case 2:
            {
                setHo(nd);
            } break;
            
            case 3:
            {
                setTen(nd);
            } break;
            
            case 4:
            {
                setGioiTinh(nd);
            } break;
            
            case 5:
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ns = LocalDate.parse(nd, formatter);
                setNgaySinh(ns);
            } break;
            
            case 6:
            {
                setChucVu(nd);
            } break;

            case 7:
            {
                setHeSoLuong(Double.parseDouble(nd));
            } break;
            case 8:
            {
                setSDT(nd);
            }
            case 9:
            {
                boolean bl;
                bl = Boolean.parseBoolean(nd);
                setHoatDong(bl);
            }
            default:
            {
                System.out.print("Sai!");
            }
        }

    }

    public String getThongTin()
    {
        String s = maNV + "," + ho + "," + ten + "," + gioiTinh + "," +ngaySinh.toString()+ "," + chucVu + "," + heSoLuong+ "," +  SDT+ "," + hoatDong   ;
        return s;
    }

}