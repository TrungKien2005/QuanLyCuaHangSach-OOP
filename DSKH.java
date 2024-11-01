import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DSKH implements IChucNang{
    static List<Khachhang> dskh;  // Sử dụng private

    Scanner sc = new Scanner(System.in);

    public DSKH() {
        dskh = new ArrayList<>();  // Khởi tạo List
    }

    public DSKH(List<Khachhang> dskh) {
        this.dskh = dskh;
    }
    @Override
    public void Them(){
        Khachhang kh = new Khachhang();
        kh.Nhap();
        dskh.add(kh);  // Thêm khách hàng vào List
    }

    @Override
    public void Sua(){

    }
    @Override
    public void Xoa(){

    }
    @Override
    public void TimKiem(){

    }
    @Override
    public void Xuat(){

    }
    public void DocFile(){

    }
    public void GhiFile(){

    }
    @Override
    public void Menu(){
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
                default:
                    check = false;
                    break;
            }
        }
    }
}
