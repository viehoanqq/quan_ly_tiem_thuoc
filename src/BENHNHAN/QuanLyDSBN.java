package BENHNHAN;

public class QuanLyDSBN {
    public void thaoTac(){
        try {
            DSBN qlDSBN = new DSBN();
            qlDSBN.docData("data/BenhNhan.txt");
            qlDSBN.menuBenhNhan();
            qlDSBN.ghiFile("data/BenhNhan.txt");
        } catch (Exception e){
            System.out.println("\nLoi khong the doc file!\n");
            e.printStackTrace();
        }
    }
}
