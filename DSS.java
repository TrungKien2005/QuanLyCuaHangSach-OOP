import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;
public class DSS implements IChucNang {
    private ArrayList<Sach> dss; // Danh sách các đối tượng Sach
    private Scanner scanner = new Scanner(System.in);

    public DSS() {
        dss = new ArrayList<>(); // Khởi tạo ArrayList rỗng
    }
    public DSS(ArrayList<Sach> dss){
        this.dss=(ArrayList<Sach>) dss;
    }
    @Override
    public void Them() {
        System.out.println("Chon loai sach de them: 1. Sach Khoa Hoc 2. Sach Nau An 3. Sach Van Hoc");
        int loaiSach = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng xuống

        Sach sach = null;
        switch (loaiSach) {
            case 1:
                sach = new SachKhoaHoc();
                break;
            case 2:
                sach = new SachNauAn();
                break;
            case 3:
                sach = new SachVanHoc();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        sach.Nhap(dss); // Gọi phương thức Nhap của sach với ArrayList dss
        dss.add(sach); // Thêm sach vào danh sách
        System.out.println("Da them sach thanh cong!");
    }

    @Override
    public void Sua() {
        System.out.print("Nhap ma sach muon sua: ");
        String maSach = scanner.nextLine();
        boolean timThay = false;

        for (Sach sach : dss) {
            if (sach.getMaSach().equals(maSach)) {
                timThay = true;
                System.out.print("Ban muon sua toan bo hay chi mot thong tin? 1. Toan bo 2. Chi mot: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng còn lại

                if (choice == 1) {
                    sach.Nhap(dss); // Sửa toàn bộ thông tin
                } else if (choice == 2) {
                    System.out.print("Ban muon sua thong tin nao: 1. Ten sach 2. Tac gia 3. Gia 4. So luong");
                    if (sach instanceof SachKhoaHoc) System.out.print(" 5. Cap do");
                    if (sach instanceof SachVanHoc) System.out.print(" 5. The loai van hoc");
                    if (sach instanceof SachNauAn) System.out.print(" 5. The loai mon an");
                    System.out.println();

                    int choice1 = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng còn lại

                    switch (choice1) {
                        case 1:
                            System.out.print("Nhap ten sach moi: ");
                            sach.setTenSach(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap tac gia moi: ");
                            sach.setTacGia(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap gia tien moi: ");
                            sach.setGia(scanner.nextFloat());
                            scanner.nextLine(); // Đọc bỏ dòng còn lại
                            break;
                        case 4:
                            System.out.print("Nhap so luong moi: ");
                            sach.setSoLuong(scanner.nextInt());
                            scanner.nextLine(); // Đọc bỏ dòng còn lại
                            break;
                        case 5:
                            if (sach instanceof SachKhoaHoc) {
                                System.out.print("Nhap cap do moi (So cap-Trung cap-Cao cap): ");
                                ((SachKhoaHoc) sach).setCapDo(scanner.nextLine());
                            } else if (sach instanceof SachVanHoc) {
                                System.out.print("Nhap the loai van hoc moi (Truyen ngan-Truyen dai-Tho-Kich): ");
                                ((SachVanHoc) sach).setTLVH(scanner.nextLine());
                            } else if (sach instanceof SachNauAn) {
                                System.out.print("Nhap the loai mon an moi (Chinh-Phu-Trang mieng): ");
                                ((SachNauAn) sach).setLoaiMon(scanner.nextLine());
                            }
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } else {
                    System.out.println("Lua chon khong hop le!");
                }
                break;
            }
        }
        if (!timThay) {
            System.out.println("Ma sach cua sach ban can sua khong ton tai hoac ban nhap sai!");
        }
    }
    @Override
    public void Xoa() {
        String maSach;
        boolean found = false;

        // Nhập mã sách muốn xóa
        System.out.print("Nhap ma cua sach ban muon xoa: ");
        maSach = scanner.nextLine();

        // Duyệt qua ArrayList dss để tìm sách
        for (int i = 0; i < dss.size(); i++) {
            if (dss.get(i).getMaSach().equals(maSach)) {
                found = true;
                dss.remove(i);  // Xóa sách tại vị trí i
                System.out.println("Sach da duoc xoa!");
                break;  // Dừng vòng lặp khi tìm thấy và xóa thành công
            }
        }

        if (!found) {
            System.out.println("Ma sach ban can xoa khong ton tai hoac ban nhap sai!");
        }
    }

    @Override
    public void TimKiem() {
        String tenSach, tenTacgia, maSach;
        int choice, count = 0;

        // Hiển thị menu tìm kiếm
        System.out.print("Ban muon tim theo ten sach, tac gia hay ma sach? 1.Ten sach 2.Tac gia 3.Ma sach: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ input trước đó

        switch (choice) {
            case 1:
                System.out.print("Nhap ten sach: ");
                tenSach = scanner.nextLine();
                for (Sach sach : dss) {
                    if (sach.getTenSach().equalsIgnoreCase(tenSach)) {  // So sánh không phân biệt chữ hoa chữ thường
                        count++;
                        sach.Xuat();
                    }
                }
                if (count == 0) {
                    System.out.println("Sach ban can tim khong co hoac ban nhap sai ten sach!!!!");
                }
                break;

            case 2:
                System.out.print("Nhap ten tac gia: ");
                tenTacgia = scanner.nextLine();
                for (Sach sach : dss) {
                    if (sach.getTacGia().equalsIgnoreCase(tenTacgia)) {  // So sánh không phân biệt chữ hoa chữ thường
                        count++;
                        sach.Xuat();
                    }
                }
                if (count == 0) {
                    System.out.println("Sach cua tac gia ban can tim khong co hoac ban nhap sai ten tac gia!!!!");
                }
                break;

            case 3:
                System.out.print("Nhap ma sach: ");
                maSach = scanner.nextLine();
                for (Sach sach : dss) {
                    if (sach.getMaSach().equals(maSach)) {
                        count++;
                        sach.Xuat();
                    }
                }
                if (count == 0) {
                    System.out.println("Sach co ma sach ban can tim khong co hoac ban nhap sai ma sach!!!!");
                }
                break;

            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }
    @Override
    public void Xuat(){
        if (dss.isEmpty()) {
            System.out.println("Danh sach sach rong.");
            return;
        }
        for (Sach sach : dss) {
            sach.InThongTin();
        }
    }
    @Override
    public void Docfile(){
        List<Sach> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/dataSach.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] getData = line.split(",");
                if (getData[0].equals("kh")) {
                    list.add(new SachKhoaHoc(getData[1], getData[2], getData[3],
                            Float.parseFloat(getData[4]), Integer.parseInt(getData[5]), getData[6]));
                } else if (getData[0].equals("na")) {
                    list.add(new SachNauAn(getData[1], getData[2], getData[3],
                            Float.parseFloat(getData[4]), Integer.parseInt(getData[5]), getData[6]));
                } else if (getData[0].equals("vh")) {
                    list.add(new SachVanHoc(getData[1], getData[2], getData[3],
                            Float.parseFloat(getData[4]), Integer.parseInt(getData[5]), getData[6]));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dss = new ArrayList<>(list); // Gán ArrayList đọc được vào dss
    }

    @Override
    public void Ghifile() {
        try {
            FileWriter fw = new FileWriter("src/dataSach.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Sach sach : dss) {
                bw.write(sach.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Menu(){
        int choice;
        do{
            System.out.println("--------------------------");
            System.out.println("1.Thêm sách");
            System.out.println("2.Xuất danh sách sách");
            System.out.println("3.Sửa thông tin của sách");
            System.out.println("4.Xóa sách theo mã sách");
            System.out.println("5.Tìm kiếm sách");
            System.out.println("6.Lấy dữ liệu từ file");
            System.out.println("7.Xuất dữ liệu ra file");
            System.out.println("8.Thoat chuong trinh");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
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
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");

            }
        }
        while (choice != 8);

    }
}
