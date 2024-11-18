import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class hoadon {
    private static int lastGeneratedMaHD = 0;  // Biến tĩnh để theo dõi mã hóa đơn vừa được sinh ra
    private String MaHD;
    private Date Ngaylaphd;
    private KhachHang KhachHang;
    private NhanVien nhanvien;
    private ArrayList<ChiTietHD> danhSachChiTietHD;
    private float Tongtien;
    
    public hoadon() {
        this.MaHD = generateMaHD();  // Sinh mã hóa đơn duy nhất cho mỗi đối tượng
        this.Ngaylaphd = new Date();
        this.KhachHang = null;
        this.nhanvien = null;
        this.danhSachChiTietHD = new ArrayList<>();
        this.Tongtien = 0;
    }
    
    public hoadon(String maHD, Date ngaylaphd, KhachHang KhachHang, NhanVien nhanvien) {
        this.MaHD = maHD;
        this.Ngaylaphd = ngaylaphd;
        this.KhachHang = KhachHang;
        this.nhanvien = nhanvien;
        this.danhSachChiTietHD = new ArrayList<>();
        this.Tongtien = 0;
    }

    // Phương thức để sinh mã hóa đơn duy nhất
    private static String generateMaHD() {
        lastGeneratedMaHD++;  // Tăng giá trị để sinh mã hóa đơn mới
        return "HD" + lastGeneratedMaHD;  // Định dạng mã hóa đơn như HD1, HD2, HD3, ...
    }

    // Getter và Setter cho MaHD
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        this.MaHD = maHD;
    }

    // Getter và Setter cho Ngaylaphd
    public Date getNgaylaphd() {
        return Ngaylaphd;
    }

    public void setNgaylaphd(Date ngaylaphd) {
        this.Ngaylaphd = ngaylaphd;
    }

    // Getter và Setter cho KhachHang
    public KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.KhachHang = khachHang;
    }

    // Getter và Setter cho NhanVien
    public NhanVien getNhanVien() {
        return nhanvien;
    }

    public void setNhanVien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    // Getter và Setter cho Tongtien
    public float getTongtien() {
        return Tongtien;
    }

    public void setTongtien(float tongtien) {
        this.Tongtien = tongtien;
    }

    // Getter cho ChiTiet
    public ArrayList<ChiTietHD> getChiTiet() {
        return danhSachChiTietHD;
    }

    // Thêm ChiTietHD vào danhSachChiTietHD
    public void addChiTiet(ChiTietHD cthd) {
        this.danhSachChiTietHD.add(cthd);
    }

    public String getMaKH() {
        if (this.KhachHang != null) {
            return this.KhachHang.getMaKH();  // Trả về mã khách hàng nếu có
        }
        return null;  // Trả về null nếu không có khách hàng
    }
    public void setMaKH(String maKH) {
        if (this.KhachHang != null) {
            this.KhachHang.setMaKH(maKH);
        }
    }

    public void setMaNV(String maNV) {
        if (this.nhanvien != null) {
            this.nhanvien.setMaNV(maNV);
        }
    }

    // Phương thức tìm KhachHang và NhanVien theo mã của họ
    public KhachHang timKhachHangTheoMa(String nMaKH, ArrayList<KhachHang> dskh) {
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().equals(nMaKH)) {
                return kh; // Trả về khách hàng nếu tìm thấy
            }
        }
        return null; // Nếu không tìm thấy, trả về null
    }

    public NhanVien timNhanVienTheoMa(String mNV, ArrayList<NhanVien> dsnv) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNV().equals(mNV)) {
                return nv; // Trả về nhân viên nếu tìm thấy
            }
        }
        return null; // Nếu không tìm thấy, trả về null
    }

    public void Nhap(ArrayList<Sach> dss, ArrayList<KhachHang> dskh, ArrayList<NhanVien> dsnv) {
        Scanner sc = new Scanner(System.in);
        this.MaHD = generateMaHD(); // Tự động sinh mã hóa đơn mới
        System.out.println("Mã hóa đơn: "+this.MaHD);
        System.out.println("Nhập mã nhân viên (chỉ Thu Ngân):");
        String mNV = sc.nextLine();
        boolean checkMaNV = false;
        while (!checkMaNV) {
            for (NhanVien nv : dsnv) {
                if (mNV.equals(nv.getMaNV())) {
                    if (nv instanceof ThuNgan) { // Kiểm tra nhân viên có phải là ThuNgan
                        this.nhanvien = nv;
                        checkMaNV = true;
                        System.out.println("Thông tin nhân viên:");
                        nv.Xuat();
                    } else {
                        System.out.println("Nhân viên không phải là Thu Ngân. Vui lòng nhập mã của Thu Ngân.");
                    }
                    break;
                }
            }
            if (!checkMaNV) {
                System.out.println("Mã nhân viên không chính xác. Vui lòng nhập lại!");
                System.out.print("Nhập mã nhân viên (chỉ Thu Ngân): ");
                mNV = sc.nextLine();
            }
        }
        this.Ngaylaphd = new Date();
        System.out.print("Nhập số lượng chi tiết hóa đơn: ");
        int soLuongChiTiet = sc.nextInt();
        sc.nextLine();

        this.danhSachChiTietHD = new ArrayList<>();
        for (int i = 0; i < soLuongChiTiet; i++) {
            System.out.print("Nhập mã sản phẩm: ");
            String maSach = sc.nextLine();
            boolean checkmaSach = false;
            while(!checkmaSach) {
                int dem=0;
                for(Sach sach :dss) {
                    if(maSach.equals(sach.getMaSach())) {
                        if(sach.getSoLuong()>0) {
                            checkmaSach = true;
                            break;
                        } else {
                            System.out.println("Sách bạn cần mua đã hết, vui lòng lựa chọn sách khác");
                            System.out.print("Nhập tên sách cần mua: ");
                            maSach = sc.nextLine();
                            dem=0;
                            break;
                        }
                    } else {
                        dem++;
                    }
                    if(dem==dss.size()) {
                        System.out.println("Sách bạn cần mua không có trong kho sách hoặc bạn nhập sai,vui lòng nhập lại!!!!");
                        System.out.print("Nhập mã sách cần mua: ");
                        maSach = sc.nextLine();
                        dem=0;
                    }
                }
            }
            System.out.print("Nhập số lượng: ");
            int soLuong = sc.nextInt();
            sc.nextLine();
            boolean checkSoLuong = false;
            while(!checkSoLuong) {
                for(Sach sach :dss) {
                    if(maSach.equals(sach.getMaSach())) {
                        if (sach.getSoLuong() >= soLuong && soLuong !=0) {
                            int soluongconlai = sach.getSoLuong() - soLuong;
                            sach.setSoLuong(soluongconlai);
                            checkSoLuong = true;
                            break;
                        } else {
                            System.out.println("Số lượng sách trong cửa hàng không đáp ứng được yêu cầu của bạn!!!!");
                            System.out.println("Số lượng sách còn lại trong cửa hàng: "+sach.getSoLuong());
                            System.out.print("Nhập số lượng cần mua: ");
                            soLuong = sc.nextInt();
                        }
                    }
                }
            }
            ChiTietHD chiTiet = new ChiTietHD(maSach, soLuong);
            this.danhSachChiTietHD.add(chiTiet);
            float gia = chiTiet.layGiaSach(dss);
            this.Tongtien += soLuong * gia;
        }
        System.out.println(" bạn đã có mã khách hàng chưa?");
        System.out.println("1. Rồi");
        System.out.println("2. Chưa");
        int as = sc.nextInt();
        sc.nextLine();
        switch (as) {
            case 1:
                System.out.println("Nhập mã Khách Hàng:");
                String nMaKH = sc.nextLine();
                boolean checkMaKH = false;
                while (!checkMaKH) {
                    for (KhachHang kh : dskh) {
                        if (nMaKH.equals(kh.getMaKH())) {
                            this.KhachHang = kh;
                            checkMaKH = true;
                            System.out.println("Thông tin khách hàng:");
                            kh.Xuat();
                            break;
                        }
                    }
                    if (!checkMaKH) {
                        System.out.println("Mã khách hàng không chính xác. Vui lòng nhập lại!");
                        System.out.print("Nhập mã khách hàng: ");
                        nMaKH = sc.nextLine();
                    }
                }
                break;
            case 2:
                System.out.println("-----Thêm khách hàng mới-----");
                KhachHang kh = new KhachHang();
                kh.Nhap();
                dskh.add(kh);
                this.KhachHang = kh;
                break;
        }
    }                     
    public void XuatHoaDon(ArrayList<Sach> dss, ArrayList<KhachHang> dskh, ArrayList<NhanVien> dsnv) {
        // In thông tin hóa đơn
        System.out.println("--------- HÓA ĐƠN ---------");
        System.out.println("Mã hóa đơn: " + this.MaHD);
        System.out.println("Ngày lập hóa đơn: " + this.Ngaylaphd.toString());
    
        // In thông tin khách hàng (chỉ in mã khách hàng)
        if (this.KhachHang != null) {
            System.out.println("Mã khách hàng: " + this.KhachHang.getMaKH()); // Giả sử KhachHang có phương thức getMaKH()
        } else {
            System.out.println("Khách hàng chưa được chọn.");
        }
        
        // In thông tin nhân viên (chỉ in mã nhân viên)
        if (this.nhanvien != null) {
            System.out.println("Mã nhân viên: " + this.nhanvien.getMaNV()); // Giả sử NhanVien có phương thức getMaNV()
        } else {
            System.out.println("Nhân viên chưa được chọn.");
        }
    
        // In thông tin chi tiết hóa đơn
        System.out.println("-------- CHI TIẾT HÓA ĐƠN --------");
        for (ChiTietHD chiTiet : this.danhSachChiTietHD) {
            // Tìm giá sách từ danh sách sách (dss)
            float gia = chiTiet.layGiaSach(dss);
            
            // Tìm tên sách từ mã sách trong chi tiết hóa đơn
            String tenSach = "Không tìm thấy sách"; // Mặc định nếu không tìm thấy
            for (Sach sach : dss) {
                if (sach.getMaSach().equals(chiTiet.getMaSP())) {
                    tenSach = sach.getTenSach(); // Lấy tên sách từ đối tượng Sach
                    break;
                }
            }
    
            // In chi tiết từng sản phẩm
            System.out.println("Mã sản phẩm: " + chiTiet.getMaSP() + " | Tên sản phẩm: " + tenSach 
                + " | Số lượng: " + chiTiet.getSoLuong() + " | Giá: " + gia 
                + " | Thành tiền: " + chiTiet.getSoLuong() * gia);
        }
    
        float total = 0;
        for (ChiTietHD chiTiet : this.danhSachChiTietHD) {
            float gia = chiTiet.layGiaSach(dss);
            total += chiTiet.getSoLuong() * gia;
        }
        this.Tongtien = total; // Set calculated total
        System.out.println("Tổng tiền: " + this.Tongtien);
    }
}
