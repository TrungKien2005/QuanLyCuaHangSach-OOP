import java.util.ArrayList;
import java.util.Scanner;

public class SachNauAn extends Sach{
    private String LoaiMon;
    private String tl = "NA";


    public SachNauAn(){}
    public SachNauAn(String MaSach, String TenSach, String TacGia, float Gia, int SoLuong, String LoaiMon){
        super(MaSach,TenSach,TacGia,Gia,SoLuong);
        this.LoaiMon = LoaiMon;
    }
    public String getLoaiMon(){
        return  LoaiMon;
    }
    public void setLoaiMon(String LoaiMon){
        this.LoaiMon = LoaiMon;
    }
    public void Nhap(ArrayList<Sach> dss){
        super.Nhap(dss);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap the loai cho mon an (Chinh - Phu - Trang mieng): ");
        LoaiMon = scanner.nextLine();
    }
    @Override
    public String toString(){
        return tl + "," + super.toString() + "," + LoaiMon;
    }
    @Override
    public void InThongTin(){
        super.Xuat();
        System.out.println("Loai mon: "+LoaiMon);
    }
}
