package DONTHUOC;

import java.util.Arrays;
import INTERFACE.interfaceDanhSach;
import THUOC.DANHSACHTHUOC;
import THUOC.THUOCCHICH;
import THUOC.Thuoc;

import java.io.*;
import java.util.Scanner;
public class DANHSACHDONTHUOC implements interfaceDanhSach {
    private DONTHUOC [] dsdt;
    private int soLuongDonThuoc;

    //3 ham khoi tao
    //get
    public DONTHUOC getDonThuocTuMa(String ma){
        for (int i=0;i<soLuongDonThuoc;i++){
            if (dsdt[i].getMaDonThuoc().equals(ma)){
                return dsdt[i];
            }
        }
        return null;
    }
    public void xuat(){
        System.out.println("\u001B[34m=".repeat(20)+"[ DANH SACH DON THUOC ]"+"=".repeat(20)+"\u001B[0m");
        for (int i=0;i<soLuongDonThuoc;i++){
            System.out.format("STT: "+ (i+1)+"\n");
            dsdt[i].xuat();
            System.out.println();
        }
    }
    public void inCuoi(){
        System.out.println("Hoa don moi nhat : ");
        dsdt[dsdt.length-1].xuat();
    }
    public void timKiem(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma can tim kiem: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc())){
                dsdt[i].xuat();
                return;
            }
        }
        System.out.println("Ma thuoc khong ton tai!");
    }
        
    public int timKiemTheoMa(String ma){
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc()))
            return 1;
        }
        return 0;
    }
    public void xuatDonThuocTheoMa(String ma){
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc()))
            {
                dsdt[i].xuaHD();
            }
        }
    }

    public void them(){
        soLuongDonThuoc++;
        if (soLuongDonThuoc == 1){
            dsdt = new DONTHUOC[1];
            dsdt[0] = new DONTHUOC();
            dsdt[0].them();
        }
        else{
            this.dsdt = Arrays.copyOf(this.dsdt, soLuongDonThuoc);
            dsdt[soLuongDonThuoc-1] = new DONTHUOC();
            dsdt[soLuongDonThuoc-1].them();
            }
    
    
}

    
    public void Xoa(){
        Scanner input =  new Scanner(System.in);
        System.out.print("Nhap ma can xoa: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc()))
            {
                for (int j=i;j<soLuongDonThuoc-1;j++){
                    dsdt[i] = dsdt[i+1];
                    
                }
                System.out.println("Xoa thanh cong!");
                soLuongDonThuoc--;
                return;
            }
            
        }
        System.out.println("Khong tim thay ma nay ! xoa that bai!!!");
        

    
    }


    ///-------------------override ----------------------
    @Override
    public void Them(int soLuong ){
        soLuongDonThuoc++;
        if (soLuongDonThuoc == 1){
            dsdt = new DONTHUOC[1];
            dsdt[0] = new DONTHUOC();
            dsdt[0].them();
        }
        else{
            this.dsdt = Arrays.copyOf(this.dsdt, soLuongDonThuoc);
            dsdt[soLuongDonThuoc-1] = new DONTHUOC();
            dsdt[soLuongDonThuoc-1].them();
            }
    
    
}
    @Override
    public void ghiData(String path)
    {
        File file = new File(path);
        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e){
            System.out.println("Loi ghi file ");
            return;
        }
        write.println(soLuongDonThuoc);
        for (int i=0;i<soLuongDonThuoc;i++){
            write.println(dsdt[i].getThongTin());
        }
        write.close();
    }
    @Override
    public void docData(String path){
        Scanner read = null;
        File file = new File(path);
        try{
            read = new Scanner(file);
        } catch(Exception e){
            System.out.println("Loi doc file !");
            return;
        }
        if (!read.hasNextLine()) return;
        soLuongDonThuoc = Integer.parseInt(read.nextLine());
        dsdt = new DONTHUOC[soLuongDonThuoc];
        int i=0;
        while ( read.hasNextLine())
        {
            dsdt[i] = new DONTHUOC();
            String line = read.nextLine();
            String [] arr = line.split(",");
            dsdt[i].setMaDonThuoc(arr[0]);
            dsdt[i].setSoLuongThuocBoc(Integer.parseInt(arr[1]));
            Thuoc [] arrThuoc = new Thuoc[dsdt[i].getSoLuongThuocBoc()];
            //doc du lieu phan thuoc va truyen vo mang tam
            for (int j=0;j<dsdt[i].getSoLuongThuocBoc();j++){
                arrThuoc[j] = new THUOCCHICH();
                arrThuoc[j].setMaThuoc(arr[(j+1)*4-2]);
                arrThuoc[j].setTenThuoc(arr[4*(j+1)-1]);
                arrThuoc[j].setGiaCa(Double.parseDouble(arr[4*(j+1)]));
                arrThuoc[j].setSoLuong(Integer.parseInt(arr[4*(j+1)+1]));
            }
            dsdt[i].setDst(0,arrThuoc);
            dsdt[i].setDonGia(Double.parseDouble(arr[arr.length-1]));
            i++;


        }

    }
    @Override
    public void Xoa(String ma){
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc()))
            {
                for (int j=i;j<soLuongDonThuoc-1;j++){
                    dsdt[i] = dsdt[i+1];
                    
                }
                System.out.println("Xoa thanh cong!");
                soLuongDonThuoc--;
                return;
            }
            
        }
        System.out.println("Khong tim thay ma nay ! xoa that bai!!!");
        

    
    }
    @Override
    public void Sua(String maCanSua){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma can sua!");
        String ma = input.nextLine();
        for (int i=0;i<soLuongDonThuoc;i++){
            if (ma.equals(dsdt[i].getMaDonThuoc())){
                System.out.println("Lua chon noi dung can sua: ");
                System.out.println("0: Thoat");
                System.out.println("1: Ma don thuoc");
                System.out.println("2: sua thong tin thuoc");
                System.out.print("Lua chon: "); 
                int option = input.nextInt();
                input.nextLine();
                if (option == 0) return;
                if (option ==1 ){
                    System.out.print("Nhap ma don thuoc moi :");
                    String ma2 = input.nextLine();
                    dsdt[i].setMaDonThuoc(ma2);
                    System.out.println("Sua thanh cong ! ");
                }
                if (option ==2 ){
                    System.out.println("--> sua thong tin cua thuoc ");
                    System.out.println("0: Thoat");
                    System.out.println("1: sua so luong theo ma");
                    System.out.println("2: xoa thuoc");
                    System.out.println("3: Them thuoc");
                    System.out.print("Lua chon");
                    int option2 = input.nextInt();
                    input.nextLine();
                    if (option2 == 0) return;
                    if (option2 ==1 ){
                        System.out.print("NHap ma can sua so luong: "); 
                        String maT = input.nextLine();
                        boolean flag = false;
                        for (int j=0;j<dsdt[i].getDst().length;j++){
                            if (maT.equals(dsdt[i].getDst()[j].getMaThuoc())){
                                flag = true;
                                System.out.print("So luong moi : ");
                                dsdt[i].getDst()[j].setSoLuong(input.nextInt());
                                System.out.println("Sua thanh cong!");
                                dsdt[i].xuat();
                                return;
                            }
                            
                        }
                            if (!flag){
                                System.out.println("Khong tim thay ma thuoc nay !");
                            }
                    }
                    if (option2 ==2 ){
                        System.out.print("Nhap ma thuoc can xoa: ");
                        String maT = input.nextLine();
                        for (int j=0;j<dsdt[i].getDst().length;j++){
                            if (maT.equals(dsdt[i].getDst()[j].getMaThuoc())){
                                dsdt[i].setDonGia(dsdt[i].getDonGia()-dsdt[i].getDst()[j].getGiaCa()*dsdt[i].getDst()[j].getSoLuong());
                                for (int k =j;k<dsdt[i].getDst().length-1;k++){

                                    dsdt[i].getDst()[k] = dsdt[i].getDst()[k+1];
                                }
                                dsdt[i].setSoLuongThuocBoc(dsdt[i].getSoLuongThuocBoc()-1);
                                if (dsdt[i].getSoLuongThuocBoc() == 0){
                                    Xoa(dsdt[i].getMaDonThuoc());
                                }
                            }

                    }
                    }
                    if (option2 == 3){
                        Thuoc [] newDST = Arrays.copyOf(dsdt[i].getDst(), dsdt[i].getDst().length + 1);
                            DANHSACHTHUOC dstchinh = new DANHSACHTHUOC();
                            try{
                                dstchinh.docData("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\dataThuoc.txt");
                            } catch ( Exception e){
                                System.out.println("Loi ghi file");
                                return;
                            }
                            // chỗ này chưa định dạng đc 2 loạit thuốc :v nên để đại , fix sau
                            newDST[dsdt[i].getDst().length] = new THUOCCHICH();
                            System.out.print("Ma: "); 
                            String ma2 = input.nextLine();
                            if (dstchinh.isExists(ma2) == 0){
                                System.out.println("Thuoc khong ton tai ! Nhap lai!");
                                return;
                            }
                            else{
                                newDST[dsdt[i].getDst().length] .setMaThuoc(ma2);
                                 newDST[dsdt[i].getDst().length] .setTenThuoc(dstchinh.getTenThuocTheoMa(ma2));
                                System.out.print("So luong: "); 
                                int soluong = input.nextInt();
                                input.nextLine();
                                if ((soluong>= 0) && soluong <= dstchinh.getSoLuongThuocTheoLoai(ma2)){
                                    newDST[dsdt[i].getDst().length] .setSoLuong(soluong);
                                     newDST[dsdt[i].getDst().length] .setGiaCa(dstchinh.getGiaCaTheoMa(ma2));
                                    // tinh don gia 
                                    double tien = newDST[dsdt[i].getDst().length].getGiaCa()* newDST[dsdt[i].getDst().length] .getSoLuong();
                                    dsdt[i].setDonGia(tien+dsdt[i].getDonGia());
                                    //khi nhap xong don thuoc thi set lai so luong trong danh sach thuoc
                                    dstchinh.giamSoLuongThuocTheoMa(ma2, soluong);
                                    
                                }
                                else{
                                    System.out.println("So luong thuoc khong phu hop!");
                                    return;
                                }
                        
                           
                            dsdt[i].setDst(1,newDST);
                            
                             }
                        }   
                    }
                }
            }
        }
    
    @Override
    public void menuThaoTac(){
        System.out.println("TRINH QUAN LY DON THUOC");
        System.out.println("0: Thoat");
        System.out.println("1: Them don thuoc");
        System.out.println("2: Xuat danh sach don thuoc");
        System.out.println("3: tim kiem don thuoc");
        System.out.println("4: xoa don thuoc");
        
        System.out.println("5: sua don thuoc");
        
        System.out.println("6: In hoa don moi tao");
        
        System.out.print("Lua chon: ");
        Scanner input = new Scanner(System.in);
        int i= input.nextInt();
        do{
        if (i==0)
        {
 
        }

        if (i==1){
            them();
        };
        if (i==2){
            xuat();
        };
        if ( i==3){
            timKiem();
        }
        if (i == 4)
        {
            Xoa();
        }
        if (i == 5)
        {
            Sua("test");
        }
        if ( i==6){
            inCuoi();
        }
        System.out.print("Lua chon: ");
        i= input.nextInt();
        
    } while ( i !=0 );
    }
    
    
}
