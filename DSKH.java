import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DSKH implements IChucNang {
    private ArrayList<KhachHang> dskh;
    private Scanner sc;

    public DSKH() {
        dskh = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public ArrayList<KhachHang> getDSKH() {
        return dskh;
    }
    @Override
    public void Them() {
        KhachHang kh = new KhachHang();
        kh.Nhap();
        dskh.add(kh);
        System.out.println("Đã thêm khách hàng.");
    }

    @Override
    public void Sua() {
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String maKH = sc.nextLine();
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().equals(maKH)) {
                System.out.println("Nhập thông tin mới cho khách hàng:");
                kh.Nhap();
                System.out.println("Đã cập nhật thông tin khách hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với mã " + maKH);
    }

    @Override
    public void Xoa() {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = sc.nextLine();
        boolean removed = dskh.removeIf(kh -> kh.getMaKH().equals(maKH));
        if (removed) {
            System.out.println("Đã xóa khách hàng với mã " + maKH);
        } else {
            System.out.println("Không tìm thấy khách hàng với mã " + maKH);
        }
    }

    @Override
    public void TimKiem() {
        System.out.print("Nhập mã hoặc tên khách hàng cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        ArrayList<KhachHang> ketQua = new ArrayList<>();
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().toLowerCase().contains(keyword) ||
                    kh.getTenKH().toLowerCase().contains(keyword)) {
                ketQua.add(kh);
            }
        }
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng với từ khóa " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (KhachHang kh : ketQua) {
                kh.Xuat();
            }
        }
    }

    @Override
    public void Xuat() {
        if (dskh.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : dskh) {
                kh.Xuat();
            }
        }
    }

    @Override
    public void Ghifile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dataKhachHang.txt"))) {
            for (KhachHang kh : dskh) {
                bw.write(kh.toString());
                bw.newLine();
            }
            System.out.println("Đã ghi danh sách khách hàng ra file.");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void Docfile() {
        try (BufferedReader br = new BufferedReader(new FileReader("dataKhachHang.txt"))) {
            dskh.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] getData = line.split(",");
                if (getData.length == 4) {
                    String maKH = getData[0];
                    String tenKH = getData[1];
                    String sdt = getData[2];
                    String diachi = getData[3];

                    dskh.add(new KhachHang(maKH, tenKH, sdt, diachi));
                }
            }
            System.out.println("Đã đọc danh sách khách hàng từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void Menu() {
        boolean running = true;
        while (running) {
            System.out.println("--------------------------");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Sửa khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Tìm kiếm khách hàng");
            System.out.println("5. Xuất danh sách khách hàng");
            System.out.println("6. Lấy dữ liệu từ file");
            System.out.println("7. Xuất dữ liệu ra file");
            System.out.println("8. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1 -> Them();
                case 2 -> Sua();
                case 3 -> Xoa();
                case 4 -> TimKiem();
                case 5 -> Xuat();
                case 6 -> Docfile();
                case 7 -> Ghifile();
                case 8 -> {
                    running = false;
                    System.out.println("Thoát chương trình...");
                }
                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
