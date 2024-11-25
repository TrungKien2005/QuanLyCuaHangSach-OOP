import java.util.ArrayList;
import java.util.Scanner;

public class ThuNgan extends NhanVien {
    private int banSo;
    private String CV = "TN"; 

    
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

    
    @Override
    public void Nhap(ArrayList<NhanVien> dsnv) {
        super.Nhap(dsnv);  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban so thu ngan: ");
        banSo = scanner.nextInt();
    }

    
    @Override
    public void Xuat() {
        super.Xuat();  
        System.out.println("Ban lam viec so: " + banSo);
    }

    
    @Override
    public String toString() {
        return CV + "," + super.toString() + "," + banSo;
    }
}
