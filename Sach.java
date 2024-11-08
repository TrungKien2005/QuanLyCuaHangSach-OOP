import java.util.Scanner;
public abstract class Sach {
    private String MaSach;
    private String TenSach;
    private String TacGia;
    private float Gia;
    private int SoLuong;

    public Sach(){}
    public Sach(String MaSach, String TenSach, String TacGia, float Gia, int SoLuong){
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
    }

    public String getMaSach() {
        return MaSach;
    }
    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }
    public String getTenSach() {
        return TenSach;
    }
    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }
    public String getTacGia() {
        return TacGia;
    }
    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }
    public float getGia() {
        return Gia;
    }
    public void setGia(float Gia) {
        this.Gia = Gia;
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        MaSach = scanner.nextLine();
        boolean check = true;
        while (check){
            int count = 0;
            for(int i = 0; i < DSS.n; i++){
                if (DSS.dss[i].getMaSach().equals(MaSach)){
                    System.out.println("Ma sach nay da ton tai. Vui long nhap lai!");
                    System.out.print("Nhap ma sach: ");
                    MaSach = scanner.nextLine();
                    break;
                }
                else {
                    count++;
                }
            }
            if (count == DSS.n){
                check = false;
            }
        }
        System.out.print("Nhap ten sach: ");
        TenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        TacGia = scanner.nextLine();
        System.out.print("Nhap gia: ");
        Gia = scanner.nextFloat();
        System.out.print("Nhap so luong: ");
        SoLuong = scanner.nextInt();
    }
    public void Xuat(){
        System.out.println("------------------------");
        System.out.println("Ma sach "+MaSach);
        System.out.println("Ten sach "+TenSach);
        System.out.println("Tac gia "+TacGia);
        System.out.println("So luong hien co "+SoLuong);
    }
    @Override
    public String toString(){
        return MaSach+","+TenSach+","+TacGia+","+Gia+","+SoLuong;
    }
    public abstract void InThongTin();
}

