package NHACUNGCAP;


import java.util.Scanner;
class NHACUNGCAP {
    private String maNhaCungCap,tenNhaCungCap,diaChi,SDT;
    public String getLine()
    {
        return maNhaCungCap+","+tenNhaCungCap+","+diaChi+","+SDT;
    }
    NHACUNGCAP()
    {
        maNhaCungCap = null;
        tenNhaCungCap = null;
        diaChi = null;
        SDT = null;
    }
    NHACUNGCAP(String mancc,String tncc,String dc,String sdt)
    {
        this.maNhaCungCap = mancc;
        this.tenNhaCungCap = tncc;
        this.diaChi = dc;
        this.SDT = sdt;
    }
    NHACUNGCAP( NHACUNGCAP ncc)
    {
        this.maNhaCungCap = ncc.maNhaCungCap;
        this.tenNhaCungCap = ncc.tenNhaCungCap;
        this.diaChi = ncc.diaChi;
        this.SDT = ncc.SDT;
    }
    public void nhap()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma nha cung cap: ");
        this.maNhaCungCap = input.nextLine();
        System.out.print("Ten nha cung cap: ");
        this.tenNhaCungCap = input.nextLine();
        System.out.print("Dia chi nha cung cap: ");
        this.diaChi = input.nextLine();
        System.out.print("SDT nha cung cap: ");
        this.SDT = input.nextLine();
    }
    public void xuat()
    {
        System.out.print(maNhaCungCap+"       "+tenNhaCungCap+"       "+diaChi+"      "+SDT);
    }

    //SET
    public void setMaNhaCungCap(String val)
    {
        this.maNhaCungCap = val;
    }
    public void setTenNhaCungCap(String val)
    {
        this.tenNhaCungCap = val;
    }
    public void setDiaChi(String val)
    {
        this.diaChi = val;
    }
    public void setSDT(String val)
    {
        this.SDT = val;
    }

    //GET
    public String getMaNhaCungCap()
    {
        return this.maNhaCungCap;
    }
    public String getTenNhaCungCap()
    {
        return this.tenNhaCungCap;
    }
    public String getDiaChi()
    {
        return this.diaChi;
    }
    public String getSDT()
    {
        return this.SDT;
    }
}
