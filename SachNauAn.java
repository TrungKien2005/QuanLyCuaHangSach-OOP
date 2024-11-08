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
    public void setLoaiMon(){
        this.LoaiMon = LoaiMon;
    }
    public void Nhap(){
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap the loai cho mon an (Chinh - Phu - Trang mieng): ");
        LoaiMon = scanner.nextLine();
    }
}