import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChucVu {
    public String MaCV;
    public String TenCV;

    public List<NhanVien> listTP = new ArrayList<>();
    public List<NhanVien> listPP = new ArrayList<>();
    public List<NhanVien> listNV = new ArrayList<>();

    // Constructor không tham số, khởi tạo các biến về 0.
    public ChucVu() {
        MaCV = TenCV = "";
    }

    public void addNhanVien(NhanVien x) {
        if(x.getChucVu().equals("TP")){
            listTP.add(x);
        }

        else if(x.getChucVu().equals("PP")){
            listPP.add(x);
        }

        else if(x.getChucVu().equals("NV")){
            listNV.add(x);
        }
    }

    // Constructor với tham số là tên chức vụ.
    public ChucVu(String TenCV){
        this.MaCV = chuan_hoa(TenCV);
        this.TenCV = TenCV;
    }
    // Phương pháp chuẩn hóa để khởi tạo MaCV
    public String chuan_hoa (String z){
        String[] s = z.split("\\s+"); //Tách từng từ
        String a = "";
        for (int i = 0; i < s.length; i++){
            a += s[i].substring(0,1).toUpperCase(); // Lấy chữ cái đầu rồi viết hoa
        }
        return a;
    }
    // Phương thức thiết lập mã chức vụ
    public void setMaCV(String ma_CV) {
        this.MaCV = ma_CV;
    }
    // Phương thức trả về mã chức vụ
    public String getMaCV(){
        return MaCV;
    }

    // Phương thức thiết lập tên chức vụ
    public void setTenCV(String ten_CV) {
        this.TenCV = ten_CV;
    }
    // Phương thức trả về tên chức vụ
    public String getTenCV() {
        return TenCV;
    }

    //code chưa báo đỏ nhưng phải khai thêm chucvu vào trong nhan vien( can review them)

    //code để cho ra danh sách theo tìm kiếm mã chức vụ
    
     public List<NhanVien> searchNhanVienPB(String ChucVu) {
        listTP.sort(Comparator.comparing(NhanVien::getTenNV));
        listPP.sort(Comparator.comparing(NhanVien::getTenNV));
        listNV.sort(Comparator.comparing(NhanVien::getTenNV)); // sắp xếp theo thứ tự từ điển của tên nhân viên
        if(ChucVu.equals("")){
            for(NhanVien x : listTP){
               System.out.println(x);
            }
            for(NhanVien x : listPP){
               System.out.println(x);
            }
            for(NhanVien x : listNV){
               System.out.println(x);
            }
        }
        if(ChucVu.equals("TP")){
            return listTP;
        }

        else if(ChucVu.equals("PP")){
            return listPP;
        }
        return listNV;
    }
    @Override
    public String toString() {
        return MaCV + " " + TenCV;
    }
}
//gudd
