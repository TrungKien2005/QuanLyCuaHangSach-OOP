import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSNV implements IChucNang {
    private ArrayList<NhanVien> dsnv;  
    private Scanner scanner = new Scanner(System.in);

   
    public DSNV() {
        dsnv = new ArrayList<>(); 
    }

    
    public DSNV(ArrayList<NhanVien> dsnv) {
        this.dsnv = dsnv;
    }
    public ArrayList<NhanVien> getDSNV() {
        return dsnv; // Trả về danh sách sách
    }
    @Override
    public void Them() {
        System.out.println("Chọn loại nhân viên để thêm: 1. Thu ngân 2. Bảo vệ");
        int loaiNV = scanner.nextInt();
        scanner.nextLine(); 

        
        switch (loaiNV) {
            case 1:
                NhanVien nv = new ThuNgan();
                nv.Nhap(dsnv);
                dsnv.add(nv);
                break;
            case 2:
                nv = new BaoVe();
                nv.Nhap(dsnv);
                dsnv.add(nv);
                break;
            default:
                System.out.println("lựa chọn không hợp lệ!");
                return;
        }

        System.out.println("Đã thêm nhân viên thành công!");
    }

    @Override
    public void Sua() {
        System.out.print("Nhập mã nhân viên muốn sửa: ");
        String maNV = scanner.nextLine();
        boolean timThay = false;

        for (NhanVien nv : dsnv) {
            if (nv.getMaNV().equals(maNV)) {
                timThay = true;

                // Nếu là ThuNgan
                if (nv instanceof ThuNgan) {
                    System.out.println("Nhân viên là thu ngân. Nhập thông tin muốn sửa:");
                    System.out.print("Sửa tên nhân viên: ");
                    nv.setTenNV(scanner.nextLine());

                    System.out.print("Sửa số thứ tự bàn: ");
                    ((ThuNgan) nv).setBanSo(scanner.nextInt());
                    scanner.nextLine(); // Đọc ký tự newline còn lại
                } 
                // Nếu là BaoVe
                else if (nv instanceof BaoVe) {
                    System.out.println("Nhân viên là bảo vệ. Nhập thông tin muốn sửa:");
                    System.out.print("Sửa tên nhân viên: ");
                    nv.setTenNV(scanner.nextLine());

                    System.out.print("Sửa giờ làm việc: ");
                    ((BaoVe) nv).setGioLamViec(scanner.nextInt());
                    scanner.nextLine(); // Đọc ký tự newline còn lại
                }

                System.out.println("Thông tin nhân viên đã được sửa thành công!");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Mã nhân viên cần sửa không tồn tại hoặc nhập sai!");
        }
    }



    @Override
    public void Xoa() {
        String maNV;
        boolean timThay = false;

        // Nhập mã nhân viên muốn xóa
        System.out.print("Nhập mã nhân viên muốn xóa: ");
        maNV = scanner.nextLine();

        // Duyệt qua ArrayList dsnv để tìm nhân viên
        for (int i = 0; i < dsnv.size(); i++) {
            if (dsnv.get(i).getMaNV().equals(maNV)) {
                timThay = true;
                dsnv.remove(i);  
                System.out.println("Đã xóa nhân viên khỏi danh sách!");
                break;  
            }
        }

        if (!timThay) {
            System.out.println("Mã nhân viên cần xóa không tồn tại hoặc nhập sai!");
        }
    }

    @Override
    public void TimKiem() {
    String tenNV, maNV;
    int choice;
    boolean timThay = false; 

    System.out.print("Tìm kiếm nhân viên theo tên hay mã nhân viên? 1.Tên nhân viên 2.Mã nhân viên: ");
    choice = scanner.nextInt();
    scanner.nextLine(); 

    switch (choice) {
        case 1:
            System.out.print("Nhập tên nhân viên: ");
            tenNV = scanner.nextLine();
            for (NhanVien nv : dsnv) {
                if (nv.getTenNV().equalsIgnoreCase(tenNV)) {  
                    timThay = true;
                    nv.Xuat();
                }
            }
            if (!timThay) {
                System.out.println("Nhân viên cần tìm không tồn tại hoặc nhập sai tên nhân viên!");
            }
            break;

        case 2:
            System.out.print("Nhập mã nhân viên: ");
            maNV = scanner.nextLine();
            for (NhanVien nv : dsnv) {
                if (nv.getMaNV().equals(maNV)) {
                    timThay = true;
                    nv.Xuat();
                }
            }
            if (!timThay) {
                System.out.println("Nhân viên cần tìm không tồn tại hoặc nhập sai mã nhân viên!");
            }
            break;

        default:
            System.out.println("Lựa chọn không hợp lệ!");
            break;
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
        List<NhanVien> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("dataNhanVien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] getData = line.split(",");
                if (getData[0].equals("TN")) {
                    list.add(new ThuNgan(getData[1], getData[2], Integer.parseInt(getData[3])));
                } else if (getData[0].equals("BV")) {
                    list.add(new BaoVe(getData[1], getData[2], Integer.parseInt(getData[3])));
                }
            }
            br.close();
            fr.close();
            System.out.println("Đã đọc dữ liệu.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không đọc được dữ liệu.");
        }
        dsnv = new ArrayList<>(list); // Gán ArrayList đọc được vào dsnv
    }

    @Override
    public void Ghifile() {
        try {
            FileWriter fw = new FileWriter("dataNhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhanVien nv : dsnv) {
                bw.write(nv.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Đã ghi dữ liệu.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không ghi được dữ liệu.");
        }
    }

    @Override
    public void Menu() {
        int choice;
        do {
            System.out.println("----------------------------------------------------");
            System.out.println("1.Thêm nhân viên");
            System.out.println("2.Xuất danh sách nhân viên");
            System.out.println("3.Sửa thông tin nhân viên");
            System.out.println("4.Xóa nhân viên");
            System.out.println("5.Tìm kiếm nhân viên");
            System.out.println("6.Đọc dữ liệu");
            System.out.println("7.Ghi dữ liệu");
            System.out.println("8.Thoát");
            System.out.print("Nhập lựa chọn: ");
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
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
