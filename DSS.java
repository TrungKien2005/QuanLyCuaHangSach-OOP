import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DSS {
    private static int n;
    private static ArrayList<Sach> dss;
    private Scanner scanner = new Scanner(System.in);

    // Constructor mặc định
    public DSS() {
        n = 0;
        dss = new ArrayList<>();
    }

    // Constructor với tham số
    public DSS(int n, ArrayList<Sach> dss) {
        DSS.n = n;
        DSS.dss = dss;
    }

    // Phương thức thêm sách
    public void Them() {
        int choice;
        System.out.print("Chon the loai sach ban muon them: 1.Khoa hoc 2.Nau an 3.Van hoc");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                SachKhoaHoc sachKhoaHoc = new SachKhoaHoc();
                sachKhoaHoc.Nhap();
                dss.add(sachKhoaHoc);  // Thêm vào ArrayList
                break;
            case 2:
                SachNauAn sachNauAn = new SachNauAn();
                sachNauAn.Nhap();
                dss.add(sachNauAn);  // Thêm vào ArrayList
                break;
            case 3:
                SachVanHoc sachVanHoc = new SachVanHoc();
                sachVanHoc.Nhap();
                dss.add(sachVanHoc);  // Thêm vào ArrayList
                break;
        }
        n++;  // Tăng số lượng sách đã thêm
    }
}
    @Override
    public void Sua(){
        System.out.print("Nhap ma sach muon sua: ");
        String MaSach = scanner.nextLine();
        int choice
    }
}