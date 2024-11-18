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
        System.out.println("Chon loai nhan vien de them: 1. Thu Ngan 2. Bao Ve");
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
                System.out.println("Lua chon khong hop le!");
                return;
        }

        System.out.println("Da them nhan vien thanh cong!");
    }

    @Override
    public void Sua() {
        System.out.print("Nhap ma nhan vien muon sua: ");
        String maNV = scanner.nextLine();
        boolean timThay = false;

        for (NhanVien nv : dsnv) {
            if (nv.getMaNV().equals(maNV)) {
                timThay = true;

                if (nv instanceof ThuNgan) {
                    // Nếu là Thu Ngân
                    System.out.print("Ban muon sua thong tin nao: 1. Ten nhan vien 2. Ban so: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ten nhan vien moi: ");
                            nv.setTenNV(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ban so moi: ");
                            ((ThuNgan) nv).setBanSo(scanner.nextInt());
                            scanner.nextLine(); 
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }

                } else if (nv instanceof BaoVe) {
                    // Nếu là Bảo Vệ
                    System.out.print("Ban muon sua thong tin nao: 1. Ten nhan vien 2. Gio lam viec: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ten nhan vien moi: ");
                            nv.setTenNV(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap gio lam viec moi: ");
                            ((BaoVe) nv).setGioLamViec(scanner.nextInt());
                            scanner.nextLine(); 
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                }
                System.out.println("Thong tin nhan vien da duoc sua thanh cong!");
                break;
            }
        }
        if (!timThay) {
            System.out.println("Ma nhan vien ban can sua khong ton tai hoac ban nhap sai!");
        }
    }



    @Override
    public void Xoa() {
        String maNV;
        boolean found = false;

        // Nhập mã nhân viên muốn xóa
        System.out.print("Nhap ma cua nhan vien ban muon xoa: ");
        maNV = scanner.nextLine();

        // Duyệt qua ArrayList dsnv để tìm nhân viên
        for (int i = 0; i < dsnv.size(); i++) {
            if (dsnv.get(i).getMaNV().equals(maNV)) {
                found = true;
                dsnv.remove(i);  
                System.out.println("Nhan vien da duoc xoa!");
                break;  
            }
        }

        if (!found) {
            System.out.println("Ma nhan vien ban can xoa khong ton tai hoac ban nhap sai!");
        }
    }

    @Override
    public void TimKiem() {
        String tenNV, maNV;
        int choice, count = 0;

        // Hiển thị menu tìm kiếm
        System.out.print("Ban muon tim theo ten nhan vien hay ma nhan vien? 1.Ten nhan vien 2.Ma nhan vien: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ input trước đó

        switch (choice) {
            case 1:
                System.out.print("Nhap ten nhan vien: ");
                tenNV = scanner.nextLine();
                for (NhanVien nv : dsnv) {
                    if (nv.getTenNV().equalsIgnoreCase(tenNV)) {  // So sánh không phân biệt chữ hoa chữ thường
                        count++;
                        nv.Xuat();
                    }
                }
                if (count == 0) {
                    System.out.println("Nhan vien ban can tim khong co hoac ban nhap sai ten nhan vien!!!!");
                }
                break;

            case 2:
                System.out.print("Nhap ma nhan vien: ");
                maNV = scanner.nextLine();
                for (NhanVien nv : dsnv) {
                    if (nv.getMaNV().equals(maNV)) {
                        count++;
                        nv.Xuat();
                    }
                }
                if (count == 0) {
                    System.out.println("Nhan vien co ma nhan vien ban can tim khong co hoac ban nhap sai ma nhan vien!!!!");
                }
                break;

            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }

    @Override
    public void Xuat() {
        if (dsnv.isEmpty()) {
            System.out.println("Danh sach nhan vien rong.");
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
            FileReader fr = new FileReader("QuanLyCuaHangSach-OOP-main/dataNhanVien.txt");
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
            System.out.println("Da doc du lieu.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Khong doc duoc du lieu.");
        }
        dsnv = new ArrayList<>(list); // Gán ArrayList đọc được vào dsnv
    }

    @Override
    public void Ghifile() {
        try {
            FileWriter fw = new FileWriter("QuanLyCuaHangSach-OOP-main/dataNhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhanVien nv : dsnv) {
                bw.write(nv.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Da ghi du lieu.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Khong ghi duoc du lieu.");
        }
    }

    @Override
    public void Menu() {
        int choice;
        do {
            System.out.println("----------------------------------------------------");
            System.out.println("1.Them nhan vien");
            System.out.println("2.Xuat danh sach nhan vien");
            System.out.println("3.Sua Thong tin nhan vien");
            System.out.println("4.Xoa nhan vien");
            System.out.println("5.Tim kiem nhan vien");
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
