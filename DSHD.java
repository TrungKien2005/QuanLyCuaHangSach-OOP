import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DSHD implements IChucNang{
    private ArrayList<hoadon> dshd; // Danh sách các đối tượng Sach
    private ArrayList<Sach> dss;
    private ArrayList<KhachHang> dskh;
    private ArrayList<NhanVien> dsnv;
    private Scanner scanner = new Scanner(System.in);

    public DSHD(){
        dshd = new ArrayList<>();
    }
    public DSHD(ArrayList<hoadon> dshd, ArrayList<Sach> dss, ArrayList<KhachHang> dskh, ArrayList<NhanVien> dsnv) {
        this.dshd = dshd;
        this.dss = dss;
        this.dskh = dskh;
        this.dsnv = dsnv;
    }
    public DSHD(ArrayList<Sach> dss, ArrayList<KhachHang> dskh, ArrayList<NhanVien> dsnv) {
        this.dshd = new ArrayList<>();
        this.dss = dss;
        this.dskh = dskh;
        this.dsnv = dsnv;
    }

    @Override
    public void Them(){
        System.out.println("Thêm hóa đơn mới:");
        hoadon hd = new hoadon(); 
        hd.Nhap(dss, dskh, dsnv); // Gọi phương thức nhập của hóa đơn
        dshd.add(hd); // Thêm hóa đơn mới vào danh sách
        System.out.println("Thêm hóa đơn thành công.");
    }
    @Override
    public void Sua(){
        System.out.print("Nhập mã hóa đơn cần sửa: ");
        String maHD = scanner.nextLine();
        for (hoadon hd : dshd) {
            if (hd.getMaHD().equals(maHD)) {
                hd.Nhap(dss, dskh, dsnv); // Cho phép nhập lại thông tin hóa đơn
                System.out.println("Sửa hóa đơn thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn với mã " + maHD);
    }
    @Override
    public void Xoa(){
        System.out.print("Nhập mã hóa đơn cần xóa: ");
        String maHD = scanner.nextLine();
        for (int i = 0; i < dshd.size(); i++) {
            if (dshd.get(i).getMaHD().equals(maHD)) {
                dshd.remove(i); // Xóa hóa đơn
                System.out.println("Xóa hóa đơn thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn với mã " + maHD);
    }
    @Override
public void TimKiem() {
    System.out.println("Tìm kiếm hóa đơn theo:");
    System.out.println("1. Mã hóa đơn");
    System.out.println("2. Tên khách hàng");
    System.out.println("3. Mã khách hàng");
    System.out.print("Nhập lựa chọn: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Đọc bỏ newline

    switch (choice) {
        case 1:
            System.out.print("Nhập mã hóa đơn cần tìm: ");
            String maHD = scanner.nextLine();
            for (hoadon hd : dshd) {
                if (hd.getMaHD().equals(maHD)) {
                    System.out.println("Thông tin hóa đơn tìm được:");
                    hd.XuatHoaDon(dss, dskh, dsnv); // Xuất thông tin hóa đơn
                    return;
                }
            }
            System.out.println("Không tìm thấy hóa đơn với mã " + maHD);
            break;

        case 2:
            System.out.print("Nhập tên khách hàng cần tìm: ");
            String tenKH = scanner.nextLine().toLowerCase();  // Chuyển tên khách hàng thành chữ thường để so sánh không phân biệt chữ hoa/thường
            boolean found = false;
            for (hoadon hd : dshd) {
                if (hd.getKhachHang() != null && hd.getKhachHang().getTenKH().toLowerCase().contains(tenKH)) {
                    System.out.println("Thông tin hóa đơn tìm được:");
                    hd.XuatHoaDon(dss, dskh, dsnv); // Xuất thông tin hóa đơn
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy hóa đơn với tên khách hàng: " + tenKH);
            }
            break;

        case 3:
            System.out.print("Nhập mã khách hàng cần tìm: ");
            String maKH = scanner.nextLine();
            boolean foundByMaKH = false;
            for (hoadon hd : dshd) {
                if (hd.getMaKH().equals(maKH)) {
                    System.out.println("Thông tin hóa đơn tìm được:");
                    hd.XuatHoaDon(dss, dskh, dsnv); // Xuất thông tin hóa đơn
                    foundByMaKH = true;
                }
            }
            if (!foundByMaKH) {
                System.out.println("Không tìm thấy hóa đơn với mã khách hàng: " + maKH);
            }
            break;

        default:
            System.out.println("Lựa chọn không hợp lệ.");
            break;
    }
}


    @Override
    public void Xuat(){
        System.out.println("Danh sách hóa đơn:");
        if (dshd.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }
        for (hoadon hd : dshd) {
            hd.XuatHoaDon(dss,dskh,dsnv);
        }
    }
    public void Docfile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("QuanLyCuaHangSach-OOP-main/dataHoaDon.txt"))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày (ví dụ dd/MM/yyyy)
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                String maHD = parts[0]; // Mã hóa đơn
                Date ngayLap = null;
                
                try {
                    ngayLap = dateFormat.parse(parts[1]); // Chuyển đổi ngày
                } catch (Exception e) {
                    System.out.println("Lỗi khi chuyển đổi ngày: " + e.getMessage());
                }
                
                String maKH = parts[2]; // Mã khách hàng
                String maNV = parts[3]; // Mã nhân viên
    
                hoadon hd = new hoadon();
                hd.setMaHD(maHD);         // Gán mã hóa đơn
                hd.setNgaylaphd(ngayLap); // Gán ngày lập
                hd.setMaKH(maKH);         // Gán mã khách hàng
                hd.setMaNV(maNV);         // Gán mã nhân viên
                
                 // Tìm khách hàng và nhân viên từ danh sách
                KhachHang kh = null;
                for (KhachHang k : dskh) {
                    if (k.getMaKH().equals(maKH)) {
                        kh = k;
                        break;
                    }
                }
                if (kh != null) {
                    hd.setKhachHang(kh); // Gán đối tượng khách hàng vào hóa đơn
                }

                NhanVien nv = null;
                for (NhanVien n : dsnv) {
                    if (n.getMaNV().equals(maNV)) {
                        nv = n;
                        break;
                    }
                }
                if (nv != null) {
                    hd.setNhanVien(nv); // Gán đối tượng nhân viên vào hóa đơn
                }

                // Đọc danh sách chi tiết hóa đơn
                for (int i = 4; i < parts.length; i++) {
                    String[] chiTiet = parts[i].split("-");
                    String maSach = chiTiet[0];     // Mã sách
                    int soLuong = Integer.parseInt(chiTiet[1]); // Số lượng
                    ChiTietHD cthd = new ChiTietHD(maSach, soLuong);
                    hd.addChiTiet(cthd); // Thêm chi tiết vào hóa đơn
                }
    
                // Thêm hóa đơn vào danh sách
                dshd.add(hd);
            }
            System.out.println("Đọc dữ liệu từ file thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
    
    public void Ghifile() {
        try (FileWriter writer = new FileWriter("QuanLyCuaHangSach-OOP-main/dataHoaDon.txt")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày (ví dụ dd/MM/yyyy)
    
            for (hoadon hd : dshd) {
                StringBuilder line = new StringBuilder();
                line.append(hd.getMaHD()).append(","); // Ghi mã hóa đơn
    
                // Ghi ngày lập hóa đơn theo định dạng ngày
                String formattedDate = dateFormat.format(hd.getNgaylaphd());
                line.append(formattedDate).append(",");
    
                line.append(hd.getKhachHang().getMaKH()).append(","); // Ghi mã khách hàng
                line.append(hd.getNhanVien().getMaNV()).append(","); // Ghi mã nhân viên
    
                // Ghi các chi tiết hóa đơn
                for (ChiTietHD cthd : hd.getChiTiet()) {
                    line.append(cthd.getMaSP()).append("-").append(cthd.getSoLuong()).append(",");
                }
    
                // Xóa dấu `;` dư thừa cuối dòng
                if (line.charAt(line.length() - 1) == ',') {
                    line.deleteCharAt(line.length() - 1);
                }
    
                // Ghi vào file
                writer.write(line.toString());
                writer.write("\n");
            }
    
            System.out.println("Ghi dữ liệu vào file thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }
    
    
    @Override
    public void Menu(){
        int choice;
        do {
            System.out.println("----------------------------------------------------");
            System.out.println("1.Them hoa don");
            System.out.println("2.Xuat danh sach hoa don");
            System.out.println("3.Sua Thong tin hoa don");
            System.out.println("4.Xoa hoa don");
            System.out.println("5.Tim kiem hoa don");
            System.out.println("6.Doc du lieu file");
            System.out.println("7.Ghi du lieu vao file");
            System.out.println("8.Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Them();
                    break;
                case 2:
                    Xuat();
                    break;
                case 3:
                    Sua();
                    break;
                case 4:
                    Xoa();
                    break;
                case 5:
                    TimKiem();
                    break;
                case 6:
                    Docfile();
                    break;
                case 7:
                    Ghifile();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        } while (choice != 8);
    }
}
