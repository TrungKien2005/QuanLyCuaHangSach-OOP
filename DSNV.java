import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DSNV implements IChucNang {
    private ArrayList<NhanVien> dsnv; 
    private Scanner sc = new Scanner(System.in);

    public DSNV() {
        dsnv = new ArrayList<>(); 
    }
    // Hàm thiết lập có tham số
    public void setDsnv(ArrayList<NhanVien> dsnv) {
        this.dsnv = dsnv;  
    }

    @Override
    public void Them() {
        System.out.println("Chọn loại nhân viên để thêm: 1. Thu Ngân 2. Bảo Vệ");
        int loaiNV = sc.nextInt();
        sc.nextLine(); 

        NhanVien nv = null;
        switch (loaiNV) {
            case 1:
                // nv = new ThuNgan();
                // break;
                NhanVien nv = new ThuNgan();
                ThuNgan.nhap(dsnv);
                dsnv.add(ThuNgan);
            case 2:
                // nv = new BaoVe();
                // break;
                NhanVien nv = new BaoVe();
                BaoVe.nhap(dsnv);
                dsnv.add(BaoVe);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        // nv.Nhap(dsnv);
        // dsnv.add(nv); 
        System.out.println("Đã thêm nhân viên thành công!");
    }

    @Override
    public void Sua() {
        System.out.print("Nhập mã nhân viên muốn sửa: ");
        String maNV = sc.nextLine();
        boolean timThay = false;

        for (NhanVien nv : dsnv) {
            if (nv.getMaNV().equals(maNV)) {
                timThay = true;
                System.out.println("Sửa thông tin cho nhân viên:");
                nv.Nhap(dsnv); 
                break;
            }
        }

        if (!timThay) {
            System.out.println("Mã nhân viên không tồn tại hoặc nhập chưa đúng!");
        }
    }

    @Override
    public void Xoa() {
        System.out.print("Nhập mã của nhân viên muốn xóa: ");
        String maNV = sc.nextLine();
        boolean timThay = false;

        for (int i = 0; i < dsnv.size(); i++) {
            if (dsnv.get(i).getMaNV().equals(maNV)) {
                timThay = true;
                dsnv.remove(i); 
                System.out.println("Nhân viên đã được xóa!");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Mã nhân viên không tồn tại hoặc bạn nhập sai!");
        }
    }

    @Override
    public void TimKiem() {
        System.out.print("Nhập tên nhân viên muốn tìm: ");
        String tenNV = sc.nextLine();
        boolean timThay = false;

        for (NhanVien nv : dsnv) {
            if (nv.getTenNV().equalsIgnoreCase(tenNV)) {
                timThay = true;
                nv.Xuat(); 
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy nhân viên với tên bạn đã nhập!");
        }
    }

    @Override
    public void Xuat() {
        if (dsnv.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng.");
            return;
        }

        for (NhanVien nv : dsnv) {
            nv.Xuat(); 
        }
    }

    @Override
    public void Docfile() {
        try {
            FileReader fr = new FileReader("src/dataNhanVien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                NhanVien nv = null;
                if (data[0].equals("ThuNgan")) {
                    nv = new ThuNgan(data[1], data[2], Integer.parseInt(data[3]));
                } else if (data[0].equals("BaoVe")) {
                    nv = new BaoVe(data[1], data[2], Integer.parseInt(data[3]));
                }
                dsnv.add(nv);
            }

            br.close();
            fr.close();
            System.out.println("Dữ liệu đã được tải vào danh sách.");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void Ghifile() {
        try {
            FileWriter fw = new FileWriter("src/dataNhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien nv : dsnv) {
                bw.write(nv.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("Dữ liệu đã được ghi vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void Menu() {
        int choice;
        do {
            System.out.println("----- Quản lý Nhân Viên -----");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xuất danh sách nhân viên");
            System.out.println("3. Sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Đọc dữ liệu từ file");
            System.out.println("7. Ghi dữ liệu vào file");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 8);
    }
}
