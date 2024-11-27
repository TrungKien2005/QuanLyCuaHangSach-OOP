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
        System.out.print("Nhập mã nhân viên: ");
        MaNV = scanner.nextLine();
        boolean check = true;

        
        while (check) {
            check = false;  
            for (NhanVien nv : dsnv) {
                if (nv.getMaNV().equals(MaNV)) {
                    System.out.println("Mã nhân viên này đã tồn tại. vui lòng nhập lại!");
                    System.out.print("Nhập mã nhân viên: ");
                    MaNV = scanner.nextLine();
                    check = true;  
                    break;
                }
            }
        }

        System.out.print("Nhập tên nhân viên: ");
        TenNV = scanner.nextLine();
    }

    
    public void Xuat() {
        System.out.println("------------------------");
        System.out.println("Mã nhân viên: " + MaNV);
        System.out.println("Tên nhân viên: " + TenNV);
    }

    
    @Override
    public String toString() {
        return MaNV + "," + TenNV;
    }
}
