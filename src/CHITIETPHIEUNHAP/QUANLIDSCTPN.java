package CHITIETPHIEUNHAP;


public class QUANLIDSCTPN {
    public void thaoTac() {
        try {
            DANHSACHCHITHIETPHIEUNHAP ds = new DANHSACHCHITHIETPHIEUNHAP();
            ds.docfile("data\\CHITIETPHIEUNHAP.txt");
            ds.xuat();
            ds.thaoTac();
            ds.ghiFile("data\\CHITIETPHIEUNHAP.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }



}


