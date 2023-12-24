package NHANVIEN;



//import java.util.Scanner;

public class QUANLIDSNhanVien {
 public void thaoTac(){
     try{
         DANHSACHNHANVIEN qldsnv = new DANHSACHNHANVIEN();
         qldsnv.docData("data\\NHANVIEN.txt");
         qldsnv.xuat();
         qldsnv.menu();
         qldsnv.ghiData("data\\NHANVIEN.txt");
     } catch(Exception e){
         System.out.print("\nLoi khong the doc file !!!\n");
     }
 }
}
