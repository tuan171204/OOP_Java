import java.util.*;

public class ChiTietHoaDon {
    private String maHoaDon;
    private String maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    private String  status ; // them bien status 1: con hoat dong, 0: da xoa
    // ly do them: xu ly xoa chi can chinh status ve 0 la dc.
    Scanner sc = new Scanner(System.in);
    // constructor.
    public ChiTietHoaDon() {};

    public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong, double donGia,String status){
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
        this.status = status;
    }
 
    public String toString(){ // toString nay de ghi ra terminal
        return "\t" + maHoaDon +"\t\t"+ maSanPham +"\t\t"+ soLuong +"\t\t"+ donGia +"$\t\t " + thanhTien +"$\t";
    }

    public String toString2(){ // toString nay de ghi vao file
        return maHoaDon +", "+ maSanPham +", "+ soLuong +", "+ donGia +", " + thanhTien +", " + status;
    }
   

    // Getters and setters
    public String getStatus(){
        return status;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }
// setter
    public void setStatus(String status){
        this.status = status;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
