import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String ngayLap;
    private String gioLap;
    private double tongTien;
    private String status;
    Scanner sc = new Scanner(System.in);
    public HoaDon() {}

    public HoaDon(String maHoaDon, String maKhachHang, String maNhanVien, String ngayLap, String gioLap, Double tongtien,String status) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongTien =  tongtien;
        this.status = status;
    }

    // ham toString co chuc nang chuyen thanh chuoi, su dung khi in vao file
    public String toString (){
        return maHoaDon+"\t\t"+maKhachHang+"\t\t"+maNhanVien+"\t\t"+
        ngayLap+"\t"+gioLap+"\t\t"+tongTien+ "$";
    }

    public String toString2 (){
        return maHoaDon+", "+maKhachHang+", "+maNhanVien+", "+
        ngayLap+", "+gioLap+", "+tongTien + ", " + status;
    }

    // Getters and setters
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getGioLap() {
        return gioLap;
    }

    public void setGioLap(String gioLap) {
        this.gioLap = gioLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}

    

