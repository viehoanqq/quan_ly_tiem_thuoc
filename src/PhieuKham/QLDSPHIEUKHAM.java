package PhieuKham;

public class QLDSPHIEUKHAM {
    public void trinhQuanLiDanhSachPhieuKhamBenh() {
        try {
            DANHSACHPHIEUKHAMBENH ds = new DANHSACHPHIEUKHAMBENH();
            ds.docData("data/dataPhieuKham.txt");
            ds.getNeedData("data/BacSi.txt", "data/BenhNhan.txt");
            ds.inDanhSachPhieuKham();
            ds.menuThaoTac();
            ds.ghiData("data/dataPhieuKham.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }
}
