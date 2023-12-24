package PHIEUNHAP;


public class QUANLIDSPN {
    public void thaoTac() {
        try {
            DANHSACHPHIEUNHAP ds = new DANHSACHPHIEUNHAP();
            ds.docfile("data\\PHIEUNHAP.txt");
            ds.xuat();
            ds.thaoTac();
            ds.ghiFile("data\\PHIEUNHAP.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }

}


