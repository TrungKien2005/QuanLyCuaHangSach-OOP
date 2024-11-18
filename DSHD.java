import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class DSHD implements IChucNang {
    Scanner sc = new Scanner(System.in);
    static int n;
    static HoaDon[] dshd;
    private int dem=1; //Biến đếm và String dùng để tạo mã hóa đơn tự động
    String MaHD ="HD";

    public DSHD() //Hàm thiết lập rỗng này khởi tạo tự động mảng hóa đơn khi đã có mảng khách hàng
    {
        n = DSKH.n;
        dshd = new HoaDon[n];

        for(int i=0;i<n;i++)
        {
            dshd[i] = new HoaDon(DSKH.dskh[i]);//Truyền vào khách hàng thứ i ứng với hóa đơn thứ i
            dshd[i].setMahd(MaHD+dem); //Ta ghép biến String và biến đếm lại để tạo thành mã hóa đơn cho lớp hóa đơn
            dem++; //Sau đó tăng biến đếm lên
        }
    }

    public DSHD(int n,HoaDon[] dshd)
    {
        DSHD.n = n;
        DSHD.dshd = dshd;
    }

    @Override
    public void Them() {}
    @Override
    public void Sua(){}
    @Override
    public void Xoa(){}
    @Override
    public void TimKiem()
    {
        int dem=0;
        System.out.println("Nhập mã của hóa đơn cần tìm: ");
        String maHoaDon = sc.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dshd[i].getMahd().equals(maHoaDon)) {
                dem++;
                dshd[i].Xuat(DSKH.dskh[i]);
                break;
            }
        }
        if(dem==0)
        {
            System.out.println("Mã của hóa đơn bạn cần tìm không tồn tại hoặc bạn nhập sai!!!!");
        }
    }
    @Override
    public void Xuat()
    {
        for(int i=0;i<n;i++)
        {
            dshd[i].Xuat(DSKH.dskh[i]);
        }
    }

    public void GhiFile()
    {
        try {
            FileWriter fw = new FileWriter("QuanLyCuaHangSach-OOP-main/outputHoaDon.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < n; i++) {
                bw.write(dshd[i].toString(DSKH.dskh[i]));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) { }
    }

    @Override
    public void Menu()
    {
        boolean check = true;
        while(check)
        {
            System.out.println("--------------------------");
            System.out.println("1.Tìm kiếm hóa đơn");
            System.out.println("2.Xuất danh sách hóa đơn");
            System.out.println("3.Xuất dữ liệu ra file");
            System.out.println("4.Thoat chuong trinh");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                {
                    TimKiem();
                    break;
                }
                case 2:
                {
                    Xuat();
                    break;
                }
                case 3:
                {
                    GhiFile();
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
