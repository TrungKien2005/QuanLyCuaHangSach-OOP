import java.util.Scanner;

public class Khachhang {
    private String TenKH;
    private String Sdt;
    private String Diachi;
    private String MaKH;
    
    public Khachhang(){
        MaKH="";
        TenKH="";
        Sdt="";
        Diachi="";
    }
    public Khachhang(String MaKH,String TenKH,String Sdt,String Diachi){
        this.MaKH=MaKH;
        this.TenKH=TenKH;
        this.Sdt=Sdt;
        this.Diachi=Diachi;
    }
    public String getDiachi() {
        return Diachi;
    }
    public String getMaKH() {
        return MaKH;
    }
    public String getSdt() {
        return Sdt;
    }
    public String getTenKH() {
        return TenKH;
    }
    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
    public void setMaKH(String maKH) {
        MaKH = maKH;
    }
    public void setSdt(String sdt) {
        Sdt = sdt;
    }
    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang: ");
        MaKH = sc.nextLine();
        System.out.println("Nhap ten khach hang:");
        TenKH=sc.nextLine();
        System.out.println("Nhap so dien thoai");
        Sdt=sc.nextLine();
        System.out.println("Nhap dia chi:");
        Diachi=sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Ma khach hang: "+MaKH);
        System.out.println("Ten khach hang: "+TenKH);
        System.out.println("So dien thoai: "+Sdt);
        System.out.println("Dia chi: "+Diachi);

    }
    public String toString() {
        return "Khachhang {" +
                "TenKH='" + TenKH + '\'' +
                ", Sdt='" + Sdt + '\'' +
                ", DiaChi='" + Diachi + '\'' +
                ", MaKH='" + MaKH + '\'' +
                '}';
    }
    
}
