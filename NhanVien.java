// Nguyễn Quang Trung - B22DCDT321

import java.util.Scanner;

public class NhanVien {
    public static Scanner scanner = new Scanner(System.in);
    public static int COUNT = 1;

    private final String maNV;
    private String tenNV;
    private String gioiTinh;
    private String email;
    private String soDT;
    private String ngaySinh;
    private String ngayBatDau;

    public NhanVien() {
        this.maNV = null;
        this.tenNV = null;
        this.gioiTinh = null;
        this.email = null;
        this.soDT = null;
        this.ngaySinh = null;
        this.ngayBatDau = null;
    }

    public NhanVien( String tenNV, String gioiTinh, String email, String soDT, String ngaySinh, String ngayBatDau ) {
        this.maNV = "NV" + String.format("%02d",COUNT++); // Mã nhân viên tự động tăng.
        this.tenNV = checkFormatName(tenNV);
        this.gioiTinh = checkFormatName(gioiTinh);
        this.email = checkFormatEmail(email);
        this.soDT = checkFormatSoDT(soDT);
        this.ngaySinh = checkFormatDate(ngaySinh);
        this.ngayBatDau = checkFormatDate(ngayBatDau);
    }

    // setter và getter cho các thuộc tính
    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    // Kiểm tra và format họ và tên.
    public String checkFormatName( String tmpName ) {
        // Kiem tra format ho va ten.
        final String NAME_REGEX = "[a-zA-Z\s]+";
        while ( !tmpName.matches(NAME_REGEX) ) {
            System.out.println("Invalid name format! Please enter again: ");
            tmpName = scanner.nextLine();
        }

        // Chuan hoa ho va ten (Viet hoa chu cai dau moi tu, cac chu cai sau viet thuong).
        StringBuilder formattedName = new StringBuilder();
        String[] tmpList = tmpName.trim().split("\\s+");

        for ( int i = 0; i < tmpList.length; i++ ) {
            tmpList[i] = tmpList[i].substring(0, 1).toUpperCase() + tmpList[i].substring(1).toLowerCase();
            formattedName.append(tmpList[i]).append(" ");
        }

        return String.valueOf(formattedName).trim();
    }

    // Kiểm tra đầu vào email. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.
    public String checkFormatEmail( String tmpEmail ) {
        final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        while ( !tmpEmail.matches(EMAIL_REGEX) ) {
            System.out.println("Invalid email format! Please enter again: ");
            tmpEmail = scanner.nextLine();
        }

        return tmpEmail;
    }

    // Kiểm tra đầu vào Số điện thoại. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.
    public String checkFormatSoDT( String tmpSDT ) {
        final String PHONE_NUMBER_REGEX = "^\\d{10}$";
        while ( !tmpSDT.matches(PHONE_NUMBER_REGEX) || tmpSDT.length() != 10 ) {
            System.out.println("Invalid phone number format! Please enter again: ");
            tmpSDT = scanner.nextLine();
        }

        return tmpSDT;
    }

    // Kiểm tra đầu vào ngày tháng năm sinh, format dd/mm/yyyy. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.
    public String checkFormatDate( String tmpDate ) {
        final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";

        while (true) {
            // Kiểm tra định dạng ngày tháng
            if (!tmpDate.matches(DATE_REGEX)) {
                System.out.println("Invalid date (ngaySinh/ngayBatDau) format! Please enter again: ");
                tmpDate = scanner.nextLine();
                continue; // Tiếp tục vòng lặp nếu định dạng không hợp lệ
            }

            // Lấy năm, tháng, ngày từ tmpDate
            int tmpNamSinh = Integer.parseInt(tmpDate.substring(tmpDate.length() - 4));
            int tmpThangSinh = Integer.parseInt(tmpDate.substring(3, 5));
            int tmpNgaySinh = Integer.parseInt(tmpDate.substring(0, 2));

            // Kiểm tra năm nhuận
            boolean checkNamThuan = (tmpNamSinh % 4 == 0 && tmpNamSinh % 100 != 0) || (tmpNamSinh % 400 == 0);
            int[] soNgayTrongThang = {31, checkNamThuan ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // Kiểm tra giá trị ngày, tháng
            if (tmpThangSinh < 1 || tmpThangSinh > 12 || tmpNgaySinh <= 0 || tmpNgaySinh > soNgayTrongThang[tmpThangSinh - 1]) {
                System.out.println("Invalid date (ngaySinh/ngayBatDau) format! Please enter again: ");
                tmpDate = scanner.nextLine();
                continue; // Tiếp tục vòng lặp nếu giá trị không hợp lệ
            }

            // Nếu mọi thứ hợp lệ, trả về tmpDate
            return tmpDate;
        }
    }

    // Ghi đè lại phương thức toString để kiểm tra code có hoạt động đúng không, in ra man hinh cac thuoc tinh.
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-5s %-25s %-15s %-12s %-12s", maNV, tenNV, gioiTinh, email, soDT, ngaySinh, ngayBatDau);
    }
}
