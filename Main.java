
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSS dss = new DSS();
        DSNV dsnv = new DSNV();
        DSKH dskh = new DSKH();

        dss.Docfile();
        dsnv.Docfile();
        dskh.Docfile();
        // Truyền danh sách vào DSHD
        DSHD dshd = new DSHD(dss.getDSS(), dskh.getDSKH(), dsnv.getDSNV());
        boolean check = true;
        while(check)
        {
            System.out.println("Nhập lựa chọn của bạn: 1.Sách 2.Nhân viên 3.Khách hàng 4.Hóa đơn 5.Thống kê 0.Thoát");
            int luachon = sc.nextInt();
            switch(luachon)
            {
                case 1:
                {
                    dss.Menu();
                    break;
                }
                case 2:
                {
                    dsnv.Menu();
                    break;
                }
                case 3:
                {
                    dskh.Menu();
                    break;
                }
                case 4:
                {
                    dshd.Menu();
                    break;
                }
                default:
                {
                    check = false;
                    break;
                }
            }
        }
    }
}
