import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class hoadon {
    private String MaHD;
    private Date Ngaylaphd;
    private Khachhang khachhang;
    private NhanVien nhanvien;
    private List<ChiTietHD> danhSachChiTietHD;
    private float Tongtien;
    
    public hoadon() {
        this.MaHD = "";
        this.Ngaylaphd = new Date();
        this.khachhang = null;
        this.nhanvien = null;
        this.danhSachChiTietHD = new ArrayList<>();
        this.Tongtien = 0;
    }
    public hoadon(String maHD, Date ngaylaphd, Khachhang khachhang, NhanVien nhanvien) {
        this.MaHD = maHD;
        this.Ngaylaphd = ngaylaphd;
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.danhSachChiTietHD = new ArrayList<>();
        this.Tongtien = 0;
    }
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        this.MaHD = sc.nextLine();
        
        // Ngày lập hóa đơn sẽ tự động lấy ngày hiện tại
        this.Ngaylaphd = new Date();
        
        // Nhập thông tin khách hàng
        System.out.println("Ban da co ma khach hang chua(chua/roi):");
        String as = sc.nextLine();
        if (as.equals("roi")) {
            System.out.println("Nhap Ma Khach Hang: ");

        }
        else if (as.equals("chua")) {
            Khachhang khachhangMoi = new Khachhang();
            khachhangMoi.Nhap();
            DSKH.dskh.add(khachhangMoi);

            //Nhập tên nhân viên và so sánh có trùng với tên nv bán hàng nào trong danh sách không nếu không thì cho nhập lại tên còn có thì đi tiếp
            // nhập hóa đơn
            System.out.print("Nhập số lượng chi tiết hóa đơn: ");
            int soLuongChiTiet = sc.nextInt();
            sc.nextLine(); // Xóa bỏ newline left-over
            
            this.danhSachChiTietHD = new ArrayList<>();
            
            for (int i = 0; i < soLuongChiTiet; i++) {
                System.out.print("Nhập mã sản phẩm: ");
                String maSP = sc.nextLine();
                System.out.print("Nhập số lượng: ");
                int soLuong = sc.nextInt();
                System.out.print("Nhập giá: ");
                float gia = sc.nextFloat();
                sc.nextLine(); // Xóa bỏ newline left-over
                
                ChiTietHD chiTiet = new ChiTietHD(maSP, soLuong, gia); // Giả sử bạn có một constructor cho ChiTietHD
                this.danhSachChiTietHD.add(chiTiet);
                this.Tongtien += soLuong * gia; // Cập nhật tổng tiền
            }
        }


}
}