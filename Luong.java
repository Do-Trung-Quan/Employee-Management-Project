import java.util.Scanner;

public class Luong {
    private static int COUNT = 1; // Biến đếm tĩnh, dùng để tạo mã hóa đơn (MaHD) tự động tăng dần.
    private ChucVu chucVu; // Biến để lưu chức vụ của nhân viên (thuộc class ChucVu).
    private String maHD; // Mã hóa đơn của nhân viên, tự động tạo dựa trên cnt.
    private int luongCB, ngayCong, phuCap, tienThuong; // Các biến lưu lương cơ bản, số ngày công, phụ cấp, tiền thưởng.
    // Constructor không tham số, khởi tạo mã hóa đơn và thiết lập các biến về 0.
    public Luong() {
        maHD = String.format("L%02d", COUNT++); // Tạo mã hóa đơn tự động tăng dần, ví dụ L01, L02...
        luongCB = ngayCong = phuCap = tienThuong = 0; // Khởi tạo lương cơ bản, số ngày công, phụ cấp và tiền thưởng về 0.
    }
    // Phương thức thiết lập mã hóa đơn
    public String getMaHD() {
        return maHD;
    }
    // Phương thức gán chức vụ cho nhân viên.
    public void setChucvu(ChucVu chucvu) {
        this.chucVu = chucvu;
    }
    // Phương thức thiết lập lương cơ bản dựa trên chức vụ.
    public void setLuongCB() {
        // Dựa vào mã chức vụ để thiết lập lương cơ bản.
        switch (chucVu.getMa_ChucVu()) {
            case "TP": // Nếu là trưởng phòng
                this.luongCB = 1363636;
                break;
            case "PP": // Nếu là phó phòng
                this.luongCB = 1136364;
                break;
            default: // Nếu là nhân viên
                this.luongCB = 545454;
                break;
        }
    }
    // Phương thức trả về lương cơ bản.
    public int getLuongCB() {
        return luongCB;
    }
    // Phương thức thiết lập số ngày công.
    public void setNgayCong() {
        Scanner sc = new Scanner(System.in);
        do {
            int NgayCong = sc.nextInt();
            if (NgayCong >= 1 && NgayCong <= 26) {
                this.ngayCong = NgayCong;
                break;
            } else {
                System.out.println("Please enter again:");
            }
        } while (true);
    }
    // Phương thức trả về số ngày công.
    public int getNgayCong() {
        return ngayCong;
    }
    // Phương thức thiết lập phụ cấp dựa trên chức vụ.
    public void setPhuCap() {
        // Dựa vào mã chức vụ để thiết lập phụ cấp.
        switch (chucVu.getMa_ChucVu()) {
            case "TP": // Nếu là trưởng phòng
                this.phuCap = 300000;
                break;
            case "PP": // Nếu là phó phòng
                this.phuCap = 250000;
                break;
            default: // Nếu là nhân viên
                this.phuCap = 150000;
                break;
        }
    }
    // Phương thức trả về phụ cấp.
    public int getPhuCap() {
        return phuCap;
    }
    // Phương thức thiết lập tiền thưởng dựa trên số ngày công.
    public void setTienThuong() {
        // Nếu ngày công >= 25 thì thưởng 20% của tổng lương.
        if (ngayCong >= 25) {
            this.tienThuong = (int) (luongCB * ngayCong * 0.2);
        } 
        // Nếu ngày công >= 22 nhưng < 25 thì thưởng 10%.
        else if (ngayCong >= 22) {
            this.tienThuong = (int) (luongCB * ngayCong * 0.1);
        } 
        // Nếu ít hơn 22 ngày công thì không thưởng.
        else {
            this.tienThuong = 0;
        }
    }
    // Phương thức trả về tiền thưởng.
    public int getTienThuong() {
        return tienThuong;
    }
    // Phương thức tính tổng lương = Lương cơ bản * Ngày công + Phụ cấp + Tiền thưởng
    public long tinhTongLuong() {
        return luongCB * ngayCong + phuCap + tienThuong;
    }
    // Phương thức trả về thông tin của nhân viên theo dạng chuỗi.
    @Override
    public String toString() {
        return maHD + " " + luongCB + " " + ngayCong + " " + phuCap + " " + tienThuong + " " + tinhTongLuong();
    }
}
