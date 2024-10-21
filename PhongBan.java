/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentManagement;

/**
 *
 * @author Lenovo
 */
import java.util.*;

public class PhongBan {
    static Scanner sc = new Scanner(System.in);
    static int cnt = 1;
    private List<NhanVien> list = new ArrayList<>();
    private String MaPhongBan, TenPhongBan;
    //private List<NhanVien>
    public PhongBan() {
        this.MaPhongBan = null;
        this.TenPhongBan = null;
    }

    public void addNhanVien(NhanVien x) {
        list.add(x);
    }

    PhongBan(int cnt, String TenPhongBan) {
        this.MaPhongBan = "PB" + String.format("%02d", cnt++);
        this.TenPhongBan = TenPhongBan;
    }

    public String getMaPhongBan() {
        return this.MaPhongBan;
    }

    public String getTenPhongBan() {
        return this.TenPhongBan;
    }

    public void setTenPhongBan(String TenPhongBan) {
        this.TenPhongBan = TenPhongBan;
    }

    public List<NhanVien> searchNhanVienPhongBan() {
        list.sort(Comparator.comparing(NhanVien NhanVien) ->NhanVien.ten
        );
        return list;
    }

    @Override
    public String toString() {
        return MaPhongBan + " " + TenPhongBan;
    }
}
