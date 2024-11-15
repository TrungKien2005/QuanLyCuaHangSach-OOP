import java.util.ArrayList;
import java.util.Scanner;

public class ThuNgan extends NhanVien {
    private int banSo; 
    private String CV = "ThuNgan"; 

    public ThuNgan() {}

    public ThuNgan(String MaNV, String TenNV, int banSo) {
        super(MaNV, TenNV);
        this.banSo = banSo;
    }

    public int getBanSo() {
        return banSo;
    }

    public void setBanSo(int banSo) {
        this.banSo = banSo;
    }

    public void Nhap(ArrayList<NhanVien> dsnv) {
        super.Nhap(dsnv);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so ban lam viec cua thu ngan: ");
        banSo = scanner.nextInt();
    }

    @Override
    public String toString() {
        return CV + "," + super.toString() + "," + banSo;
    }

    public void Xuat() {
        super.Xuat();
        System.out.println("So ban lam viec: " + banSo);
    }
}
