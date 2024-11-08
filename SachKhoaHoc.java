import java.util.ArrayList;
import java.util.Scanner;

public class SachKhoaHoc extends Sach {
    private String capDo;
    private String tl = "KH";

    public SachKhoaHoc() {}
    public SachKhoaHoc(String MaSach, String TenSach, String TacGia, float Gia, int SoLuong, String capDo) {
        super(MaSach, TenSach, TacGia, Gia, SoLuong);
        this.capDo = capDo;
    }

    public String getCapDo() {
        return capDo;
    }
    public void setCapDo(String capDo) {
        this.capDo = capDo;
    }

    public void Nhap(ArrayList<Sach> dss) {
        super.Nhap(dss);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap cap do sach nay (So cap - Trung cap - Cao cap): ");
        capDo = scanner.nextLine();
    }
    @Override
    public String toString(){
        return tl + "," + super.toString() + "," +capDo;
    }
    @Override
    public void InThongTin(){
        super.Xuat();
        System.out.println("Cap do: "+capDo);
    }
}
