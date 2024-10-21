package studentManagement;

/**
 *
 * @author Nguyen Hai Quang
 */
import studentManagement.NhanVien;
import java.util.*;

public class PhongBan {
    static Scanner sc = new Scanner(System.in); //biến scanner để nhập giữ liệu từ bàn phím.
    static int cnt = 1; //Biến đếm tĩnh, dùng để tạo mã phòng ban (MaPhongBan) tự động tăng dần.
    private List<NhanVien> list = new ArrayList<>();// dùng arraylist để lưu (quản lí) nhân viên
    private String maPB, tenPB;// thuộc tính mã phòng ban, tên phòng ban.
    // Constructor không tham số: khởi tạo các thuộc tính bán đầu là rỗng.
    public PhongBan() {
        this.maPB = null;
        this.tenPB = null;
    }

    //Constructor có tham số, khởi tạo mã phòng ban tăng dần theo mẫu, tên phòng ban.
    PhongBan(int cnt, String tenPB) {
        this.maPB = "PB" + String.format("%02d", cnt++);
        this.tenPB = tenPB;
    }

    // phương thức thêm nhân viên vào phòng ban.
    public void addNhanVien(NhanVien x) {
        list.add(x);
    }

    // phương thức trả về mã phòng ban
    public String getMaPB() {
        return this.maPB;
    }

    // phương thức trả về tên phòng ban
    public String getTenPB() {
        return this.tenPB;
    }

    // phương thức thiết lập tên phòng ban
    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    // phương thức trả về danh sách nhân viên thuộc phòng ban cần tìm
    public List<NhanVien> searchNhanVienPB() {
        list.sort(Comparator.comparing(NhanVien::getTenNV)); // sắp xếp theo thứ tự từ điển của tên nhân viên
        return list;
    }
    // phương thức trả thông tin phòng ban theo dạng chuỗi
    @Override
    public String toString() {
        return maPB + " " + tenPB;
    }
}
