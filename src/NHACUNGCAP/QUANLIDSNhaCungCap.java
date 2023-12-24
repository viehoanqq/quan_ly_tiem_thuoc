package NHACUNGCAP;



//import java.util.Scanner;

public class QUANLIDSNhaCungCap {
 public void thaoTac(){
     try{
         DANHSACHNHACUNGCAP ql = new DANHSACHNHACUNGCAP();
         ql.docData("data\\nhacungcap.txt");
         ql.xuat();
         ql.menuThaoTac();
         ql.ghiData("data\\nhacungcap.txt");
     } catch(Exception e){
         System.out.print("\nLoi khong the doc file !!!\n");
     }
 }
}
