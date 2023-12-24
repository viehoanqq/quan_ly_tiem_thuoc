package BacSi;



import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DSBS {
// Thuộc tính:
    private BacSi [] dsbs;
    private int n;

// Phương thức:
    public DSBS(){
        dsbs = new BacSi[1];
        dsbs [0] = null;
        dsbs [0] = new BacSi();
        n = 0;
    }

    DSBS(BacSi dsbs[], int n){
        this.dsbs = dsbs;
        this.n = n;
    }

    DSBS(DSBS l){
        dsbs = l.dsbs;
        n = l.n;
    }
// Phương Thức Cũ !!!

//     public String fileBS(){
//         return "data/BacSi.txt";
//     }

// // Ham lay dong de ghi vao file
//     public String getLine(int i){
//         return (dsbs[i].getMaBS()+","+dsbs[i].getHo()+","+dsbs[i].getTen()+","+dsbs[i].getGioiTinh()+","+dsbs[i].getNgaySinh()+","+dsbs[i].getSDT()+","+dsbs[i].getTrinhDo()+","+dsbs[i].getChuyenNganh()+","+dsbs[i].getHoatDong());
//     }

// // Ham xoa data trong file
//     public void xoaDataFile(String filePath){
//         try{
//             FileWriter writer = new FileWriter(filePath, false);
//             writer.write("");
//             writer.close();
//         } catch(IOException e){
//             System.out.print("\nLoi");
//         }
//     }

// // Ham ghi file
//     public void ghiLine(String fileName, String s){
//         // Xoa data trong file truoc
//         File outFile = new File(fileName);
//         PrintWriter write = null;
//         try{
//             write = new PrintWriter(new FileWriter(outFile, true));
//         } catch(Exception e){
//             System.out.print("\nKhong the tao tap tin ket qua");
//             return;
//         }
//         write.print(s);
//         write.print("\n");
//         write.close();
//     }

// Ghi file
    void ghiFile(String filePath){
        File file = new File(filePath);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("loi ghi file!");
        }
        write.println(n);
        for (int i = 0; i < n; i++) {
            write.println(dsbs[i].getThongTin());
        }
        write.close();
    }

// Nhập
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong: ");
        n = input.nextInt();
        dsbs = new BacSi[n];
        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            System.out.print("Bac si ["+(i+1)+"] : \n");
            dsbs[i].nhap();
            System.out.print("\n");
        }
        
    }

// Đọc file
    public void docData(String filePath){
        File inFile = new File(filePath);
        Scanner read = null;
        try{
            read = new Scanner(inFile);   
        } catch( Exception e){
            System.out.print("Khong mo duoc file BacSi.txt");
            return;
        }
        String sl = read.nextLine();
        n = Integer.parseInt(sl);
        dsbs = new BacSi[n];
        for(int i = 0; i < n; i++){
            dsbs[i] = new BacSi();
            String line = read.nextLine();
            String [] str = line.split(",");
            dsbs[i].setMaBS(str[0]);
            dsbs[i].setHo(str[1]);
            dsbs[i].setTen(str[2]);
            dsbs[i].setGioiTinh(str[3]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate tempNgaySinh = LocalDate.parse(str[4], formatter);
            dsbs[i].setNgaySinh(tempNgaySinh);
            dsbs[i].setSDT(str[5]);
            dsbs[i].setTrinhDo(str[6]);
            dsbs[i].setChuyenNganh(str[7]);
            dsbs[i].setHoatDong(Boolean.parseBoolean(str[8]));
        }
        read.close();
    }

// Xuất
    public void xuat(){
        System.out.print("\n" + "=".repeat(56) + "  DANH SACH BAC SI  " + "=".repeat(56));
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
        System.out.print("\n" + "||" + "-".repeat(128) + "||");
        
        for(int i = 0; i < n; i++){
            dsbs[i].xuat();           
        }
        System.out.print("\n" + "=".repeat(132));
    }

// Thêm bác sĩ
    public void them(){
        // n = dsbs.length;
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap so luong muon them: ");
        int sl = input.nextInt();
        for(int i = 0; i < sl; i++){
            dsbs = Arrays.copyOf(dsbs, n + 1);
            dsbs[n] = new BacSi();
            System.out.print("\nNhap thong tin bac si thu " + (n + 1) + " : \n");
            dsbs[n].nhap();
            n++;
        }
               
    }

    public void them(int sl){
        // n = dsbs.length;
        for(int i = 0; i < sl; i++){
            dsbs = Arrays.copyOf(dsbs, n + 1);
            dsbs[n] = new BacSi();
            System.out.print("\nNhap thong tin bac si thu " + (n + 1) + " : \n");
            dsbs[n].nhap();
            n++;
        }
               
    }

// Sửa thông tin 
    void sua(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n <-> Nhap ma bac si can sua: ");
        String ma = input.nextLine();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            // Check theo mã để sửa
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                dsbs[i].menuSua();
            }
        } if(!flag){
            System.out.print("\nKhong tim thay bac si !!!");
        }
        
    }

    void sua(String ma){
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                dsbs[i].menuSua();
            }
        } if(!flag){
            System.out.print("\nKhong tim thay bac si !!!");
        }
        
    }

//Tim:
    // public int timKiem(String maBS){
    //     for(int i = 0; i < n; i++){
    //         if(dsbs[i].getMaBS().equals(maBS)){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

//Xoa: 
    
    // public void Xoa(String maBS){
    //     int d = timKiem(maBS);
    //     if(d == -1){
    //         System.out.print("\nKHONG TON TAI NGUOI NAY!!!");
    //     }
    //     else{
    //         for(int i = d; i < n - 1; i++){
    //             dsbs[i] = new BacSi(dsbs[i + 1]);
    //         }
    //         dsbs = Arrays.copyOf(dsbs, n - 1);
    //         n--;
    //     }
    // }

// Xóa bác sĩ 
    public void xoa(){
        System.out.print("\nNhap ma bac si can xoa: ");
        Scanner input = new Scanner(System.in);
        String ma = input.nextLine();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                for(int j = i; j < n - 1; j++){
                    dsbs[j] = dsbs[j + 1];
                }
                n--;
            }
        } if(!flag){
            System.out.print("\nKhong tim thay ma bac si !!!");
            return;
        }
        
    }
    public void xoa(String ma){
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(ma.equals(dsbs[i].getMaBS())){
                flag = true;
                for(int j = i; j < n - 1; j++){
                    dsbs[j] = dsbs[j + 1];
                }
                n--;
            }
        } if(!flag){
            System.out.print("\nKhong tim thay ma bac si !!!");
            return;
        }
        
    }

// Menu tìm kiếm theo: mã, tên, trình độ
    public void timKiem(){
        Scanner input = new Scanner(System.in);
        // Tạo vòng lặp duy trì tìm kiếm
        boolean tiepTuc = true;
        while(tiepTuc){
            System.out.print("\n <-> Nhap thong tin can tim: ");
            String search = input.nextLine();
            System.out.print("\n" + "=".repeat(56) + " THONG TIN CAN TIM " + "=".repeat(56));
            System.out.print("\n");
            System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
            System.out.print("\n" + "||" + "-".repeat(128) + "||");
            for(int i = 0; i < n; i++){
                if((search.equals(dsbs[i].getMaBS())) || (search.equals(dsbs[i].getHo())) || search.equals(dsbs[i].getTen()) || search.equals(dsbs[i].getChuyenNganh()) || search.equals(dsbs[i].getGioiTinh()) || search.equals(dsbs[i].getTrinhDo())){                
                    dsbs[i].xuat();
                }
            } 
            System.out.print("\n" + "=".repeat(132));
            // Xác nhận tiếp tục tìm kiếm
            System.out.print("\nBan co muon tiep tuc tim kiem? (Y/N): ");
            String luaChon = input.nextLine();
            // Dừng tìm kiếm
            if (!luaChon.equalsIgnoreCase("Y")) {
                tiepTuc = false;
            }
        }
    }

    public void timKiem(String ma){
        
        for(int i = 0; i < n; i++){
            if((ma.equals(dsbs[i].getMaBS())) || (ma.equals(dsbs[i].getTen()))){
                dsbs[i].xuat();
            }
        }
    }
    public BacSi timKiemTraVeBacSi(String ma){
        
        for(int i = 0; i < n; i++){
            if((ma.equals(dsbs[i].getMaBS())) || (ma.equals(dsbs[i].getTen()))){
                return dsbs[i];
            }
        } 
        BacSi none = new BacSi();
        return none;
    }


    
    public int timMaBacSi(String findedMaBacSi) {
        int index = -1;
        for (int i = 0; i < this.n; i++) {
            if (this.dsbs[i].getMaBS().equals(findedMaBacSi))
                index = i;
        }
        return index;
    }

// Thong ke
    public void menuThongKe(){
        int option = 0;
        do{
            Scanner input = new Scanner(System.in);

            System.out.print("\n\t\t-----------------------");
            System.out.print("\n\t\t|| >>Thong ke theo<< ||" + 
                             "\n\t\t||  0) Thoat.        ||" + 
                             "\n\t\t||  1) Gioi tinh.    ||" + 
                             "\n\t\t||  2) Trinh do.     ||" + 
                             "\n\t\t||  3) Hoat dong.    ||");
            System.out.print("\n\t\t-----------------------");
        
            System.out.print("\n <-> Chon phuong thuc thong ke: ");
            option = input.nextInt();
            input.nextLine();
            while (option < 0 || option > 4){
                System.out.print("\nKhong ton tai lua chon nay !!! Vui long chon lai: ");
                option = input.nextInt();
            } if(option == 0){
               break; 
            } if(option == 1){
                thongKeGioiTinh();
            } if(option == 2){
                thongKeTrinhDo();
            } if(option == 3){
                thongKeHoatDong();
            }
        } while(option != 0);
    }

    public void thongKeTrinhDo(){
        Arrays.sort(dsbs, 0, n, (bs1, bs2) -> bs1.getTrinhDo().compareTo(bs2.getTrinhDo()));

        int daiHoc = 0;
        int thacSi = 0;
        int tienSi = 0;
        
        System.out.print("\n" + "=".repeat(54) + " BANG THONG KE TRINH DO " + "=".repeat(54));
        System.out.print("\n" + "=".repeat(5) + " TRINH DO DAI HOC " + "=".repeat(109));
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
        System.out.print("\n" + "||" + "-".repeat(128) + "||");
        for(int i = 0; i < n; i++){
            
            if(dsbs[i].getTrinhDo().equalsIgnoreCase("Dai hoc")){
                daiHoc++;
                dsbs[i].xuat();
            }
        }

        System.out.print("\n" +"||" + "=".repeat(3) + " TRINH DO THAC SI " + "=".repeat(107) + "||");       
        for(int i = 0; i < n; i++){
            if(dsbs[i].getTrinhDo().equalsIgnoreCase("thac si")){
                thacSi++;               
                dsbs[i].xuat();
            }
        }

        System.out.print("\n" +"||" + "=".repeat(3) + " TRINH DO TIEN SI " + "=".repeat(107) + "||");       
        for(int i = 0; i < n; i++){
            if(dsbs[i].getTrinhDo().equalsIgnoreCase("Tien si")){
                tienSi++;
                dsbs[i].xuat();
            }
        }
        System.out.print("\n" + "=".repeat(132));
        System.out.print("\nTONG SO LUONG BAC SI: " + n);
        System.out.print("\n- Trinh do dai hoc: " + daiHoc);
        System.out.print("\n- Trinh do thac si: " + thacSi);
        System.out.print("\n- Trinh do tien si: " + tienSi);
    }
    
    public void thongKeGioiTinh(){
        Arrays.sort(dsbs, 0, n, (bs1, bs2) -> bs1.getGioiTinh().compareTo(bs2.getGioiTinh()));

        int nam = 0;
        int nu = 0;
        
        System.out.print("\n" + "=".repeat(54) + " BANG THONG KE GIOI TINH " + "=".repeat(53));
        System.out.print("\n" + "=".repeat(5) + " NAM " + "=".repeat(122));
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
        System.out.print("\n" + "||" + "-".repeat(128) + "||");
        for(int i = 0; i < n; i++){
            
            if(dsbs[i].getGioiTinh().equalsIgnoreCase("Nam")){
                nam++;
                dsbs[i].xuat();
            }
        }

        System.out.print("\n" +"||" + "=".repeat(3) + " NU " + "=".repeat(121) + "||");       
        for(int i = 0; i < n; i++){
            if(dsbs[i].getGioiTinh().equalsIgnoreCase("Nu")){
                nu++;               
                dsbs[i].xuat();
            }
        }

        System.out.print("\n" + "=".repeat(132));
        System.out.print("\nTONG SO LUONG BAC SI: " + n);
        System.out.print("\n- Gioi tinh nam: " + nam + " (" + (nam * 100.0 / n) + "%)");
        System.out.print("\n- Gioi tinh nu: " + nu + " (" + (nu * 100.0 / n) + "%)");
    }

    public void thongKeHoatDong(){
        int hd =0;
        System.out.print("\n" + "=".repeat(54) + " BANG THONG KE HOAT DONG " + "=".repeat(53));
        for (int i = 0; i < n; i++)
        {
            if (dsbs[i].getHoatDong())
            {
                hd++;
            }
        }
        System.out.print("\n" + "=".repeat(5) + " So bac si dang hoat dong: "+ hd +" :" + "=".repeat(97));
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
        System.out.print("\n" + "||" + "-".repeat(128) + "||");
        for (int i=0;i<n;i++)
        {
            if (dsbs[i].getHoatDong())
            {
                dsbs[i].xuat();
            }
        }

        System.out.print("\n" + "=".repeat(5) + " So bac si khong hoat dong: "+ (n - hd) +" :" + "=".repeat(96));
        System.out.print("\n");
        System.out.format("|| %-12s | %-25s | %-10s | %-12s | %-14s | %-10s | %-12s | %-10s ||", "Ma bac si","Ho Ten","Gioi tinh","Ngay sinh","So dien thoai","Trinh do","Chuyen nganh","Hoat Dong");
        System.out.print("\n" + "||" + "-".repeat(128) + "||");
        for (int i=0;i<n;i++)
        {
            if (!dsbs[i].getHoatDong())
            {
                dsbs[i].xuat();
            }
        }
        System.out.print("\n" + "=".repeat(132));
    }

    public void menuBacSi(){
        int option = 0;
        do{  
            Scanner input = new Scanner(System.in);
            System.out.print("\n");
            System.out.print("\n\t\t\t ========  QUAN LY BAC SI  ========");             
            System.out.print("\n\t\t\t || 0) Thoat.                    ||" +
                             "\n\t\t\t || 1) Tao danh sach bac si.     ||" + 
                             "\n\t\t\t || 2) Xem danh sach bac si.     ||" + 
                             "\n\t\t\t || 3) Them bac si.              ||" + 
                             "\n\t\t\t || 4) Xoa bac si.               ||" + 
                             "\n\t\t\t || 5) Sua thong tin bac si.     ||" + 
                             "\n\t\t\t || 6) Tim kiem thong tin bac si.||" + 
                             "\n\t\t\t || 7) Thong ke danh sach bac si.||" );
            System.out.print("\n\t\t\t ==================================");
        
            System.out.print("\n <-> Hay chon chuc nang: ");
            option = input.nextInt();
            while (option < 0 || option > 7){
                System.out.print("\nKhong ton tai lua chon nay !!! Vui long chon lai: ");
                option = input.nextInt();
            } if(option == 0){
                break;
            } if(option == 1){
                nhap();
            } if(option == 2){
                xuat();
            } if(option == 3){
                them();
            } if(option == 4){
                xoa();
            } if(option == 5){
                sua();
            } if(option == 6){
                timKiem();
            } if(option == 7){
                menuThongKe();
            }
        } while(option != 0);
    }
    
}
