import java.util.ArrayList;
import java.util.Scanner;

public abstract class NhanVien {
    private String MaNV;
    private String TenNV;

    
    public NhanVien() {}

    
    public NhanVien(String MaNV, String TenNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
    }

   
    public String getMaNV() {
        return MaNV;
    }
    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

   
    public String getTenNV() {
        return TenNV;
    }
    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    
    public void Nhap(ArrayList<NhanVien> dsnv) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        MaNV = scanner.nextLine();
        boolean check = true;

        
        while (check) {
            check = false;  
            for (NhanVien nv : dsnv) {
                if (nv.getMaNV().equals(MaNV)) {
                    System.out.println("Ma nhan vien nay da ton tai. Vui long nhap lai!");
                    System.out.print("Nhap ma nhan vien: ");
                    MaNV = scanner.nextLine();
                    check = true;  
                    break;
                }
            }
        }

        System.out.print("Nhap ten nhan vien: ");
        TenNV = scanner.nextLine();
    }

    
    public void Xuat() {
        System.out.println("------------------------");
        System.out.println("Ma nhan vien: " + MaNV);
        System.out.println("Ten nhan vien: " + TenNV);
    }

    
    @Override
    public String toString() {
        return MaNV + "," + TenNV;
    }
}
