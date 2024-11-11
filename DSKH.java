import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class DSKH implements IChucNang {
    static List<KhachHang> dskh;

    Scanner sc = new Scanner(System.in);

    public DSKH() {
        dskh = new ArrayList<>();
    }

    public DSKH(List<KhachHang> dskh) {
        this.dskh = dskh;
    }

    @Override
    public void Them() {
        KhachHang kh = new KhachHang();
        kh.Nhap();
        dskh.add(kh);
    }

    @Override
    public void Sua() {
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String maKH = sc.nextLine();
        boolean timThay = false;
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().equals(maKH)) {
                System.out.println("Nhập thông tin mới cho khách hàng:");
                kh.Nhap();
                timThay = true;
                System.out.println("Đã cập nhật thông tin khách hàng.");
                break;
            }
            if (!timThay) {
                System.out.println("Không tìm thấy khách hàng với mã " + maKH);
            }
        }
    }

    @Override
    public void Xoa() {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = sc.nextLine();
        boolean timThay = false;
        for (int i = 0; i < dskh.size(); i++) {
            if (dskh.get(i).getMaKH().equals(maKH)) {
                dskh.remove(i);
                System.out.println("Đã xóa khách hàng với mã " + maKH);
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy khách hàng với mã " + maKH);
        }
    }

    @Override
    public void TimKiem() {
        System.out.print("Nhập mã hoặc tên khách hàng cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean timThay = false;
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().toLowerCase().contains(keyword) || kh.getTenKH().toLowerCase().contains(keyword)) {
                kh.Xuat();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy khách hàng với từ khóa " + keyword);
        }
    }

    @Override
    public void Xuat() {
        if (dskh.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            for (KhachHang kh : dskh) {
                kh.Xuat(); 
            }
        }
    }

    @Override
    public void Ghifile() {}

    @Override
    public void Docfile() {}

    public void DocFile() {
        List<KhachHang> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("java/dataKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] getData = line.split(",");
                if (getData.length == 4) {
                    String maKH = getData[0];
                    String tenKH = getData[1];
                    String sdt = getData[2];
                    String diachi = getData[3];

                    KhachHang kh = new KhachHang(maKH, tenKH, sdt, diachi);
                    list.add(kh);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dskh = new ArrayList<>(list);  
        System.out.println("Đã đọc danh sách khách hàng từ file.");
    }
    public void GhiFile() {
        try {
            FileWriter fw = new FileWriter("java/dataKhachHang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (KhachHang kh : dskh) {
                bw.write(kh.toString());  
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Đã ghi danh sách khách hàng ra file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Menu() {
        boolean check = true;
        while (check) {
            System.out.println("--------------------------");
            System.out.println("1.Thêm khách hàng");
            System.out.println("2.Sửa khách hàng");
            System.out.println("3.Xóa khách hàng");
            System.out.println("4.Tìm kiếm khách hàng");
            System.out.println("5.Xuất danh sách khách hàng");
            System.out.println("6.Lấy dữ liệu từ file");
            System.out.println("7.Xuất dữ liệu ra file");
            System.out.println("8.Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Them();
                    break;
                case 2:
                    Sua();
                    break;
                case 3:
                    Xoa();
                    break;
                case 4:
                    TimKiem();
                    break;
                case 5:
                    Xuat();
                    break;
                case 6:
                    DocFile();
                    break;
                case 7:
                    GhiFile();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh...");

                default:
                    check = false;
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
                    break;
            }
        }
    }

}
