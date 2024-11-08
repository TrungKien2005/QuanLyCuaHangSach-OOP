import java.util.Scanner;

public class SachVanHoc extends Sach{
    private String TLVH;
    private String tl = "VH";

    public SachVanHoc(){}
    public SachVanHoc(String MaSach, String TenSach, String TacGia, float Gia, int SoLuong, String TLVH){
        super(MaSach,TenSach,TacGia,Gia,SoLuong);
        this.TLVH = TLVH;
    }
    public String getTLVH(){
        return TLVH;
    }
    public void setTLVH(String TLVH){
        this.TLVH = TLVH;
    }
    public void Nhap(){
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap the loai van hoc (Truyen ngan - Truyen dai - Tho - Kich): ");
        TLVH = scanner.nextLine();
    }
}