package QUANLYNHAPHANG;

import java.util.Scanner;
import CHITIETPHIEUNHAP.QUANLIDSCTPN;
import PHIEUNHAP.QUANLIDSPN;
public class QUANLYNHAPHANG
{
    QUANLIDSCTPN qldsctpn = new QUANLIDSCTPN();
    QUANLIDSPN qldspn = new QUANLIDSPN();
    public void menu()
    {
        System.out.println("\n\t\u001B[34m======[ Trinh quan ly nhap hang ]=====\u001B[0m");
        System.out.println("\t -> Nhap 0 de quay tro lai");
        System.out.println("\t -> Nhap 1 de quan ly chi tiet phieu nhap");
        System.out.println("\t -> Nhap 2 de quuan ly phieu nhap");
        int i; 
        do
        {
            System.out.print("\t -> lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch(i)
            {
                case 0:
                {
                   break;
                }
                case 1:
                { 
                    qldsctpn.thaoTac();
                }break;
                case 2: qldspn.thaoTac(); break;
            }


        }
        while (i!=0);

    
    
    }
}