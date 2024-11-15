import java.util.ArrayList;
import java.util.Scanner;

public class BaoVe extends NhanVien {
    private int GioLamViec; 
    private String CV = "BaoVe"; 

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

    public void Nhap(ArrayList<NhanVien> dsnv) {
        super.Nhap(dsnv);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so gio lam viec cua bao ve: ");
        GioLamViec = scanner.nextInt();
    }

    @Override
    public String toString() {
        return CV + "," + super.toString() + "," + GioLamViec;
    }

    public void Xuat() {
        super.Xuat();
        System.out.println("So gio lam viec: " + GioLamViec);
    }
}
