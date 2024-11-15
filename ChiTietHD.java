import java.util.ArrayList;

public class ChiTietHD {
    private String maSach;
    private int soLuong;
    public ChiTietHD(String maSach, int soLuong) {
        this.maSach=maSach;
        this.soLuong=soLuong;
    }
    public String getMaSP() {
        return maSach;
    }
    public int getSoLuong() {
        return soLuong;
    }
 
    public float layGiaSach(ArrayList<Sach> dss) {
        for (Sach sach : dss) {
            if (sach.getMaSach().equals(maSach)) {
                return sach.getGia();
            }
        }
        return 0; // Trả về 0 nếu không tìm thấy sách
    }
    public float tinhTongTien(ArrayList<Sach> dss) {
        float gia = layGiaSach(dss);
        return gia * soLuong;
    }
    public void Xuat(ArrayList<Sach> dss){
        float gia = layGiaSach(dss);
        System.out.println("Sach: "+maSach);
        System.out.println("So luong: "+soLuong);
        System.out.println("Gia: "+gia);
    }
}
