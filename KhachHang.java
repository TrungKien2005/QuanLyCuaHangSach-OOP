import java.util.Scanner;
import java.util.ArrayList;

public class KhachHang {
    private String TenKH;
    private String Sdt;
    private String Diachi;
    private String MaKH;

    public KhachHang(){
        MaKH="";
        TenKH="";
        Sdt="";
        Diachi="";
    }
    public KhachHang(String MaKH,String TenKH,String Sdt,String Diachi){
        this.MaKH= MaKH;
        this.TenKH= TenKH;
        this.Sdt= Sdt;
        this.Diachi= Diachi;
    }
    public String getMaKH() {
        return MaKH;
    }
    public void setMaKH(String maKH) {
        MaKH = maKH;
    }
    public String getTenKH() {
        return TenKH;
    }
    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }
    public String getSdt() {
        return Sdt;
    }
    public void setSdt(String sdt) {
        Sdt = sdt;
    }
    public String getDiachi() {
        return Diachi;
    }
    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng: ");
        MaKH = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        TenKH=sc.nextLine();
        System.out.print("Nhập số điện thọai: ");
        Sdt=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        Diachi=sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Mã khách hàng: "+MaKH);
        System.out.println("Tên khách hàng: "+TenKH);
        System.out.println("Số điện thọai: "+Sdt);
        System.out.println("Địa chỉ: "+Diachi);
    }
    @Override
    public String toString() {
        return return MaKH + "," + TenKH + "," + Sdt + "," + Diachi;
    }

}
