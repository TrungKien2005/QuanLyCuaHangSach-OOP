import java.util.ArrayList;
import java.util.Scanner;

public class ThuNgan extends NhanVien {
    private int BanSo;
    private String CV = "TN"; 

    
    public ThuNgan() {}

    
    public ThuNgan(String MaNV, String TenNV, int BanSo) {
        super(MaNV, TenNV);  
        this.BanSo = BanSo;
    }

    
    public int getBanSo() {
        return BanSo;
    }

    public void setBanSo(int BanSo) {
        this.BanSo = BanSo;
    }

    
    @Override
    public void Nhap(ArrayList<NhanVien> dsnv) {
        super.Nhap(dsnv);  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ tự bàn của thu ngân: ");
        BanSo = scanner.nextInt();
    }

    
    @Override
    public void Xuat() {
        super.Xuat();  
        System.out.println("Bàn làm việc số: " + BanSo);
    }

    
    @Override
    public String toString() {
        return CV + "," + super.toString() + "," + BanSo;
    }
}
