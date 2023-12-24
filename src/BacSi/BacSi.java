package BacSi;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BacSi {
// Thuoc tinh: 
    private String maBS, SDT, trinhDo, chuyenNganh, ho, ten, gioiTinh;
    private LocalDate ngaySinh;   
    private boolean hoatDong;

//Phuong thuc: 
    BacSi(){
        maBS = "NULL";
        ho = "NULL";
        ten = "NULL";
        gioiTinh = "NULL";
        ngaySinh = null;
        SDT = "NULL";
        trinhDo = "NULL";
        chuyenNganh = "NULL";
        hoatDong = false;
    }

    BacSi(String maBS, String ho, String ten, String gioiTinh, LocalDate ngaySinh, String SDT, String trinhDo, String chuyenNganh, boolean hoatDong){
        this.maBS = maBS;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.trinhDo = trinhDo;
        this.chuyenNganh = chuyenNganh;
        this.hoatDong = hoatDong;
    }

    BacSi(BacSi bs){
        maBS = bs.maBS;
        ho = bs.ho;
        ten = bs.ten;
        gioiTinh = bs.gioiTinh;
        ngaySinh = bs.ngaySinh;
        SDT = bs.SDT;
        trinhDo = bs.trinhDo;
        chuyenNganh = bs.chuyenNganh;
        hoatDong = bs.hoatDong;
    }

//Nhap:
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma bac si: ");
        maBS = input.nextLine();
        System.out.print("\nNhap ho: ");
        ho = input.nextLine();
        System.out.print("\nNhap ten: ");
        ten = input.nextLine();
        System.out.print("\nNhap gioi tinh (Nam/Nu): ");
        gioiTinh = input.nextLine();
        System.out.print("\nNhap ngay sinh (yyyy-mm-dd): ");
        String ngaySinhTemp = input.nextLine();
        DateTimeFormatter kieuNgay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngaySinh = LocalDate.parse(ngaySinhTemp, kieuNgay);
        System.out.print("\nNhap so dien thoai: ");
        SDT = input.nextLine();
        System.out.print("\nNhap trinh do: ");
        trinhDo = input.nextLine();
        System.out.print("\nNhap chuyen nganh: ");
        chuyenNganh = input.nextLine();
        System.out.print("\nNhap hoat dong: ");
        hoatDong = input.nextBoolean();
        System.out.print("\n");
    }

//Xuat: 
    public void xuat(){
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", maBS,ho +" "+ ten,gioiTinh,ngaySinh,SDT,trinhDo,chuyenNganh,hoatDong);
    }

//Set:
    public void setMaBS(String data){
        maBS = data;
    }
    public void setHo(String data){
        ho = data;
    }
    public void setTen(String data){
        ten = data;
    }
    public void setGioiTinh(String data){
        gioiTinh = data;
    }
    public void setNgaySinh(LocalDate data){
        ngaySinh = data;
    }
    public void setSDT(String data){
        SDT = data;
    }
    public void setTrinhDo(String data){
        trinhDo = data;
    }
    public void setChuyenNganh(String data){
        chuyenNganh = data;
    }
    public void setHoatDong(boolean data){
        hoatDong = data;
    }

//Get:
    public String getMaBS(){
        return maBS;
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public String getGioiTinh(){
        return gioiTinh;
    }
    public LocalDate getNgaySinh(){
        return ngaySinh;
    }
    public String getSDT(){
        return SDT;
    }
    public String getTrinhDo(){
        return trinhDo;
    }
    public String getChuyenNganh(){
        return chuyenNganh;
    }
    public boolean getHoatDong(){
        return hoatDong;
    }
    
//Sua: 
    public void menuSua(){
        int option = 0;
        do{
            Scanner input = new Scanner(System.in);
            
            System.out.print("\t\t === DANH SACH CAC SUA THONG TIN ===");            
            System.out.print("\n\t\t || 0) Thoat.                     ||" +
                             "\n\t\t || 1) Ma bac si.                 ||" + 
                             "\n\t\t || 2) Ho bac si.                 ||" + 
                             "\n\t\t || 3) Ten bac si.                ||" + 
                             "\n\t\t || 4) Gioi tinh.                 ||" + 
                             "\n\t\t || 5) Ngay sinh.                 ||" + 
                             "\n\t\t || 6) So dien thoai.             ||" + 
                             "\n\t\t || 7) Trinh do.                  ||" +
                             "\n\t\t || 8) Chuyen nganh.              ||" +
                             "\n\t\t || 9) Hoat dong.                 ||" );
            System.out.print("\n\t\t ===================================");
        
            System.out.print("\n <-> Chon thong tin can sua: ");
            option = input.nextInt();
            input.nextLine();
            while (option < 0 || option > 9){
                System.out.print("\nKhong ton tai lua chon nay !!! Vui long chon lai: ");
                option = input.nextInt();
            } if(option == 0){
                break;
            } if(option == 1){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setMaBS(nd);                
            } if(option == 2){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setHo(nd);
            } if(option == 3){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setTen(nd);
            } if(option == 4){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setGioiTinh(nd);
            } if(option == 5){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate tt5 = LocalDate.parse(nd, formatter);
                setNgaySinh(tt5);
            } if(option == 6){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setSDT(nd);
            } if(option == 7){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setTrinhDo(nd);
            } if(option == 8){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                setChuyenNganh(nd);
            } if(option == 9){
                System.out.print("\nNhap noi dung sua: ");
                String nd = input.nextLine();
                boolean hd;
                hd = Boolean.parseBoolean(nd);
                setHoatDong(hd);
            }
        } while(option != 0);       
    }

    public String getThongTin(){
        String inFor = maBS + "," + ho + "," + ten + "," + gioiTinh + "," + ngaySinh + "," + SDT + "," + trinhDo + "," + chuyenNganh + "," +hoatDong;
        return inFor;
    }
}
