import java.util.ArrayList;
import java.util.Scanner;

public class BaoVe extends NhanVien {
    private int GioLamViec;
    private String CV = "BV"; 

    
    public BaoVe() {}

    
    public BaoVe(String MaNV, String TenNV, int GioLamViec) {
        super(MaNV, TenNV);  
        this.GioLamViec = GioLamViec;
    }

   
    public int getGioLamViec() {
        return GioLamViec;
    }

    public void setGioLamViec(int GioLamViec) {
        this.GioLamViec = GioLamViec;
    }

    
    @Override
    public void Nhap(ArrayList<NhanVien> dsnv) {
        super.Nhap(dsnv);  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap gio lam viec cua bao ve: ");
        GioLamViec = scanner.nextInt();
    }

    
    @Override
    public void Xuat() {
        super.Xuat();  
        System.out.println("Gio lam viec: " + GioLamViec);
    }

    
    @Override
    public String toString() {
        return CV + "," + super.toString() + "," + GioLamViec;
    }
}
